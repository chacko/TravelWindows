package Travel.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.autocomplete.Configurator;

import Travel.DataBase.PackagesDB;
import Travel.Entity.Packages;

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
public class PackageSearchJDialog extends javax.swing.JDialog {
	public JList lstPackage;
	private JButton btnDelete;
	private JTextField txtSearchPackage;
	private JLabel jLabel1;
	private JButton btnExit;
	private JButton btnEdit;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				PackageSearchJDialog inst = new PackageSearchJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public PackageSearchJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setModal(true);
				getContentPane().setLayout(null);
				this.setTitle("Packages");
				//this.setModalityType(java.awt.Dialog$ModalityType.APPLICATION_MODAL);
				{
					//ArrayList<String> agents = new ArrayList<>();
					Vector<Packages> packages = new Vector<Packages>();
					
					packages = PackagesDB.getAllPackages();

					lstPackage = new JList(packages);
					
					getContentPane().add(lstPackage);
					lstPackage.setBounds(12, 48, 303, 269);
					lstPackage.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					lstPackage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					lstPackage.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent evt) {
							//System.out.println("lstAgent.valueChanged, event="+evt);
							//TODO add your code for lstAgent.valueChanged
							if(lstPackage.isSelectionEmpty()){
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
				{
					btnEdit = new JButton();
					getContentPane().add(btnEdit);
					btnEdit.setText("Edit Package");
					btnEdit.setBounds(327, 242, 143, 32);
					btnEdit.setEnabled(false);
					btnEdit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//System.out.println("btnEdit.actionPerformed, event="+evt);
							//TODO add your code for btnEdit.actionPerformed
							if(evt.getSource() == btnEdit)
							{
								Packages pkg = (Packages) lstPackage.getSelectedValue();
								//JOptionPane.showConfirmDialog(null, agt.getAgentId());
								String [] args = {String.valueOf(pkg.getPackageId())};
								//System.out.println(args[0]);
								
								//PackageEditJDialog.main(args);
								PackageAddJDialog.main(args);
							}
						}
					});
				}
				{
					btnDelete = new JButton();
					getContentPane().add(btnDelete);
					btnDelete.setText("Delete Package:");
					btnDelete.setBounds(327, 159, 143, 32);
					btnDelete.setEnabled(false);
					btnDelete.setVisible(false);
					btnDelete.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							//System.out.println("btnDelete.mouseClicked, event="+evt);
							//TODO add your code for btnDelete.mouseClicked
							
							if(btnDelete.isEnabled() == true){
								int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this agent?");
								if(option == JOptionPane.YES_OPTION){
									if(evt.getSource() == btnDelete){
										PackagesDB.deletePackage(Integer.valueOf(txtSearchPackage.getText()));
									}
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
					jLabel1.setText("Search Package:");
					jLabel1.setLayout(null);
					jLabel1.setBounds(19, 21, 108, 15);
				}
				{
					txtSearchPackage = new JTextField();
					getContentPane().add(txtSearchPackage);
					txtSearchPackage.setBounds(154, 18, 161, 22);
					
					//Configurator.enableAutoCompletion(lstAgent, txtSearchAgent);
					Configurator.enableAutoCompletion(lstPackage,txtSearchPackage);
				}
			}
			this.setSize(491, 370);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
