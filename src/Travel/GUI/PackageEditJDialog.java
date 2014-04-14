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
public class PackageEditJDialog extends javax.swing.JDialog {
	private JPanel pnlEditPackage;
	private JButton btnExit;
	private ButtonGroup btnStatus;
	private JButton btnSave;
	private JLabel jLabel18;
	private JLabel jLabel17;
	private JLabel jLabel16;
	private JLabel jLabel15;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JTextField txtPackageId;
	private JTextField txtPackageName;
	private JTextField txtPackageDesc;
	private JTextField txtPackageBaseprice;
	private JTextField txtPackageStartDate;
	private JTextField txtPackageEndDate;
	
	private static String packageId; 
	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		packageId = args[0].toString();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				PackageEditJDialog inst = new PackageEditJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public PackageEditJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setModal(true);
				{
					pnlEditPackage = new JPanel();
					getContentPane().add(pnlEditPackage);
					pnlEditPackage.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					pnlEditPackage.setLayout(null);
					pnlEditPackage.setBounds(17, 11, 313, 238);
					{
						txtPackageId = new JTextField();
						pnlEditPackage.add(txtPackageId);
						txtPackageId.setBounds(135, 29, 163, 22);
					}
					{
						txtPackageName = new JTextField();
						pnlEditPackage.add(txtPackageName);
						txtPackageName.setBounds(135, 79, 163, 22);
					}
					{
						txtPackageDesc = new JTextField();
						pnlEditPackage.add(txtPackageDesc);
						txtPackageDesc.setBounds(135, 104, 163, 22);
					}
					{
						txtPackageBaseprice = new JTextField();
						pnlEditPackage.add(txtPackageBaseprice);
						txtPackageBaseprice.setBounds(135, 130, 163, 22);
					}
					{
						txtPackageStartDate = new JTextField();
						pnlEditPackage.add(txtPackageStartDate);
						txtPackageStartDate.setBounds(135, 155, 163, 22);
					}
					{
						txtPackageEndDate = new JTextField();
						pnlEditPackage.add(txtPackageEndDate);
						txtPackageEndDate.setBounds(135, 180, 163, 22);
					}
					{
						jLabel10 = new JLabel();
						pnlEditPackage.add(jLabel10);
						jLabel10.setText("Package Name:");
						jLabel10.setBounds(15, 77, 110, 19);
					}
					{
						jLabel11 = new JLabel();
						pnlEditPackage.add(jLabel11);
						jLabel11.setText("Package Desc:");
						jLabel11.setBounds(15, 105, 110, 19);
					}
					{
						jLabel12 = new JLabel();
						pnlEditPackage.add(jLabel12);
						jLabel12.setText("Package Base Price:");
						jLabel12.setBounds(15, 133, 110, 19);
					}
					{
						jLabel13 = new JLabel();
						pnlEditPackage.add(jLabel13);
						jLabel13.setText("Package Start Date:");
						jLabel13.setBounds(15, 161, 110, 19);
					}
					{
						jLabel14 = new JLabel();
						pnlEditPackage.add(jLabel14);
						jLabel14.setText("Package End Date:");
						jLabel14.setBounds(16, 189, 110, 19);
					}
					{
						jLabel18 = new JLabel();
						pnlEditPackage.add(jLabel18);
						jLabel18.setText("Edit Package Information");
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
					btnSave.setText("Save");
					btnSave.setBounds(342, 169, 100, 36);
					btnSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnSave.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {							
									int numRows = PackagesDB.updatePackage(getTextfieldData());
									if(numRows >0)
									{
										JOptionPane.showMessageDialog(null,"Packages data saved!!!");
									}
									
									dispose();								
								}
							});
						}
					});									
				}
			}
			this.setSize(460, 290);
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
	//---------------------------------------------------------------------
	/**
	 * get the dat of agent from agents table
	 * set those data into form fields
	 * */
	private void setTextfieldData()
	{
		Packages pkg = PackagesDB.getPackage(Integer.valueOf(packageId));
		
		txtPackageName.setText(pkg.getPackageName());
		txtPackageDesc.setText(pkg.getPackageDesc());
		txtPackageBaseprice.setText(String.valueOf(pkg.getPackagePrice()));
		txtPackageStartDate.setText(String.valueOf(pkg.getPackageStartDate()));
		txtPackageEndDate.setText(String.valueOf(pkg.getPackageEndDate()));		
	}
	//---------------------------------------------------------------------
	private Packages  getTextfieldData()
	{
		Packages pkg = new Packages();
		
		pkg.setPackageId(Integer.valueOf(packageId));
		pkg.setPackageName(txtPackageName.getText());
		pkg.setPackageDesc(txtPackageDesc.getText());
		pkg.setPackagePrice(Double.valueOf(txtPackageBaseprice.getText()));
		//pkg.setPackageStartDate(Integer.valueOf(txtPackageStartDate.getText()));
		//pkg.setPackageEndDate(Integer.valueOf(txtPackageEndDate.getText()));
		
		return pkg;
	}
	//---------------------------------------------------------------------
	
	//---------------------------------------------------------------------

}
