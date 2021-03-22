

### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none -Xlint:unchecked

JVM = java
JVMFLAGS =



### REGLES ESSENTIELLES ###
 
Main.class : Main.java TitleMenuFrame.class
	${JC} ${JCFLAGS} Main.java

MenuFrame.class : MenuFrame.java Langue.class Options.class
	${JC} ${JCFLAGS} MenuFrame.java

BackgroundImagePanel.class : BackgroundImagePanel.java
	${JC} ${JCFLAGS} BackgroundImagePanel.java

Langue.class : Langue.java
	${JC} ${JCFLAGS} Langue.java


## MENU TITRE ##
TitleMenuFrame.class : TitleMenuFrame.java MenuFrame.class BackgroundImagePanel.class TitleMenuObs.class 
	${JC} ${JCFLAGS} TitleMenuFrame.java

TitleMenuObs.class : TitleMenuObs.java TitleMenuFrame.class SaveMenuFrame.class
	${JC} ${JCFLAGS} TitleMenuObs.java

## MENU PRINCIPAL ##
MainMenuFrame.class : MainMenuFrame.java MenuFrame.class BackgroundImagePanel.class MainMenu.class MainMenuObs.class
	${JC} ${JCFLAGS} MainMenuFrame.java

MainMenu.class : MainMenu.java
	${JC} ${JCFLAGS} MainMenu.java

MainMenuObs.class : MainMenuObs.java MainMenuFrame.class GameFrame.class OptionsFrame.class StatisticsMenuFrame.class SaveMenuFrame.class ShopFrame.class
	${JC} ${JCFLAGS} MainMenuObs.java

## MENU OPTIONS ##
OptionsFrame.class : OptionsFrame.java BackgroundImagePanel.class Options.class OptionsObs.class 
	${JC} ${JCFLAGS} OptionsFrame.java

OptionsObs.class : OptionsObs.java OptionsFrame.class Credits.class MainMenuFrame.class
	${JC} ${JCFLAGS} OptionsObs.java

Options.class : Options.java 
	${JC} ${JCFLAGS} Options.java

## MENU STATISTIQUES ##
StatisticsMenuFrame.class : StatisticsMenuFrame.java StatisticsObs.class BackgroundImagePanel.class Statistics.class Game.class
	${JC} ${JCFLAGS} StatisticsMenuFrame.java

Statistics.class : Statistics.java Save.class Game.class
	${JC} ${JCFLAGS} Statistics.java

StatisticsObs.class : StatisticsObs.java StatisticsMenuFrame.class MainMenuFrame.class
	${JC} ${JCFLAGS} StatisticsObs.java

## MENU CREDITS ##
Credits.class : Credits.java MenuFrame.java CreditsObs.class
	${JC} ${JCFLAGS} Credits.java

CreditsObs.class : CreditsObs.java Credits.java MainMenuFrame.class
	${JC} ${JCFLAGS} CreditsObs.java


## SAUVEGARDES ##

SaveMenuFrame.class : SaveMenuFrame.java BackgroundImagePanel.class MenuFrame.class Save.class SaveMenuObs.class Coins.class
	${JC} ${JCFLAGS} SaveMenuFrame.java

Save.class : Save.java
	${JC} ${JCFLAGS} Save.java

SaveMenuObs.class : SaveMenuObs.java SaveMenuFrame.class MainMenuFrame.class 
	${JC} ${JCFLAGS} SaveMenuObs.java

## BOUTIQUE ##

ShopFrame.class : ShopFrame.java MenuFrame.class Shop.class ShopObs.class Save.class Coins.class
	${JC} ${JCFLAGS} ShopFrame.java

Shop.class : Shop.java Coins.class
	${JC} ${JCFLAGS} Shop.java

ShopObs.class : ShopObs.java MainMenuFrame.class ShopFrame.class Save.class Coins.class Shop.class
	${JC} ${JCFLAGS} ShopObs.java


## COINS ###
Coins.class : Coins.java
	${JC} ${JCFLAGS} Coins.java

## LE JEUX ##
Game.class : Game.java Chrono.class Coins.class Save.class
	${JC} ${JCFLAGS} Game.java

GameFrame.class : GameFrame.java Game.class GameObs.class BackgroundImagePanel.class
	${JC} ${JCFLAGS} GameFrame.java

GameObs.class : GameObs.java Game.class GameFrame.class MainMenuFrame.class
	${JC} ${JCFLAGS} GameObs.java


Chrono.class : Chrono.java ChronoThread.class
	${JC} ${JCFLAGS} Chrono.java

ChronoThread.class : ChronoThread.java GameFrame.class
	${JC} ${JCFLAGS} ChronoThread.java




### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###