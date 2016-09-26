import jenkins.model.*
import java.util.logging.Logger

def instance = Jenkins.getInstance()

def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()

{% if jenkins.email.default_email_suffix is defined and jenkins.email.default_email_suffix %}
jenkinsLocationConfiguration.setAdminAddress("{{ jenkins.email.default_email_suffix }}")
{% else %}
jenkinsLocationConfiguration.setAdminAddress("noreply@nowhere")
{% endif %}

{% if jenkins_public_url is defined and jenkins_public_url %}
jenkinsLocationConfiguration.setUrl("{{ jenkins_public_url }}")
{% endif %}

jenkinsLocationConfiguration.save()

instance.save()
