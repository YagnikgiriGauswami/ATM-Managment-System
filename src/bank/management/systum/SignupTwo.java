
package bank.management.system;


import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, category, education, occupation, income;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("New Account Aplication Form-Page 2");
        
        JLabel additionalDetails = new JLabel ("pagr 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD ,22));
        additionalDetails.setBounds(290,80,400,30);
        additionalDetails.setForeground(Color.orange);
        add(additionalDetails);
        
        JLabel name = new JLabel ("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD ,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu" , "Muslim" ,"Sikh","Christian" ,"Others"};
        religion = new JComboBox (valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);        
        
        JLabel fname = new JLabel ("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD ,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[]={"Genral","OBC","ST","SC","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel ("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD ,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[]={"NUll","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel ("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD ,20));
        gender.setBounds(100,290,200,30);
        add(gender);
 
        JLabel email = new JLabel ("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD ,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationValues[]={"Non graduation","Graduate","Post Graduation","Doctrte","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel marital = new JLabel ("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD ,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[]={"salaried","self Employed","Bussiness man","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address = new JLabel ("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD ,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Ralway", Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel ("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD ,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Ralway", Font.BOLD,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel state = new JLabel ("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD ,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes = new JRadioButton("yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("no");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
       
        JLabel pincode = new JLabel ("Exisiting Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD ,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes = new JRadioButton("yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("no");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway" , Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,770);
        setVisible(true);
        setLocation(250,10);

    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen ="yes";
         }else if(sno.isSelected()){
             seniorcitizen = "no";
            }
       
        String exisitingaccount = null;
        if(eyes.isSelected()){
            exisitingaccount = "yes";
        }else if(eno.isSelected()){
            exisitingaccount = "no";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"' , '"+sreligion+"' , '"+scategory+"', '"+sincome+"' , '"+seducation+"' , '"+soccupation+"' , '"+span+"' ,'"+saadhar+"' , '"+seniorcitizen+"' , '"+exisitingaccount+"')";
                c.s.executeUpdate(query);
                
                //Signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.print(e);
        }
    }
    

  
    public static void main(String args[]) {
        new SignupTwo("");
    }
}