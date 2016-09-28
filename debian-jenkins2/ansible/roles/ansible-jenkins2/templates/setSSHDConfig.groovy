import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;
import org.jenkinsci.plugins.*

  def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("org.jenkinsci.main.modules.sshd.SSHD")

desc.setPort(-1)
desc.save()
inst.save()
