package Travel.GUI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DateFormatter;

//import net.sourceforge.*;
//import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
//import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
//import net.sourceforge.jdatepicker.impl.UtilDateModel;








import org.jdesktop.swingx.autocomplete.*;
import org.jdesktop.swingx.JXDatePicker;

import com.mysql.jdbc.EscapeTokenizer;
import com.qt.datapicker.*;

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
/**
* 
*/
public class PackageAddJDialog extends javax.swing.JDialog {
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;

	private LimitedJTextField txtComm;
	private JLabel lblComm;
	private JLabel lblmsg1;
	private JLabel lblMessage;
	private JButton btnExit;
	private JLabel jLabel9;
	private JPanel pnlAddPackage;
	private JButton btnReset;
	private JButton btnSave;
	private JTextField txtPackageName;
	private JTextField txtPackageDesc;
	private JTextField txtPackageBaseprice;
	private ObservingTextField txtPackageStartDate;
	private ObservingTextField txtPackageEndDate;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JButton jBtnStart;
	private JButton jBtnEnd;
	Date currDt = new Date(); 

	private static String packageId; 
	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		if(args != null)
		{
			packageId = args[0].toString();
		}
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.getContentPane().setLayout(null);
				PackageAddJDialog inst = new PackageAddJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
    
	public PackageAddJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void jBtnStartActionPerformed(ActionEvent evt)
	{
		String lang = null;
		final Locale locale = getlocale(lang);
		DatePicker dp = new DatePicker(txtPackageStartDate, locale);
		Date selectedDate = dp.parseDate(txtPackageStartDate.getText());
		dp.setSelectedDate(selectedDate);
		
		dp.start(txtPackageStartDate);
	}
	private void jBtnEndActionPerformed(ActionEvent evt)
	{
		String lang = null;
		final Locale locale = getlocale(lang);
		DatePicker dp = new DatePicker(txtPackageEndDate, locale);
		Date selectedDate = dp.parseDate(txtPackageEndDate.getText());
		dp.setSelectedDate(selectedDate);
		dp.start(txtPackageEndDate);
	}
	private Locale getlocale(String loc){
		if(loc != null && loc.length() > 0)
			return new Locale(loc);
		else
			return Locale.US;
	}
	
