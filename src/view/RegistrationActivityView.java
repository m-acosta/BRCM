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
import javax.swing.JLabel;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class RegistrationActivityView extends JFrame implements ActionListener {

	private Purchase purchase;
	private double total_price, baPrice, soPrice, foPrice;
	private List<Activity> selectable_activities = new ArrayList<Activity>();
	private List<Activity> selected_activities;
	private JPanel contentPane;
	private JButton btnBack;
	private JButton btnCheckout;
	private Customer customer;
	private JLabel lblBasketball;
	private JCheckBox chckbxBasketballCart;
	private JLabel lblSoccerAtA;
	private JCheckBox chckbxSoccerCart;
	private JLabel lblFootballAtA;
	private JCheckBox chckbxFootballCart;
	private JLabel lblCart;
	private JLabel lblBasketballX;
	private JLabel lblSoccerX;
	private JLabel lblFootballX;
	private JLabel lblTotalPriceX;

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
		for(String temp: activities)
		{
			// Have all activities but also need to get prices so I should do a query on the 
			// activity_price table by activity_name and date closest to the current date. 
			try {
				if (temp.equals("Basketball")) {
					baPrice = ActivityBusiness.getActivityPrice(temp).getPrice();
				}
				else if (temp.equals("Soccer")) {
					soPrice = ActivityBusiness.getActivityPrice(temp).getPrice();
				}
				else if (temp.equals("Football")) {
					foPrice = ActivityBusiness.getActivityPrice(temp).getPrice();
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(349, 331, 100, 25);
		btnCheckout.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(461, 331, 117, 25);
		btnBack.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		contentPane.add(btnCheckout);
		
		lblBasketball = new JLabel("Basketball at a price of $" + baPrice);
		lblBasketball.setBounds(12, 0, 278, 15);
		contentPane.add(lblBasketball);
		
		chckbxBasketballCart = new JCheckBox("Add to Cart");
		chckbxBasketballCart.setBounds(12, 23, 129, 23);
		chckbxBasketballCart.addActionListener(this);
		contentPane.add(chckbxBasketballCart);
		
		lblSoccerAtA = new JLabel("Soccer at a price of $" + soPrice);
		lblSoccerAtA.setBounds(12, 50, 278, 15);
		contentPane.add(lblSoccerAtA);
		
		chckbxSoccerCart = new JCheckBox("Add to Cart");
		chckbxSoccerCart.setBounds(12, 73, 129, 23);
		chckbxSoccerCart.addActionListener(this);
		contentPane.add(chckbxSoccerCart);
		
		lblFootballAtA = new JLabel("Football at a price of $" + foPrice);
		lblFootballAtA.setBounds(12, 101, 278, 15);
		contentPane.add(lblFootballAtA);
		
		chckbxFootballCart = new JCheckBox("Add to Cart");
		chckbxFootballCart.setBounds(12, 124, 129, 23);
		chckbxFootballCart.addActionListener(this);
		contentPane.add(chckbxFootballCart);
		
		lblCart = new JLabel("Cart:");
		lblCart.setBounds(12, 169, 70, 15);
		contentPane.add(lblCart);
		
		lblBasketballX = new JLabel("Basketball x 0");
		lblBasketballX.setBounds(12, 204, 278, 15);
		contentPane.add(lblBasketballX);
		
		lblSoccerX = new JLabel("Soccer x 0");
		lblSoccerX.setBounds(12, 231, 278, 15);
		contentPane.add(lblSoccerX);
		
		lblFootballX = new JLabel("Football x 0");
		lblFootballX.setBounds(12, 258, 278, 15);
		contentPane.add(lblFootballX);
		
		lblTotalPriceX = new JLabel("Total Price: $" + total_price + 
				" at a discount of " + customer.getAffiliation().getDiscount() + " = $"
				+ (total_price - Math.round(total_price*customer.getAffiliation().getDiscount())));
		lblTotalPriceX.setBounds(12, 285, 450, 15);
		contentPane.add(lblTotalPriceX);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 398);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == chckbxBasketballCart) {
			try {
				Activity current = ActivityBusiness.getActivityPrice("Basketball");
				if (chckbxBasketballCart.isSelected()) {
					total_price += baPrice;
					lblBasketballX.setText("Basketball x 1");
					selectable_activities.add(current);
				}
				else {
					total_price -= baPrice;
					lblBasketballX.setText("Basketball x 0");
					for(int i =0; i < selectable_activities.size(); i++)
					{
						if(selectable_activities.get(i).getActivity().equals("Basketball"))
						{
							selectable_activities.remove(i);
						}
					}
				}
				lblTotalPriceX.setText("Total Price: $" + total_price + 
						" at a discount of " + customer.getAffiliation().getDiscount() + " = $"
						+ (total_price - Math.round(total_price*customer.getAffiliation().getDiscount())));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (event.getSource() == chckbxSoccerCart) {
			try {
				Activity current = ActivityBusiness.getActivityPrice("Soccer");
				if (chckbxSoccerCart.isSelected()) {
					total_price += soPrice;
					lblSoccerX.setText("Soccer x 1");
					selectable_activities.add(current);
				}
				else {
					total_price -= soPrice;
					lblSoccerX.setText("Soccer x 0");
					for(int i =0; i < selectable_activities.size(); i++)
					{
						if(selectable_activities.get(i).getActivity().equals("Soccer"))
						{
							selectable_activities.remove(i);
						}
					}
				}
				lblTotalPriceX.setText("Total Price: $" + total_price + 
						" at a discount of " + customer.getAffiliation().getDiscount() + " = $"
						+ (total_price - Math.round(total_price*customer.getAffiliation().getDiscount())));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (event.getSource() == chckbxFootballCart) {
			try {
				Activity current = ActivityBusiness.getActivityPrice("Football");
				if (chckbxFootballCart.isSelected()) {
					total_price += foPrice;
					lblFootballX.setText("Football x 1");
					selectable_activities.add(current);
				}
				else {
					total_price -= foPrice;
					lblFootballX.setText("Football x 0");
					for(int i =0; i < selectable_activities.size(); i++)
					{
						if(selectable_activities.get(i).getActivity().equals("Football"))
						{
							selectable_activities.remove(i);
						}
					}
				}
				lblTotalPriceX.setText("Total Price: $" + total_price + 
						" at a discount of " + customer.getAffiliation().getDiscount() + " = $"
						+ (total_price - Math.round(total_price*customer.getAffiliation().getDiscount())));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
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