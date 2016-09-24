import jenkins.model.*

def instance = Jenkins.getInstance()

final String name = "{{ jenkins_proxy_host  |default ('')}}"
final int port = {{ jenkins_proxy_port |default ('') }}
final String userName = "{{ jenkins_proxy_user |default ('') }}"
final String password = "{{ jenkins_proxy_password |default ('') }}"
final String noProxyHost = "{{ jenkins_proxy_exceptions |default ('') }}"

final def pc = new hudson.ProxyConfiguration(name, port, userName, password)
instance.proxy = pc
instance.save()
println "Proxy settings updated!"
