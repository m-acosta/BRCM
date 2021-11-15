package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MainView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnCustomerRegistration, btnAdministrativeTools;

	public static void main(String[] args) {
		new MainView();
	}

	public MainView() {
		initializeComponents();
		buildUI();
	}
	
	private void initializeComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCustomerRegistration = new JButton("Customer Registration");
		btnCustomerRegistration.setBounds(30, 100, 194, 25);
		btnCustomerRegistration.addActionListener(this);
		
		btnAdministrativeTools = new JButton("Administrative Tools");
		btnAdministrativeTools.setBounds(236, 100, 178, 25);
		btnAdministrativeTools.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(btnCustomerRegistration);
		contentPane.add(btnAdministrativeTools);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCustomerRegistration) {
			new CustomerRegisterView();
			dispose();
		}
		else if (event.getSource() == btnAdministrativeTools) {
			new AdminView();
			dispose();
		}
	}
	
}
