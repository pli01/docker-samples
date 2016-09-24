import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*

Jenkins.instance.setNoUsageStatistics(true)
Jenkins.instance.setDisableRememberMe(true)
Jenkins.instance.setNumExecutors({{ jenkins_num_executors | default(2) }})
Jenkins.instance.save()
