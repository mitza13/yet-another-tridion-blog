@echo off

set classpath=;core-service-client-2011sp1hr1.jar

java -cp %classpath% mitza.coreservice.client.Test http://t2011sp1hr1.playground/ author tridion

pause