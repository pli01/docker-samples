// These are the basic imports that Jenkin's interactive script console
// automatically includes.
import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

// Don't edit : This file is generated !
[{{ jenkins_plugins_recommended | quote_items | join(',') }}].each{ plugin -> Jenkins.instance.updateCenter.getPlugin(plugin).install()
}
if (Jenkins.instance.updateCenter.restartScheduled)  Jenkins.getInstance().doSafeRestart();

/*
['groovy', 'gradle', 'chucknorris', 'greenballs', 'github', 'analysis-core', 'analysis-collector', 'cobertura',
 'project-stats-plugin','audit-trail', 'view-job-filters', 'disk-usage', 'global-build-stats',
 'radiatorviewplugin', 'violations', 'build-pipeline-plugin', 'monitoring', 'dashboard-view',
 'iphoneview', 'jenkinswalldisplay'].each{ plugin -> Jenkins.instance.updateCenter.getPlugin(plugin).install()
}
*/

/*
String pluginNameToRemove = "myPluginToRemove"
def jenkins = Jenkins.getInstance()
def pluginManager = jenkins.getPluginManager()
def pluginWrapperToUninstall = pluginManager.getPlugin(pluginNameToRemove)
pluginWrapperToUninstall.doDoUninstall()
*/

/* println(Jenkins.instance.pluginManager.plugins)
pm = Jenkins.instance.pluginManager

plug = pm.getPlugin("git")


def deployPlugin(plugin) {
  if (! plugin.isEnabled() ) {
    plugin.enable()
  }
  plugin.getDependencies().each { 
    deployPlugin(pm.getPlugin(it.shortName)) 
  }
}

deployPlugin(plug)
*/

