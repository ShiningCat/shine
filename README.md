A new spring boot + spring cloud project
--
# shine

Modify the hosts file, add  127.0.0.1    discovery
SQL file in Project root directory


CD /shine-common   mvn install
CD /shine-cm       mvn install

First run shine-server
CD /shine-server   mvn package
CD /target         java -jar shine-server-1.0-SNAPSHOT.jar

CD /service-forum  mvn package
CD /target         java -jar service-forum-1.0-SNAPSHOT.jar
......
......
shine-web          mvn package
CD /target         java -jar shine-web-1.0-SNAPSHOT.jar