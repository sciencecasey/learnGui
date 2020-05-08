package swingTutorials;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

/*
 * @author modified from ProgrammingKnowledge
 * https://www.youtube.com/watch?v=-GoqPrxM8TQ
 */
public class Frame1 {

   private JFrame frame;
   private JTextField textFieldNum2;
   private JTextField textFieldNum1;
   private JButton btnAdd;
   private JButton btnSubtract;
   private JTextField answerField;
   private JLabel lblAnswer;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Frame1 window = new Frame1();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Frame1() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      textFieldNum2 = new JTextField();
      textFieldNum2.setBounds(37, 24, 130, 26);
      frame.getContentPane().add(textFieldNum2);
      textFieldNum2.setColumns(10);
      
      textFieldNum1 = new JTextField();
      textFieldNum1.setBounds(237, 24, 130, 26);
      frame.getContentPane().add(textFieldNum1);
      textFieldNum1.setColumns(10);
      
      btnAdd = new JButton("Add");
      btnAdd.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            float number1;
            float number2;
            float ans;
            try {
               number1 = Float.parseFloat(textFieldNum1.getText().strip());
               number2 = Float.parseFloat(textFieldNum2.getText().strip());
               ans = (Float) number1 + number2;
               answerField.setText(Float.toString(ans));
            }catch(Exception e) {
               JOptionPane.showMessageDialog(null, "Enter valid numbers");
            }
         }
      });
      btnAdd.setBounds(37, 87, 117, 29);
      frame.getContentPane().add(btnAdd);
      
      btnSubtract = new JButton("Subtract");
      btnSubtract.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            float number1;
            float number2;
            float ans;
            try {
               number1 = Float.parseFloat(textFieldNum1.getText().strip());
               number2 = Float.parseFloat(textFieldNum2.getText().strip());
               ans = (Float) number1 - number2;
               answerField.setText(Float.toString(ans));
            }catch(Exception e) {
               JOptionPane.showMessageDialog(null, "Enter valid numbers");
            }
         }
      });
      btnSubtract.setBounds(237, 87, 117, 29);
      frame.getContentPane().add(btnSubtract);
      
      answerField = new JTextField();
      answerField.setBounds(141, 166, 130, 26);
      frame.getContentPane().add(answerField);
      answerField.setColumns(10);
      
      lblAnswer = new JLabel("Answer: ");
      lblAnswer.setBounds(68, 171, 61, 16);
      frame.getContentPane().add(lblAnswer);
   }
}
