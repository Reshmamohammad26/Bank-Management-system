
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame  implements ActionListener{
    
    JButton clearBtn, signUpBtn, signInBtn;
    JTextField cardField;
    JPasswordField pinField;
    
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
         setLayout(null); // Absolute layout

        URL imageURL = ClassLoader.getSystemResource("ICONS/login.jpg");
        
            ImageIcon originalIcon = new ImageIcon(imageURL);
            Image img = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(img);

            // Image label
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setBounds(50, 30, 100, 100); // Position image
            add(imageLabel);

            // Text label
            JLabel textLabel = new JLabel("Welcome to ATM");
            textLabel.setFont(new Font("Arial", Font.BOLD, 40));
            textLabel.setBounds(180, 55, 500, 50); // Position text to the right of image
            add(textLabel);
            // Card No label
            JLabel cardLabel = new JLabel("Card No:");
            cardLabel.setFont(new Font("Arial", Font.BOLD, 20));
            cardLabel.setBounds(120, 180, 120, 30); // More left & top space
            add(cardLabel);

            // Card No input
             cardField = new JTextField();
            cardField.setFont(new Font("Arial", Font.BOLD, 13));
            cardField.setBounds(230, 180, 220, 30); // Aligns with label
            add(cardField);

            // PIN label
            JLabel pinLabel = new JLabel("PIN:");
            pinLabel.setFont(new Font("Arial", Font.BOLD, 20));
            pinLabel.setBounds(120, 230, 120, 30); // Same left as Card No
            add(pinLabel);

            // PIN input
             pinField = new JPasswordField();
            pinField.setBounds(230, 230, 220, 30); // Align with card input
            add(pinField);
            
            KeyAdapter numberOnly = new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c)) e.consume();
                    }
                };

                cardField.addKeyListener(numberOnly);
                pinField.addKeyListener(numberOnly);

            // Sign In button
            signInBtn = new JButton("Sign In");
            signInBtn.setFont(new Font("Arial", Font.BOLD, 16));
            signInBtn.setBounds(230, 280, 100, 35);
            signInBtn.addActionListener(this);
            add(signInBtn);

            // Clear button (next to Sign In)
             clearBtn = new JButton("Clear");
            clearBtn.setFont(new Font("Arial", Font.BOLD, 16));
            clearBtn.setBounds(350, 280, 100, 35);
            clearBtn.addActionListener(this);
            add(clearBtn);

            // Sign Up button (below Sign In and Clear, centered)
            signUpBtn = new JButton("Sign Up");
            signUpBtn.setFont(new Font("Arial", Font.BOLD, 16));
            signUpBtn.setBounds(230, 330, 220, 35); // Centered below
            signUpBtn.addActionListener(this);
            add(signUpBtn);
        
            signInBtn.setBackground(Color.BLACK);
            signInBtn.setForeground(Color.WHITE);

            clearBtn.setBackground(Color.BLACK);
            clearBtn.setForeground(Color.WHITE);

            signUpBtn.setBackground(Color.BLACK);
            signUpBtn.setForeground(Color.WHITE);

            
         getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == clearBtn){
                cardField.setText("");
                pinField.setText("");
            }
            else if (ae.getSource() == signInBtn){
            Conn c1 = new Conn();
            String cardno  = cardField.getText();
            String pin  = pinField.getText();

            if(cardno.equals("") || pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter both Card Number and PIN");
                return;
            }

            String q  = "select * from login where cardNumber = '"+cardno+"' and pinNumber = '"+pin+"'";
            try {
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");  // THIS is the dialog box
                }
            } catch (Exception e){
                System.out.println(e);
               
            }
        }


            else if (ae.getSource() == signUpBtn){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
