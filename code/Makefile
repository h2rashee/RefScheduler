Main: Main.class Command.class Referee.class Game.class Scheduler.class

Main.class: Main.java
	javac Main.java

Command.class: Command.java Referee.class
	javac Command.java

Referee.class: Referee.java
	javac Referee.java

Scheduler.class: Scheduler.java
	javac Scheduler.java

Game.class: Game.java
	javac Game.java

all:
	javac *.java

docs:
	javadoc -d ../docs -private *.java

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
