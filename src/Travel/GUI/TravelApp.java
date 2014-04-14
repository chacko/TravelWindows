package Travel.GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


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
public class TravelApp extends javax.swing.JFrame {

	private JLabel lblMain;
	private JMenuItem mnuItmAgentExit;
	private JSeparator jSeparator1;
	private JMenuItem mnuItmAgentEdit;
	private JMenuItem mnuItmAgentAdd;
	private JSeparator jSeparator2;
	private JMenuItem mnuItmPkgEdit;
	private JMenuItem mnuItmPkgAdd;
	private JMenuBar jMenuBar1;
	private JMenuItem mnuItmExit;
	private JSeparator jSep3;
	private JSeparator jSep4;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TravelApp inst = new TravelApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TravelApp() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("TEAM 6 OOSD");
			}
			{
				lblMain = new JLabel();
				getContentPane().add(lblMain, "Center");
				lblMain.setFont(new java.awt.Font("Abyssinica SIL",1,48));
				//lblMain.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/travel2.jpeg")));
				lblMain.setBounds(0, 125, 744, 94);
				lblMain.setText("TRAVEL EXPERTS");
			}
			this.setSize(755, 391);
			this.setBounds(0, 0, 800, 600);
			this.setResizable(false);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Images/travel.jpg")).getImage());
			getContentPane().setLayout(null);

			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				//--------------------------
				{
					mnuItmPkgAdd = new JMenuItem();
					jMenuBar1.add(mnuItmPkgAdd);
					mnuItmPkgAdd.setText("Package Insert");
					mnuItmPkgAdd.setBackground(new java.awt.Color(173,216,230));
					mnuItmPkgAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							mnuItmPkgAddActionPerformed(evt);
						}
					});
				}
				//--------------------------
				{
					jSeparator2 = new JSeparator(JSeparator.VERTICAL);
					jMenuBar1.add(jSeparator2);
				}
				//--------------------------
				{
					mnuItmPkgEdit = new JMenuItem();
					jMenuBar1.add(mnuItmPkgEdit);
					mnuItmPkgEdit.setText("Package Change");
					mnuItmPkgEdit.setBackground(new java.awt.Color(173,216,230));
					mnuItmPkgEdit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							mnuItmPkgEditActionPerformed(evt);
						}
					});
				}
				//--------------------------
				{
					jSeparator1 = new JSeparator(JSeparator.VERTICAL);
					jMenuBar1.add(jSeparator1);
				}
				//--------------------------
				{
					mnuItmAgentAdd = new JMenuItem();
					jMenuBar1.add(mnuItmAgentAdd);
					mnuItmAgentAdd.setText("Agent Insert");
					mnuItmAgentAdd.setBackground(new java.awt.Color(173,216,230));
					mnuItmAgentAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					mnuItmAgentAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							mnuItmAgentAddActionPerformed(evt);
						}
					});
				}
				//--------------------------
				jSep4 = new JSeparator(JSeparator.VERTICAL);
				jMenuBar1.add(jSep4);
				//--------------------------
				//---- agent edit menu item
				{
					mnuItmAgentEdit = new JMenuItem();
					jMenuBar1.add(mnuItmAgentEdit);
					mnuItmAgentEdit.setText("Agent Change");
					mnuItmAgentEdit.setBackground(new java.awt.Color(173,216,230));
					mnuItmAgentEdit.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent evt) 
						{
							mnuItmAgentEditActionPerformed(evt);
						}
					});
				}
				//--------------------------
				jSep3 = new JSeparator(JSeparator.VERTICAL);
				jMenuBar1.add(jSep3);
				//--------------------------
				{
					mnuItmExit = new JMenuItem();
					jMenuBar1.add(mnuItmExit);
					mnuItmExit.setText("Exit");
					//mnuItmExit.setPreferredSize(new java.awt.Dimension(25, 6));
					mnuItmExit.setSize(100, 21);
					mnuItmExit.setBackground(new java.awt.Color(173,216,230));
					mnuItmExit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							mnuItmExitActionPerformed(evt);
						}
					});
				}
				//----------------------
				//----------------------
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void mnuItmAgentAddActionPerformed(ActionEvent evt) {
		AgentAddJDialog.main(null);
		
	}
	
	private void mnuItmAgentExitActionPerformed(ActionEvent evt) {
		
		System.exit(0);
	}
	
	private void mnuItmAgentEditActionPerformed(ActionEvent evt) {
		AgentSearchJDialog.main(null);
		
	}
	
	private void mnuItmPkgAddActionPerformed(ActionEvent evt) 
	{
		PackageAddJDialog.main(null);
		
	}
	
	private void mnuItmPkgExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private void mnuItmPkgEditActionPerformed(ActionEvent evt) {
		//System.out.println("mnuItmPkgEdit.actionPerformed, event="+evt);
		//TODO add your code for mnuItmPkgEdit.actionPerformed
		PackageSearchJDialog.main(null);
	}
	
	private void mnuItmExitActionPerformed(ActionEvent evt) {
		//System.out.println("mnuItmExit.actionPerformed, event="+evt);
		//TODO add your code for mnuItmExit.actionPerformed
		System.exit(0);
	}

	/*private void mnuItmPkgAddActionPerformed(ActionEvent evt) {
		System.out.println("mnuItmPkgAdd.actionPerformed, event="+evt);
		//TODO add your code for mnuItmPkgAdd.actionPerformed
	}*/

}
