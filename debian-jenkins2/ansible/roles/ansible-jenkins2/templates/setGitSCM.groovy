
import jenkins.model.*

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("hudson.plugins.git.GitSCM")

desc.setGlobalConfigName("{{ jenkins_git_config_name }}")
desc.setGlobalConfigEmail("{{ jenkins_git_config_email }}")

desc.save()

