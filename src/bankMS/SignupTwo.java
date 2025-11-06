
package bank.management.system;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class SignupTwo extends JFrame  implements ActionListener{
     
    
    JTextField  pan, aadhar;
    JRadioButton syes, sno, eyes, eno;
     JButton next ;
     JComboBox category, income,  religion, education, occupation;
     String formno; 
     
    SignupTwo(String formno) {
        
        this.formno = formno;
        
        setLayout(null);
         
       
       setTitle ("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
        

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
       additionalDetails.setBounds(290, 70, 400, 30);
        add(additionalDetails);
        

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 120, 100, 30);
        add(name);

         String valReligion[] = {"Hindhu", "Muslim", "Sikh","Christian","Other"};
          religion = new JComboBox(valReligion);
        religion.setBounds(300, 120, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 170, 200, 30);
        add(fname);

        String valcategory[] = {"General", "OBC", "SC","ST","other"};
         category = new JComboBox(valcategory);
        category.setBounds(300, 170, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);

        String incomecategory[] = {"Null", "<1,50,000", "<2,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 220, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 270, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualifiaction :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 300, 200, 30);
        add(email);
        
        String educationalValues[] = {"NON-GRADUATE", "GRADUATE", "POST GRADUATE","DOCTRATE","other"};
         education = new JComboBox(educationalValues);
        education.setBounds(300, 300, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 370, 200, 30);
        add(marital);

         String occupationValues[] = {"Salaried", "Self employed", "Bussiness","Retired","other"};
         occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 370, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN No:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 420, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.PLAIN, 14));
        pan.setBounds(300, 420, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar No:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 470, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.PLAIN, 14));
        aadhar.setBounds(300, 470, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 520, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes .setBounds(300, 520, 100, 30);
        syes .setBackground(Color.WHITE);
        add(syes );

         sno= new JRadioButton("No");
        sno.setBounds(400, 520, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);

        JLabel pin = new JLabel("Existing account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 600, 200, 30);
        add(pin);

         eyes = new JRadioButton("Yes");
        eyes .setBounds(300, 600, 100, 30);
        eyes .setBackground(Color.WHITE);
        add(eyes );

         eno= new JRadioButton("No");
        eno.setBounds(400, 600, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);

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

        String sreligion = (String) religion.getSelectedItem(); 
        String scategory = (String) category.getSelectedItem(); 
        String sincome = (String) income.getSelectedItem(); 
        String seducation = (String) education.getSelectedItem(); 
        String soccupation = (String) occupation.getSelectedItem(); 
        String seniorcitizen = null; 
        if(syes.isSelected()){
           seniorcitizen="Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount ="Yes";
        }
        else if(eno.isSelected()){
            existingaccount ="No";
        }
        
        String  span = pan.getText();
        String  saadhar = aadhar.getText();

        
        try{
            
                Conn c =new Conn();
            
            
                String query = "insert into signupTwo  values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"' , '"+seniorcitizen+"' , '"+existingaccount+"')";  
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
