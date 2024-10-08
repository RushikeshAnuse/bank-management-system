package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup2 extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    //t1-aadhar,t2-pan
	JTextField t1,t2;
    JRadioButton r1,r2,r3,r4;
    JButton b;
       
    
    //Global variable
    JComboBox religion,category,income,education,occuption;
    String formno;
    Signup2(String formno){
        this.formno=formno;
        setTitle("ACCOUNT APPLICATION FORM  2");
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 100, 100);
        add(l11);
        
//        l1 = new JLabel("APPLICATION FORM NO. "+first);
//        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        
        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(290, 80, 400, 30);
        add(l1);
        
        
        //RELIGION
        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(100, 140, 100, 30);
        add(l2);
        String valreligion[] = {"Hindu","Muslim","Krishchan","Isai"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        
        //CATEGORY
        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100, 190, 200, 30);
        add(l3);
        String valcategory[] = {"OPEN","OBC","NT","SC","ST"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        //INCOME
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100, 240, 200, 30);
        add(l4);
        String valincome[] = {"<1,50,000","<5,00,000","<8,00,000","<8,00,000"};
        income= new JComboBox(valincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        //EDUCATION
        l5 = new JLabel("Education");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100, 290, 200, 30);
        add(l5);
        String valeducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate"};
        education= new JComboBox(valeducation);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        //OCCUPTION
        l6 = new JLabel("Occuption:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(100, 340, 200, 30);
        add(l6);
        String valoccuption[] = {"Un-Employed","Employed","Self-Employee","Business","Student"};
        occuption= new JComboBox(valoccuption);
        occuption.setBounds(300, 340, 400, 30);
        occuption.setBackground(Color.WHITE);
        add(occuption);
        
        
        
        //SENIOR CITIZEN
        l7 = new JLabel("Senior Citizen:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100, 390, 200, 30);
        add(l7);
      
        r3 = new JRadioButton("YES");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(300, 390, 100, 30);
        add(r3);
        
        r4 = new JRadioButton("NO");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450, 390, 100, 30);
        add(r4);
        
        ButtonGroup groupcitizen = new ButtonGroup();
        groupcitizen.add(r3);
        groupcitizen.add(r4);
        
        
        
        //AADHAR
        l8 = new JLabel("Aadhar:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100, 440, 200, 30);
        add(l8);
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(300, 440, 400, 30);
        add(t1);
        
        
        //PAN
        l9 = new JLabel("Pan:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(100, 490, 200, 30);
        add(l9);
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(300, 490, 400, 30);
        add(t2);
        
        
        
        //EXISTING ACCOUNT
        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        l10.setBounds(100, 540, 200, 30);
        add(l10);
        r1 = new JRadioButton("YES");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(300, 540, 100, 30);
        add(r1);
        
        r2 = new JRadioButton("NO");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(450, 540, 100, 30);
        add(r2);
        
        ButtonGroup checkexistaccount = new ButtonGroup();
        checkexistaccount.add(r1);
        checkexistaccount.add(r2);
       
        
        


       
        //next Button
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
       
        //chatgpt
        // Add components to the frame
        setLayout(null);

        //NextButton
        b.setBounds(620, 660, 80, 30);
        b.addActionListener(this);
        add(b);
        //color of "Next" text is white
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 50);
        setVisible(true);
        
    }
        
        //action listener on activity
	@Override
	public void actionPerformed(ActionEvent ae) {
	    //t1-name,t2-fname,t3-city,t4-pincode,t5-state,t6-email,t7-address
	    String sformno = formno;
		String saadhar = t1.getText();
        String span = t2.getText();
        
//        //String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

         String sexistaccount = null;
        if(r1.isSelected()){ 
        	sexistaccount = "YES";
        }else if(r2.isSelected()){ 
        	sexistaccount = "No";
        }
           
//        String email = t6.getText();
        String scitizen = null;
        if(r3.isSelected()){ 
        	scitizen = "YES";
        }else if(r4.isSelected()){ 
        	scitizen = "NO";
        }
           
        String srelegion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccuption = (String) occuption.getSelectedItem(); 

        try{
           
            if(t1.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup2 values('"+sformno+"','"+srelegion+"','"+scategory+"','"
                +sincome+"','"+seducation+"','"+soccuption+"','"+span+"','"+saadhar+"',"
                				+ "'"+scitizen+"','"+sexistaccount+"')";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Additional Details Saved Successfully");
                new Signup3(sformno).setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
	
	public static void main(String[] args){
	    new Signup2("");
	}
}
