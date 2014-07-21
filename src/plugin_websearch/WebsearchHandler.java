package plugin_websearch;

import java.net.MalformedURLException;
import java.net.URL;

import org.as.plugin.websearch.Activator;
import org.as.plugin.websearch.views.InternalView;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class WebsearchHandler extends AbstractHandler {

    @Override
    public void addHandlerListener(IHandlerListener handlerListener) {
	// TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
	// TODO Auto-generated method stub

    }

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
	
	Boolean internalView;
	Boolean externalBrowser;
	String urlString;
	
	IWorkbenchPage page = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
	IWorkbenchPart part = page.getActivePart();
	String confSuffix = event.getParameter("org.as.plugin.websearch.commandParameter");
	
	// No activated config -> show preference page
	if (confSuffix.equals("prefs")){
	    PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(null, "org.as.plugin.websearch.preferences", null, null);
	    dialog.open();
	    return null;
	}
	    
	internalView = Activator.getDefault().getPreferenceStore().getBoolean("btnRadioInternalView" + confSuffix);
	externalBrowser = Activator.getDefault().getPreferenceStore().getBoolean("btnRadioExternalBrowser" + confSuffix);
	    
	urlString = getUrl(confSuffix);
	try {
	    if (internalView == true){
		//internal view
		InternalView view = new InternalView();
		view = (InternalView)page.showView("org.as.plugin.websearch.views.internalView");
		view.showUrl(urlString);
	    }
	    else if (externalBrowser == true){
		//external Browser (Systembrowser)
		Activator.getDefault().getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(urlString));
	    }

	} catch (PartInitException e) {
	    e.printStackTrace();
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	}
	
	if (part instanceof org.eclipse.ui.IEditorPart)
	    page.activate(part);
	
	return null;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    @Override
    public boolean isHandled() {
	return true;
    }

    @Override
    public void removeHandlerListener(IHandlerListener handlerListener) {
	// TODO Auto-generated method stub

    }

    public String getUrl(String confSuffix){
	// Read Url-Pattern from Preferences
	String url = Activator.getDefault().getPreferenceStore().getString("textUrlPattern" + confSuffix);
	    
	// Get the selected Text
	String selectedText = null;
	ISelection selection = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
	if (selection != null && selection instanceof ITextSelection){
	    ITextSelection textSelection = (ITextSelection) selection;
	    selectedText = textSelection.getText();
	}
	    
	if (selectedText == null)
	    return null;
	    
	url = url.replaceAll("%SEARCHTERM", selectedText);
	    
	// Read Login needed
	Boolean login = Activator.getDefault().getPreferenceStore().getBoolean("btnCheckLogin" + confSuffix);
	String user;
	String password;
	if (login == true){
	    user = Activator.getDefault().getPreferenceStore().getString("textUser" + confSuffix);
	    password = Activator.getDefault().getPreferenceStore().getString("textPassword" + confSuffix);
		
	    url = url.replaceAll("%USER", user);
	    url = url.replaceAll("%PASSWORD", password);
	}
	    
	return url;
    }
    
}
