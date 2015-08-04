@echo off
set OIM_HOME=c:/Middleware/11.1.2.1/Oracle_IDM1
set WLS_HOME=c:/Middleware/11.1.2.1/wlserver_10.3
set ORCH_CLASSPATH=%OIM_HOME%/server/apps/oim.ear/APP-INF/lib/groovy-all.jar;%OIM_HOME%/server/client/oimclient.jar;%OIM_HOME%/server/apps/oim.ear/APP-INF/lib/iam-platform-workflowservice.jar;%WLS_HOME%/server/lib/ojdbc6.jar
java -classpath %ORCH_CLASSPATH% groovy.lang.GroovyShell orch.groovy
