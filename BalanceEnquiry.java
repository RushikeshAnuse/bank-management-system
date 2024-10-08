package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinnumber;
	
	BalanceEnquiry(String pinnumber){
		 this.pinnumber = pinnumber;
		 setLayout(null);
		 
	     ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));

	     //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
	     Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
	     ImageIcon i3 = new ImageIcon(i2);
	     JLabel l2 = new JLabel(i3);
	     l2.setBounds(0, 0, 960, 1080);
	     add(l2);
	     
	     
	     //code to check balance
		int balance = 0;
	     try {
     		Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
						
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }
	     
	     JLabel amount = new JLabel("Your Account Balance is : Rs "+balance);
	     amount.setForeground(Color.WHITE);
	     amount.setFont(new Font("System",Font.BOLD,16));
	     amount.setBounds(235,400,400,30);
	     l2.add(amount);
	     
	     
	     
	     //created back button
	     back = new JButton("BACK");
	     back.setFont(new Font("System",Font.BOLD,16));
	     back.setBounds(390,633,150,35);
	     back.addActionListener(this);
	     l2.add(back);
	     
	     setSize(960,1080);
	     setLocation(500,0);
	     //it will hide the title or minimize maximize layout
	     //setUndecorated(true);
	     setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
	
	public static void main(String args[]) {
		new BalanceEnquiry("");
	}

	
	
	
	
}
