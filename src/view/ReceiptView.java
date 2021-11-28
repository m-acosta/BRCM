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
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ReceiptView extends JFrame implements ActionListener {

	private Purchase purchase;
	private JTextArea textArea;
	private JPanel contentPane;
	private JButton btnMainMenu;
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
		
		textArea = new JTextArea();
		textArea.setBounds(12, 43, 523, 230);
		
		textArea.append(purchase.getCustomer().getFn_ln() + ", "
				+ "Bronco ID: " + purchase.getCustomerId() + ", "
				+ purchase.getDate().toString() + ", "
				+ purchase.getTime().toString() + "\n");

		double total_price = 0.0;
		for(ActivityPurchase temp: activity_purchases)
		{
			String activity = temp.getActivity().getActivity();
			double price = temp.getActivity().getPrice();
			total_price += price;
			
			// put all these on same line
			textArea.append(activity + " $" + price + 
					" at " + purchase.getCustomer().getAffiliation().getDiscountDisplay() 
					+ "% discount \n");
		}
		double discount_price = total_price - Math.round(total_price * (purchase.getCustomer().getAffiliation().getDiscount()));
		
		textArea.append("$" + discount_price + " = Total Price With Discount" + "\n");
		
		System.out.println(purchase.getTotal_price());
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDigitalReceipt = new JLabel("Digital Receipt");
		lblDigitalReceipt.setBounds(12, 12, 103, 15);
		
		lblThankYou = new JLabel("Thank you!");
		lblThankYou.setBounds(12, 302, 78, 15);
		
		btnMainMenu = new JButton("Back");
		btnMainMenu.setBounds(418, 336, 117, 25);
		btnMainMenu.addActionListener(this);
		
	}
	
	private void buildUI() {
		
		
		contentPane.add(btnMainMenu);
		contentPane.add(lblDigitalReceipt);
		contentPane.add(lblThankYou);
		contentPane.add(textArea);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 403);
		
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