	class ObservingTextField extends JTextField implements Observer {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void update(Observable o, Object arg) {
	        Calendar calendar = (Calendar) arg;
	        DatePicker dp = (DatePicker) o;
	        //System.out.println("picked=" + dp.formatDate(calendar));
	        setText(dp.formatDate(calendar));
	    }
	}
	private void initGUI() {
		try {
			{
				this.setModal(true);
				getContentPane().setLayout(null);
				this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				this.setUndecorated(true);

				{
					btnSave = new JButton();
					getContentPane().add(btnSave);
					btnSave.setText("Save");
					btnSave.setBounds(345, 154, 100, 36);
					btnSave.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) 
						{
							lblMessage.setText("");
							
							if(validateFields())
							{
								try 
								{
									Integer numRows=0;
									
									if(packageId != null) // edit mode
									{
										System.out.println(packageId);
										numRows = PackagesDB.updatePackage(getTextfieldData());
									}
									else // add mode
									{
										numRows = PackagesDB.insertPackage(getTextfieldData());
									}
									
									if(numRows <=0)
									{
										lblMessage.setText("Insert failed !!!");
									}
									else
									{
										// On successful insertion return to main App
										// show message on successful insert operation
										JOptionPane.showMessageDialog(null,"Package data saved!!!");
										dispose();
									}
								} catch (HeadlessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else
							{
								//lblmsg1.setText("It is NOT VALID");
							}							
							
						}
					});
				}
				{
					btnReset = new JButton();
					getContentPane().add(btnReset);
					btnReset.setText("Reset");
					btnReset.setBounds(345, 195, 100, 36);
					btnReset.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							JTextField [] txtField = {
									txtPackageName,
									txtPackageDesc,
									txtPackageBaseprice,
									txtPackageStartDate,
									txtPackageEndDate,
									txtComm};
							
							for(JTextField tf: txtField)
							{
								tf.setText("");
							}
							};
						});
				}
				{
					pnlAddPackage = new JPanel();
					getContentPane().add(pnlAddPackage);
					pnlAddPackage.setLayout(null);
					pnlAddPackage.setBounds(16, 7, 318, 267);
					pnlAddPackage.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					{
						jLabel3 = new JLabel();
						pnlAddPackage.add(jLabel3);
						jLabel3.setText("Name");
						jLabel3.setBounds(13, 42, 110, 19);
					}
					{
						jLabel4 = new JLabel();
						pnlAddPackage.add(jLabel4);
						jLabel4.setText("Description");
						jLabel4.setBounds(13, 70, 110, 19);
					}
					{
						jLabel5 = new JLabel();
						pnlAddPackage.add(jLabel5);
						jLabel5.setText("Base Price");
						jLabel5.setBounds(13, 98, 110, 19);
					}
					{
						jLabel6 = new JLabel();
						pnlAddPackage.add(jLabel6);
						jLabel6.setText("Start Date");
						jLabel6.setBounds(15, 161, 110, 19);
					}
					{
						jLabel7 = new JLabel();
						pnlAddPackage.add(jLabel7);
						jLabel7.setText("End Date");
						jLabel7.setBounds(16, 189, 110, 19);
					}
					{
						txtPackageName = new LimitedJTextField(40);
						pnlAddPackage.add(txtPackageName);
						txtPackageName.setBounds(135, 42, 163, 22);
						txtPackageName.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						txtPackageDesc = new LimitedJTextField(40);
						pnlAddPackage.add(txtPackageDesc);
						txtPackageDesc.setBounds(135, 69, 163, 22);
						txtPackageDesc.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						txtPackageBaseprice = new LimitedJTextField(20);
						pnlAddPackage.add(txtPackageBaseprice);
						txtPackageBaseprice.setBounds(135, 98, 163, 22);
						txtPackageBaseprice.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}	
					{
						txtPackageStartDate = new ObservingTextField();
						pnlAddPackage.add(txtPackageStartDate);
						txtPackageStartDate.setBounds(137, 161, 83, 22);
						txtPackageStartDate.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						txtPackageStartDate.setEditable(true);
						txtPackageStartDate.setEnabled(false);
						txtPackageStartDate.setFont(new java.awt.Font("Abyssinica SIL",3,12));
						txtPackageStartDate.setForeground(new java.awt.Color(0,0,255));
					}
					{
						jBtnStart = new JButton();
						pnlAddPackage.add(jBtnStart);
						jBtnStart.setBounds(220, 161, 42, 22);
						jBtnStart.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						jBtnStart.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/cal.jpeg")));
						//jBtnStart.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/cal.png")));
						//jBtnStart.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/cal.jpg")));
						jBtnStart.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								// clicking start calendar button
								jBtnStartActionPerformed(evt);
							}
						});
					}				
					{
						txtPackageEndDate = new ObservingTextField();
						pnlAddPackage.add(txtPackageEndDate);
						txtPackageEndDate.setBounds(136, 189, 83, 22);
						txtPackageEndDate.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						txtPackageEndDate.setEnabled(false);
						txtPackageEndDate.setFont(new java.awt.Font("Abyssinica SIL",3,12));
					}
					{
						jBtnEnd = new JButton();
						pnlAddPackage.add(jBtnEnd);
						jBtnEnd.setBounds(220, 189, 42, 22);
						jBtnEnd.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						jBtnEnd.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/cal.jpeg")));
						jBtnEnd.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//System.out.println("here");
								jBtnEndActionPerformed(evt);
							}
						});
					}	
					{
						jLabel9 = new JLabel();
						pnlAddPackage.add(jLabel9);
						jLabel9.setText("Add Package Information");
						jLabel9.setLayout(null);
						jLabel9.setBounds(18, 1, 280, 29);
						jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel9.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					{
						lblComm = new JLabel();
						pnlAddPackage.add(lblComm);
						lblComm.setText("Commission");
						lblComm.setBounds(13, 130, 110, 19);
					}
					{
						txtComm = new LimitedJTextField(20);
						pnlAddPackage.add(txtComm);
						txtComm.setColumns(40);
						txtComm.setText("Travel.Util.LimitedJTextField");
						txtComm.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						txtComm.setBounds(135, 128, 163, 22);
					}
				}
				{
					btnExit = new JButton();
					getContentPane().add(btnExit);
					btnExit.setText("Exit");
					btnExit.setBounds(345, 236, 100, 36);
					btnExit.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							packageId =null;
							dispose(); 
						}
					});
				}
				{
					lblMessage = new JLabel();
					getContentPane().add(lblMessage);
					lblMessage.setText("lblMessage");
					lblMessage.setBounds(15, 286, 430, 15);
				}
				{
					lblmsg1 = new JLabel();
					getContentPane().add(lblmsg1);
					lblmsg1.setBounds(17, 308, 215, 15);
				}
			}
			this.setSize(491, 356);
			lblMessage.setText("");
			lblmsg1.setText("");
			
			// initialize start and end dates 
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			//txtPackageStartDate.setText(dateFormat.format(currDt).toUpperCase());
			//txtPackageEndDate.setText(dateFormat.format(currDt).toUpperCase());
			//txtPackageStartDate.setText(dateFormat.format(currDt).toUpperCase());
			//txtPackageEndDate.setText(dateFormat.format(currDt).toUpperCase());
			// In edit mode
			if(packageId != null)
			{
				setTextfieldData();
				jLabel9.setText("Edit Package Information");
			}
			else
			{
				clearTextfieldData();
				jLabel9.setText("Add Package Information");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------
	private Integer insertPackage() throws ParseException
	{
		
		/*Packages pkg = new Packages();
		
		//pkg.setPackageId(Integer.valueOf(txtPackageId.getText()));
		pkg.setPackageName(txtPackageName.getText());
		pkg.setPackageDesc(txtPackageDesc.getText());
		pkg.setPackagePrice(Double.valueOf(txtPackageBaseprice.getText()));
		pkg.setPackageAgencyComm(Double.valueOf(txtComm.getText()));
		
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yy");
		Date tempDate = formatDate.parse(txtPackageStartDate.getText());
		
		pkg.setPackageStartDate(tempDate);
		
		SimpleDateFormat ftDate = new SimpleDateFormat("MM/dd/yy");
		Date tmpDate = ftDate.parse(txtPackageEndDate.getText());
		
		pkg.setPackageEndDate(tmpDate);*/
		
		//getTextfieldData
		//return PackagesDB.insertPackage(pkg);// call db layer for insert
		return PackagesDB.insertPackage(getTextfieldData());
	}
	//----------------------------------
	private boolean validateFields()
	{
		// Package Id - mandatory check
		/*if(txtPackageId.getText().trim().isEmpty())
		{
			lblMessage.setText("Pacakge Id is mandatory");
			return false;
		}*/
		
		// Package Name - mandatory check
		if(txtPackageName.getText().trim().isEmpty())
		{
			lblMessage.setText("Name is mandatory");
			return false;
		}
		if(txtPackageDesc.getText().trim().isEmpty())
		{
			lblMessage.setText("Description is mandatory");
			return false;
		}
		if(txtPackageBaseprice.getText().trim().isEmpty())
		{
			lblMessage.setText("Base price is mandatory");
			return false;
		}
		if(!Validator.isDouble(txtPackageBaseprice.getText()))
		{
			lblMessage.setText("Base price should be numeric");
			return false;
		}
		
		if(!txtComm.getText().trim().isEmpty())
		{
			if(!Validator.isDouble(txtComm.getText()))
			{
				lblMessage.setText("Commission should be numeric");
				return false;
			}
			if(Double.parseDouble(txtComm.getText()) >= Double.parseDouble(txtPackageBaseprice.getText()))
			{
				lblMessage.setText("Commission should be less than Base price");
				return false;
			}
		}
		
		// date validation
		if(txtPackageStartDate.getText().trim().isEmpty())
		{
			lblMessage.setText("Start date is mandatory");
			return false;
		}
		if(txtPackageEndDate.getText().trim().isEmpty())
		{
			lblMessage.setText("End date is mandatory");
			return false;
		}
		//----------------------------------------------
		DateFormat df = new SimpleDateFormat("MM/dd/yy");
		Date startDate;
		Date endDate;
		try {
			startDate = df.parse(txtPackageStartDate.getText());
			endDate = df.parse(txtPackageEndDate.getText());
			if(endDate.before(startDate) || endDate.equals(startDate))
			{
				lblMessage.setText("End date should be later than Start date");
				return false;
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	//---------------------------------------------------------------------
	/**
	 * get the data of package from packages table
	 * set those data into form fields
	 * */
	private void setTextfieldData()
	{
		Packages pkg = PackagesDB.getPackage(Integer.valueOf(packageId));
		
		txtPackageName.setText(pkg.getPackageName());
		txtPackageDesc.setText(pkg.getPackageDesc());
		txtPackageBaseprice.setText(String.valueOf(pkg.getPackagePrice()));
		txtComm.setText(String.valueOf(pkg.getPackageAgencyComm()));
		
		txtPackageStartDate.setText(DBase.getMMddyyFormat(String.valueOf(pkg.getPackageStartDate())));
		txtPackageEndDate.setText(DBase.getMMddyyFormat(String.valueOf(pkg.getPackageEndDate())));		
		
	}
	//---------------------------------------------------------------------
	private void clearTextfieldData()
	{
		
		txtPackageName.setText("");
		txtPackageDesc.setText("");
		txtPackageBaseprice.setText("");
		txtComm.setText("");
		
		txtPackageStartDate.setText("");
		txtPackageEndDate.setText("");		
	}
	//---------------------------------------------------------------------
	private Packages  getTextfieldData() throws ParseException
	{
		Packages pkg = new Packages();
		
		if(packageId != null)
		{
			pkg.setPackageId(Integer.valueOf(packageId));	
		}
		
		pkg.setPackageName(txtPackageName.getText());
		pkg.setPackageDesc(txtPackageDesc.getText());
		pkg.setPackagePrice(Double.valueOf(txtPackageBaseprice.getText()));
		pkg.setPackageAgencyComm(Double.valueOf(txtComm.getText()));
		
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yy");
		Date tempDate = formatDate.parse(txtPackageStartDate.getText());
		
		pkg.setPackageStartDate(tempDate);
		
		SimpleDateFormat ftDate = new SimpleDateFormat("MM/dd/yy");
		Date tmpDate = ftDate.parse(txtPackageEndDate.getText());
		
		pkg.setPackageEndDate(tmpDate);
		
		return pkg;
	}
	//---------------------------------------------------------------------

}
