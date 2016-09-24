import jenkins.model.Jenkins;
import java.util.logging.Logger

def logger = Logger.getLogger("")

def instance = Jenkins.getInstance()
pm = instance.pluginManager
uc = instance.updateCenter

deployed = false
installed = false

pm.plugins.each { plugin ->
plugin.disable()
}

def activatePlugin(plugin) {
  if (! plugin.isEnabled()) {
    plugin.enable()
    deployed = true
  }

  plugin.getDependencies().each {
    activatePlugin(pm.getPlugin(it.shortName))
  }
}

def pluginParameter="{{ jenkins_plugins_recommended|join(' ') }} {{ jenkins_plugins_extra|join(' ') }}"
def plugins = pluginParameter.split()
plugins.each {
if (! pm.getPlugin(it)) {
  deployment = uc.getPlugin(it).deploy(true)
  deployment.get()
  installed=true
}
activatePlugin(pm.getPlugin(it))
}

if (installed) {
  logger.info("Plugins installed, initializing a restart!")
  instance.save()
  instance.doSafeRestart()
}

