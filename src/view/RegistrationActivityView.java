package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.ActivityBusiness;
import model.business.PurchaseBusiness;
import model.dataccess.ActivityPurchaseDataAccess;
import model.entities.Activity;
import model.entities.ActivityPurchase;
import model.entities.ActivityPurchaseId;
import model.entities.Customer;
import model.entities.Purchase;
import model.entities.Status;

import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class RegistrationActivityView extends JFrame implements ActionListener {

	private Purchase purchase;
	private double total_price;
	private List<Activity> selectable_activities = new ArrayList<Activity>();
	private List<Activity> selected_activities;
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
		
		total_price = 0;
		// Remove for loop when complete with gui this was just proof of concept for retrieving from DB
		for(String temp: activities)
		{
			// Have all activities but also need to get prices so I should do a query on the 
			// activity_price table by activity_name and date closest to the current date. 
			try {
				// Activity
				System.out.println(temp);
				// Current Activity Price
				Activity current = ActivityBusiness.getActivityPrice(temp);
				// list of all selectable activities
				// need some if selected event handler to add activities to selected_activities
				selectable_activities.add(current);
				System.out.println(current.getPrice());
				// rememeber to only add this to the get selected event handler
				// also need a deselected event handler to update selected items array and to update total price
				total_price += current.getPrice(); // also dont forget the discount we can get this with customer
				
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
			// need to get selected activities here from GUI
			// will hard code activities for now
			Status status = new Status("Counter");
			Time time = new Time(System.currentTimeMillis());
			LocalDate local_date = LocalDate.now();
			
			this.purchase = new Purchase(time, local_date, total_price, status, customer);
			PurchaseBusiness.CreatePurchase(purchase);
			
			// for loop to go through all selected activities
			
			ActivityPurchaseDataAccess purchase_activityDa = new ActivityPurchaseDataAccess();
			// this for loop should go through all selected items not selectable will change when 
			// event handler to add selected is created.
			for (Activity temp: this.selectable_activities)
			{
				ActivityPurchaseId purchase_activity_pk = new ActivityPurchaseId(this.purchase, temp);
				ActivityPurchase purchase_activity = new ActivityPurchase(purchase_activity_pk, 1); // set to one for now dont need more than that
				purchase_activityDa.saveActivityPurchase(purchase_activity);
			}
			
			new ReceiptView(this.purchase);
			dispose();
		}
		else if (event.getSource() == btnBack) {
			new MainView();
			dispose();
		}
		
	}
}