package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.ActivityBusiness;
import model.business.ActivityPurchaseBusiness;
import model.entities.Activity;
import model.entities.ActivityPurchase;
import model.entities.Purchase;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ReceiptView extends JFrame implements ActionListener {

	private Purchase purchase;
	private JPanel contentPane;
	private JButton btnMainMenu;
	private JTable table;
	private JLabel lblDigitalReceipt;
	private JLabel lblThankYou;

	public ReceiptView(Purchase purchase) {
		this.purchase = purchase;
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		List<ActivityPurchase> activity_purchases = new ArrayList<ActivityPurchase>();
		try {
			activity_purchases = ActivityPurchaseBusiness.PurchaseReceipt(purchase.getPurchaseId());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(purchase.getCustomer().getFn_ln());
		System.out.println(purchase.getCustomerId());
		System.out.println(purchase.getDate().toString());
		System.out.println(purchase.getTime().toString());
		for(ActivityPurchase temp: activity_purchases)
		{
			String activity = temp.getActivity().getActivity();
			double price = temp.getActivity().getPrice();
			
			// put all these on same line
			System.out.println(activity);
			System.out.println(price);
			System.out.println(purchase.getCustomer().getAffiliation().getDiscountDisplay());
			
			double discount_price = price- Math.round(price * (purchase.getCustomer().getAffiliation().getDiscount()));
			System.out.println(discount_price + " Total Price With Discount");
		}
		
		System.out.println(purchase.getTotal_price());
		
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDigitalReceipt = new JLabel("Digital Receipt");
		lblDigitalReceipt.setBounds(12, 12, 103, 15);
		
		table = new JTable();
		table.setBounds(12, 50, 416, 94);
		
		lblThankYou = new JLabel("Thank you!");
		lblThankYou.setBounds(12, 156, 78, 15);
		
		btnMainMenu = new JButton("Back");
		btnMainMenu.setBounds(311, 215, 117, 25);
		btnMainMenu.addActionListener(this);
		
	}
	
	private void buildUI() {
		
		
		contentPane.add(btnMainMenu);
		contentPane.add(table);
		contentPane.add(lblDigitalReceipt);
		contentPane.add(lblThankYou);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnMainMenu) {
			new MainView();
			dispose();
		}
		
	}
}