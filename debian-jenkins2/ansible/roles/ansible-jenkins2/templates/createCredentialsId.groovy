import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*;

import hudson.security.*

global_domain = Domain.global()
credentials_store = Jenkins.instance.getExtensionList(
    'com.cloudbees.plugins.credentials.SystemCredentialsProvider'
)[0].getStore()

def getUserPassword = { username ->
    def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
            com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials.class,
            jenkins.model.Jenkins.instance
            )

    def c = creds.findResult { it.username == username ? it : null }
    return c
}

if (! getUserPassword('user')) {
user = new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  java.util.UUID.randomUUID().toString(), "description", "user", "password")
credentials_store.addCredentials(global_domain, user)
}

if (! getUserPassword('userB')) {
user = new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "jenkins-slave-password", "Jenkis Slave with Password Configuration", "userB", "jenkins"
)
credentials_store.addCredentials(global_domain, user)
}

Jenkins.instance.save()

/* DEBUG
def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
      com.cloudbees.plugins.credentials.common.StandardUsernameCredentials.class,
      Jenkins.instance,
      null,
      null
);

for (a in creds) {
       println(a.id + ": " + a.description + " " + a.username +" " + a.password)
}
*/
