package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
        
public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, Withdraw, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
       
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 790);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDWRAWL AMOUNT");
        text.setBounds(210, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text);
        
        deposit = new JButton("RS 100");
        deposit.setBounds(170, 369, 150, 27);
        deposit.addActionListener(this);
        image.add(deposit);
        
        Withdraw = new JButton(" RS 500");
        Withdraw.setBounds(355, 369, 150, 27);
        Withdraw.addActionListener(this);
        image.add(Withdraw);
        
        fastcash = new JButton("RS 1000");
        fastcash.setBounds(170, 398, 150, 27);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("RS 2000");
        ministatement.setBounds(355, 398, 150, 27);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("RS 5000");
        pinchange.setBounds(170, 427, 150, 27);
        pinchange.addActionListener(this);
        image.add(pinchange); 
        
        balanceenquiry = new JButton("RS 10000");
        balanceenquiry.setBounds(355, 427, 150, 27);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("BACK");
        exit.setBounds(355, 456, 150, 27);
        exit.addActionListener(this);
        image.add(exit); 
        
        setSize(900,790);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    
    public void  actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);  
        }else{
           String amount =  ((JButton)ae.getSource()).getText().substring(3);
           Conn c = new Conn();
           try{
              ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
              int balance = 0;
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")) {
                      balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
               }
              if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "Insufficient Balance");
                  return;
              }
              
              Date date = new Date();
              String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl' ,'"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "RS "+ amount + "Debited Sucessfully");
              
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
           }catch(Exception e){
               System.out.println(e);
           }
        }
        
    }

    public static void main(String args[]) {
         new FastCash("");
    }
}
