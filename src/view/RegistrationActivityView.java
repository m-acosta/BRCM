package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.ActivityBusiness;
import model.business.PurchaseBusiness;
import model.entities.Activity;
import model.entities.Customer;
import model.entities.Purchase;
import model.entities.Status;

import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class RegistrationActivityView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnBack;
	private JTable table;
	private JButton btnCheckout;
	private Customer customer;

	public RegistrationActivityView(Customer customer) {
		this.customer = customer;
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		
		List<String> activities = null;
		try {
			// Need to make get activities by date 
			activities = ActivityBusiness.getAllActivities();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Remove for loop when complete with gui this was just proof of concept for retrieving from DB
		for(String temp: activities)
		{
			// Have all activities but also need to get prices so I should do a query on the 
			// activity_price table by activity_name and date closest to the current date. 
			System.out.println(temp);
			try {
				System.out.println(ActivityBusiness.getActivityPrice(temp));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		getContentPane().setLayout(null);
		
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
		if (event.getSource() == btnCheckout) 
		{
			Status status = new Status("Counter");
			Time time = new Time(System.currentTimeMillis());
			LocalDate local_date = LocalDate.now();
			
			Purchase purchase = new Purchase(time, local_date, 0.0, status, customer);
			PurchaseBusiness.CreatePurchase(purchase);
			new ReceiptView();
			dispose();
		}
		else if (event.getSource() == btnBack) {
			new MainView();
			dispose();
		}
		
	}
}