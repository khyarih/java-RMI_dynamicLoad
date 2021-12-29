#!/bin/bash
echo "start executing ..."
#path=`pwd`
#echo $path
#
#if ["$path" = "*/src"]; then
#  folders = `ls`
#else
#  echo "You should be in the project src directory"
#fi
#process = `sudo lsof -t -i:1099`

#exucute .java
#rm java.client/*.class
#rm server/*.class
#
#javac java.client/*.java
#javac server/*.java
#
#rmic -v1.2 server.ServerLogic

#javac -d /var/www/html/rmi/java.client/ -classpath . java.client/ReverseClient.java
javac -d /var/www/html/rmi/client client/ReverseClient.java