// These are the basic imports that Jenkin's interactive script console 
// automatically includes.
import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

Jenkins.instance.setNumExecutors({{ jenkins_num_executors |default(2) }})
Jenkins.instance.save()
