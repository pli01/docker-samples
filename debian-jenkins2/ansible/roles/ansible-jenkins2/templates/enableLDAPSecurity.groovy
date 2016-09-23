import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*

String server                      = '{{ jenkins_ldap_host }}'
String rootDN                      = '{{jenkins_ldap_base_sso}}'
String userSearchBase              = '{{jenkins_ldap_users}}'
String userSearch                  = '{{jenkins_ldap_filter}}'
String groupSearchBase             = '{{ jenkins_ldap_group }}'
String groupSearchFilter           = '(&(cn={0}) (| (objectclass=groupOfNames) (objectclass=groupOfUniqueNames) (objectclass=posixGroup)))'
String groupMembershipStrategy     = null
String managerDN                   = '{{jenkins_ldap_bind_dn}}'
String managerPasswordSecret       = '{{ jenkins_ldap_password_bind_dn }}'
boolean inhibitInferRootDN         = {{jenkins_ldap_enable_root_dn}}
boolean disableMailAddressResolver = {{jenkins_ldap_disable_email}}
// cache null or value
// FIXME: cache = new LDAPSecurityRealm.CacheConfiguration(50, 30)
String cache                       = null
String displayNameAttributeName    = '{{ jenkins_ldap_displayname }}'
String mailAddressAttributeName    = '{{ jenkins_ldap_mail }}'


/*
public LDAPSecurityRealm(
 String server,
 String rootDN,
 String userSearchBase,
 String userSearch,
 String groupSearchBase,
 String groupSearchFilter,
 LDAPGroupMembershipStrategy groupMembershipStrategy,
 String managerDN,
 Secret managerPasswordSecret,
 boolean inhibitInferRootDN,
 boolean disableMailAddressResolver,
 CacheConfiguration cache,
 EnvironmentProperty[] environmentProperties,
 String displayNameAttributeName,
 String mailAddressAttributeName,
 IdStrategy userIdStrategy,
 IdStrategy groupIdStrategy,
*/
SecurityRealm ldap_realm = new LDAPSecurityRealm(
 server                     = server,
 rootDN                     = rootDN,
 userSearchBase             = userSearchBase,
 userSearch                 = userSearch,
 groupSearchBase            = groupSearchBase,
 groupSearchFilter          = groupSearchFilter,
 groupMembershipStrategy    = groupMembershipStrategy,
 managerDN                  = managerDN,
 managerPasswordSecret      = managerPasswordSecret,
 inhibitInferRootDN         = inhibitInferRootDN,
 disableMailAddressResolver = disableMailAddressResolver,
 cache                      = cache,
 EnvironmentProperty        = null,
 displayNameAttributeName   = displayNameAttributeName,
 mailAddressAttributeName   = mailAddressAttributeName,
// userIdStrategy             = null,
// groupIdStrategy            = null,
)
Jenkins.instance.setSecurityRealm(ldap_realm)
Jenkins.instance.save()

