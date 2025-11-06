
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;
import java.awt.event.*;

public class SignupOne extends JFrame  implements ActionListener{
     
    long random;
    JTextField nameField, fnameField,emailField ,addressField ,cityField,stateField ,pinField;
    JDateChooser dobChooser;
    JRadioButton male, female,married,unmarried,other ;
     JButton next ;
     
    SignupOne() {
        setLayout(null);
         
       Random ran = new Random();
       random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formNo = new JLabel("APPLICATION FORM NO. 3864");
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 70, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 120, 100, 30);
        add(name);

         nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.PLAIN, 14));
        nameField.setBounds(300, 120, 400, 30);
        add(nameField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 170, 200, 30);
        add(fname);

         fnameField = new JTextField();
        fnameField.setFont(new Font("Raleway", Font.PLAIN, 14));
        fnameField.setBounds(300, 170, 400, 30);
        add(fnameField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);

         dobChooser = new JDateChooser();
        dobChooser.setBounds(300, 220, 400, 30);
        dobChooser.setForeground(new Color(105, 105, 105));
        add(dobChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 270, 200, 30);
        add(gender);

         male = new JRadioButton("Male");
        male.setBounds(300, 270, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 270, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 320, 200, 30);
        add(email);

         emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.PLAIN, 14));
        emailField.setBounds(300, 320, 400, 30);
        add(emailField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 370, 200, 30);
        add(marital);

         married = new JRadioButton("Married");
        married.setBounds(300, 370, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 370, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

         other = new JRadioButton("Other");
        other.setBounds(500, 370, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 420, 200, 30);
        add(address);

         addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.PLAIN, 14));
        addressField.setBounds(300, 420, 400, 30);
        add(addressField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 470, 200, 30);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.PLAIN, 14));
        cityField.setBounds(300, 470, 400, 30);
        add(cityField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 520, 200, 30);
        add(state);

         stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.PLAIN, 14));
        stateField.setBounds(300, 520, 400, 30);
        add(stateField);

        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 570, 200, 30);
        add(pin);

         pinField = new JTextField();
        pinField.setFont(new Font("Raleway", Font.PLAIN, 14));
        pinField.setBounds(300, 570, 400, 30);
        add(pinField);

         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(620, 630, 80, 30);
        next.addActionListener(this);
        add(next);

        next.addActionListener(e -> {
            // Handle form submission or open next page
            JOptionPane.showMessageDialog(null, "Next button clicked!");
        });

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno =  "" +random;
        String name = nameField.getText(); 
        String fname = fnameField.getText(); 
        String dob = ((JTextField)dobChooser.getDateEditor().getUiComponent()).getText(); 
        String gender = null;
        if(male.isSelected()){
            gender ="Male";
        }
        else if(female.isSelected()){
            gender ="Female";
        }
        String  email = emailField.getText();
        String martial = null;
        if(married.isSelected()){
            gender ="Married";
        }
        else if(unmarried.isSelected()){
            gender ="UnMarried";
        }
        else if(other.isSelected()){
            gender ="Other";
        }
        String  address = addressField.getText();
        String  city = cityField.getText();
        String  state = stateField.getText();
        String  pin = pinField.getText();
        
        try{
            if (name.equals("")){
              JOptionPane.showMessageDialog(null, "Name is Required");  
            }
            else{
                Conn c =new Conn();
                String marital = null;
                String query = "insert into signup  values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"' , '"+city+"' , '"+pin+"' , '"+state+"')";  
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupOne();
    }
}
