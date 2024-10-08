package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.*;

public class ChangePin extends JFrame implements ActionListener {
	
	JLabel label,pintext,rpintext;
	JPasswordField npin,rpin;
	JButton change,back;
	String pin;
	
	ChangePin(String pin){
		this.pin = pin;
		setLayout(null);
		//add image 
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));

        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);
        
        
        //add label for change pin
        label = new JLabel("CHANGE ACCOUNT PIN");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,18));
        label.setBounds(240,350,250,30);
        l2.add(label);
        
        //New pin
        pintext = new JLabel("Enter New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(180,400,250,30);
        l2.add(pintext);
        
        npin = new JPasswordField();
        npin.setFont(new Font("System",Font.BOLD,16));
        npin.setBounds(350,400,180,30);
        l2.add(npin);
        
        
        
        //Re-enter pin
        rpintext = new JLabel("Re-Enter New PIN:");
        rpintext.setForeground(Color.WHITE);
        rpintext.setFont(new Font("System",Font.BOLD,16));
        rpintext.setBounds(180,440,200,30);
        l2.add(rpintext);
        
        rpin = new JPasswordField();
        rpin.setFont(new Font("System",Font.BOLD,16));
        rpin.setBounds(350,440,180,30);
        l2.add(rpin);
        
        change = new JButton("CHANGE");
        change.setForeground(Color.BLACK);
        change.setFont(new Font("System",Font.BOLD,14));
        change.setBounds(390,588,150,35);
        change.addActionListener(this);
        l2.add(change);
        
        back = new JButton("BACK");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System",Font.BOLD,14));
        back.setBounds(390,633,150,35);
        back.addActionListener(this);
        l2.add(back);
        
        setSize(960,1080);
        setLocation(500,0);
        setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == change) {
			try {
				String newpin = npin.getText();
				String repin = rpin.getText();
				
				if(!newpin.equals(repin)) {
					JOptionPane.showMessageDialog(null, "entered  pin does not match");
					return;
				}
				if(newpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new pin");
					return;
				}
				
				if(repin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new pin");
					return;
				}
				
				Conn c = new Conn();
				String query1 = "update bank set pin ='"+newpin+"' where pin ='"+pin+"'";
				String query2 = "update login set pin ='"+newpin+"' where pin ='"+pin+"'";
				String query3 = "update signup3 set pin ='"+newpin+"' where pin ='"+pin+"'";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
 
				JOptionPane.showMessageDialog(null, "Pin changed Successfully");
				
				setVisible(false);
				new Transactions(newpin).setVisible(true);

				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
		
	}
	

	public static void main(String[] args) {

		new ChangePin("");
	}

	

}
