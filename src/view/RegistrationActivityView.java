package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entities.Customer;

import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class RegistrationActivityView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnBack;
	private JTable table;
	private JLabel lblName;
	private JButton btnCheckout;
	private Customer customer;

	public RegistrationActivityView(Customer customer) {
		this.customer = customer;
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		getContentPane().setLayout(null);
		
		lblName = new JLabel(customer.getFn_ln());
		lblName.setBounds(12, 12, 70, 15);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(12, 12, 416, 175);

		btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(199, 215, 100, 25);
		btnCheckout.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(311, 215, 117, 25);
		btnBack.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(btnBack);
		contentPane.add(table);
		contentPane.add(btnCheckout);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCheckout) {
			new ReceiptView();
			dispose();
		}
		else if (event.getSource() == btnBack) {
			new MainView();
			dispose();
		}
		
	}
}