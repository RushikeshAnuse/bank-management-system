package bankmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{


    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));

        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);
        
        l1 = new JLabel("SELECT WITHDRWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
       
        b1 = new JButton("Rs 100");
        b1.setFont(new Font("System",Font.BOLD,16));
        b2 = new JButton("Rs 2000");
        b2.setFont(new Font("System",Font.BOLD,16));
        b3 = new JButton("Rs 500");
        b3.setFont(new Font("System",Font.BOLD,16));
        b4 = new JButton("Rs 5000");
        b4.setFont(new Font("System",Font.BOLD,16));
        b5 = new JButton("Rs 1000");
        b5.setFont(new Font("System",Font.BOLD,16));
        b6 = new JButton("Rs 10000");
        b6.setFont(new Font("System",Font.BOLD,16));
        b7 = new JButton("BACK");
        b7.setFont(new Font("System",Font.BOLD,16));
        
        setLayout(null);
        
        l1.setBounds(235,400,700,35);
        l2.add(l1);
        
        b1.setBounds(170,499,150,35);
        l2.add(b1);
        
        b2.setBounds(390,499,150,35);
        l2.add(b2);
        
        b3.setBounds(170,543,150,35);
        l2.add(b3);
        
        b4.setBounds(390,543,150,35);
        l2.add(b4);
        
        b5.setBounds(170,588,150,35);
        l2.add(b5);
        
        b6.setBounds(390,588,150,35);
        l2.add(b6);
        
        b7.setBounds(390,633,150,35);
        l2.add(b7);
        
        
          b1.addActionListener(this);
          b2.addActionListener(this);
          b3.addActionListener(this);
          b4.addActionListener(this);
          b5.addActionListener(this);
          b6.addActionListener(this);
          b7.addActionListener(this);
        
        
        setSize(960,1080);
        setLocation(500,0);
        //it will hide the title or minimize maximize layout
        //setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
//    	if(ae.getSource() == b1) {
//    		setVisible(false);
//    		new Deposit(pin).setVisible(true);
//    	}else if(ae.getSource() == b2) {
//    		setVisible(false);
//    		new Withdraw(pin).setVisible(true);
//    	}
    
    	String amount = ((JButton)ae.getSource()).getText().substring(3);
    	
    	if(ae.getSource() == b7) {
    		setVisible(false);
    		new Transactions(pinnumber).setVisible(true);
    	}else {
    		try {
        		Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
						
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null,"Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Rs "+amount+" Dedited in Your Account");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public static void main(String[] args){
        new FastCash("").setVisible(true);
    }
}
