// These are the basic imports that Jenkin's interactive script console
// automatically includes.
// Don't edit : This file is generated !

import jenkins.model.*

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("hudson.tasks.Mailer")

// desc.setSmtpAuth("user", "userpass")
// desc.setReplyToAddress("dummy@jenkins.bla")
{% if jenkins.email.smtp_host is defined and jenkins.email.smtp_host %}
desc.setSmtpHost("{{ jenkins.email.smtp_host }}")
{% endif %}
desc.setUseSsl({{ jenkins.email.smtp_ssl | default('false')}})
desc.setSmtpPort("25")
desc.setCharset("UTF-8")

desc.save()
inst.save()
