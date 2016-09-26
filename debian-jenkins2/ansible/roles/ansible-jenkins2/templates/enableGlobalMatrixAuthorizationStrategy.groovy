import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*
import com.michelin.cio.hudson.plugins.rolestrategy.*
import java.util.logging.Logger


AuthorizationStrategy strategy = Jenkins.instance.getAuthorizationStrategy()

logger = Logger.getLogger("GlobalMatrixAuthorizationStrategy Updater")

if(strategy ==null || ! (strategy instanceof GlobalMatrixAuthorizationStrategy) ){
 logger.info("We shoud build a GlobalMatrixAuthorizationStrategy!")
 strategy = new GlobalMatrixAuthorizationStrategy()
 Jenkins.instance.setAuthorizationStrategy(strategy)
}

logger.info("Building permissions")
// Admin
permissionIds = [ Jenkins.ADMINISTER, Jenkins.READ, Jenkins.RUN_SCRIPTS ]
permissionIds.each { 
 strategy.add( it ,'authenticated')
}

logger.info("Building role admin")

Jenkins.instance.save()
logger.info("GlobalMatrixAuthorizationStrategy definition done")

