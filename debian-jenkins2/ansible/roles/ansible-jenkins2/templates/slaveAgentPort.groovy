// These are the basic imports that Jenkin's interactive script console 
// automatically includes.
import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

// This will use a setter, which will set the value (to a random port) 
// and also initialize the slave agent.
Jenkins.instance.setSlaveAgentPort({{ jenkins_slave_agent_port |default(0) }})
Jenkins.instance.save()
