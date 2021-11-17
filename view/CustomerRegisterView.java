package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CustomerRegisterView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnSearchMember, btnCreateMember, btnBack;

	public CustomerRegisterView() {
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSearchMember = new JButton("Search Existing Member");
		btnSearchMember.setBounds(30, 100, 203, 25);
		btnSearchMember.addActionListener(this);
		
		btnCreateMember = new JButton("Create New Member");
		btnCreateMember.setBounds(239, 100, 178, 25);
		btnCreateMember.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(311, 215, 117, 25);
		btnBack.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(btnSearchMember);
		contentPane.add(btnCreateMember);
		contentPane.add(btnBack);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnSearchMember) {
			new CustomerSearchView();
			dispose();
		}
		else if (event.getSource() == btnCreateMember) {
			new CustomerCreateView();
			dispose();
		}
		else if (event.getSource() == btnBack) {
			new MainView();
			dispose();
		}
		
	}

}
