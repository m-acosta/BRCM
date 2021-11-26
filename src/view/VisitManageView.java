package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.ActivityPurchaseBusiness;
import model.business.PurchaseBusiness;
import model.entities.Purchase;

import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class VisitManageView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnBack;
	private JTable table;
	private JButton btnDeleteCustomer;

	public VisitManageView() {
		initializeComponents();
		buildUI();		
	}
	
	private void initializeComponents() {
		List<Purchase> purchases = null;
		try {
			purchases = PurchaseBusiness.getAllPurchases();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Purchase temp: purchases)
		{
			System.out.println(temp.getCustomer().getFn_ln());
			System.out.println(temp.getStatus());
			System.out.println(temp.getDate().toString());
		}
		
		getContentPane().setLayout(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(12, 12, 416, 175);

		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.setBounds(145, 215, 153, 25);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(311, 215, 117, 25);
		btnBack.addActionListener(this);
	}
	
	private void buildUI() 
	{
		contentPane.add(btnBack);
		contentPane.add(table);
		contentPane.add(btnDeleteCustomer);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnBack) {
			new AdminView();
			dispose();
		}
		
	}
}