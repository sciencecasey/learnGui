package alexLee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * @author CaseyJayne
 * using swing to make a loginGui
 */
public class LoginGui implements ActionListener{
   private static JLabel userLabel;
   private static JTextField userText;
   private static JLabel passwordLabel;
   private static JPasswordField passText;
   private static JButton button;
   private static JLabel success;

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      userLabel = new JLabel("User");
      userText = new JTextField(20);
      passwordLabel = new JLabel("Password");
      passText = new JPasswordField();
      button = new JButton("Login");
      success = new JLabel("");
      
      //create frame and panel
      frame.setSize(300, 200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //add the panel to frame
      frame.add(panel);
      panel.setLayout(null);
      
      //set the user label bounds
      userLabel.setBounds(10,  20,  80,  25);
      panel.add(userLabel);
      
      //set the user text bounds
      userText.setBounds(100, 20, 165, 25);
      panel.add(userText);
      
      //set the bounds for the Password
      passwordLabel.setBounds(10, 50, 80, 25);
      panel.add(passwordLabel);
      
      //set location to enter password
      passText.setBounds(100, 50, 165, 25);
      panel.add(passText);
      
      //set button
      button.setBounds(10, 80, 80, 25);
      //make clickable with the interface
      button.addActionListener(new LoginGui());
      panel.add(button);
      
      //set success bounds
      success.setBounds(10, 110, 300, 25);
      panel.add(success);
      
      frame.setVisible(true);
   }
   
 //give the button actionListener definition
   @Override
   public void actionPerformed(ActionEvent e) {
      //get text of user and the password test
      String user = userText.getText();
      char[] pass = passText.getPassword();
      String password = new String(pass);
      System.out.println(user + " " + password);
      //print select message
      if(user.equals("CJay") && password.equals("password")) {
         success.setText("Login Successfull!");
      } else {
         success.setText("Error");
      }
   }

}
