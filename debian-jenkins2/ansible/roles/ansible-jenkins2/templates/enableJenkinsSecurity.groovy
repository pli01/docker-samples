#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

    def hudsonRealm = new HudsonPrivateSecurityRealm(false)

    hudsonRealm.createAccount('{{ jenkins_admin_username | default("admin")}}','{{ jenkins_admin_password |default ("admin123")}}')

    instance.setSecurityRealm(hudsonRealm)

    instance.save()
