package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class ReportsByCustomerView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCustomerAndID;
	private JCheckBox chckbxCustomer1;
	private JCheckBox chckbxCustomer2;
	private JCheckBox chckbxCustomer3;
	private JCheckBox chckbxCustomer4;
	private JButton btnCancel;
	private JButton btnGenerateReport;

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
		
		lblCustomerAndID = new JLabel("Customer and ID");
		lblCustomerAndID.setBounds(12, 0, 145, 15);
		
		chckbxCustomer1 = new JCheckBox("Customer 1");
		chckbxCustomer1.setBounds(12, 23, 129, 23);
		
		chckbxCustomer2 = new JCheckBox("Customer 2");
		chckbxCustomer2.setBounds(12, 50, 129, 23);
		
		chckbxCustomer3 = new JCheckBox("Customer 3");
		chckbxCustomer3.setBounds(12, 77, 129, 23);
		
		chckbxCustomer4 = new JCheckBox("Customer 4");
		chckbxCustomer4.setBounds(12, 104, 129, 23);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(311, 215, 117, 25);
		btnCancel.addActionListener(this);
		
		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(146, 215, 153, 25);
		btnGenerateReport.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(lblCustomerAndID);
		contentPane.add(chckbxCustomer1);
		contentPane.add(chckbxCustomer2);
		contentPane.add(chckbxCustomer3);
		contentPane.add(chckbxCustomer4);
		contentPane.add(btnCancel);
		contentPane.add(btnGenerateReport);
		
		JToggleButton tglbtnEnableDateRange = new JToggleButton("Enable Date Range");
		tglbtnEnableDateRange.setBounds(259, 12, 169, 25);
		contentPane.add(tglbtnEnableDateRange);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnGenerateReport) {
			JOptionPane.showMessageDialog(null, "Customer has spent $$$.");
		}
		else if (event.getSource() == btnCancel) {
			new AdminView();
			dispose();
		}
	}
}
