#vim:ts=4:sw=4:
compile:
	mvn compile

vm:
	native2ascii -encoding utf8 src/main/webapp/WEB-INF/classes/ValidationMessages_zh_CN src/main/webapp/WEB-INF/classes/ValidationMessages_zh_CN.properties

debug:
	MAVEN_OPTS="-Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000" mvn tomcat:run

all: $(vm) $(compile)

