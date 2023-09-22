package Design;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class main extends JFrame {

	JFrame frame;
	private JPanel contentPane;
    JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setTitle("Company Management\r\n");
		setAlwaysOnTop(true);
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Company Name");
		lblNewLabel.setBounds(160, 80, 177, 43);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 142, 296, 22);
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 0, 0));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setBounds(196, 186, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputText=textField.getText();
				Page2 p2=new Page2();
				p2.lblNewLabel_2_1_2.setText(inputText);
				p2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnNewButton);
		
		JLabel lblCompanyManager = new JLabel("Company Manager");
		lblCompanyManager.setForeground(new Color(192, 192, 192));
		lblCompanyManager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompanyManager.setEnabled(false);
		lblCompanyManager.setBackground(Color.BLACK);
		lblCompanyManager.setBounds(173, 11, 136, 33);
		contentPane.add(lblCompanyManager);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(main.class.getResource("/Resource/imgonline-com-ua-resize-Bx9EuKIYgAdn.jpg")));
		lblNewLabel_1.setBounds(10, -11, 493, 269);
		contentPane.add(lblNewLabel_1);
	}
}
