package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.business.CustomerBusiness;
import model.entities.Customer;
import model.entities.Purchase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class CustomerSearchView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblBroncoId;
	private JTextField textField_1;
	private JButton btnSearch;
	private JButton btnCancel;
	private JButton btnBack;

	public CustomerSearchView() {
		initializeComponents();
		buildUI();
	}
	
	private void initializeComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBroncoId = new JLabel("Bronco ID:");
		lblBroncoId.setBounds(10, 59, 72, 15);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 75, 114, 19);
		textField_1.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(12, 184, 83, 25);
		btnSearch.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(130, 184, 81, 25);
		btnCancel.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(311, 215, 117, 25);
		btnBack.addActionListener(this);
		
	}
	
	private void buildUI() {
		contentPane.add(lblBroncoId);
		contentPane.add(textField_1);
		contentPane.add(btnSearch);
		contentPane.add(btnCancel);
		contentPane.add(btnBack);
		
		setTitle("BRCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnSearch) {
			try {
				Customer customer = CustomerBusiness.SearchByBroncoId(textField_1.getText());
				if(customer != null)
				{
					int reply = JOptionPane.showConfirmDialog(null, 
							"Account Found. Continue to Recreation Activity Registration?", "Alert", 
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(reply == JOptionPane.YES_OPTION) {
						new RegistrationActivityView(customer);
						dispose();
					}
					else if(reply == JOptionPane.NO_OPTION) {
						new CustomerRegisterView();
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could not find account");
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (event.getSource() == btnCancel) {
			JOptionPane.showMessageDialog(null, "Could not find account");
		}
		else if (event.getSource() == btnBack) {
			new CustomerRegisterView();
			dispose();
		}
	}
}