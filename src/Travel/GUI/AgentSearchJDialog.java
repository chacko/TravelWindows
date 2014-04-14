package Travel.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.autocomplete.*;

import Travel.DataBase.AgenciesDB;
import Travel.DataBase.AgentsDB;
import Travel.DataBase.CustomerDB;
import Travel.Entity.Agents;
import Travel.Entity.Customers;

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
public class AgentSearchJDialog extends javax.swing.JDialog {
	public JList lstAgent;
	private JButton btnDelete;
	private JScrollPane jScrollPane1;
	private JTextField txtSearchAgent;
	private JLabel jLabel1;
	private JButton btnExit;
	private JButton btnEdit;

	private Vector<Agents> agents = new Vector<Agents>();
	
	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				AgentSearchJDialog inst = new AgentSearchJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public AgentSearchJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setModal(true);
				getContentPane().setLayout(null);
				
				{
					jScrollPane1 = new JScrollPane(lstAgent);
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(16, 48, 296, 263);
					jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					{
						agents = AgentsDB.getAllAgents();
						
						ComboBoxModel cboAgencyModel = 
								new DefaultComboBoxModel(agents);
						
						lstAgent = new JList(agents);
						jScrollPane1.setViewportView(lstAgent);

						lstAgent.setBounds(13, 47, 300, 264);
						lstAgent.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						lstAgent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						lstAgent.setPreferredSize(new java.awt.Dimension(295, 264));
						lstAgent.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent evt) {
								//System.out.println("lstAgent.valueChanged, event="+evt);
								//TODO add your code for lstAgent.valueChanged
								if(lstAgent.isSelectionEmpty()){
									btnEdit.setEnabled(false);
									btnDelete.setEnabled(false);
								}
								else{
									btnEdit.setEnabled(true);
									btnDelete.setEnabled(true);
								}
							}
						});
					}
				}
				//this.setModalityType(java.awt.Dialog$ModalityType.APPLICATION_MODAL);
				{
					btnEdit = new JButton();
					getContentPane().add(btnEdit);
					btnEdit.setText("Edit Agent");
					btnEdit.setBounds(327, 202, 143, 32);
					btnEdit.setEnabled(false);
					btnEdit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//System.out.println("btnEdit.actionPerformed, event="+evt);
							//TODO add your code for btnEdit.actionPerformed
							if(evt.getSource() == btnEdit)
							{
								Agents agt = (Agents) lstAgent.getSelectedValue();
								//JOptionPane.showConfirmDialog(null, agt.getAgentId());
								String [] args = {String.valueOf(agt.getAgentId())};
								
								AgentEditJDialog.main(args);
							}
						}
					});
				}
				{
					btnDelete = new JButton();
					getContentPane().add(btnDelete);
					btnDelete.setText("Delete Agent");
					btnDelete.setBounds(327, 242, 143, 32);
					btnDelete.setEnabled(false);
					btnDelete.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							//System.out.println("btnDelete.mouseClicked, event="+evt);
							//TODO add your code for btnDelete.mouseClicked
							
							int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this agent?",null,JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.YES_OPTION){
								Agents agt = (Agents) lstAgent.getSelectedValue();
								int agentID = agt.getAgentId();
								
								String [] args = {String.valueOf(agt.getAgentId())};
								int cust = CustomerDB.findAgent(agentID);
								
								if(cust == 0){
									AgentsDB.deleteAgent(agentID);
									JOptionPane.showMessageDialog(null, "Agent " + agt + " successfully removed!");
									lstAgent.setListData(AgentsDB.getAllAgents());
								}
								else {
									CustomerAssign.main(args);
								}
							}
						}
					});
				}
				{
					btnExit = new JButton();
					getContentPane().add(btnExit);
					btnExit.setText("Exit");
					btnExit.setBounds(327, 285, 143, 32);
					btnExit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//System.out.println("btnAdd.actionPerformed, event="+evt);
							//TODO add your code for btnAdd.actionPerformed
							//System.exit(0);
							dispose();
						}
					});
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Search Agent:");
					jLabel1.setLayout(null);
					jLabel1.setBounds(19, 21, 108, 15);
				}
				{
					txtSearchAgent = new JTextField();
					getContentPane().add(txtSearchAgent);
					txtSearchAgent.setBounds(154, 18, 161, 22);
					
					Configurator.enableAutoCompletion(lstAgent, txtSearchAgent);
				}
			}
			this.setSize(491, 370);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
