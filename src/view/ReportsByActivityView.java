package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.ActivityBusiness;
import model.business.ActivityPurchaseBusiness;
import model.entities.Activity;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class ReportsByActivityView extends JFrame implements ActionListener 
{
	private double revenue;
	private JPanel contentPane;
	private JLabel lblRecreationalActivity;
	private JCheckBox chckbxBasketball;
	private JCheckBox chckbxSoccer;
	private JCheckBox chckbxFootball;
	private JButton btnCancel;
	private JButton btnGenerateReport;

	public ReportsByActivityView() {
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRecreationalActivity = new JLabel("Recreational Activity");
		lblRecreationalActivity.setBounds(12, 0, 145, 15);
		
		chckbxBasketball = new JCheckBox("Basketball");
		chckbxBasketball.setBounds(12, 23, 129, 23);
		chckbxBasketball.addActionListener(this);
		
		chckbxSoccer = new JCheckBox("Soccer");
		chckbxSoccer.setBounds(12, 50, 129, 23);
		chckbxSoccer.addActionListener(this);
		
		chckbxFootball = new JCheckBox("Football");
		chckbxFootball.setBounds(12, 77, 129, 23);
		chckbxFootball.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(311, 215, 117, 25);
		btnCancel.addActionListener(this);
		
		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(146, 215, 153, 25);
		btnGenerateReport.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(lblRecreationalActivity);
		contentPane.add(chckbxBasketball);
		contentPane.add(chckbxSoccer);
		contentPane.add(chckbxFootball);
		contentPane.add(btnCancel);
		contentPane.add(btnGenerateReport);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) 
	{
		
		if (event.getSource() == btnGenerateReport) {
			List<String> activities = null;
			try 
			{
				// need to make get all unique by activity name
				activities = ActivityBusiness.getAllActivities();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			revenue = 0;
			// Remove for loop when complete with gui this was just proof of concept for retrieving from DB
			for(String temp: activities)
			{
				List<Activity> activity_ids = null;
				try {
					activity_ids = ActivityBusiness.getActivityIds(temp);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (temp.equals("Basketball") && chckbxBasketball.isSelected()) {
					try {
						revenue += ActivityPurchaseBusiness.RevenueReportByActivities(activity_ids);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// check activity purchase tables for all the activities that are checked then get the price by date of the purchase id
				}
				else if (temp.equals("Soccer") && chckbxSoccer.isSelected()) {
					try {
						revenue += ActivityPurchaseBusiness.RevenueReportByActivities(activity_ids);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// check activity purchase tables for all the activities that are checked then get the price by date of the purchase id
				}
				else if (temp.equals("Football") && chckbxFootball.isSelected()) {
					try {
						revenue += ActivityPurchaseBusiness.RevenueReportByActivities(activity_ids);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// check activity purchase tables for all the activities that are checked then get the price by date of the purchase id
				}
			}
			JOptionPane.showMessageDialog(null, "Selected Recreational Activities have generated $" + revenue);
		}
		else if (event.getSource() == btnCancel) {
			new AdminView();
			dispose();
		}
	}
}
