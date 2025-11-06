
package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount,t2;
    JButton deposit,back,b3;
    JLabel l1,l2,l3;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        
        deposit = new JButton("DEPOSIT");
        back = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(180,320,400,35);
        l3.add(l1);
        
        amount.setBounds(180,360,320,25);
        l3.add(amount);
        
        deposit.setBounds(355,485,150,30);
        l3.add(deposit);
        
        back.setBounds(355,520,150,30);
        l3.add(back);
        
        deposit.addActionListener(this);
        back.addActionListener(this);
        
        setSize(900,900);
        //setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount1 = amount.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(amount1.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+amount1+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount1+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
