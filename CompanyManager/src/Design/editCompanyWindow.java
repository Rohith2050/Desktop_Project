package Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Source.company;
import Source.treeNode;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class editCompanyWindow extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel_1;
	private JTextField employeeNameLineEdit;
	private JTextField employeePhoneLineEdit;
	private JTextField employeeReportLineEdit;
	private JTextField employeeSearchLineEdit;
	private JTextField newEmployeeNameLineEdit;
	private JTextField newEmployeePhoneLineEdit;
	private JTextField employeePromoteSearchLineEdit;
	private JTextField employeeNewBossLineEdit;
	private JTextField employeeESearchLineEdit;
	private JTextField employeeNewNameLineEdit;
	private JTextField employeeNewPhoneLineEdit;
	JButton FirePromoteAllButton;
	JLabel companyDisplay;
	JRadioButton firePromoteOneRadioButton;
	JRadioButton replaceEmployeeRadioButton;
	JRadioButton fireEmployeeRadioButton;
	JRadioButton firePromoteAllRadioButton;
	JButton EmployeeReplaceButton;
	JButton EmployeeFindBossButton;
	JButton EmployeeChangeBossButton;
	JButton EmployeeESearchButton;
	JButton EmployeeEditButton;
	JLabel hirePromptLabel;
	JLabel fireOptionPrompt;
	JLabel employeePromoteSearchPrompt;

	/**
	 * Launch the application.
	 */
	company cp;
	private JLabel employeeESearchPrompt;
	//company c=(company)c1.clone();
	//cp = (company)copy.clone();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editCompanyWindow frame = new editCompanyWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cp 
	 * @param c 
	 */

	@SuppressWarnings("deprecation")
	public editCompanyWindow(company c) {
		cp=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 665);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 47, 550, 453);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setToolTipText("");
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		tabbedPane.addTab("Hire Employee(s)", null, panel, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Add one or more employees:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 11, 234, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Names:(comma seperated:a,b,c,..)");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 71, 189, 29);
		panel.add(lblNewLabel_3);
		
		employeeNameLineEdit = new JTextField();
		employeeNameLineEdit.setForeground(new Color(255, 255, 255));
		employeeNameLineEdit.setBackground(new Color(0, 0, 0));
		employeeNameLineEdit.setBounds(217, 75, 297, 20);
		panel.add(employeeNameLineEdit);
		employeeNameLineEdit.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phone Numbers:(comma seperated)  ");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(10, 111, 189, 29);
		panel.add(lblNewLabel_3_1);
		
		employeePhoneLineEdit = new JTextField();
		employeePhoneLineEdit.setForeground(new Color(255, 255, 255));
		employeePhoneLineEdit.setBackground(new Color(0, 0, 0));
		employeePhoneLineEdit.setColumns(10);
		employeePhoneLineEdit.setBounds(217, 115, 297, 20);
		panel.add(employeePhoneLineEdit);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Employees report to:");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(10, 185, 189, 29);
		panel.add(lblNewLabel_3_1_1);
		
		employeeReportLineEdit = new JTextField();
		employeeReportLineEdit.setForeground(new Color(255, 255, 255));
		employeeReportLineEdit.setBackground(new Color(0, 0, 0));
		employeeReportLineEdit.setColumns(10);
		employeeReportLineEdit.setBounds(217, 189, 297, 20);
		panel.add(employeeReportLineEdit);
		
		JButton btnNewButton = new JButton("Hire Employee(s)");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				hirePromptLabel.hide();
				
				System.out.println("Hire Employee-----------");
				ArrayList<ArrayList<String>> newEmployees=new ArrayList<>();;
				
				String employeeNames = employeeNameLineEdit.getText().toString();
				String employeePhone = employeePhoneLineEdit.getText().toString();
				newEmployees = parseEmployeeHireInputs(employeeNames,employeePhone);
				
				String employeesReportTo =  employeeReportLineEdit.getText().toString();
				//System.out.println(employeesReportTo);
				
				//treeNode t=new treeNode("A","B");
				//cp.returnLeader();
				//System.out.println(cp.getName());
				cp.findNode(cp.returnLeader(), employeesReportTo);
				
				if(cp.returnFoundNode()==null) {
					//System.out.println("-------------Null Node-----------");
					hirePromptLabel.setText("Employee Not Fount :( ");
					 employeesReportTo = "";
				}else if(cp.returnFoundNode().returnEmp().equals(employeesReportTo)) {
					if(newEmployees.get(0).size() == newEmployees.get(1).size()) {
						cp.addChildren(cp.returnFoundNode(), newEmployees.get(0), newEmployees.get(1));
						updateCompanyDisplay();
						hirePromptLabel.setText("Hired: " + employeeNames + " under " +  cp.returnFoundNode().returnEmp());
						//employeeNameLineEdit.clear();
						//employeePhoneLineEdit.clear();
						//employeeReportLineEdit.clear();
						cp.resetFoundNode();
					}else {
						hirePromptLabel.setText("Extra name(s) and/or phone numbers! ");
					}
				}
				hirePromptLabel.show();
			}
			
			/*public void updateCompanyDisplay() {
			    ArrayList<Boolean> flag = new ArrayList<>();
			    flag.add(true);
			    companyDisplay.setText(cp.returnEmployees(cp.returnLeader(), flag, 0, true));
			    cp.resetEmployeeString();
			}*/


			private ArrayList<ArrayList<String>> parseEmployeeHireInputs(String s, String p) {
				// TODO Auto-generated method stub
				
				ArrayList<ArrayList<String>> result = new ArrayList<>();

			    ArrayList<String> names = new ArrayList<>();
			    StringTokenizer st = new StringTokenizer(s, ",");
			    while (st.hasMoreTokens()) {
			        names.add(st.nextToken());
			    }

			    ArrayList<String> phoneNumbers = new ArrayList<>();
			    StringTokenizer st2 = new StringTokenizer(p, ",");
			    while (st2.hasMoreTokens()) {
			        phoneNumbers.add(st2.nextToken());
			    }

			    result.add(names);
			    result.add(phoneNumbers);
			    return result;
			}
		});
		btnNewButton.setBounds(217, 263, 127, 23);
		panel.add(btnNewButton);
		
		hirePromptLabel = new JLabel("prompt!");
		hirePromptLabel.setForeground(Color.WHITE);
		hirePromptLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		hirePromptLabel.setBounds(110, 225, 352, 20);
		panel.add(hirePromptLabel);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		tabbedPane.addTab("Fire or Replace Employee", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Search Employee to Fire or Replace:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(10, 11, 277, 23);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Name:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(10, 45, 64, 23);
		panel_1.add(lblNewLabel_5);
		
		employeeSearchLineEdit = new JTextField();
		employeeSearchLineEdit.setBackground(new Color(0, 0, 0));
		employeeSearchLineEdit.setForeground(new Color(255, 255, 255));
		employeeSearchLineEdit.setBounds(69, 45, 289, 20);
		panel_1.add(employeeSearchLineEdit);
		employeeSearchLineEdit.setColumns(10);
		
		JButton EmployeeSearchButton = new JButton("Next");
		EmployeeSearchButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				EmployeeSearchButton.setEnabled(false);
				String employeeName = employeeSearchLineEdit.getText();
				cp.findNode(cp.returnLeader(), employeeName);
				
				if(cp.returnFoundNode() == null) {
					EmployeeSearchButton.setEnabled(true);
					fireOptionPrompt.setText("Employee not found!");
					fireOptionPrompt.show();
				}
				else if(employeeName == cp.returnLeader().returnEmp()) {
					firePromoteOneRadioButton.setEnabled(true);
					replaceEmployeeRadioButton.setEnabled(true);
				}
				else if(cp.returnFoundNode().returnChildren().size()==0) {
					replaceEmployeeRadioButton.setEnabled(true);
					fireEmployeeRadioButton.setEnabled(true); 
				}else if(cp.returnFoundNode().returnChildren().size()==1) {
					replaceEmployeeRadioButton.setEnabled(true);
					firePromoteAllRadioButton.setEnabled(true);
				}else {
					replaceEmployeeRadioButton.setEnabled(true);
					firePromoteOneRadioButton.setEnabled(true);
					firePromoteAllRadioButton.setEnabled(true);
				}
				
			}
		});
		EmployeeSearchButton.setForeground(new Color(0, 0, 0));
		EmployeeSearchButton.setBackground(new Color(255, 255, 255));
		EmployeeSearchButton.setBounds(387, 44, 89, 23);
		panel_1.add(EmployeeSearchButton);
		
		JLabel lblNewLabel_6 = new JLabel("Choose option:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(10, 85, 112, 23);
		panel_1.add(lblNewLabel_6);
		
		replaceEmployeeRadioButton = new JRadioButton("Fire Employees and Replace with New Employee");
		replaceEmployeeRadioButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FirePromoteAllButton.setEnabled(true);
				if(true){
					disableRadioButtons();
					fireOptionPrompt.setText("Details of the new employee");
					fireOptionPrompt.show();
					newEmployeeNameLineEdit.setEnabled(true);
					newEmployeePhoneLineEdit.setEnabled(true);
					EmployeeReplaceButton.setEnabled(true);
				}
			}

			private void disableRadioButtons() {
				// TODO Auto-generated method stub
				fireEmployeeRadioButton.setEnabled(false);
				firePromoteAllRadioButton.setEnabled(false);
				firePromoteOneRadioButton.setEnabled(false);
				replaceEmployeeRadioButton.setEnabled(false);
			}
		});
		replaceEmployeeRadioButton.setForeground(new Color(255, 255, 255));
		replaceEmployeeRadioButton.setBackground(new Color(0, 0, 0));
		replaceEmployeeRadioButton.setBounds(69, 115, 289, 23);
		panel_1.add(replaceEmployeeRadioButton);
		
		fireEmployeeRadioButton = new JRadioButton("Fire Employees");
		fireEmployeeRadioButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FirePromoteAllButton.setEnabled(true);
				FirePromoteAllButton.show();
			}
		});
		fireEmployeeRadioButton.setForeground(Color.WHITE);
		fireEmployeeRadioButton.setBackground(Color.BLACK);
		fireEmployeeRadioButton.setBounds(69, 141, 289, 23);
		panel_1.add(fireEmployeeRadioButton);
		
		firePromoteOneRadioButton = new JRadioButton("Fire Employees,and Promote One Employee Supervised Under him/her");
		firePromoteOneRadioButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FirePromoteAllButton.setEnabled(true);
				if(true) {
					disableRadioButtons();
					List<treeNode> child= cp.returnFoundNode().returnChildren();
					String options = null;
					for(int i=0;i<child.size();i++) {
						options+=child.get(i).returnEmp()+", ";
					}
					fireOptionPrompt.setText("Choose one employee to promote from: "+options);
					fireOptionPrompt.show();
					newEmployeeNameLineEdit.setEnabled(true);
					FirePromoteAllButton.setEnabled(true);
					FirePromoteAllButton.show();
				}
			}
		});
		firePromoteOneRadioButton.setForeground(Color.WHITE);
		firePromoteOneRadioButton.setBackground(Color.BLACK);
		firePromoteOneRadioButton.setBounds(69, 167, 407, 23);
		panel_1.add(firePromoteOneRadioButton);
		
		firePromoteAllRadioButton = new JRadioButton("Fire Employees and Promote All Employees Supervised under him/her");
		firePromoteAllRadioButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				disableRadioButtons();
				FirePromoteAllButton.setEnabled(true);
				FirePromoteAllButton.show();
			}
		});
		firePromoteAllRadioButton.setForeground(Color.WHITE);
		firePromoteAllRadioButton.setBackground(Color.BLACK);
		firePromoteAllRadioButton.setBounds(69, 193, 407, 23);
		panel_1.add(firePromoteAllRadioButton);
		
		JLabel lblNewLabel_7 = new JLabel("Name:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(10, 254, 51, 23);
		panel_1.add(lblNewLabel_7);
		
		newEmployeeNameLineEdit = new JTextField();
		newEmployeeNameLineEdit.setBackground(new Color(0, 0, 0));
		newEmployeeNameLineEdit.setForeground(new Color(255, 255, 255));
		newEmployeeNameLineEdit.setBounds(69, 256, 289, 20);
		panel_1.add(newEmployeeNameLineEdit);
		newEmployeeNameLineEdit.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Phone:");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1.setBounds(10, 288, 51, 23);
		panel_1.add(lblNewLabel_7_1);
		
		newEmployeePhoneLineEdit = new JTextField();
		newEmployeePhoneLineEdit.setForeground(Color.WHITE);
		newEmployeePhoneLineEdit.setColumns(10);
		newEmployeePhoneLineEdit.setBackground(Color.BLACK);
		newEmployeePhoneLineEdit.setBounds(69, 288, 289, 20);
		panel_1.add(newEmployeePhoneLineEdit);
		
		EmployeeReplaceButton = new JButton("Replace");
		EmployeeReplaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeModName = newEmployeeNameLineEdit.getText();
				String employeeModPhone = newEmployeePhoneLineEdit.getText();
				
				cp.returnFoundNode().editEmpDetails(employeeModName, employeeModPhone);
				updateCompanyDisplay();
				EmployeeSearchButton.setEnabled(true);
				replaceEmployeeRadioButton.setEnabled(false);

				//
				//
				//
				//
				//
				//
				
				cp.resetFoundNode();
			}
		});
		EmployeeReplaceButton.setBackground(new Color(255, 255, 255));
		EmployeeReplaceButton.setBounds(387, 267, 89, 23);
		panel_1.add(EmployeeReplaceButton);
		
		FirePromoteAllButton = new JButton("Proceed");
		FirePromoteAllButton.hide();
		FirePromoteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newEmployeeNameLineEdit.isEnabled() == false) {
					cp.deleteNode(cp.returnLeader(), cp.returnFoundNode(), "all");
				}else {
					Boolean match =false;
					String employeeModName = newEmployeeNameLineEdit.getText();
					ArrayList<treeNode> child=cp.returnFoundNode().returnChildren();
					int ct=0;
					while(ct<child.size()) {
						if(child.get(ct).returnEmp() == employeeModName) {
							match = true;
							ct=100000;
						}else {
							ct+=1;
						}
					}
					if(match) {
						cp.deleteNode(cp.returnLeader(), cp.returnFoundNode(), employeeModName);
					}else {
						cp.deleteNode(cp.returnLeader(), cp.returnFoundNode(), child.get(0).returnEmp());
					}
					//update and reset
					updateCompanyDisplay();
					EmployeeSearchButton.setEnabled(true);
					FirePromoteAllButton.setEnabled(false);
					EmployeeReplaceButton.setEnabled(false);
					cp.resetFoundNode();
				}
			}
		});
		FirePromoteAllButton.setEnabled(false);
		FirePromoteAllButton.setBackground(new Color(255, 255, 255));
		FirePromoteAllButton.setForeground(new Color(0, 0, 0));
		FirePromoteAllButton.setBounds(387, 115, 89, 23);
		panel_1.add(FirePromoteAllButton);
		
		fireOptionPrompt = new JLabel("prompt!");
		fireOptionPrompt.setForeground(Color.WHITE);
		fireOptionPrompt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		fireOptionPrompt.setBackground(Color.BLACK);
		fireOptionPrompt.setBounds(40, 223, 318, 23);
		panel_1.add(fireOptionPrompt);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		tabbedPane.addTab("Edit Employee", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8_1 = new JLabel("Search Employee:");
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1.setBackground(Color.BLACK);
		lblNewLabel_8_1.setBounds(10, 11, 329, 33);
		panel_3.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("Name:\r\n");
		lblNewLabel_9_2.setForeground(Color.WHITE);
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9_2.setBackground(Color.BLACK);
		lblNewLabel_9_2.setBounds(10, 55, 61, 27);
		panel_3.add(lblNewLabel_9_2);
		
		employeeESearchLineEdit = new JTextField();
		employeeESearchLineEdit.setForeground(Color.WHITE);
		employeeESearchLineEdit.setColumns(10);
		employeeESearchLineEdit.setBackground(Color.BLACK);
		employeeESearchLineEdit.setBounds(91, 59, 329, 20);
		panel_3.add(employeeESearchLineEdit);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("New Name:\r\n");
		lblNewLabel_9_2_1.setForeground(Color.WHITE);
		lblNewLabel_9_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9_2_1.setBackground(Color.BLACK);
		lblNewLabel_9_2_1.setBounds(10, 119, 80, 27);
		panel_3.add(lblNewLabel_9_2_1);
		
		employeeNewNameLineEdit = new JTextField();
		employeeNewNameLineEdit.setForeground(Color.WHITE);
		employeeNewNameLineEdit.setColumns(10);
		employeeNewNameLineEdit.setBackground(Color.BLACK);
		employeeNewNameLineEdit.setBounds(91, 123, 329, 20);
		panel_3.add(employeeNewNameLineEdit);
		
		JLabel lblNewLabel_9_2_1_1 = new JLabel("New Phone:\r\n");
		lblNewLabel_9_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_9_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9_2_1_1.setBackground(Color.BLACK);
		lblNewLabel_9_2_1_1.setBounds(10, 157, 80, 27);
		panel_3.add(lblNewLabel_9_2_1_1);
		
		employeeNewPhoneLineEdit = new JTextField();
		employeeNewPhoneLineEdit.setForeground(Color.WHITE);
		employeeNewPhoneLineEdit.setColumns(10);
		employeeNewPhoneLineEdit.setBackground(Color.BLACK);
		employeeNewPhoneLineEdit.setBounds(91, 161, 329, 20);
		panel_3.add(employeeNewPhoneLineEdit);
		
		EmployeeESearchButton = new JButton("Next");
		EmployeeESearchButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				EmployeeESearchButton.setEnabled(false);
				String employeeName = employeeESearchLineEdit.getText();
				cp.findNode(cp.returnLeader(), employeeName);
				if(cp.returnFoundNode() == null) {
					EmployeeESearchButton.setEnabled(true);
					employeeESearchPrompt.setText("Employee not found!");
					employeeESearchPrompt.show();
				}else {
					EmployeeESearchButton.setEnabled(false);
					employeeESearchPrompt.setText("Found Employee "+cp.returnFoundNode().returnEmp());
					employeeESearchPrompt.show();
					employeeNewNameLineEdit.setEnabled(true);
					employeeNewPhoneLineEdit.setEnabled(true);
					EmployeeEditButton.setEnabled(true);
				}
			}
		});
		EmployeeESearchButton.setBackground(new Color(255, 255, 255));
		EmployeeESearchButton.setBounds(430, 58, 80, 23);
		panel_3.add(EmployeeESearchButton);
		
		EmployeeEditButton = new JButton("Finish");
		EmployeeEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = employeeNewNameLineEdit.getText();
				String newPhone = employeeNewPhoneLineEdit.getText();
				if(!newName.isEmpty() && !newPhone.isEmpty()) {
					cp.returnFoundNode().editEmpDetails(newName, newPhone);
					updateCompanyDisplay();
					employeeESearchPrompt.setText("Done");
					EmployeeESearchButton.setEnabled(true);
					cp.resetFoundNode();
				}else {
					employeeESearchPrompt.setText("Name and/or Phone field is empty!");
				}
				
			}
		});
		EmployeeEditButton.setBackground(new Color(255, 255, 255));
		EmployeeEditButton.setBounds(430, 138, 80, 23);
		panel_3.add(EmployeeEditButton);
		
		employeeESearchPrompt = new JLabel("prompt!");
		employeeESearchPrompt.setForeground(Color.WHITE);
		employeeESearchPrompt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		employeeESearchPrompt.setBackground(Color.BLACK);
		employeeESearchPrompt.setBounds(10, 93, 329, 20);
		panel_3.add(employeeESearchPrompt);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		tabbedPane.addTab("Change Boss", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Search Employee to promote or demote:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(0, 0, 0));
		lblNewLabel_8.setBounds(10, 11, 329, 33);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Name:\r\n");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBackground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(10, 49, 61, 27);
		panel_2.add(lblNewLabel_9);
		
		employeePromoteSearchLineEdit = new JTextField();
		employeePromoteSearchLineEdit.setForeground(new Color(255, 255, 255));
		employeePromoteSearchLineEdit.setBackground(new Color(0, 0, 0));
		employeePromoteSearchLineEdit.setBounds(81, 53, 329, 20);
		panel_2.add(employeePromoteSearchLineEdit);
		employeePromoteSearchLineEdit.setColumns(10);
		
		EmployeeFindBossButton = new JButton("Next");
		EmployeeFindBossButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String employeePromoteName = employeePromoteSearchLineEdit.getText();
				cp.findNode(cp.returnLeader(), employeePromoteName);
				if(cp.returnFoundNode() == null || cp.returnFoundNode() == cp.returnLeader()) {
					employeePromoteSearchPrompt.setText("Employee not found, or cannot change the CEO's position!");
					employeePromoteSearchPrompt.setEnabled(true);
					employeePromoteSearchPrompt.show();
				}else {
					employeePromoteSearchPrompt.setText("Employee reports to: " + cp.returnFoundNode().returnParent().returnEmp());
					employeePromoteSearchPrompt.show();
					EmployeeFindBossButton.setEnabled(true);
					employeeNewBossLineEdit.setEnabled(true);
				}
			}
		});
		EmployeeFindBossButton.setBackground(new Color(255, 255, 255));
		EmployeeFindBossButton.setBounds(420, 52, 109, 23);
		panel_2.add(EmployeeFindBossButton);
		
		JLabel lblNewLabel_9_1 = new JLabel("New Boss:");
		lblNewLabel_9_1.setForeground(Color.WHITE);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9_1.setBackground(Color.BLACK);
		lblNewLabel_9_1.setBounds(10, 114, 61, 27);
		panel_2.add(lblNewLabel_9_1);
		
		employeeNewBossLineEdit = new JTextField();
		employeeNewBossLineEdit.setForeground(Color.WHITE);
		employeeNewBossLineEdit.setColumns(10);
		employeeNewBossLineEdit.setBackground(Color.BLACK);
		employeeNewBossLineEdit.setBounds(81, 118, 329, 20);
		panel_2.add(employeeNewBossLineEdit);
		
		EmployeeChangeBossButton = new JButton("Change Boss");
		EmployeeChangeBossButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String employeeNewBoss = employeeNewBossLineEdit.getText().toString();
				if(!employeeNewBoss.isEmpty()) {
					cp.changeParent(cp.returnLeader(), cp.returnFoundNode(), employeeNewBoss);
					updateCompanyDisplay();
					employeePromoteSearchPrompt.hide();
					//
					EmployeeFindBossButton.setEnabled(true);
					cp.resetFoundNode();
				}
			}
		});
		EmployeeChangeBossButton.setBackground(new Color(255, 255, 255));
		EmployeeChangeBossButton.setBounds(420, 117, 109, 23);
		panel_2.add(EmployeeChangeBossButton);
		
		employeePromoteSearchPrompt = new JLabel("prompt!");
		employeePromoteSearchPrompt.setForeground(Color.WHITE);
		employeePromoteSearchPrompt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		employeePromoteSearchPrompt.setBackground(Color.BLACK);
		employeePromoteSearchPrompt.setBounds(20, 83, 297, 20);
		panel_2.add(employeePromoteSearchPrompt);
		
		JLabel lblNewLabel = new JLabel("Edit Your Company: ");
		lblNewLabel.setBounds(10, 11, 165, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(185, 11, 131, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("Update Company View\r\n");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCompanyDisplay();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.setBounds(881, 14, 165, 28);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_10 = new JLabel("Your Company Tree\r\n:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10.setBackground(new Color(0, 0, 0));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(908, 53, 122, 14);
		contentPane.add(lblNewLabel_10);
		
		companyDisplay = new JLabel("Details");
		companyDisplay.setForeground(new Color(255, 255, 255));
		companyDisplay.setBounds(570, 134, 741, 366);
		contentPane.add(companyDisplay);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon(editCompanyWindow.class.getResource("/Resource/wallpaperflare.com_wallpaper (2).jpg")));
		lblNewLabel_11.setBounds(0, 0, 1321, 626);
		contentPane.add(lblNewLabel_11);
	}

	public editCompanyWindow() {
		// TODO Auto-generated constructor stub
	}
	
	
	List<Boolean> flag = new ArrayList<>();
	public void updateCompanyDisplay() {
	    flag.add(true);
	    companyDisplay.setText("<html>"+cp.returnEmployees(cp.returnLeader(), flag, 0, true)+"</html>");
	    cp.resetEmployeeString();
	}

	protected void disableRadioButtons() {
		// TODO Auto-generated method stub
		fireEmployeeRadioButton.setEnabled(false);
		firePromoteAllRadioButton.setEnabled(false);
		firePromoteOneRadioButton.setEnabled(false);
		replaceEmployeeRadioButton.setEnabled(false);
	}
}
