JAVA = java
EXEC = Main

JAVAC = javac
FLAGS = -Xlint -Werror -Xdiags:verbose -d class
SRC   = $(wildcard *.java)

FIND = find
DIREC = .
F_FLAGS = -type f -not \( -name "*.java" -or -name "Makefile" \)
F_COMMAND = -delete

all:
	$(JAVAC) $(FLAGS) $(SRC)

exec: all
	@cd class; \
	$(JAVA) $(EXEC)

clean:
	$(FIND) $(DIREC) $(F_FLAGS) $(F_COMMAND)
