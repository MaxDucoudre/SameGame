
JFLAGS = -encoding UTF-8 -implicit:none -g
JC = javac

JVM = java
JVMFLAGS = 

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java \
	MenuFrame.java \
	TitleMenu.java \
	TitleMenuFrame.java \
	TitleMenuObs.java \
	MainMenu.java \
	MainMenuFrame.java \
	MainMenuObsOptions.java 

run : Main.class
	${JVM} ${JVMFLAGS} Main

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class