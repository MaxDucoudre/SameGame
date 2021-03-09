
### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS =



### REGLES ESSENTIELLES ###
 
Main.class : Main.java TitleMenuFrame.class
	${JC} ${JCFLAGS} Main.java


MenuFrame.class : MenuFrame.java 
	${JC} ${JCFLAGS} MenuFrame.java


TitleMenuFrame.class : TitleMenuFrame.java TitleMenu.class TitleMenuObs.class MenuFrame.class
	${JC} ${JCFLAGS} TitleMenuFrame.java

TitleMenu.class : TitleMenu.java
	${JC} ${JCFLAGS} TitleMenu.java

TitleMenuObs.class : TitleMenuObs.java TitleMenu.class MainMenuFrame.class
	${JC} ${JCFLAGS} TitleMenuObs.java


MainMenuFrame.class : MainMenuFrame.java MainMenu.class MainMenuObsOptions.class MenuFrame.class 
	${JC} ${JCFLAGS} MainMenuFrame.java

MainMenu.class : MainMenu.java
	${JC} ${JCFLAGS} MainMenu.java

MainMenuObs.class : MainMenuObs.java
	${JC} ${JCFLAGS} MainMenuObs.java

MainMenuObsOptions.class : MainMenuObsOptions.java MainMenuFrame.class
	${JC} ${JCFLAGS} MainMenuObsOptions.java



### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###