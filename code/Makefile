Main: Main.class Command.class Referee.class Game.class Scheduler.class \
  Time.class Day.class

Main.class: Main.java
	javac Main.java

Command.class: Referee.class Command.java
	javac Command.java

Referee.class: Referee.java
	javac Referee.java

RefereeList.class: Referee.class Referee.java
	javac Referee.java

Availability.class: Referee.class Referee.java
	javac Referee.java

Scheduler.class: Scheduler.java
	javac Scheduler.java

Game.class: Game.java
	javac Game.java

Time.class: Time.java
	javac Time.java

Day.class: Day.java
	javac Day.java

Shift.class: Day.class Day.java
	javac Day.java

Schedule.class: Day.class Day.java
	javac Day.java


all:
	javac *.java

docs:
	javadoc -d ../docs -private *.java

classes: $(CLASSES:.java=.class)

run:
	java Main

clean:
	$(RM) *.class
