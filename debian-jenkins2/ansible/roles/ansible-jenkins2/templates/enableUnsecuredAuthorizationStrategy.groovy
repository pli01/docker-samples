import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*
import com.michelin.cio.hudson.plugins.rolestrategy.*
import java.util.logging.Logger


AuthorizationStrategy strategy = Jenkins.instance.getAuthorizationStrategy()

logger = Logger.getLogger("FullControlOnceLoggedInAuthorizationStrategy Updater")

if(strategy ==null || !strategy instanceof AuthorizationStrategy.Unsecured){
 logger.info("Unsecured AuthorizationStrategy set!")
 strategy = new AuthorizationStrategy.Unsecured()
 Jenkins.instance.setAuthorizationStrategy(strategy)
}

Jenkins.instance.save()
logger.info("AuthorizationStrategy done")
