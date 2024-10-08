package bankmanagementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;

import javax.swing.*;

public class Signup3 extends JFrame implements ActionListener{
	JRadioButton r1,r2,r3,r4;
	JCheckBox atm,cheque,ibank,estatement,declaration;
	JButton submit,cancel;
	String formno;
	Signup3(String formno){
		this.formno = formno;
		setLayout(null);
		
		JLabel l1  = new JLabel("Page 3:Accont Details");
		l1.setFont(new Font("Raleway",Font.BOLD,24));
		l1.setBounds(290, 80, 400, 30);
	    add(l1);
	    
	    
	    JLabel account = new JLabel("Accont Type");
	    account.setFont(new Font("Raleway",Font.BOLD,18));
	    account.setBounds(100,150,200,30);
	    add(account);
	    
	    //Create Radio button
	    r1 = new JRadioButton("Saving Account");
	    r1.setFont(new Font("Raleway",Font.PLAIN,16));
	    r1.setBackground(Color.black.WHITE);
	    r1.setBounds(100,180,150,30);
	    add(r1);
	    
	    r2 = new JRadioButton("Fixed Deposit");
	    r2.setFont(new Font("Raleway",Font.PLAIN,16));
	    r2.setBackground(Color.black.WHITE);
	    r2.setBounds(300,180,150,30);
	    add(r2);
	    
	    r3 = new JRadioButton("Current Account");
	    r3.setFont(new Font("Raleway",Font.PLAIN,16));
	    r3.setBackground(Color.black.WHITE);
	    r3.setBounds(100,220,150,30);
	    add(r3);
	    
	    r4 = new JRadioButton("Recuring Account");
	    r4.setFont(new Font("Raleway",Font.PLAIN,16));
	    r4.setBackground(Color.black.WHITE);
	    r4.setBounds(300,220,150,30);
	    add(r4);
	    
	    ButtonGroup accounts = new ButtonGroup();
	    accounts.add(r1);
	    accounts.add(r2);
	    accounts.add(r3);
	    accounts.add(r4);
	    		
	    
	    
	    //Card Details
	    JLabel card = new JLabel("Card Number");
	    card.setFont(new Font("Raleway",Font.BOLD,18));
	    card.setBounds(100,300, 200, 30);
	    add(card);
	    
	    JLabel carddetails = new JLabel("XXXX-XXXX-XXXX-2003");
	    carddetails.setFont(new Font("Raleway",Font.BOLD,18));
	    carddetails.setBounds(350,300, 300, 30);
	    add(carddetails);
	    
	    JLabel cdetails = new JLabel("Your 16 digit Card Number");
	    cdetails.setFont(new Font("Raleway",Font.BOLD,14));
	    cdetails.setBounds(100,330, 200, 25);
	    add(cdetails);
	    
	    
	    //Password Details
	    JLabel pin = new JLabel("PIN");
	    pin.setFont(new Font("Raleway",Font.BOLD,18));
	    pin.setBounds(100,380, 200, 30);
	    add(pin);
	    
	    JLabel pindetails = new JLabel("XXXX");
	    pindetails.setFont(new Font("Raleway",Font.BOLD,18));
	    pindetails.setBounds(350,380, 300, 30);
	    add(pindetails);
	    
	    JLabel pdetails = new JLabel("Your 4 digit Password");
	    pdetails.setFont(new Font("Raleway",Font.BOLD,14));
	    pdetails.setBounds(100,410, 200, 25);
	    add(pdetails);
	    
	    
	    //Services Required
	    JLabel services = new JLabel("Services Required");
	    services.setFont(new Font("Raleway",Font.BOLD,18));
	    services.setBounds(100,470, 300, 25);
	    add(services);
	    
	    atm = new JCheckBox("ATM Card");
	    atm.setBackground(Color.WHITE);
	    atm.setFont(new Font("Raleway",Font.BOLD,16));
	    atm.setBounds(100,500,200,30);
	    add(atm);
	    
	    ibank = new JCheckBox("Internet Banking");
	    ibank.setBackground(Color.WHITE);
	    ibank.setFont(new Font("Raleway",Font.BOLD,16));
	    ibank.setBounds(350,500,200,30);
	    add(ibank);
	    
	    cheque = new JCheckBox("Cheque Book");
	    cheque.setBackground(Color.WHITE);
	    cheque.setFont(new Font("Raleway",Font.BOLD,16));
	    cheque.setBounds(100,540,200,30);
	    add(cheque);
	    
	    estatement = new JCheckBox("E-Statement");
	    estatement.setBackground(Color.WHITE);
	    estatement.setFont(new Font("Raleway",Font.BOLD,16));
	    estatement.setBounds(350,540,200,30);
	    add(estatement);
	    
	    
	    declaration = new JCheckBox("I hearby declare that the above entered "
	    		          + "details are correct to the best of my knoweledge.");
	    declaration.setBackground(Color.WHITE);
	    declaration.setFont(new Font("Raleway",Font.BOLD,12));
	    declaration.setBounds(100,580,600,30);
	    add( declaration);
	    
	    submit = new JButton("Submint");
	    submit.setBackground(Color.BLACK);
	    submit.setForeground(Color.WHITE);
	    submit.setFont(new Font("Raleway",Font.BOLD,16));
	    submit.setBounds(250,650,100,30);
	    submit.addActionListener(this);
	    add(submit);
	    
	    cancel = new JButton("Cancel");
	    cancel.setBackground(Color.BLACK);
	    cancel.setForeground(Color.WHITE);
	    cancel.setFont(new Font("Raleway",Font.BOLD,16));
	    cancel.setBounds(400,650,100,30);
	    cancel.addActionListener(this);
	    add(cancel);
	    
	    
	
		getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 50);
        setVisible(true);
        	
	}
	
	 @Override
 	public void actionPerformed(ActionEvent ae) {
 		// TODO Auto-generated method stub
		 String sformno = formno;
     	if(ae.getSource() == submit) {
     		String accounttype = null;
     		if(r1.isSelected()) {
     			accounttype = "Saving accoung";
     		}else if(r2.isSelected()) {
     			accounttype = "Fixed Account";
     		}else if(r3.isSelected()) {
     			accounttype = "Current Account";
     		}else if(r4.isSelected()) {
     			accounttype = "Recuring Account";
     		}
     		
     		
     		Random random = new Random();
     		String cardnumber =""+Math.abs((random.nextLong()%90000000L) + 504093600000000L);     		
            String pinnumber =""+Math.abs((random.nextLong()%9000L) + 1000L);  
            
            String services = null;
            if(atm.isSelected()) {
            	services = "ATM Card";
            }else if(ibank.isSelected()) {
            	services = "Internet Banking";
            }else if(cheque.isSelected()) {
            	services = "Cheque Book";
            }else if(estatement.isSelected()) {
            	services = "E-Statement";
            }
            
            if(declaration.isSelected()) {
            	try {
                	Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+sformno+"','"+accounttype+"',"
                    	     + "'"+cardnumber+"','"+pinnumber+"','"+services+"')";
                    c1.s.executeUpdate(q1);
                    String q2 = "insert into login values('"+cardnumber+"','"+pinnumber+"')";
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber +"\nPassword:"+pinnumber);
                    //new Signup2(first).setVisible(true);
                    
                    //first add money in your bank account 
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }catch(Exception e) {
                	System.out.println(e);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Fill the declaration checkbox");
            }

     	}
     	else if(ae.getSource() == cancel) {	
     	}
 		
 	}

	public static void main(String[] args) {
		new Signup3("");

	}

	
}
