package plugin_websearch;

import org.as.plugin.websearch.Activator;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

    public PreferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
	IEclipsePreferences pref = DefaultScope.INSTANCE.getNode(Activator.PLUGIN_ID);

	pref.putBoolean("btnActivateConfigurationConf1", false);
	pref.put("textMenuEntryConf1", "Conf1");
	pref.putBoolean("btnRadioInternalViewConf1", true);
	pref.putBoolean("btnExternalBrowserConf1", false);
	pref.put("textUrlPatternConf1", "http://foo.bar//?search=%SEARCHTERM?user=%USER?pass=%PASSWORD");
	pref.putBoolean("btnCheckLoginConf1", false);
	pref.put("textUserConf1", "");
	pref.put("textPasswordConf1", "");

	pref.putBoolean("btnActivateConfigurationConf2", false);
	pref.put("textMenuEntryConf2", "Conf2");
	pref.putBoolean("btnRadioInternalViewConf2", true);
	pref.putBoolean("btnExternalBrowserConf2", false);
	pref.put("textUrlPatternConf2", "http://foo.bar//?search=%SEARCHTERM?user=%USER?pass=%PASSWORD");
	pref.putBoolean("btnCheckLoginConf2", false);
	pref.put("textUserConf2", "");
	pref.put("textPasswordConf2", "");

	pref.putBoolean("btnActivateConfigurationConf3", false);
	pref.put("textMenuEntryConf3", "Conf3");
	pref.putBoolean("btnRadioInternalViewConf3", true);
	pref.putBoolean("btnExternalBrowserConf3", false);
	pref.put("textUrlPatternConf3", "http://foo.bar//?search=%SEARCHTERM?user=%USER?pass=%PASSWORD");
	pref.putBoolean("btnCheckLoginConf3", false);
	pref.put("textUserConf3", "");
	pref.put("textPasswordConf3", "");

    }

}
