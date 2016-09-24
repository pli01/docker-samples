import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*

nodes = Jenkins.instance.globalNodeProperties

nodes.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)

if ( nodes.size() != 1 ) {
  println("error: unexpected number of environment variable containers: ${nodes.size()}, expected: 1")
} else {
  envVars = nodes[0].envVars
/*
  declaration des VAR globales
*/
  envVars["JENKINS_HTTP_PROXY"]  = "{{ proxy_env.http_proxy }}"
  envVars["JENKINS_HTTPS_PROXY"] = "{{ proxy_env.https_proxy }}"

  Jenkins.instance.save()
}

