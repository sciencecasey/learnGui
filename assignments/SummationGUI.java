package assignments;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JFormattedTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * @author Casey Jayne using WindowBuilder automated code generation
 * A Simple summation gui which takes 2 values and provides the sum (using floats)
 * Null value returned for non-numerics
 */
public class SummationGUI {

   private JFrame frame;
   private JTextField textFieldTotal;
   private Float value1 = 0f;
   private Float value2= 0f;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               SummationGUI window = new SummationGUI();
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
   public SummationGUI() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      //setup the main window
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 130);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{0, 0, 0};
      gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
      gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
      frame.getContentPane().setLayout(gridBagLayout);
      
      //setup the labels for Values Input Fields
      JLabel labelVal1 = new JLabel("Value 1");
      GridBagConstraints gbc_labelVal1 = new GridBagConstraints();
      gbc_labelVal1.anchor = GridBagConstraints.SOUTH;
      gbc_labelVal1.insets = new Insets(0, 0, 5, 5);
      gbc_labelVal1.gridx = 0;
      gbc_labelVal1.gridy = 0;
      frame.getContentPane().add(labelVal1, gbc_labelVal1);
      
      JLabel labelVal2 = new JLabel("Value 2");
      GridBagConstraints gbc_labelVal2 = new GridBagConstraints();
      gbc_labelVal2.anchor = GridBagConstraints.SOUTH;
      gbc_labelVal2.insets = new Insets(0, 0, 5, 0);
      gbc_labelVal2.gridx = 1;
      gbc_labelVal2.gridy = 0;
      frame.getContentPane().add(labelVal2, gbc_labelVal2);
      
      //setup the input fields themselves
      JFormattedTextField formattedTextFieldVal1 = new JFormattedTextField();
      GridBagConstraints gbc_formattedTextFieldVal1 = new GridBagConstraints();
      gbc_formattedTextFieldVal1.insets = new Insets(0, 0, 5, 5);
      gbc_formattedTextFieldVal1.fill = GridBagConstraints.HORIZONTAL;
      gbc_formattedTextFieldVal1.gridx = 0;
      gbc_formattedTextFieldVal1.gridy = 1;
      frame.getContentPane().add(formattedTextFieldVal1, gbc_formattedTextFieldVal1);
      
      
      JFormattedTextField formattedTextFieldVal2 = new JFormattedTextField();
      GridBagConstraints gbc_formattedTextFieldVal2 = new GridBagConstraints();
      gbc_formattedTextFieldVal2.insets = new Insets(0, 0, 5, 0);
      gbc_formattedTextFieldVal2.fill = GridBagConstraints.HORIZONTAL;
      gbc_formattedTextFieldVal2.gridx = 1;
      gbc_formattedTextFieldVal2.gridy = 1;
      frame.getContentPane().add(formattedTextFieldVal2, gbc_formattedTextFieldVal2);
      
      //create the summation button
      JButton btnSum = new JButton("Calculate Sum");
      GridBagConstraints gbc_btnSum = new GridBagConstraints();
      gbc_btnSum.insets = new Insets(0, 0, 0, 5);
      gbc_btnSum.gridx = 0;
      gbc_btnSum.gridy = 2;
      frame.getContentPane().add(btnSum, gbc_btnSum);
      //create an action associated with button press to perform summation
      btnSum.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
            //set Values from input
            setValue1(formattedTextFieldVal1.getText().strip());
            setValue2(formattedTextFieldVal2.getText().strip());
            //print summation to field
               try {
                  //in case of null value from non-numeric input
                  float total = (float) (getValue1() + getValue2()); 
                  textFieldTotal.setText(Float.toString(total));
               } catch(Exception except) {
                  //non-numeric input
                  textFieldTotal.setText("Null");
               } 
            } catch(Exception except) {
               except.printStackTrace();
            } finally {
               //resetValues to zero no matter what
               setValue1("0");
               setValue2("0");
            }
         }
      });
      //create a text field in which to print the total
      textFieldTotal = new JTextField();
      //don't allow text input to this field
      textFieldTotal.setEditable(false);
      GridBagConstraints gbc_textFieldTotal = new GridBagConstraints();
      gbc_textFieldTotal.fill = GridBagConstraints.HORIZONTAL;
      gbc_textFieldTotal.gridx = 1;
      gbc_textFieldTotal.gridy = 2;
      frame.getContentPane().add(textFieldTotal, gbc_textFieldTotal);
      textFieldTotal.setColumns(10);
   }
   /*
    * set value based on user input to text field (setting occurs after button press)
    */
   private void setValue1(String input) {
      try {
         this.value1 = Float.parseFloat(input);
      } catch(Exception except) {
         //keep value 0
         this.value1 = null;
      }
   }
   /*
    * get the Value from user input to use in action listener
    */
   public float getValue1() {
      return (float) this.value1;
   }
   /*
    * set value based on user input to text field (setting occurs after button press)
    */
   private void setValue2(String input) {
      try {
         this.value2 = Float.parseFloat(input);
      } catch(Exception except) {
         //keep value 0
         this.value2 = null;
      }
   }
   /*
    * get the Value from user input to use in action listener
    */
   public float getValue2() {
      return (float) this.value2;
   }

}
