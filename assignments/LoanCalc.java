package assignments;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/*
 * @author Casey Jayne and automated code created by WindowBuilder
 * Gui takes a float interst rate, loan length (in years), and loan amount
 * then calculates a fixed rate repayment and total payment from given inputs
 */
public class LoanCalc extends JFrame {
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTextField intRateInput;
   private JTextField numYearsInput;
   private JTextField loanAmtInput;
   private JTextField monthPayDisplay;
   private JTextField totalPayDisplay;
   
   //create variables for calculations
   private Float intRate;
   private Float loanLength;
   private Float loanAmt;
   private Float monthPay;
   private Float totalPay;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               LoanCalc frame = new LoanCalc();
               frame.setTitle("Loan Calculator");
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   /*
    * return interest rate
    */
   private Float getIntRate() {
      return intRate;
   }
   /*
    * @param intRate 
    */
   private void setIntRate(String interestInput) {
      //convert to monthly interest rate
      try {
         float tempRate = Float.parseFloat(interestInput);
         //make decimal
         tempRate/=100;
         //make monthly
         tempRate/=12;
         this.intRate = (Float) tempRate;
      } catch(Exception e) {
         this.intRate = null;
      };
   }
   /*
    * return loan length in months as float object
    */
   private Float getLoanLength() {
      return loanLength;
   }
   /*
    * set loan length in months
    */
   private void setLoanLength(String input) {
      try {
         this.loanLength = (Float.parseFloat(input))*12;
      } catch(Exception e) {
         //nonnumeric string input
         this.loanLength = null;
      }
   }
   /*
    * return loan amt as float object
    */
   private Float getLoanAmt() {
      return loanAmt;
   }
   /*
    * set loan amount from input
    */
   private void setLoanAmt(String loanAmt) {
      try {
         this.loanAmt = Float.parseFloat(loanAmt);
      } catch(Exception e) {
         this.loanAmt = null;
      }
   }
   /*
    * return monthly pay
    */
   private Float getMonthPay() {
      return monthPay;
   }
   /*
    * set monthly pay when action listener called by given calculation
    */
   private void setMonthPay() {
      try { 
         //calculate numerator and denominator
         float numer = (getIntRate()*getLoanAmt());
         float denom = (float) 
               (1- (Math.pow ((1+getIntRate()), -getLoanLength())));
         this.monthPay = (Float) numer/denom;
      } catch (Exception e) {
         this.monthPay = null;
      } 
   }
   /*
    * get Total Payment
    */
   private Float getTotalPay() {
      return totalPay;
   }
   /*
    * calculate total pay from the month pay
    */
   private void setTotalPay() {
      try{
         this.totalPay = (getLoanLength() * getMonthPay());
      } catch (Exception e) {
         this.totalPay = null;
      }
   }

   /**
    * Create the frame.
    */
   public LoanCalc() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 338, 328);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      //create lables
      JLabel loanLengthTxt = new JLabel("Number of Years");
      loanLengthTxt.setBounds(18, 68, 131, 26);
      contentPane.add(loanLengthTxt);
      
      JLabel paymentTxt = new JLabel("Monthly Payment");
      paymentTxt.setBounds(18, 162, 117, 26);
      contentPane.add(paymentTxt);
      
      JLabel loanAmountTxt = new JLabel("Loan Amount");
      loanAmountTxt.setBounds(18, 115, 117, 26);
      contentPane.add(loanAmountTxt);
      
      JLabel totalPaymentTxt = new JLabel("Total Payment");
      totalPaymentTxt.setBounds(18, 209, 117, 26);
      contentPane.add(totalPaymentTxt);
      
      JLabel intRateTxt = new JLabel("Annual Interest Rate");
      intRateTxt.setBounds(18, 21, 137, 26);
      contentPane.add(intRateTxt);
      
      //create button
      JButton calculate = new JButton("Calculate");
      //button performs calculations and prints output
      calculate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               //set the variables via txt inputs
               setLoanAmt(loanAmtInput.getText().strip());
               setIntRate(intRateInput.getText().strip());
               setLoanLength(numYearsInput.getText().strip());
               setMonthPay();
               setTotalPay();
               //print monthly and total pay
               //parse to 2 values after decimal 
               DecimalFormat df = new DecimalFormat("#.##");
               monthPayDisplay.setText("$" + df.format(getMonthPay()));
               totalPayDisplay.setText("$" + df.format(getTotalPay()));
            } catch(Exception ex) {
               //if formatting can't work for null values (non-numeric input)
               monthPayDisplay.setText("Null");
               totalPayDisplay.setText("Null");
            } finally {
               //reset calculator for multiple uses
               setLoanAmt(null);
               setIntRate(null);
               setLoanLength(null);
               setMonthPay();
               setTotalPay();
            }
         }
      });
      calculate.setBounds(174, 256, 117, 29);
      contentPane.add(calculate);
      
      //create input fields for user
      intRateInput = new JTextField();
      intRateInput.setHorizontalAlignment(SwingConstants.RIGHT);
      intRateInput.setBounds(161, 21, 130, 26);
      contentPane.add(intRateInput);
      intRateInput.setColumns(10);
      
      numYearsInput = new JTextField();
      numYearsInput.setHorizontalAlignment(SwingConstants.RIGHT);
      numYearsInput.setBounds(161, 68, 130, 26);
      contentPane.add(numYearsInput);
      numYearsInput.setColumns(10);
      
      loanAmtInput = new JTextField();
      loanAmtInput.setHorizontalAlignment(SwingConstants.RIGHT);
      loanAmtInput.setBounds(161, 115, 130, 26);
      contentPane.add(loanAmtInput);
      loanAmtInput.setColumns(10);
      
      //create output fields to non-editable
      monthPayDisplay = new JTextField();
      monthPayDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
      monthPayDisplay.setEditable(false);
      monthPayDisplay.setBounds(161, 162, 130, 26);
      contentPane.add(monthPayDisplay);
      monthPayDisplay.setColumns(10);
      
      totalPayDisplay = new JTextField();
      totalPayDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
      totalPayDisplay.setEditable(false);
      totalPayDisplay.setBounds(161, 209, 130, 26);
      contentPane.add(totalPayDisplay);
      totalPayDisplay.setColumns(10);
   }
}
