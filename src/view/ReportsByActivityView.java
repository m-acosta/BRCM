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
	private JCheckBox chckbxBodybuilding;
	private JCheckBox chckbxSwimming;
	private JCheckBox chckbxDance;
	private JCheckBox chckbxMartialArts;
	private JButton btnCancel;
	private JButton btnGenerateReport;

	public ReportsByActivityView() {
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		
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
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				revenue += ActivityPurchaseBusiness.RevenueReportByActivities(activity_ids);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// check activity purchase tables for all the activities that are checked then get the price by date of the purchase id
		}
		
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRecreationalActivity = new JLabel("Recreational Activity");
		lblRecreationalActivity.setBounds(12, 0, 145, 15);
		
		chckbxBodybuilding = new JCheckBox("Bodybuilding");
		chckbxBodybuilding.setBounds(12, 23, 129, 23);
		
		chckbxSwimming = new JCheckBox("Swimming");
		chckbxSwimming.setBounds(12, 50, 129, 23);
		
		chckbxDance = new JCheckBox("Dance");
		chckbxDance.setBounds(12, 77, 129, 23);
		
		chckbxMartialArts = new JCheckBox("Martial Arts");
		chckbxMartialArts.setBounds(12, 104, 129, 23);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(311, 215, 117, 25);
		btnCancel.addActionListener(this);
		
		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(146, 215, 153, 25);
		btnGenerateReport.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(lblRecreationalActivity);
		contentPane.add(chckbxBodybuilding);
		contentPane.add(chckbxSwimming);
		contentPane.add(chckbxDance);
		contentPane.add(chckbxMartialArts);
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
			JOptionPane.showMessageDialog(null, "Selected Recreational Activities have generated $" + revenue);
		}
		else if (event.getSource() == btnCancel) {
			new AdminView();
			dispose();
		}
	}
}
