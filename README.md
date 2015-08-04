# OIM Stuff 

1) Groovy script to retrieve the orchestration details for OIM 11.1.1.5 - 11.1.2.2
orch.sh - Linux script for getting the details of an orchestration
	Variables to be set: 
		OIM_HOME - location of the OIM_HOME, for example: /opt/11.1.2.2/Oracle_IDM1
		WLS_HOME - location of the WLS_HOME, for example: /opt/11.1.2.2/wlserver_10.3
	Based on these the classpath is set for the Groovy script

orch.cmd - Windows script for getting the details of an orchestration
	Variables to be set: 
		OIM_HOME - location of the OIM_HOME, for example: C:/Middleware/11.1.2.1/Oracle_IDM1
		WLS_HOME - location of the WLS_HOME, for example: C:/Middleware/11.1.2.1/wlserver_10.3
	Based on these the classpath is set for the Groovy script
	
orch.groovy - Groovy script that retrieves the orchestration details
	Variables to be set:
		DB_HOST = the DB host
		DB_PORT = the DB port
		DB_SID = the DB SID
		OIM_SCHEMA = the OIM schema
		OIM_PASSWORD = the OIM schema password
		ORCHID = the orchestration ID
