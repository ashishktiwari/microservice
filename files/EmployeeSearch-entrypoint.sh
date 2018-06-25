#!/bin/sh
while ! nc -z config-server 9090 ; do
    echo "Waiting for the Config Server"
    sleep 3
done
while ! nc -z eureka-server 9091 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
/usr/bin/java -jar /opt/lib/EmployeeSearch-0.0.1-SNAPSHOT.jar