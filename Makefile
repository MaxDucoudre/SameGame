### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java TitleMenuFrame.class
	${JC} ${JCFLAGS} Main.java

TitleMenuFrame.class : TitleMenuFrame.java TitleMenuObs.class TitleMenu.class
	${JC} ${JCFLAGS} TitleMenuFrame.java

TitleMenu.class : TitleMenu.java
	${JC} ${JCFLAGS} TitleMenu.java

TitleMenuObs.class : TitleMenuObs.java TitleMenu.class
	${JC} ${JCFLAGS} TitleMenuObs.java

	


### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###