package Page;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Connexion.ConnexionProjet;

public class PageRDV {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public PageRDV() {
		try {
			
			this.open();
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
		shell.setText("SWT Application");
		
		Label lblRdv = new Label(shell, SWT.NONE);
		lblRdv.setBounds(168, 94, 47, 25);
		lblRdv.setText("RDV");
		
		Button btnDeco = new Button(shell, SWT.NONE);
		btnDeco.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				ConnexionProjet window = new ConnexionProjet();
				window.open();
				
			}
		});
		btnDeco.setBounds(10, 10, 139, 35);
		btnDeco.setText("D\u00E9connexion");

	}
}
