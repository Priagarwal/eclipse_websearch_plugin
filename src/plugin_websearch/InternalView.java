package plugin_websearch;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class InternalView extends ViewPart {

    private Browser browser;
    
    public InternalView() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void createPartControl(Composite parent) {
	browser = new Browser(parent, SWT.NONE);
    }

    @Override
    public void setFocus() {
	// TODO Auto-generated method stub

    }

    public void showUrl(String urlString){
	if (urlString != null){
	    browser.setUrl(urlString);
	}
	
    }
}
