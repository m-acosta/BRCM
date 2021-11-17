package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ReportsMenuView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnCustAndDate, btnRecreationActiv, btnBack;
	private JLabel lblRecreationalActivity;
	private JLabel lblNewLabel;

	public ReportsMenuView() {
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Customer and Date");
		lblNewLabel.setBounds(60, 56, 185, 15);
		
		btnCustAndDate = new JButton("Sort Report");
		btnCustAndDate.setBounds(63, 100, 116, 25);
		btnCustAndDate.addActionListener(this);
		
		lblRecreationalActivity = new JLabel("Recreational Activity");
		lblRecreationalActivity.setBounds(243, 56, 185, 15);
		
		btnRecreationActiv = new JButton("Sort Report");
		btnRecreationActiv.setBounds(256, 100, 116, 25);
		btnRecreationActiv.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(311, 215, 117, 25);
		btnBack.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(btnCustAndDate);
		contentPane.add(btnRecreationActiv);
		contentPane.add(btnBack);
		contentPane.add(lblNewLabel);
		contentPane.add(lblRecreationalActivity);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCustAndDate) {
			new ReportsByCustomerView();
			dispose();
		}
		else if (event.getSource() == btnRecreationActiv) {
			new ReportsByActivityView();
			dispose();
		}
		else if (event.getSource() == btnBack) {
			new AdminView();
			dispose();
		}
		
	}
}
