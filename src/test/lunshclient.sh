#!/bin/bash
java client.Client

rmiregistry -J-Djava.security.policy=client1.policy &

java -Djava.security.policy=client.policy -Djava.rmi.server.codebase=http://localhost/rmi server.DynamicServer