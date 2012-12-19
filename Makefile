#vim:ts=4:sw=4:
compile:
	mvn compile

vm:
	native2ascii -encoding utf8 src/main/webapp/WEB-INF/classes/ValidationMessages_zh_CN src/main/webapp/WEB-INF/classes/ValidationMessages_zh_CN.properties

all: $(vm) $(compile)

