package Travel.GUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Travel.DataBase.*;
import Travel.Entity.*;
import Travel.Util.*;

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
public class AgentAddJDialog extends javax.swing.JDialog {
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel lblmsg1;
	private JLabel lblMessage;
	private JComboBox cboAgency;
	private JButton btnExit;
	private JLabel jLabel9;
	private JPanel pnlAddAgent;
	private JButton btnReset;
	private JButton btnSave;
	private JTextField txtPosition;
	private JTextField txtEmail;
	private JTextField txtBusPhone;
	private JTextField txtLastName;
	private JTextField txtMiddleInitial;
	private JTextField txtFirstName;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel2;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.getContentPane().setLayout(null);
				AgentAddJDialog inst = new AgentAddJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public AgentAddJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setModal(true);
				getContentPane().setLayout(null);
				
				{
					btnSave = new JButton();
					getContentPane().add(btnSave);
					btnSave.setText("Save");
					btnSave.setBounds(393, 154, 100, 36);
					btnSave.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) 
						{
							lblMessage.setText("");
							if(validateFields())
							{
								//lblmsg1.setText("It is VALID");
								int numrows = insertAgent();
								
								if(numrows >0)
								{
									// show message on successful insert operation
									JOptionPane.showMessageDialog(null,"Agent data added!!!");
									dispose();
								}
								else
								{
									// On unsuccessful insertion show error message
									lblMessage.setText("Insert failed !!!");
								}
							}
							else
							{
								//lblmsg1.setText("Data is NOT VALID");
							}
							
							
						}
					});
				}
				{
					btnReset = new JButton();
					getContentPane().add(btnReset);
					btnReset.setText("Reset");
					btnReset.setBounds(393, 195, 100, 36);
					btnReset.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							//System.out.println("btnReset.mouseClicked, event="+evt);
							//TODO add your code for btnReset.mouseClicked
							JTextField [] txtField = {txtBusPhone,
													txtEmail,
													txtFirstName,
													txtLastName,
													txtMiddleInitial,
													txtPosition};
							
							for(JTextField tf: txtField)
							{
								tf.setText("");
							}
							};
						});
				}
				{
					pnlAddAgent = new JPanel();
					getContentPane().add(pnlAddAgent);
					pnlAddAgent.setLayout(null);
					pnlAddAgent.setBounds(16, 7, 365, 267);
					pnlAddAgent.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					{
						jLabel2 = new JLabel();
						pnlAddAgent.add(jLabel2);
						jLabel2.setText("First Name:(*)");
						jLabel2.setBounds(15, 50, 132, 19);
					}
					{
						jLabel8 = new JLabel();
						pnlAddAgent.add(jLabel8);
						jLabel8.setText("Agency:");
						jLabel8.setBounds(15, 217, 132, 19);
					}
					{
						jLabel3 = new JLabel();
						pnlAddAgent.add(jLabel3);
						jLabel3.setText("Middle Initial:");
						jLabel3.setBounds(15, 77, 132, 19);
					}
					{
						jLabel4 = new JLabel();
						pnlAddAgent.add(jLabel4);
						jLabel4.setText("Last Name:");
						jLabel4.setBounds(15, 105, 132, 19);
					}
					{
						jLabel5 = new JLabel();
						pnlAddAgent.add(jLabel5);
						jLabel5.setText("Phone Number:(*)");
						jLabel5.setBounds(15, 133, 132, 19);
					}
					{
						jLabel6 = new JLabel();
						pnlAddAgent.add(jLabel6);
						jLabel6.setText("Email:(*)");
						jLabel6.setBounds(15, 161, 132, 19);
					}
					{
						jLabel7 = new JLabel();
						pnlAddAgent.add(jLabel7);
						jLabel7.setText("Position:");
						jLabel7.setBounds(16, 189, 132, 19);
					}
					{
						txtFirstName = new LimitedJTextField(40);
						pnlAddAgent.add(txtFirstName);
						txtFirstName.setBounds(159, 50, 163, 22);
						txtFirstName.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						txtFirstName.setToolTipText("Mandatory");
					}
					{
						txtMiddleInitial = new LimitedJTextField(10);
						pnlAddAgent.add(txtMiddleInitial);
						txtMiddleInitial.setBounds(159, 77, 75, 22);
						txtMiddleInitial.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						txtLastName = new LimitedJTextField(40);
						pnlAddAgent.add(txtLastName);
						txtLastName.setBounds(159, 105, 163, 22);
						txtLastName.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						txtBusPhone = new LimitedJTextField(40);
						pnlAddAgent.add(txtBusPhone);
						txtBusPhone.setBounds(159, 133, 163, 22);
						txtBusPhone.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						txtEmail = new LimitedJTextField(100);
						pnlAddAgent.add(txtEmail);
						txtEmail.setBounds(159, 161, 163, 22);
						txtEmail.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						txtPosition = new LimitedJTextField(40);
						pnlAddAgent.add(txtPosition);
						txtPosition.setBounds(159, 189, 163, 22);
						txtPosition.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						jLabel9 = new JLabel();
						pnlAddAgent.add(jLabel9);
						jLabel9.setText("Add Agent Information");
						jLabel9.setLayout(null);
						jLabel9.setBounds(18, 1, 280, 29);
						jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel9.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					{
						ComboBoxModel cboAgencyModel = 
								new DefaultComboBoxModel(AgenciesDB.getAllAgencies());
						cboAgency = new JComboBox();
						pnlAddAgent.add(cboAgency);
						cboAgency.setModel(cboAgencyModel);
						cboAgency.setBounds(159, 217, 163, 22);
					}
				}
				{
					btnExit = new JButton();
					getContentPane().add(btnExit);
					btnExit.setText("Exit");
					btnExit.setBounds(393, 236, 100, 36);
					btnExit.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							//System.out.println("btnReset.mouseClicked, event="+evt);
							//TODO add your code for btnReset.mouseClicked
							
							dispose();
							/*try {
								this.finalize();
							} catch (Throwable e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							setVisible(false);*/
						}
					});
				}
				{
					lblMessage = new JLabel();
					getContentPane().add(lblMessage);
					lblMessage.setText("lblMessage");
					lblMessage.setBounds(16, 284, 301, 15);
				}
				{
					lblmsg1 = new JLabel();
					getContentPane().add(lblmsg1);
					lblmsg1.setBounds(16, 311, 215, 15);
				}
			}
			this.setSize(539, 352);
			lblMessage.setText("");
			lblmsg1.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------
	private Integer insertAgent()
	{
		Agents agt = new Agents();
		
		agt.setAgentFName(txtFirstName.getText());
		agt.setAgentMName(txtMiddleInitial.getText());
		agt.setAgentLName(txtLastName.getText());
		agt.setAgentBusPhone(txtBusPhone.getText());
		agt.setAgentPosn(txtPosition.getText());
		agt.setAgentEmail(txtEmail.getText());
		
		Agencies agncy = (Agencies) cboAgency.getSelectedItem();
		agt.setAgentAgencyId(agncy.getAgencyId());
		
		return AgentsDB.insertAgent(agt); // call db layer for insert
	}
	//----------------------------------
	private boolean validateFields()
	{
		// first name - mandatory check
		if(txtFirstName.getText().trim().isEmpty())
		{
			lblMessage.setText("First Name is mandatory");
			txtFirstName.requestFocus();
			return false;
		}
		
		// business phone - mandatory check
		if(txtBusPhone.getText().trim().isEmpty())
		{
			lblMessage.setText("Business phone is mandatory");
			txtBusPhone.requestFocus();
			return false;
		}
		
		// Email - mandatory check
		if(txtEmail.getText().trim().isEmpty())
		{
			lblMessage.setText("Email is mandatory");
			txtEmail.requestFocus();
			return false;
		}
		
		// check email format
		if(!Validator.isValidEmail(txtEmail.getText()))
		{ 
			lblMessage.setText("Invalid Email");
			txtEmail.requestFocus();
			return false;
		}
		
		return true;
	}
	//----------------------------------
}
