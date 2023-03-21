package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, Withdraw, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
       
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 790);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 369, 150, 27);
        deposit.addActionListener(this);
        image.add(deposit);
        
        Withdraw = new JButton("Cash Withdraw");
        Withdraw.setBounds(355, 369, 150, 27);
        Withdraw.addActionListener(this);
        image.add(Withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 398, 150, 27);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 398, 150, 27);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 427, 150, 27);
        pinchange.addActionListener(this);
        image.add(pinchange); 
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 427, 150, 27);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("EXIT");
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
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == Withdraw){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }

    public static void main(String args[]) {
         new Transactions("");
    }
}
