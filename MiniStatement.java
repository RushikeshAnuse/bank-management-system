package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {

	JButton print;
	String pinnumber;
	 
	 
	public MiniStatement(String pinnumber) {

		setLayout(null);
		this.pinnumber = pinnumber;
		setTitle("Mini Statement");
		
		
		JLabel text = new JLabel("National Bank");
		text.setFont(new Font("Raleway",Font.BOLD,16));
		text.setBounds(130,10,200,30);
		add(text);
		
		//print card number 
		JLabel card = new JLabel();
	    card.setFont(new Font("System",Font.BOLD,14));
		card.setBounds(30,40,300,30);
		add(card);
		
		try {
			Conn c = new Conn();
			String query = "select * from login where pin ='"+pinnumber+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				card.setText("Card Number:"+rs.getString("cardno").substring(0,4)
						+"XXXXXXXX"+rs.getString("cardno").substring(12));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		//print transactions or print mini transaction
		JLabel mini = new JLabel();
	    mini.setFont(new Font("System",Font.BOLD,14));
		mini.setBounds(30,115,350,190);
		add(mini);
		
		try {
			Conn c = new Conn();
			String query1 = "select * from bank where pin ='"+pinnumber+"'";
			//String query1 = "select * from bank where pin ='2004'";

			ResultSet rs = c.s.executeQuery(query1);
			
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date")+
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		//balace label
		int bal = 0;
	     try {
    		Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						bal += Integer.parseInt(rs.getString("amount"));
						
					}else {
						bal -= Integer.parseInt(rs.getString("amount"));
					}
				}
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }
	     
	     JLabel amount = new JLabel("Account Balance : Rs "+bal);
	    // amount.setForeground(Color.WHITE);
	     amount.setFont(new Font("System",Font.BOLD,14));
	     amount.setBounds(30,60,300,30);
	     add(amount);
		
	     
		//create print button
		print = new JButton("PRINT");
		print.setFont(new Font("Raleway",Font.BOLD,16));
		print.setBounds(270,320,100,30);
		print.addActionListener(this);
		add(print);
		
		setSize(400,400);
		setLocation(20,20);
		setVisible(true);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		//new Transactions(pinnumber).setVisible(true);
	}
	

	public static void main(String[] args) {
		new MiniStatement("");
	}
}
