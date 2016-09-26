import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import jenkins.security.*

userListParameter = "{{ jenkins_users_api_token | join(' ') }}"
def userList = userListParameter.split()

userList.each {
User u = User.get(it)
ApiTokenProperty t = u.getProperty(ApiTokenProperty.class)

def token = t.getApiToken()

def file2 = new File('/var/lib/jenkins/jenkins_job_builder_' + it + '.txt')
file2 << "${token}"
}
