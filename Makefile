

### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none -g 

JVM = java
JVMFLAGS =



### REGLES ESSENTIELLES ###
 
Main.class : Main.java TitleMenuFrame.class
	${JC} ${JCFLAGS} Main.java

MenuFrame.class : MenuFrame.java 
	${JC} ${JCFLAGS} MenuFrame.java


TitleMenuFrame.class : MenuFrame.class TitleMenuFrame.java TitleMenu.class TitleMenuObs.class 
	${JC} ${JCFLAGS} TitleMenuFrame.java

TitleMenu.class : TitleMenu.java
	${JC} ${JCFLAGS} TitleMenu.java

TitleMenuObs.class : TitleMenuObs.java TitleMenu.class MainMenuFrame.class
	${JC} ${JCFLAGS} TitleMenuObs.java


MainMenuFrame.class : MenuFrame.class MainMenuFrame.java MainMenu.class MainMenuObsSavemenu.class MainMenuObsLaunchgamevs.class MainMenuObsOptions.class MainMenuObsLaunchgame.class MainMenuObsLeftgame.class MainMenuObsBoutique.class MainMenuObsStatistique.class
	${JC} ${JCFLAGS} MainMenuFrame.java

MainMenu.class : MainMenu.java
	${JC} ${JCFLAGS} MainMenu.java

MainMenuObs.class : MainMenuObs.java MainMenuFrame.class
	${JC} ${JCFLAGS} MainMenuObs.java

MainMenuObsOptions.class : MainMenuObsOptions.java MainMenuFrame.class MainMenuObs.class
	${JC} ${JCFLAGS} MainMenuObsOptions.java

MainMenuObsLeftgame.class : MainMenuObsLeftgame.java MainMenuFrame.class MainMenuObs.class
	${JC} ${JCFLAGS} MainMenuObsLeftgame.java

MainMenuObsStatistique.class : MainMenuObsStatistique.java MainMenuFrame.class MainMenuObs.class
	${JC} ${JCFLAGS} MainMenuObsStatistique.java

MainMenuObsBoutique.class : MainMenuObsBoutique.java MainMenuFrame.class MainMenuObs.class
	${JC} ${JCFLAGS} MainMenuObsBoutique.java

MainMenuObsLaunchgame.class : MainMenuObsLaunchgame.java MainMenuFrame.class MainMenuObs.class Game.class GameFrame.class
	${JC} ${JCFLAGS} MainMenuObsLaunchgame.java

MainMenuObsLaunchgamevs.class : MainMenuObsLaunchgamevs.java MainMenuFrame.class MainMenuObs.class
	${JC} ${JCFLAGS} MainMenuObsLaunchgamevs.java

MainMenuObsSavemenu.class : MainMenuObsSavemenu.java MainMenuFrame.class MainMenuObs.class SaveMenuFrame.class
	${JC} ${JCFLAGS} MainMenuObsSavemenu.java


SaveMenuFrame.class : SaveMenuFrame.java MenuFrame.class
	${JC} ${JCFLAGS} SaveMenuFrame.java

Game.class : Game.java
	${JC} ${JCFLAGS} Game.java

GameFrame.class : GameFrame.java Game.class GameObs.class
	${JC} ${JCFLAGS} GameFrame.java

GameObs.class : GameObs.java Game.class GameFrame.class
	${JC} ${JCFLAGS} GameObs.java
	


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