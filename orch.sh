OIM_HOME=/opt/11.1.2.2/Oracle_IDM1
WLS_HOME=/opt/11.1.2.2/wlserver_10.3
ORCH_CLASSPATH=$OIM_HOME/server/apps/oim.ear/APP-INF/lib/groovy-all.jar:$OIM_HOME/server/client/oimclient.jar:$OIM_HOME/server/apps/oim.ear/APP-INF/lib/iam-platform-workflowservice.jar:$WLS_HOME/server/lib/ojdbc6.jar
java -classpath $ORCH_CLASSPATH groovy.lang.GroovyShell orch.groovy
