import jenkins.model.Jenkins;
import java.util.logging.Logger

def logger = Logger.getLogger("")

def instance = Jenkins.getInstance()
pm = instance.pluginManager
uc = instance.updateCenter

updated = false

pm.plugins.each { plugin ->
  if (uc.getPlugin(plugin.shortName).version != plugin.version) {
    update = uc.getPlugin(plugin.shortName).deploy(true)
    update.get()
    updated = true
  }
}
if (updated) {
  logger.info("Plugins upgraded, initializing a restart!")
  instance.save()
  instance.doSafeRestart()
}

