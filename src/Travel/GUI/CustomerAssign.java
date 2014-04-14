package Travel.GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingWorker;

import Travel.DataBase.AgentsDB;
import Travel.DataBase.CustomerDB;
import Travel.Entity.Agencies;
import Travel.Entity.Agents;
import Travel.Entity.Customers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class CustomerAssign extends javax.swing.JDialog {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JScrollPane jScrollPane1;
	private JButton btnExit;
	private JButton btnAssign;
	private JList lstAgents;
	private JList lstCustomers;
	
	private static String agentID;
	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		agentID = args[0].toString();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				CustomerAssign inst = new CustomerAssign(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public CustomerAssign(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setModal(true);
				getContentPane().setLayout(null);
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("The following customers are assigned to the agent you are about to delete.");
					jLabel1.setBounds(12, 12, 561, 15);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("Please assign them to a new agent to continue.");
					jLabel2.setBounds(12, 30, 368, 15);
				}
				{
					jScrollPane1 = new JScrollPane(lstAgents);
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(215, 91, 190, 184);
					jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					{
						// populating listbox with all available agents
						Vector<Agents> agents = new Vector<Agents>();
						
						agents = AgentsDB.getAllAgentsX(agentID);
						
						lstAgents = new JList<>(agents);
						jScrollPane1.setViewportView(lstAgents);

						lstAgents.setBounds(215, 91, 191, 186);
						lstAgents.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						lstAgents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						lstAgents.setEnabled(false);
						lstAgents.setPreferredSize(new java.awt.Dimension(189, 186));
						lstAgents.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent evt) {
								//System.out.println("lstAgents.valueChanged, event="+evt);
								//TODO add your code for lstAgents.valueChanged
								
								if(lstCustomers.isSelectionEmpty()){
									btnAssign.setEnabled(false);
								}
								else {
									btnAssign.setEnabled(true);
								}
							}
						});
					}
				}
				{
					// populating listbox with customers assigned to agents the user wants to delete
					Vector<Customers> customers = new Vector<Customers>();
					
					customers = CustomerDB.getCustomers(Integer.parseInt(agentID));
					
					ComboBoxModel cboCustomerModel = 
							new DefaultComboBoxModel(customers);
					
					lstCustomers = new JList(customers);
					getContentPane().add(lstCustomers);
					lstCustomers.setBounds(12, 91, 191, 186);
					lstCustomers.setModel(cboCustomerModel);
					lstCustomers.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					lstCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					lstCustomers.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent evt) {
							//System.out.println("lstCustomers.valueChanged, event="+evt);
							//TODO add your code for lstCustomers.valueChanged
							if(lstCustomers.isSelectionEmpty()){
								btnAssign.setEnabled(false);
							}
							else{
								lstAgents.setEnabled(true);
							}
						}
					});
				}
				{
					btnAssign = new JButton();
					getContentPane().add(btnAssign);
					btnAssign.setText("Assign");
					btnAssign.setBounds(459, 180, 106, 46);
					btnAssign.setEnabled(false);
					btnAssign.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							//System.out.println("btnAssign.mouseClicked, event="+evt);
							//TODO add your code for btnAssign.mouseClicked
							if(AssignCustomer() <=0) {
								JOptionPane.showMessageDialog(null, "Re-assigning customer to new agent failed!");
							}
							else {
								JOptionPane.showMessageDialog(null, "Customer " + lstCustomers.getSelectedValue() + " is assigned to a new agent " + lstAgents.getSelectedValue());
								lstCustomers.setListData(CustomerDB.getCustomers(Integer.parseInt(agentID)));
							}
							
							if(lstCustomers.getModel().getSize() == 0){
								AgentsDB.deleteAgent(Integer.parseInt(agentID));
								int option = JOptionPane.showConfirmDialog(null, "Do you wish to continue deleting this agent?");
								if(option == JOptionPane.YES_OPTION){
									JOptionPane.showMessageDialog(null, "Agent was successfully removed!");
									dispose();
								}
							}
						}
					});
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Assign to agent:");
					jLabel3.setBounds(215, 57, 191, 22);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("Pick a customers:");
					jLabel4.setBounds(12, 57, 175, 22);
				}
				{
					btnExit = new JButton();
					getContentPane().add(btnExit);
					btnExit.setText("Exit");
					btnExit.setBounds(459, 231, 106, 46);
					btnExit.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							//System.out.println("btnExit.mouseClicked, event="+evt);
							//TODO add your code for btnExit.mouseClicked
							dispose();
						}
					});
				}
			}
			this.setSize(579, 317);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Integer AssignCustomer() {
		Customers cust = new Customers();
		Agents agt = new Agents();
		
		cust = (Customers) lstCustomers.getSelectedValue();
		agt = (Agents) lstAgents.getSelectedValue();
		
		int customerID = cust.getCustomerID();
		int agentID = agt.getAgentId();
		
		return CustomerDB.updateCustomer(customerID, agentID);
	}
}
	
