package PageConnexion;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//import org.eclipse.wb.swt.SWTResourceManager;

import BDD.BDD;
import Page.Info;
import org.eclipse.wb.swt.SWTResourceManager;


public class PageConnexion {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PageConnexion window = new PageConnexion();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Connexion");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(96, 89, 199, 31);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(96, 155, 199, 31);
		
		Label lblConnexion = new Label(shell, SWT.NONE);
		lblConnexion.setFont(SWTResourceManager.getFont("Segoe UI Historic", 12, SWT.BOLD));
		lblConnexion.setBounds(114, 27, 152, 31);
		lblConnexion.setText("CONNEXION");

	}
}
