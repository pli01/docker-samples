import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*
import com.michelin.cio.hudson.plugins.rolestrategy.*
import java.util.logging.Logger


AuthorizationStrategy strategy = Jenkins.instance.getAuthorizationStrategy()

logger = Logger.getLogger("RoleBasedAuthorizationStrategy Updater")

if(strategy ==null || !(strategy instanceof RoleBasedAuthorizationStrategy) ){
 logger.info("We shoud build a RoleBasedAuthorizationStrategy!")
 strategy = new RoleBasedAuthorizationStrategy()
 strategy.getRoleMaps().put("globalRoles", new RoleMap())
 strategy.getRoleMaps().put("projectRoles", new RoleMap())
 strategy.getRoleMaps().put("slaveRoles", new RoleMap())
 Jenkins.instance.setAuthorizationStrategy(strategy)
}
roleMaps = strategy.getRoleMaps();

if(roleMaps.get("globalRoles") == null){
 logger.info("We shoud add a globalRoles map!") 
 roleMaps.put("globalRoles", new RoleMap())
}
if(roleMaps.get("projectRoles") == null){
 logger.info("We shoud add a projectRoles map!") 
 roleMaps.put("projectRoles", new RoleMap())
}
if(roleMaps.get("slaveRoles") == null){
 logger.info("We shoud add a slaveRoles map!") 
 roleMaps.put("slaveRoles", new RoleMap())
}

logger.info("Building permissions")
// Admin
permissionIds = ['hudson.model.Run.Artifacts','hudson.scm.SCM.Tag','com.cloudbees.plugins.credentials.CredentialsProvider.Delete',
'hudson.model.View.Delete','hudson.model.Computer.Disconnect','hudson.model.Item.ExtendedRead','hudson.model.Computer.Configure',
'hudson.model.Item.Configure','hudson.model.Item.Workspace','hudson.model.View.Create','hudson.model.Run.Delete','hudson.model.View.Read',
'hudson.model.Hudson.UploadPlugins','hudson.model.Item.WipeOut','hudson.model.Computer.Connect','hudson.model.Computer.ExtendedRead',
'hudson.model.Item.Discover','com.cloudbees.plugins.credentials.CredentialsProvider.View','com.cloudbees.plugins.credentials.CredentialsProvider.Create',
'hudson.model.Hudson.Read','hudson.model.Item.Delete','hudson.model.View.Configure','hudson.model.Hudson.ConfigureUpdateCenter',
'com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains','hudson.model.Item.Read','hudson.model.Hudson.Administer',
'com.cloudbees.plugins.credentials.CredentialsProvider.UseItem','hudson.model.Computer.Delete','hudson.model.Hudson.RunScripts',
'com.cloudbees.plugins.credentials.CredentialsProvider.UseOwn','hudson.model.Computer.Create','hudson.model.Item.Create',
'hudson.model.Item.Build','hudson.model.Computer.Build','hudson.model.Item.Cancel','com.cloudbees.plugins.credentials.CredentialsProvider.Update',
'hudson.model.Run.Update']
permissions = new HashSet<Permission>();
permissionIds.each { permissionId -> permissions.add(Permission.fromId(permissionId))}

logger.info("Building role admin")
adminRole = new Role("admin",".*",permissions)

logger.info("Adding admin role to globalRoles")
roleMaps.get("globalRoles").addRole(adminRole)

logger.info("Assigning admin  role to some people")
roleMaps.get("globalRoles").assignRole(adminRole, "{{jenkins_app_group_admin_username}}");
// if more is required do a loop on th assign role for having many people affected as admin on jenkins

// Reader
permissionIds = ['hudson.model.View.Read', 'hudson.model.Item.Read', 'hudson.model.Hudson.Read' ]
permissions = new HashSet<Permission>();
permissionIds.each { permissionId -> permissions.add(Permission.fromId(permissionId))}

logger.info("Building role reader")
readerRole = new Role("reader",".*",permissions)

logger.info("Adding reader role to globalRoles")
roleMaps.get("globalRoles").addRole(readerRole)

logger.info("Assigning reader role to some people")
roleMaps.get("globalRoles").assignRole(readerRole, "{{jenkins_app_group_reader_username}}");
// if more is required do a loop on th assign role for having many people affected as admin on jenkins



Jenkins.instance.save()
logger.info("Role matrix definition done")
