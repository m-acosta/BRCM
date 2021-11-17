package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AdminView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnVisitManagement, btnIntelligentRevenueReport, btnBack;

	public AdminView() {
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVisitManagement = new JButton("Visit Management");
		btnVisitManagement.setBounds(30, 100, 162, 25);
		btnVisitManagement.addActionListener(this);
		
		btnIntelligentRevenueReport = new JButton("Intelligent Revenue Report");
		btnIntelligentRevenueReport.setBounds(204, 100, 224, 25);
		btnIntelligentRevenueReport.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(311, 215, 117, 25);
		btnBack.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(btnVisitManagement);
		contentPane.add(btnIntelligentRevenueReport);
		contentPane.add(btnBack);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnVisitManagement) {
			new VisitManageView();
			dispose();
		}
		else if (event.getSource() == btnIntelligentRevenueReport) {
			new ReportsMenuView();
			dispose();
		}
		else if (event.getSource() == btnBack) {
			new MainView();
			dispose();
		}
		
	}

}