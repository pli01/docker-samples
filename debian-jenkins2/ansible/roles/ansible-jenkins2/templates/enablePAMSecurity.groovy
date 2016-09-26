#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def hudsonRealm = new PAMSecurityRealm("")
instance.setSecurityRealm(hudsonRealm)

instance.save()
