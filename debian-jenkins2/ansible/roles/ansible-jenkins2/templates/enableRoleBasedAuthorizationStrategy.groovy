import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*

SecurityRealm role = new RoleBasedAuthorizationStrategy()
Jenkins.instance.setSecurityRealm(role)
Jenkins.instance.save()
