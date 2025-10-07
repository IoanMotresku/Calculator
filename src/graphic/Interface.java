package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import calculus.Calculus;
import java.awt.Color;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    UIManager.setLookAndFeel(new FlatLightLaf());

					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(6, 6, 438, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton Button_1 = new JButton("1");
		Button_1.addActionListener(this::appendValueFromButton);
		Button_1.setBounds(16, 56, 75, 38);
		contentPane.add(Button_1);
		
		JButton Button_2 = new JButton("2");
		Button_2.addActionListener(this::appendValueFromButton);
		Button_2.setBounds(103, 56, 75, 38);
		contentPane.add(Button_2);
		
		JButton Button_3 = new JButton("3");
		Button_3.addActionListener(this::appendValueFromButton);
		Button_3.setBounds(190, 56, 75, 38);
		contentPane.add(Button_3);
		
		JButton Button_4 = new JButton("4");
		Button_4.addActionListener(this::appendValueFromButton);
		Button_4.setBounds(16, 104, 75, 38);
		contentPane.add(Button_4);
		
		JButton Button_5 = new JButton("5");
		Button_5.addActionListener(this::appendValueFromButton);
		Button_5.setBounds(103, 104, 75, 38);
		contentPane.add(Button_5);
		
		JButton Button_6 = new JButton("6");
		Button_6.addActionListener(this::appendValueFromButton);
		Button_6.setBounds(190, 104, 75, 38);
		contentPane.add(Button_6);
		
		JButton Button_9 = new JButton("9");
		Button_9.addActionListener(this::appendValueFromButton);
		Button_9.setBounds(190, 154, 75, 38);
		contentPane.add(Button_9);
		
		JButton Button_8 = new JButton("8");
		Button_8.addActionListener(this::appendValueFromButton);
		Button_8.setBounds(103, 154, 75, 38);
		contentPane.add(Button_8);
		
		JButton Button_7 = new JButton("7");
		Button_7.addActionListener(this::appendValueFromButton);
		Button_7.setBounds(16, 154, 75, 38);
		contentPane.add(Button_7);
		
		JButton Button_0 = new JButton("0");
		Button_0.addActionListener(this::appendValueFromButton);
		Button_0.setBounds(16, 204, 75, 38);
		contentPane.add(Button_0);
		
		JButton Button_Dott = new JButton(".");
		Button_Dott.addActionListener(this::appendValueFromButton);
		Button_Dott.setBounds(103, 204, 75, 38);
		contentPane.add(Button_Dott);
		
		JButton Button_Equal = new JButton("=");
		Button_Equal.addActionListener(e -> performCalculations());
		Button_Equal.setBounds(190, 204, 75, 38);
		contentPane.add(Button_Equal);
		
		JButton Button_Back = new JButton("⌫");
		Button_Back.addActionListener(e -> deleteLastChar());
		Button_Back.setBounds(277, 56, 75, 38);
		contentPane.add(Button_Back);
		
		JButton Button_LeftParenthesis = new JButton("(");
		Button_LeftParenthesis.addActionListener(this::appendValueFromButton);
		Button_LeftParenthesis.setBounds(277, 104, 75, 38);
		contentPane.add(Button_LeftParenthesis);
		
		JButton Button_Division = new JButton("/");
		Button_Division.addActionListener(this::appendValueFromButton);
		Button_Division.setBounds(277, 154, 75, 38);
		contentPane.add(Button_Division);
		
		JButton Button_Minus = new JButton("-");
		Button_Minus.addActionListener(this::appendValueFromButton);
		Button_Minus.setBounds(277, 204, 75, 38);
		contentPane.add(Button_Minus);
		
		JButton Button_Clear = new JButton("AC");
		Button_Clear.addActionListener(e -> clearAll());
		Button_Clear.setBounds(364, 56, 75, 38);
		contentPane.add(Button_Clear);
		
		JButton Button_RightParenthesis = new JButton(")");
		Button_RightParenthesis.addActionListener(this::appendValueFromButton);
		Button_RightParenthesis.setBounds(364, 104, 75, 38);
		contentPane.add(Button_RightParenthesis);
		
		JButton Button_Multiplication = new JButton("*");
		Button_Multiplication.addActionListener(this::appendValueFromButton);
		Button_Multiplication.setBounds(364, 154, 75, 38);
		contentPane.add(Button_Multiplication);
		
		JButton Button_Plus = new JButton("+");
		Button_Plus.addActionListener(this::appendValueFromButton);
		Button_Plus.setBounds(364, 204, 75, 38);
		contentPane.add(Button_Plus);

	}
	
	private void appendValueFromButton(ActionEvent e) {
	    JButton source = (JButton) e.getSource(); 
	    String value = source.getText();          
	    String current = textField.getText();
	    textField.setText(current + value);
	}
	private void deleteLastChar() {
	    String current = textField.getText();
	    if (!current.isEmpty()) {
	        textField.setText(current.substring(0, current.length() - 1));
	    }
	}
	private void clearAll() {
	    textField.setText("");
	}
	private void performCalculations() {
		try {
			double result = Calculus.performCalculations(textField.getText());
			textField.setText(String.valueOf(result));
			textField.setForeground(Color.BLACK);

		} catch(Exception e) {
			textField.setForeground(Color.RED);

		
		}
	}


}
