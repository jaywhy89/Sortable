JCC = javac
BIN = ./bin/
SRC = ./src/*.java
LIB = ./lib/json-simple.jar
JFLAGS = -g -d $(BIN) -cp $(LIB)

COMPILE = $(JCC) $(JFLAGS)


# .java.class:
# 	$(COMPILE) $(SRC)

default: classes

classes: 
	$(COMPILE) $(SRC)

clean: 
	$(RM) $(BIN)*.*

run: 
	java -cp "./bin/:./lib/*" Sortable
