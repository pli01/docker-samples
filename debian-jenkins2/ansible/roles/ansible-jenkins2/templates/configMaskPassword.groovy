import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;
import com.michelin.cio.hudson.plugins.*;

d = new com.michelin.cio.hudson.plugins.maskpasswords.MaskPasswordsConfig()
desc = d.getInstance()
config = d.load()                                            
desc.save(config)
