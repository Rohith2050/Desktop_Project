package Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Source.company;
import Source.treeNode;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Page2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lblNewLabel_2_1_2;
	JLabel lblNewLabel_1_1_1;
	JButton btnNewButton_1;
	JLabel prompt;
	JButton btnNext;
	
	company c=new company();
	//company c1=(company)c.clone()
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page2 frame = new Page2();
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
	public Page2() {
		setBackground(new Color(128, 128, 128));
		setTitle("Setting Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Setup Your Company:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(10, 11, 172, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Who is in charge and how many people report to him/her?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 48, 333, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Leader First Name:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 85, 126, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Leader Phone Number:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 113, 126, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Number of employees managed:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(10, 138, 155, 24);
		contentPane.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 0, 0));
		textField.setBounds(181, 85, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(0, 0, 0));
		textField_1.setColumns(10);
		textField_1.setBounds(181, 113, 162, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(0, 0, 0));
		textField_2.setColumns(10);
		textField_2.setBounds(181, 140, 162, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
				String name=textField.getText().toString();
				String phone=textField_1.getText().toString();
				lblNewLabel_1_1_1.setText(name);
				btnNewButton_1.setEnabled(true);
				
				//////////////////////////////////////////	
				//Number of Leader Child
				String x=textField_2.getText().toString();
				int nleaderChild=0;
				if(!name.isEmpty() && !phone.isEmpty()) {
					
					c.setLeader(name, phone);
					try {
						nleaderChild=Integer.parseInt(x);
					}catch(Exception e1){
						prompt.setText("Numbers missing");
					}
					
					if(nleaderChild>0) {
						textField.setEnabled(false);
						textField_1.setEnabled(false);
						textField_2.setEnabled(false);
						btnNewButton.setEnabled(false);
						prompt.hide();
					}else {
						prompt.setText("You must have atleast 1 employee reporting to leader!");
						prompt.setEnabled(true);
						prompt.show();
					}
				}else if(name==null || phone==null) {
					prompt.setText("Missing name or phone number");
					prompt.hide();
				}
			}
		});
		btnNewButton.setBounds(386, 114, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add Employees Reporting To:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 188, 231, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Names: (comma seperated: a,b,c..)");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(10, 225, 216, 26);
		contentPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBackground(new Color(0, 0, 0));
		textField_3.setColumns(10);
		textField_3.setBounds(236, 228, 297, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Phone Numbers: (comma seperated)");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(10, 259, 216, 26);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(new Color(0, 0, 0));
		textField_4.setColumns(10);
		textField_4.setBounds(236, 262, 297, 20);
		contentPane.add(textField_4);
		
		btnNewButton_1 = new JButton("Add Employees");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String employeeNames = textField_3.getText().toString();
				String employeephoneNumbers = textField_4.getText().toString();
				
				ArrayList<String> names = parseEmployeeInputs(employeeNames);
				ArrayList<String> numbers = parseEmployeeInputs(employeephoneNumbers);
				System.out.print(names+"\n");
				System.out.print(numbers+"\n");
				
				if(names.size() == numbers.size()) {
					btnNewButton_1.setEnabled(false);
					prompt.hide();
					c.addChildren(c.returnLeader(), names, numbers);
					btnNext.show();
					btnNext.setEnabled(true);
				}else {
					prompt.setText("Extra name(s) and/or phone numbers!");
					prompt.show();
				}
			}
			
			
			//////////////////////////
			private ArrayList<String> parseEmployeeInputs(String s) {
				// TODO Auto-generated method stub
				/*List<String> result =new ArrayList<String>();
				String ss[]=s.split(",");
				for(int i=0;i<ss.length;i++) {
					result.add(ss[i]);
				}
				return result;*/
				ArrayList<String> result = new ArrayList<>();
		        Scanner scanner = new Scanner(s);
		        scanner.useDelimiter(",");
		        while (scanner.hasNext()) {
		            String substr = scanner.next();
		            result.add(substr);
		        }
		        scanner.close();
		        return result;
			}
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(572, 244, 126, 23);
		contentPane.add(btnNewButton_1);
		
		btnNext = new JButton("Next");
		//
		btnNext.setEnabled(false);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//treeNode c1=c.root;
				editCompanyWindow ed=new editCompanyWindow(c);
				ed.setVisible(true);
				ed.lblNewLabel_1.setText(lblNewLabel_2_1_2.getText());
				dispose();
			}
		});
		btnNext.setBounds(202, 317, 89, 23);
		contentPane.add(btnNext);
		
		lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setBounds(181, 13, 216, 26);
		contentPane.add(lblNewLabel_2_1_2);
		
		lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(251, 188, 231, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		prompt = new JLabel("prompt!!");
		prompt.setForeground(new Color(255, 255, 255));
		prompt.setBackground(new Color(0, 0, 0));
		prompt.setBounds(251, 292, 282, 14);
		contentPane.add(prompt);
		
		JLabel Image2 = new JLabel("New label");
		Image2.setIcon(new ImageIcon(Page2.class.getResource("/Resource/imgonline-com-ua-resize-ASqJtbxZyAGTXF8M.jpg")));
		Image2.setBounds(0, 0, 746, 373);
		contentPane.add(Image2);
	}
}
