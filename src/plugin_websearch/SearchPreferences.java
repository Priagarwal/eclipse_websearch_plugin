package plugin_websearch;

import org.as.plugin.websearch.Activator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class SearchPreferences extends PreferencePage implements IWorkbenchPreferencePage {

    public SearchPreferences() {
	super();
	setTitle("Websearch Preferences");
    }

    Tab tab1;
    Tab tab2;
    Tab tab3;

    @Override
    protected Control createContents(Composite parent) {
	Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(null);
		
		CTabFolder tabFolder = new CTabFolder(container, SWT.BORDER);
		tabFolder.setBounds(5, 5, 485, 334);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		tab1 = new Tab(tabFolder, "Conf1", getPreferenceStore());
		tab1.showContent();
		tab1.readTabPreferences();
		tab1.setConfVisibility();
		
		tab2 = new Tab(tabFolder, "Conf2", getPreferenceStore());
		tab2.showContent();
		tab2.readTabPreferences();
		tab2.setConfVisibility();
		
		tab3 = new Tab(tabFolder, "Conf3", getPreferenceStore());
		tab3.showContent();
		tab3.readTabPreferences();
		tab3.setConfVisibility();
		
		tabFolder.setSelection(0);
		
	return container;
    }


    @Override
    public void init(IWorkbench workbench) {
	setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }
    
    @Override
    public void performApply(){
	tab1.performTabApply();
	tab2.performTabApply();
	tab3.performTabApply();
    }
    
    @Override
    public boolean performOk(){
	performApply();
	return true;
    }
    
    @Override
    public void performDefaults(){
	tab1.performTabDefaults();
	tab2.performTabDefaults();
	tab3.performTabDefaults();
    }
    

    class Tab{
	private CTabFolder tabFolder;
	private String confName;
	private IPreferenceStore prefStore;
	
	private Button btnActivateConfiguration; 
	private Button btnRadioInternalView;
	private Button btnRadioExternalBrowser;
	private Text textUrlPattern;
	private Button btnCheckLogin;
	private Text textUser;
	private Text textPassword;
	private Text textMenuEntry;
	
	public Tab (CTabFolder tabFolder, String confName, IPreferenceStore prefStore){
	    this.tabFolder = tabFolder;
	    this.confName = confName;
	    this.prefStore = prefStore;
	}

	public void showContent(){
		CTabItem tbtmConf = new CTabItem(tabFolder, SWT.NONE);
		tbtmConf.setText(confName);
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmConf.setControl(composite);
		composite.setLayout(new GridLayout(5, false));
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
						
						btnActivateConfiguration = new Button(composite, SWT.CHECK);
						btnActivateConfiguration.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
							    setConfVisibility();
							}
						});
						btnActivateConfiguration.setText("Activate Configuration");
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
						new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
						
						Label lblMenuEntry1 = new Label(composite, SWT.NONE);
						lblMenuEntry1.setSize(141, 15);
						lblMenuEntry1.setText("Menu Entry:");
				
						textMenuEntry = new Text(composite, SWT.BORDER);
						GridData gd_textMenuEntry = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
						gd_textMenuEntry.widthHint = 99;
						textMenuEntry.setLayoutData(gd_textMenuEntry);
						textMenuEntry.setSize(481, 299);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);

				Label lblUrlpattern1 = new Label(composite, SWT.NONE);
				lblUrlpattern1.setSize(70, 15);
				lblUrlpattern1.setText("URL-Pattern: ");
				
				
				textUrlPattern = new Text(composite, SWT.BORDER);
				GridData gd_textUrlPattern = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
				gd_textUrlPattern.widthHint = 198;
				textUrlPattern.setLayoutData(gd_textUrlPattern);
				textUrlPattern.setSize(199, 21);
				new Label(composite, SWT.NONE);
				
				Label lblExpressions1 = new Label(composite, SWT.NONE);
				lblExpressions1.setSize(85, 60);
				lblExpressions1.setText("Expressions:\r\n%SEARCHTERM\r\n%USER\r\n%PASSWORD");
				
				btnRadioInternalView = new Button(composite, SWT.RADIO);
				btnRadioInternalView.setSize(89, 16);
				btnRadioInternalView.setText("Internal View");
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				
				
				btnRadioExternalBrowser = new Button(composite, SWT.RADIO);
				btnRadioExternalBrowser.setSize(107, 16);
				btnRadioExternalBrowser.setText("External Browser");
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				
				Label label1 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
				label1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
				label1.setSize(128, 2);
				new Label(composite, SWT.NONE);
				
				btnCheckLogin = new Button(composite, SWT.CHECK);
				btnCheckLogin.setSize(51, 16);
				btnCheckLogin.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
					    setLoginVisability();	
					}
				});
				btnCheckLogin.setText("Login");
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				
				Label lblUser1 = new Label(composite, SWT.NONE);
				lblUser1.setSize(29, 15);
				lblUser1.setText("User: ");
				
				textUser = new Text(composite, SWT.BORDER);
				textUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				textUser.setSize(139, 21);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				
				Label lblPassword1 = new Label(composite, SWT.NONE);
				lblPassword1.setSize(56, 15);
				lblPassword1.setText("Password: ");
				
				textPassword = new Text(composite, SWT.BORDER | SWT.PASSWORD);
				textPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				textPassword.setSize(138, 21);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
				new Label(composite, SWT.NONE);
	    
	}
	
	    protected void setConfVisibility() {
		if (btnActivateConfiguration.getSelection() == true){
			textUrlPattern.setEnabled(true);
			btnRadioInternalView.setEnabled(true);
			btnRadioExternalBrowser.setEnabled(true);
			btnCheckLogin.setEnabled(true);
			textMenuEntry.setEnabled(true);
			setLoginVisability();
		}
		else {
			textUrlPattern.setEnabled(false);
			btnRadioInternalView.setEnabled(false);
			btnRadioExternalBrowser.setEnabled(false);
			btnCheckLogin.setEnabled(false);
			textMenuEntry.setEnabled(false);
			textUser.setEnabled(false);
			textPassword.setEnabled(false);
		}
	    }

	    protected void setLoginVisability(){
		    if (btnCheckLogin.getSelection() == true){
			textUser.setEnabled(true);
			textPassword.setEnabled(true);
		    }
		    else {
			textUser.setEnabled(false);
			textPassword.setEnabled(false);
		    }
		
	    }
	    
	    protected void performTabApply(){
		prefStore.setValue("btnActivateConfiguration" + confName, btnActivateConfiguration.getSelection());
		prefStore.setValue("textMenuEntry" + confName, textMenuEntry.getText());
		prefStore.setValue("btnRadioInternalView" + confName, btnRadioInternalView.getSelection());
		prefStore.setValue("btnRadioExternalBrowser" + confName, btnRadioExternalBrowser.getSelection());
		prefStore.setValue("textUrlPattern" + confName, textUrlPattern.getText());
		prefStore.setValue("btnCheckLogin" + confName, btnCheckLogin.getSelection());
		prefStore.setValue("textUser" + confName, textUser.getText());
		prefStore.setValue("textPassword" + confName, textPassword.getText());
	    }
	    
	    protected void performTabDefaults(){
		btnActivateConfiguration.setSelection(prefStore.getDefaultBoolean("btnActivateConfiguration" + confName));
		textMenuEntry.setText(prefStore.getDefaultString("textMenuEntry" + confName));
		btnRadioInternalView.setSelection(prefStore.getDefaultBoolean("btnRadioInternalView" + confName));
		btnRadioExternalBrowser.setSelection(prefStore.getDefaultBoolean("btnRadioExternalBrwoser" + confName));
		textUrlPattern.setText(prefStore.getDefaultString("textUrlPattern" + confName));
		btnCheckLogin.setSelection(prefStore.getDefaultBoolean("btnCheckLogin" + confName));
		textUser.setText(prefStore.getDefaultString("textUser" + confName));
		textPassword.setText(prefStore.getDefaultString("textPassword" + confName));
		
		setLoginVisability();
		setConfVisibility();
	    }

	    public void readTabPreferences(){
		btnActivateConfiguration.setSelection(prefStore.getBoolean("btnActivateConfiguration" + confName));
		textMenuEntry.setText(prefStore.getString("textMenuEntry" + confName));
		textUrlPattern.setText(prefStore.getString("textUrlPattern" + confName));
		btnRadioInternalView.setSelection(prefStore.getBoolean("btnRadioInternalView" + confName));
		btnRadioExternalBrowser.setSelection(prefStore.getBoolean("btnRadioExternalBrowser" + confName));
		btnCheckLogin.setSelection(prefStore.getBoolean("btnCheckLogin" + confName));
		textUser.setText(prefStore.getString("textUser" + confName));
		textPassword.setText(prefStore.getString("textPassword" + confName));
	    }
    }
}
