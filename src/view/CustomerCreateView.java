package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.AffiliationBusiness;
import model.business.CustomerBusiness;
import model.entities.Address;
import model.entities.Affiliation;
import model.entities.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.time.LocalDate;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class CustomerCreateView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField textField;
	private JLabel lblBroncoId;
	private JTextField textField_1;
	private JCheckBox chckbxStudent;
	private JCheckBox chckbxProfessor;
	private JButton btnCreate;
	private JButton btnCancel;
	private JButton btnBack;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblEnterDate;
	private JTextField textField_4;
	private JLabel lblGradDate;
	private JTextField textField_5;
	private JPanel studentPanel;
	private JPanel professorPanel;
	private JLabel lblOffice;
	private JTextField textField_6;
	private JLabel lblResearch;
	private JTextField textField_7;
	private JLabel lblDepartment;
	private JTextField textField_8;
	private JLabel lblMajor;
	private JLabel lblMinor;
	private JLabel lblDob;
	private JTextField textField_9;
	private JLabel lblPhone;
	private JTextField textField_10;
	private JLabel lblStreetNumber;
	private JTextField textField_11;
	private JLabel lblStreet;
	private JTextField textField_12;
	private JLabel lblCity;
	private JTextField textField_13;
	private JLabel lblState;
	private JTextField textField_14;
	private JLabel lblZipCode;
	private JTextField textField_15;

	public CustomerCreateView() {
		initializeComponents();
		buildUI();
	}

	private void initializeComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblName = new JLabel("Name:");
		lblName.setBounds(12, 12, 70, 15);

		textField = new JTextField();
		textField.setBounds(12, 28, 114, 19);
		textField.setColumns(10);

		lblBroncoId = new JLabel("Bronco ID:");
		lblBroncoId.setBounds(10, 59, 72, 15);

		textField_1 = new JTextField();
		textField_1.setBounds(12, 75, 114, 19);
		textField_1.setColumns(10);

		chckbxStudent = new JCheckBox("Student");
		chckbxStudent.setBounds(12, 276, 82, 23);
		chckbxStudent.addItemListener(e -> studentPanel.setVisible(e.getStateChange() == ItemEvent.SELECTED));

		chckbxProfessor = new JCheckBox("Professor");
		chckbxProfessor.setBounds(106, 276, 94, 23);
		chckbxProfessor.addItemListener(e -> professorPanel.setVisible(e.getStateChange() == ItemEvent.SELECTED));

		btnCreate = new JButton("Create");
		btnCreate.setBounds(12, 326, 82, 25);
		btnCreate.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(106, 326, 81, 25);
		btnCancel.addActionListener(this);

		btnBack = new JButton("Back");
		btnBack.setBounds(477, 326, 117, 25);
		btnBack.addActionListener(this);
	}

	private void buildUI() {
		contentPane.add(lblName);
		contentPane.add(textField);
		contentPane.add(lblBroncoId);
		contentPane.add(textField_1);
		contentPane.add(chckbxStudent);
		contentPane.add(chckbxProfessor);
		contentPane.add(btnCreate);
		contentPane.add(btnCancel);
		contentPane.add(btnBack);

		studentPanel = new JPanel();
		studentPanel.setBounds(304, 12, 290, 96);
		studentPanel.setVisible(false);
		contentPane.add(studentPanel);
		studentPanel.setLayout(null);

		lblMajor = new JLabel("Major:");
		lblMajor.setBounds(12, 12, 70, 15);
		studentPanel.add(lblMajor);

		textField_2 = new JTextField();
		textField_2.setBounds(12, 26, 114, 19);
		studentPanel.add(textField_2);
		textField_2.setColumns(10);

		lblMinor = new JLabel("Minor:");
		lblMinor.setBounds(12, 50, 70, 15);
		studentPanel.add(lblMinor);

		textField_3 = new JTextField();
		textField_3.setBounds(12, 67, 114, 19);
		studentPanel.add(textField_3);
		textField_3.setColumns(10);

		lblEnterDate = new JLabel("Enter Date:");
		lblEnterDate.setBounds(144, 12, 81, 15);
		studentPanel.add(lblEnterDate);

		textField_4 = new JTextField();
		textField_4.setBounds(138, 26, 114, 19);
		studentPanel.add(textField_4);
		textField_4.setColumns(10);

		lblGradDate = new JLabel("Grad Date:");
		lblGradDate.setBounds(144, 50, 77, 15);
		studentPanel.add(lblGradDate);

		textField_5 = new JTextField();
		textField_5.setBounds(138, 67, 114, 19);
		studentPanel.add(textField_5);
		textField_5.setColumns(10);

		professorPanel = new JPanel();
		professorPanel.setBounds(304, 120, 290, 125);
		professorPanel.setVisible(false);
		contentPane.add(professorPanel);
		professorPanel.setLayout(null);

		lblOffice = new JLabel("Office:");
		lblOffice.setBounds(12, 12, 46, 15);
		professorPanel.add(lblOffice);

		textField_6 = new JTextField();
		textField_6.setBounds(12, 26, 114, 19);
		professorPanel.add(textField_6);
		textField_6.setColumns(10);

		lblResearch = new JLabel("Research:");
		lblResearch.setBounds(12, 48, 71, 15);
		professorPanel.add(lblResearch);

		textField_7 = new JTextField();
		textField_7.setBounds(12, 65, 114, 19);
		professorPanel.add(textField_7);
		textField_7.setColumns(10);

		lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(144, 12, 90, 15);
		professorPanel.add(lblDepartment);

		textField_8 = new JTextField();
		textField_8.setBounds(138, 26, 114, 19);
		professorPanel.add(textField_8);
		textField_8.setColumns(10);

		lblDob = new JLabel("DOB:");
		lblDob.setBounds(12, 104, 70, 15);
		contentPane.add(lblDob);

		textField_9 = new JTextField();
		textField_9.setBounds(12, 118, 114, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

		lblPhone = new JLabel("Phone #:");
		lblPhone.setBounds(12, 142, 70, 15);
		contentPane.add(lblPhone);

		textField_10 = new JTextField();
		textField_10.setBounds(12, 164, 114, 19);
		contentPane.add(textField_10);
		textField_10.setColumns(10);

		lblStreetNumber = new JLabel("Number:");
		lblStreetNumber.setBounds(154, 12, 70, 15);
		contentPane.add(lblStreetNumber);

		textField_11 = new JTextField();
		textField_11.setBounds(154, 28, 114, 19);
		contentPane.add(textField_11);
		textField_11.setColumns(10);

		lblStreet = new JLabel("Street:");
		lblStreet.setBounds(154, 59, 70, 15);
		contentPane.add(lblStreet);

		textField_12 = new JTextField();
		textField_12.setBounds(154, 75, 114, 19);
		contentPane.add(textField_12);
		textField_12.setColumns(10);

		lblCity = new JLabel("City:");
		lblCity.setBounds(154, 104, 70, 15);
		contentPane.add(lblCity);

		textField_13 = new JTextField();
		textField_13.setBounds(154, 120, 114, 19);
		contentPane.add(textField_13);
		textField_13.setColumns(10);

		lblState = new JLabel("State:");
		lblState.setBounds(154, 142, 70, 15);
		contentPane.add(lblState);

		textField_14 = new JTextField();
		textField_14.setBounds(154, 164, 114, 19);
		contentPane.add(textField_14);
		textField_14.setColumns(10);

		lblZipCode = new JLabel("ZIP Code:");
		lblZipCode.setBounds(154, 195, 70, 15);
		contentPane.add(lblZipCode);

		textField_15 = new JTextField();
		textField_15.setBounds(154, 211, 114, 19);
		contentPane.add(textField_15);
		textField_15.setColumns(10);

		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 400);

		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCreate) {
			Affiliation aff = null;
			if(chckbxStudent.isSelected() && chckbxProfessor.isSelected())
			{
				aff = AffiliationBusiness.SearchByTitle("Both");
			}
			else if(chckbxStudent.isSelected())
			{
				aff = AffiliationBusiness.SearchByTitle("Student");
			}
			else
			{
				aff = AffiliationBusiness.SearchByTitle("Professor");
			}
			
			Customer customer = new Customer(textField_1.getText(), textField.getText(), LocalDate dob, String phone, Address address, aff); // Need front end to pass in 
			CustomerBusiness.CreateCustomer(customer);
			//  
			//
			
			int reply = JOptionPane.showConfirmDialog(null, 
					"Account Created. Continue to Recreation Activity Registration?", "Alert", 
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(reply == JOptionPane.YES_OPTION) {
				new RegistrationActivityView(customer);
				dispose();
			}
			else if(reply == JOptionPane.NO_OPTION) {
				new CustomerRegisterView();
				dispose();
			}
		}
		else if (event.getSource() == btnCancel) {
			JOptionPane.showMessageDialog(null, "Failed Registration");
		}
		else if (event.getSource() == btnBack) {
			new CustomerRegisterView();
			dispose();
		}
	}
}
