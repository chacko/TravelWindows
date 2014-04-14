package Travel.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.acl.Owner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import Travel.DataBase.AgenciesDB;
import Travel.DataBase.AgentsDB;
import Travel.Entity.Agencies;
import Travel.Entity.Agents;

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
public class AgentEditJDialog extends javax.swing.JDialog {
	private JPanel pnlEditAgent;
	private JLabel lbl2;
	private JLabel lbl1;
	private JComboBox cmbAgency;
	private JButton btnExit;
	private ButtonGroup btnStatus;
	private JButton btnSave;
	private JLabel jLabel18;
	private JLabel jLabel16;
	private JLabel jLabel15;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JTextField txtPosition;
	private JTextField txtEmail;
	private JTextField txtBusPhone;
	private JTextField txtLastName;
	private JTextField txtMiddleInitial;
	private JTextField txtFirstName;

	private static String agentID; 
	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		agentID = args[0].toString();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				AgentEditJDialog inst = new AgentEditJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public AgentEditJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setModal(true);
				{
					pnlEditAgent = new JPanel();
					getContentPane().add(pnlEditAgent);
					pnlEditAgent.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					pnlEditAgent.setLayout(null);
					pnlEditAgent.setBounds(17, 11, 313, 238);
					{
						txtFirstName = new JTextField();
						pnlEditAgent.add(txtFirstName);
						txtFirstName.setBounds(135, 44, 163, 22);
					}
					{
						txtMiddleInitial = new JTextField();
						pnlEditAgent.add(txtMiddleInitial);
						txtMiddleInitial.setBounds(135, 69, 35, 22);
					}
					{
						txtLastName = new JTextField();
						pnlEditAgent.add(txtLastName);
						txtLastName.setBounds(135, 94, 163, 22);
					}
					{
						txtBusPhone = new JTextField();
						pnlEditAgent.add(txtBusPhone);
						txtBusPhone.setBounds(135, 120, 163, 22);
					}
					{
						txtEmail = new JTextField();
						pnlEditAgent.add(txtEmail);
						txtEmail.setBounds(135, 145, 163, 22);
					}
					{
						txtPosition = new JTextField();
						pnlEditAgent.add(txtPosition);
						txtPosition.setBounds(135, 170, 163, 22);
					}
					{
						jLabel10 = new JLabel();
						pnlEditAgent.add(jLabel10);
						jLabel10.setText("Agency:");
						jLabel10.setBounds(13, 185, 110, 42);
					}
					{
						jLabel11 = new JLabel();
						pnlEditAgent.add(jLabel11);
						jLabel11.setText("Position:");
						jLabel11.setBounds(14, 159, 110, 42);
					}
					{
						jLabel12 = new JLabel();
						pnlEditAgent.add(jLabel12);
						jLabel12.setText("Email:");
						jLabel12.setBounds(13, 134, 110, 42);
					}
					{
						jLabel13 = new JLabel();
						pnlEditAgent.add(jLabel13);
						jLabel13.setText("Phone Number:");
						jLabel13.setBounds(13, 109, 110, 42);
					}
					{
						jLabel14 = new JLabel();
						pnlEditAgent.add(jLabel14);
						jLabel14.setText("Last Name:");
						jLabel14.setBounds(13, 83, 110, 42);
					}
					{
						jLabel15 = new JLabel();
						pnlEditAgent.add(jLabel15);
						jLabel15.setText("Middle Initial:");
						jLabel15.setBounds(13, 58, 110, 42);
					}
					{
						jLabel16 = new JLabel();
						pnlEditAgent.add(jLabel16);
						jLabel16.setText("First Name:");
						jLabel16.setBounds(13, 33, 110, 42);
					}
					{
						jLabel18 = new JLabel();
						pnlEditAgent.add(jLabel18);
						pnlEditAgent.add(getCmbAgency());
						jLabel18.setText("Edit Agent Information");
						jLabel18.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel18.setHorizontalTextPosition(SwingConstants.CENTER);
						jLabel18.setLayout(null);
						jLabel18.setBounds(1, 2, 310, 29);
					}
				}
				{
					btnSave = new JButton();
					getContentPane().add(btnSave);
					getContentPane().add(getJButton1());
					getContentPane().add(getLbl1());
					getContentPane().add(getLbl2());
					btnSave.setText("Save");
					btnSave.setBounds(342, 169, 100, 36);
					btnSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//System.out.println("btnSave.actionPerformed, event="+evt);
							//TODO add your code for btnSave.actionPerformed
						}
					});
									btnSave.addMouseListener(new MouseAdapter() {
										public void mouseClicked(MouseEvent evt) {
											//setVisible(false);
											
											int numRows = AgentsDB.updateAgent(getTextfieldData());
											if(numRows >0)
											{
												JOptionPane.showMessageDialog(null,"Agent data saved!!!");
											}
											//-------------------
											/*AgentSearchJDialog parent;
											parent = (AgentSearchJDialog)getRootPane().getParent().getParent();
											
											Vector<Agents> agents = new Vector<Agents>();
											agents = AgentsDB.getAllAgents();
											
											ComboBoxModel cboAgencyModel = 
													new DefaultComboBoxModel(agents);
											
											parent.lstAgent.setModel(cboAgencyModel);
								*/			//lstAgent = new JList(agents);
											//-------------------
											System.out.println(getRootPane().getParent().getParent().getName());
											System.out.println(getRootPane().getParent().getName());
											dispose();
										}
									});
				}
			}
			this.setSize(454, 338);
			//---- populate data from data base into form fields
			setTextfieldData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getBtnStatus() {
		if(btnStatus == null) {
			btnStatus = new ButtonGroup();
		}
		return btnStatus;
	}
	
	private JButton getJButton1() {
		if(btnExit == null) {
			btnExit = new JButton();
			btnExit.setText("Exit");
			btnExit.setBounds(342, 210, 100, 36);
			btnExit.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					//System.out.println("btnReset.mouseClicked, event="+evt);
					//TODO add your code for btnReset.mouseClicked
					//setVisible(false);
					dispose();
				}
			});
		}
		return btnExit;
	}
	
	private JComboBox getCmbAgency() {
		//if(cmbAgency == null) {
			ComboBoxModel cmbAgencyModel = 
					new DefaultComboBoxModel(AgenciesDB.getAllAgencies());
			cmbAgency = new JComboBox();
			cmbAgency.setModel(cmbAgencyModel);
			cmbAgency.setBounds(136, 195, 160, 22);
		//}
		//setTextfieldData();
		return cmbAgency;
	}
	//---------------------------------------------------------------------
	/**
	 * get the dat of agent from agents table
	 * set those data into form fields
	 * */
	private void setTextfieldData()
	{
		Agents agt = AgentsDB.getAgent(Integer.valueOf(agentID));
		
		txtFirstName.setText(agt.getAgentFName());
		txtLastName.setText(agt.getAgentLName());
		txtMiddleInitial.setText(agt.getAgentMName());
		txtBusPhone.setText(agt.getAgentBusPhone());
		txtEmail.setText(agt.getAgentEmail());
		txtPosition.setText(agt.getAgentPosn());
		
		//
		cmbAgency.setSelectedItem(AgenciesDB.getAgency(agt.getAgentAgencyId()));
		
		
		//lbl1.setText(AgenciesDB.getAgency(agt.getAgentAgencyId()).getAgencyId().toString());
		//lbl2.setText(AgenciesDB.getAgency(agt.getAgentAgencyId()).getAgncyCity());
	}
	//---------------------------------------------------------------------
	private Agents  getTextfieldData()
	{
		Agents agt = new Agents();
		
		agt.setAgentId(Integer.valueOf(agentID));
		agt.setAgentFName(txtFirstName.getText());
		agt.setAgentMName(txtMiddleInitial.getText());
		agt.setAgentLName(txtLastName.getText());
		agt.setAgentBusPhone(txtBusPhone.getText());
		agt.setAgentEmail(txtEmail.getText());
		agt.setAgentPosn(txtPosition.getText());
		
		agt.setAgentAgencyId(((Agencies)cmbAgency.getSelectedItem()).getAgencyId());
		
		return agt;
	}
	
	private JLabel getLbl1() {
		if(lbl1 == null) {
			lbl1 = new JLabel();
			lbl1.setBounds(22, 261, 119, 15);
		}
		return lbl1;
	}
	
	private JLabel getLbl2() {
		if(lbl2 == null) {
			lbl2 = new JLabel();
			lbl2.setBounds(22, 282, 134, 15);
		}
		return lbl2;
	}
	//---------------------------------------------------------------------
	
	//---------------------------------------------------------------------

}
