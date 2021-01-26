package Page;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.awt.*;  
import java.awt.*;  
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Spring;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;


import BDD.BDD;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Canvas;


public class Info {

protected Shell shlJunior;
	
	BDD MaBDD = new BDD();
	
	
	int check = 0;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Info window = new Info();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws SQLException 
	 */
	public void open() throws SQLException {
		Display display = Display.getDefault();
		createContents();
		shlJunior.open();
		shlJunior.layout();
		while (!shlJunior.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws SQLException 
	 */
	protected void createContents() throws SQLException {
		shlJunior = new Shell();
		shlJunior.setSize(1081, 686);
		shlJunior.setText("Junior");
		
		Canvas canvas = new Canvas(shlJunior, SWT.NONE);
		canvas.setBounds(290, 348, 358, 177);
		
		Canvas canvas_1 = new Canvas(shlJunior, SWT.NONE);
		canvas_1.setBounds(10, 10, 398, 284);
		
		Canvas canvas_2 = new Canvas(shlJunior, SWT.NONE);
		canvas_2.setBounds(10, 348, 264, 211);
		
		Canvas canvas_3 = new Canvas(shlJunior, SWT.NONE);
		canvas_3.setBounds(445, 28, 225, 120);
		
		//a modifier !!!!!
		canvas.setVisible(true);
		canvas_1.setVisible(true);
		canvas_2.setVisible(true);
		
		
		
		String Classe[] = {"3emeJ","3emeV","2ndSn","2ndTU","2ndMEI","1erSn","1erTU","1erMEI","TerSn","TerTU","TerMEI","1erSti2D","TerSti2D","1erBtsSlam","2emeBtsSlam","1erBtsSISR"};
		
        
		String Regime[] = {"Halal","Vegetarien","Sans Gluten"};
		
		
		String Externe[] = {"oui","non","BTS"};
		
		ResultSet tab;
		tab = MaBDD.listUser();
		int a = MaBDD.defLigne();
		String Userdata[] = new String[a];
		int i = 0;
		while(tab.next())
		{
			Userdata[i] = tab.getString("nom");
			i++;
		}
		
		
		Combo listUser = new Combo(canvas_2,   SWT.DROP_DOWN | SWT.READ_ONLY);
		listUser.setBounds(87, 67, 104, 23);
		listUser.setItems(Userdata);
	
		
		Combo listUserM = new Combo(canvas_3,   SWT.DROP_DOWN | SWT.READ_ONLY);
		listUserM.setBounds(98, 41, 91, 23);
		listUserM.setItems(Userdata);
		
		int indexUserM = listUserM.getSelectionIndex();
		
		
		
	
		
		Label lblUser = new Label(canvas, SWT.NONE);
		lblUser.setBounds(160, 10, 38, 17);
		//lblUser.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		lblUser.setText("User");
		
		Label lblClasses = new Label(canvas, SWT.NONE);
		lblClasses.setBounds(20, 45, 42, 20);
		lblClasses.setText("Classe : ");
		Combo combo = new Combo(canvas, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setBounds(68, 42, 134, 23);
		
				combo.setItems(Classe);
				
				Button btnNewButton = new Button(canvas, SWT.NONE);
				btnNewButton.setBounds(243, 132, 105, 35);
				btnNewButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
					}
				});
				
				
				btnNewButton.addListener(SWT.Selection, new Listener()
				{
					@Override
					public void handleEvent(Event arg0) {
						int idx = combo.getSelectionIndex();
						String choixClasse = combo.getItem(idx);
						
						
						
						  //expe ChangeFen2 = new expe(choixClasse, check);
						  //ChangeFen2.setVisible(true);
					}
				});
				btnNewButton.setText("Voir Table");
				
				Button btnOrdreAlphabtique = new Button(canvas, SWT.CHECK);
				btnOrdreAlphabtique.setBounds(68, 90, 134, 23);
				btnOrdreAlphabtique.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						  if(btnOrdreAlphabtique.getSelection( ))
				          {    
				              check = 1;
				     
				              
				          }
				          else
				          {
				        	  check = 0; 
				          } 
					}
				});
				btnOrdreAlphabtique.setText("Ordre Alphab\u00E9tique");
				
				Label lblLogin = new Label(canvas_1, SWT.NONE);
				lblLogin.setBounds(10, 47, 35, 18);
				lblLogin.setText("Nom :");
				
				
				
				Text nom = new Text(canvas_1, SWT.BORDER);
				nom.setBounds(45, 44, 76, 21);
				
				Label lblMdp = new Label(canvas_1, SWT.NONE);
				lblMdp.setBounds(10, 92, 47, 17);
				lblMdp.setText("Prenom : ");
				
				Text prenom = new Text(canvas_1, SWT.BORDER);
				prenom.setBounds(63, 89, 76, 21);
				
				Text Autre = new Text(canvas_1, SWT.BORDER);
				Autre.setBounds(239, 141, 105, 81);
				

				Spinner SpinnAge = new Spinner(canvas_1, SWT.BORDER);
				SpinnAge.setBounds(58, 141, 63, 23);
				SpinnAge.setMaximum(26);
				SpinnAge.setMinimum(15);
				
				Label lblNewLabel = new Label(canvas_1, SWT.NONE);
				lblNewLabel.setBounds(18, 144, 35, 20);
				lblNewLabel.setText("Age :");
				
				Combo ListClasse = new Combo(canvas_1,  SWT.DROP_DOWN | SWT.READ_ONLY);
				ListClasse.setBounds(239, 36, 105, 23);
				ListClasse.setItems(Classe);
				
				Combo ListExterne = new Combo(canvas_1, SWT.DROP_DOWN | SWT.READ_ONLY);
				ListExterne.setBounds(239, 106, 105, 23);
				ListExterne.setItems(Externe);
				
				Combo  ListRegime = new Combo(canvas_1,  SWT.DROP_DOWN | SWT.READ_ONLY);
				ListRegime.setBounds(239, 70, 105, 23);
				ListRegime.setItems(Regime);
				
	
				
				Button btnNewButton_2 = new Button(canvas_1, SWT.NONE);
				btnNewButton_2.setBounds(137, 239, 105, 35);
				btnNewButton_2.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
					}
				});
				
				
				btnNewButton_2.addListener(SWT.Selection, new Listener()
				{
					@Override
					public void handleEvent(Event arg0) 
					{
						
						int indexClas = ListClasse.getSelectionIndex();
						int indexReg = ListRegime.getSelectionIndex();
						int indexExt = ListExterne.getSelectionIndex();
						
						
						
						System.out.println("TEXT :" + ListClasse.getItem(indexClas));
						System.out.println("TEXT :" + nom.getText());
						System.out.println("TEXT :" + prenom.getText());
						System.out.println("TEXT :" + SpinnAge.getText());
						System.out.println("TEXT :" + ListRegime.getItem(indexReg));
						System.out.println("TEXT :" + ListExterne.getItem(indexExt));
						System.out.println("TEXT :" + Autre.getText());
										    	
						String classe = ListClasse.getItem(indexClas);
						String regime = ListRegime.getItem(indexReg);
						String externe= ListExterne.getItem(indexExt);
						String age = SpinnAge.getText();
						String Prenom = prenom.getText();
						String Nom = nom.getText();
						String autre = Autre.getText();
										  
						//on insert avec nos variables 
						MaBDD.ajout(classe,regime,externe,age,Prenom,Nom,autre);
					}
				});
				btnNewButton_2.setText("Ajouter");
				
				Label lblClasse = new Label(canvas_1, SWT.NONE);
				lblClasse.setBounds(181, 39, 47, 22);
				lblClasse.setText("Classe :");
				
			
				
				Label lblRegime = new Label(canvas_1, SWT.NONE);
				lblRegime.setBounds(181, 70, 47, 22);
				lblRegime.setText("Regime : ");
				
				
				Label lblExterne = new Label(canvas_1, SWT.NONE);
				lblExterne.setBounds(181, 109, 47, 22);
				lblExterne.setText("Externe : ");
				
				
				
				Label lblAjoutUser = new Label(canvas_1, SWT.NONE);
				lblAjoutUser.setBounds(137, 10, 72, 22);
				//lblAjoutUser.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
				lblAjoutUser.setText("Ajout User");
				
				
				
				Label lblAutre = new Label(canvas_1, SWT.NONE);
				lblAutre.setBounds(193, 144, 35, 18);
				lblAutre.setText("Autre :");
				
				Menu menu = new Menu(shlJunior, SWT.BAR);
				shlJunior.setMenuBar(menu);
				
				MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
				mntmNewItem.setText("User");
				mntmNewItem.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						canvas.setVisible(true);
						canvas_1.setVisible(false);
						canvas_2.setVisible(false);
						
					}
				});
				
				MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
				mntmNewItem_1.setText("Ajout User");
				
		
				
				MenuItem mntmNewItem_2 = new MenuItem(menu, SWT.NONE);
				mntmNewItem_2.setText("Supprimer User");
				
	
				
			
			
				
				Label lblSupprimerUser = new Label(canvas_2, SWT.NONE);
				lblSupprimerUser.setBounds(54, 25, 106, 26);
				//lblSupprimerUser.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
				lblSupprimerUser.setText("Supprimer User");
				
				Label lblUser_1 = new Label(canvas_2, SWT.NONE);
				lblUser_1.setBounds(46, 70, 35, 20);
				lblUser_1.setText("User :");
				
				
				
				Button btnSupprimer = new Button(canvas_2, SWT.NONE);
				btnSupprimer.setBounds(66, 115, 105, 35);
				btnSupprimer.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						int indexUser = listUser.getSelectionIndex();
						
						String User = listUser.getItem(indexUser); 
						MaBDD.supprimer(User);
					}
				});
				btnSupprimer.setText("Supprimer");
				
			
				
				
				
				Label lblUser_2 = new Label(canvas_3, SWT.NONE);
				lblUser_2.setBounds(63, 44, 29, 15);
				lblUser_2.setText("User :");
				
				Button btnModifier = new Button(canvas_3, SWT.NONE);
				btnModifier.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						
							shlJunior.dispose();
							//Modif window = new Modif();
							//window.open();
							
					}
				});
				
				
				
				
				
				
				
				btnModifier.setBounds(87, 78, 75, 25);
				btnModifier.setText("Modifier");
				
				Label lblModifierUser = new Label(canvas_3, SWT.NONE);
				
				lblModifierUser.setBounds(76, 10, 91, 25);
				lblModifierUser.setText("Modifier User");
				
				
				mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						canvas.setVisible(false);
						canvas_1.setVisible(true);
						canvas_2.setVisible(false);
						
					}
				});
				
				mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						canvas.setVisible(false);
						canvas_1.setVisible(false);
						canvas_2.setVisible(true);
						
					}
				});
		

	}
}
