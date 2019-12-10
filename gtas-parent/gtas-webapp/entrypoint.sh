#!/bin/bash

VERSION_NUMBER=1.0.0
BUILD_NUMBER=SNAPSHOT


cp /root/.m2/repository/gov/gtas/gtas-webapp/1.0.0-BUILD-SNAPSHOT/gtas-webapp-1.0.0-BUILD-SNAPSHOT.war /usr/local/tomcat/webapps/gtas.war

mkdir /usr/local/tomcat/webapps/gtas

cd /usr/local/tomcat/webapps/gtas && jar -xvf /usr/local/tomcat/webapps/gtas.war

rm -f /usr/local/tomcat/webapps/gtas/resources/bower_components && cp -R /usr/local/tomcat/webapps/gtas/resources/node_modules/@bower_components /usr/local/tomcat/webapps/gtas/resources/bower_components

/usr/local/tomcat/bin/catalina.sh run