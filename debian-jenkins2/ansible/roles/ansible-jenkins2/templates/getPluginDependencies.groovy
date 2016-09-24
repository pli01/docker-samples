import hudson.PluginWrapper
import jenkins.model.Jenkins
import java.util.logging.Logger

def pluginByName = Jenkins.instance.getPluginManager().getPlugins();

logger = Logger.getLogger("Plugins Dependencies")
list = "\n"
pluginByName.each{ plugin ->
  if(plugin.isActive()){
   list += "  - { name: \"${plugin.shortName}\", version: \"${plugin.version}\" }\n"
  }
};

logger.info(list)
