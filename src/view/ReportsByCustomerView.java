package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.CustomerBusiness;
import model.entities.Customer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ReportsByCustomerView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel datePanel;
	private JLabel lblBroncoID;
	private JLabel lblStartDate;
	private JButton btnCancel;
	private JButton btnGenerateReport;
	private JToggleButton tglbtnEnableDateRange;
	private JTextField textFieldDate;
	private JTextField textFieldID;

	public ReportsByCustomerView() {
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		datePanel = new JPanel();
		datePanel.setBounds(241, 49, 187, 121);
		datePanel.setLayout(null);
		datePanel.setVisible(false);
		
		tglbtnEnableDateRange = new JToggleButton("Enable Date Range");
		tglbtnEnableDateRange.setBounds(259, 12, 169, 25);
		contentPane.add(tglbtnEnableDateRange);
		tglbtnEnableDateRange.addItemListener(e -> datePanel.setVisible(e.getStateChange() == ItemEvent.SELECTED));
		
		lblStartDate = new JLabel("Start Date (to present):");
		lblStartDate.setBounds(0, 0, 168, 15);
		datePanel.add(lblStartDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(0, 27, 114, 19);
		datePanel.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		lblBroncoID = new JLabel("Bronco ID");
		lblBroncoID.setBounds(12, 0, 145, 15);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(12, 27, 114, 19);
		textFieldID.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(311, 215, 117, 25);
		btnCancel.addActionListener(this);
		
		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(146, 215, 153, 25);
		btnGenerateReport.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(lblBroncoID);
		contentPane.add(btnCancel);
		contentPane.add(btnGenerateReport);
		contentPane.add(datePanel);
		contentPane.add(textFieldID);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnGenerateReport) {
			try {
				Customer customer = CustomerBusiness.SearchByBroncoId(textFieldID.getText());
				if (customer != null) {
					if (tglbtnEnableDateRange.isSelected()) {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
						LocalDate startDate = LocalDate.parse(textFieldDate.getText(), formatter);
					}
					else {
						// All purchases by customer
					}
					
					JOptionPane.showMessageDialog(null, "Customer has spent $$$.");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (event.getSource() == btnCancel) {
			new AdminView();
			dispose();
		}
	}
}
