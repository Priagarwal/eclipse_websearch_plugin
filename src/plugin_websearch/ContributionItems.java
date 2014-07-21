package plugin_websearch;

import java.util.HashMap;
import java.util.Map;

import org.as.plugin.websearch.Activator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

public class ContributionItems extends ExtensionContributionFactory {

    private String menuEntry;
    private boolean showPrefs;
    
    public ContributionItems() {
    }


    @Override
    public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
	showPrefs = true;
	IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
	CommandContributionItem item;
	Map<String, String> parameters = new HashMap<String, String>();
	
	if (prefStore.isDefault("btnActivateConfigurationConf1") == false){
	    showPrefs = false;
	    menuEntry = Activator.getDefault().getPreferenceStore().getString("textMenuEntryConf1");
	    parameters.put("org.as.plugin.websearch.commandParameter", "Conf1");
	    
	    CommandContributionItemParameter contributionParameter = new CommandContributionItemParameter(serviceLocator, null, "org.as.plugin.websearch.command.websearch",  
		    	CommandContributionItem.STYLE_PUSH);  
		  	contributionParameter.label = menuEntry;
		  	contributionParameter.visibleEnabled = true;
		  	contributionParameter.parameters= parameters;

	    item = new CommandContributionItem(contributionParameter);
	    item.setVisible(true);
	    additions.addContributionItem(item, null);
	}

	if (prefStore.isDefault("btnActivateConfigurationConf2") == false){
	    showPrefs = false;
	    menuEntry = Activator.getDefault().getPreferenceStore().getString("textMenuEntryConf2");
	    parameters.put("org.as.plugin.websearch.commandParameter", "Conf2");
	    
	    CommandContributionItemParameter contributionParameter = new CommandContributionItemParameter(serviceLocator, null, "org.as.plugin.websearch.command.websearch",  
		    	CommandContributionItem.STYLE_PUSH);  
		  	contributionParameter.label = menuEntry;
		  	contributionParameter.visibleEnabled = true;
		  	contributionParameter.parameters= parameters;

	    item = new CommandContributionItem(contributionParameter);
	    item.setVisible(true);
	    additions.addContributionItem(item, null);
	}

	if (prefStore.isDefault("btnActivateConfigurationConf3") == false){
	    showPrefs = false;
	    menuEntry = Activator.getDefault().getPreferenceStore().getString("textMenuEntryConf3");
	    parameters.put("org.as.plugin.websearch.commandParameter", "Conf3");
	    
	    CommandContributionItemParameter contributionParameter = new CommandContributionItemParameter(serviceLocator, null, "org.as.plugin.websearch.command.websearch",  
		    	CommandContributionItem.STYLE_PUSH);  
		  	contributionParameter.label = menuEntry;
		  	contributionParameter.visibleEnabled = true;
		  	contributionParameter.parameters= parameters;

	    item = new CommandContributionItem(contributionParameter);
	    item.setVisible(true);
	    additions.addContributionItem(item, null);
	}

	if (showPrefs){
	    parameters.put("org.as.plugin.websearch.commandParameter", "prefs");
	    CommandContributionItemParameter contributionParameter = new CommandContributionItemParameter(serviceLocator, null, "org.as.plugin.websearch.command.websearch",  
		    	CommandContributionItem.STYLE_PUSH);  
		  	contributionParameter.label = "Web Search Preferences";
		  	contributionParameter.visibleEnabled = true;
		  	contributionParameter.parameters = parameters;

	    item = new CommandContributionItem(contributionParameter);
	    item.setVisible(true);
	    additions.addContributionItem(item, null);
	}
    }  

    
}
