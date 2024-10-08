package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JLabel;

public class Deposit extends JFrame implements ActionListener{

	JTextField amount;
	JButton deposit,back;
	String pin;
	
	Deposit(String pin){
		this.pin = pin;
		setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));

        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);
        
        //l2 is a object of ImageIcon
        JLabel label = new JLabel("Enter the amount you want to Deposit");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,16));
        label.setBounds(235,400,400,30);
        l2.add(label);
        
        
        //add textfield
        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,16));
        amount.setBounds(250,450,200,30);
        l2.add(amount);
        
        
        deposit = new JButton("Deposit");
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBounds(390,588,150,35);
        deposit.addActionListener(this);
        l2.add(deposit);
        
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
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
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == deposit) {
			String number = amount.getText();
			Date date = new Date();
			
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter valid ammount");
			}
			else {
				String query = "insert into bank values ('"+pin+"','"+date+"','Deposit','"+number+"')";
				try {
					Conn con = new Conn();
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs " +number+" Deposited in your account");
					setVisible(false);
					new Transactions(pin).setVisible(true);
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			
		}
		else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}

		
	}
	
	
	public static void main(String[] args) {

		new Deposit("");
	}

	

}
