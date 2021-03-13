

### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none -g

JVM = java
JVMFLAGS =



### REGLES ESSENTIELLES ###
 
Main.class : Main.java TitleMenuFrame.class
	${JC} ${JCFLAGS} Main.java

MenuFrame.class : MenuFrame.java Langue.class
	${JC} ${JCFLAGS} MenuFrame.java


TitleMenuFrame.class : MenuFrame.class TitleMenuFrame.java TitleMenu.class TitleMenuObs.class 
	${JC} ${JCFLAGS} TitleMenuFrame.java

TitleMenu.class : TitleMenu.java
	${JC} ${JCFLAGS} TitleMenu.java

TitleMenuObs.class : TitleMenuObs.java TitleMenu.class MainMenuFrame.class
	${JC} ${JCFLAGS} TitleMenuObs.java


MainMenuFrame.class : MenuFrame.class MainMenuFrame.java MainMenu.class MainMenuObs.class GameFrame.class
	${JC} ${JCFLAGS} MainMenuFrame.java

MainMenu.class : MainMenu.java
	${JC} ${JCFLAGS} MainMenu.java

MainMenuObs.class : MainMenuObs.java MainMenuFrame.class
	${JC} ${JCFLAGS} MainMenuObs.java


SaveMenuFrame.class : SaveMenuFrame.java MenuFrame.class
	${JC} ${JCFLAGS} SaveMenuFrame.java

Game.class : Game.java Chrono.class
	${JC} ${JCFLAGS} Game.java

GameFrame.class : GameFrame.java Game.class GameObs.class
	${JC} ${JCFLAGS} GameFrame.java

GameObs.class : GameObs.java Game.class GameFrame.class MainMenuFrame.class
	${JC} ${JCFLAGS} GameObs.java


Chrono.class : Chrono.java ChronoThread.class
	${JC} ${JCFLAGS} Chrono.java

ChronoThread.class : ChronoThread.java GameFrame.class
	${JC} ${JCFLAGS} ChronoThread.java

Langue.class : Langue.java
	${JC} ${JCFLAGS} Langue.java

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class
	-rm -f */*.class


mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###