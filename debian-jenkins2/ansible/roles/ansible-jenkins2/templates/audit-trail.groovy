import jenkins.model.*;
import hudson.plugins.audit_trail.AuditTrailPlugin
import hudson.plugins.audit_trail.SyslogAuditLogger

def syslogServerHostname = "localhost"
def syslogServerPort     = 514
def appName              = System.properties.'MASTER_NAME'
def messageHostname      = ""
def facility             = "USER"
def messageFormat        =  "RFC_5424"

/*
public SyslogAuditLogger(String syslogServerHostname, int syslogServerPort,
                             String appName, String messageHostname,
                             String facility, String messageFormat) {

*/
SyslogAuditLogger syslogAuditLogger = new SyslogAuditLogger(syslogServerHostname, syslogServerPort, appName, messageHostname, facility, messageFormat)

Jenkins j = Jenkins.getInstance();

AuditTrailPlugin plugin = j.getPlugin(AuditTrailPlugin.class);
plugin.loggers.clear()
plugin.loggers.add(syslogAuditLogger)
plugin.save()
plugin.start()
