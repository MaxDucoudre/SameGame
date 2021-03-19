/**
* Classe Langue
* Cette classe permet de définir les chaînes de caractère de chaque label et de chaque bouton en fonction d'une langue séléctionnée
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/


public class Langue {

	private String langue;

	public Langue(String langue0) {
		this.langue = langue0;
	}


/*
Pour rajouter une langue, rajouter


	if(this.langue == "<langue>") {
		return "<traduction>";
	}	

dans les différentes méthodes
*/



	// TEXTES DU MENU TITRE
	public String getStartString() {

		if(this.langue == "french") {
			return "Lancer";
		}

		if(this.langue == "english") {
			return "Start";
		}	

		if(this.langue == "esperanto") {
			return "Lanĉi";
		}

		if(this.langue == "german") {
			return "Starten";
		}


		return "Start";
	}


	// TEXTES DU MENU PRINCIPAL
	public String getLaunchGameString() {
		if(this.langue == "french") {
			return "Lancer la partie";
		}

		if(this.langue == "english") {
			return "Launch Game";
		}

		if(this.langue == "esperanto") {
			return "Komencu la ludon";
		}

		if(this.langue == "german") {
			return "Starte das spiel";
		}

		return "Launch Game";
	}

	public String getLaunchFromFileString() {
		if(this.langue == "french") {
			return "Lancer depuis un fichier";
		}

		if(this.langue == "english") {
			return "Launch Game from file";
		}	

		if(this.langue == "esperanto") {
			return "Lanĉo de dosiero";
		}	

		if(this.langue == "german") {
			return "Aus Datei starten";
		}

		return "Launch Game from file";
	}

	public String getShopString() {
		if(this.langue == "french") {
			return "Boutique";
		}

		if(this.langue == "english") {
			return "Shop";
		}	

		if(this.langue == "esperanto") {
			return "Butiko";
		}	

		if(this.langue == "german") {
			return "Geschäft";
		}

		return "Shop";
	}

	public String getSettingsString() {
		if(this.langue == "french") {
			return "Options";
		}

		if(this.langue == "english") {
			return "Settings";
		}	

		if(this.langue == "esperanto") {
			return "Ebloj";
		}	

		if(this.langue == "german") {
			return "Optionen";
		}

		return "Settings";
	}


	public String getStatisticsString() {
		if(this.langue == "french") {
			return "Statistiques";
		}

		if(this.langue == "english") {
			return "Statistics";
		}	

		if(this.langue == "esperanto") {
			return "Statistikoj";
		}	

		if(this.langue == "german") {
			return "Statistiken";
		}	

		return "Statistics";
	}

	public String getSavesString() {
		if(this.langue == "french") {
			return "Sauvegardes";
		}

		if(this.langue == "english") {
			return "Saves";
		}	

		if(this.langue == "esperanto") {
			return "Sekurkopioj";
		}	

		if(this.langue == "german") {
			return "Backups";
		}		

		return "Saves";
	}

	public String getLeftGameString() {
		if(this.langue == "french") {
			return "Quitter le jeux";
		}

		if(this.langue == "english") {
			return "Left Game";
		}	

		if(this.langue == "esperanto") {
			return "Forlasu la ludon";
		}

		if(this.langue == "german") {
			return "Das Spiel verlassen";
		}			

		return "Left Game";
	}

	// TEXTES DU JEUX
	public String getScoreString() {
		if(this.langue == "french") {
			return "Score";
		}

		if(this.langue == "english") {
			return "Score";
		}	

		if(this.langue == "esperanto") {
			return "Poentaro";
		}	

		if(this.langue == "german") {
			return "Ergebnis";
		}		

		return "Score";
	}

	public String getHightScoreString() {
		if(this.langue == "french") {
			return "Record";
		}

		if(this.langue == "english") {
			return "Hight Score";
		}	

		if(this.langue == "esperanto") {
			return "Rekordo";
		}	

		if(this.langue == "german") {
			return "Aufzeichnung";
		}		

		return "Hight Score";
	}

	public String getNewHightScoreString() {
		if(this.langue == "french") {
			return "Nouveau Record";
		}

		if(this.langue == "english") {
			return "New Hight Score";
		}	

		if(this.langue == "esperanto") {
			return "Nova Rekordo";
		}	

		if(this.langue == "german") {
			return "Neuer Aufzeichnung";
		}				

		return "New Hight Score";
	}


	public String getFinalScoreString() {
		if(this.langue == "french") {
			return "Score final";
		}

		if(this.langue == "english") {
			return "Final score";
		}	

		if(this.langue == "esperanto") {
			return "Fina Poentaro";
		}	

		if(this.langue == "german") {
			return "Endergebnis";
		}	

		return "Final score";
	}

	public String getTimeString() {
		if(this.langue == "french") {
			return "Chrono";
		}

		if(this.langue == "english") {
			return "Timer";
		}	

		if(this.langue == "esperanto") {
			return "Kronometro";
		}	

		if(this.langue == "german") {
			return "Stoppuhr";
		}

		return "Timer";
	}

	public String getPauseString() {
		if(this.langue == "french") {
			return "Pause";
		}

		if(this.langue == "english") {
			return "Pause";
		}	

		if(this.langue == "esperanto") {
			return "Paŭzo";
		}	

		if(this.langue == "german") {
			return "Pause";
		}

		return "Pause";
	}

	public String getResumeString() {
		if(this.langue == "french") {
			return "Reprendre";
		}

		if(this.langue == "english") {
			return "Resume";
		}	

		if(this.langue == "esperanto") {
			return "Rekomenci";
		}	

		if(this.langue == "german") {
			return "Weitermachen";
		}

		return "Resume";
	}


	public String getMainMenuString() {
		if(this.langue == "french") {
			return "Menu Principal";
		}

		if(this.langue == "english") {
			return "Main Menu";
		}		

		if(this.langue == "esperanto") {
			return "Ĉefa Menuo";
		}	

		if(this.langue == "german") {
			return "Hauptmenü";
		}

		return "Main Menu";
	}

	public String getRestartString() {
		if(this.langue == "french") {
			return "Relancer";
		}

		if(this.langue == "english") {
			return "Restart";
		}

		if(this.langue == "esperanto") {
			return "Revivigi";
		}	

		if(this.langue == "german") {
			return "Beleben";
		}	

		return "Restart";
	}

	public String getAbandonString() {
		if(this.langue == "french") {
			return "Abandonner";
		}

		if(this.langue == "english") {
			return "Abandon";
		}	

		if(this.langue == "esperanto") {
			return "Forlasi";
		}	

		if(this.langue == "german") {
			return "Aufgeben";
		}		

		return "Abandon";
	}

	public String getEndString() {
		if(this.langue == "french") {
			return "Fin de la partie";
		}

		if(this.langue == "english") {
			return "End of the game";
		}	

		if(this.langue == "esperanto") {
			return "Ludo Finiĝis";
		}	

		if(this.langue == "german") {
			return "Spiel ist aus";
		}

		return "End of the game";
	}


	// MENU DES OPTIONS
	public String getDifficultyString() {
		if(this.langue == "french") {
			return "Difficulté";
		}

		if(this.langue == "english") {
			return "Difficulty";
		}	

		if(this.langue == "esperanto") {
			return "Malfacilaĵoj";
		}	

		if(this.langue == "german") {
			return "Schwierigkeit";
		}

		return "Difficulty";
	}

	public String getModString() {
		if(this.langue == "french") {
			return "Mode";
		}

		if(this.langue == "english") {
			return "Mod";
		}	

		if(this.langue == "esperanto") {
			return "Modo";
		}		

		if(this.langue == "german") {
			return "Mode";
		}

		return "Mod";
	}

	public String getLanguageString() {
		if(this.langue == "french") {
			return "Langue";
		}

		if(this.langue == "english") {
			return "Language";
		}	

		if(this.langue == "esperanto") {
			return "Lingvo";
		}	

		if(this.langue == "german") {
			return "Sprache";
		}	

		return "Language";
	}

	public String getSaveString() {
		if(this.langue == "french") {
			return "Enregistrer";
		}

		if(this.langue == "english") {
			return "Save";
		}	

		if(this.langue == "esperanto") {
			return "Savi";
		}	

		if(this.langue == "german") {
			return "Aufzeichnung";
		}	

		return "Save";
	}

	public String getCancelString() {
		if(this.langue == "french") {
			return "Annuler";
		}

		if(this.langue == "english") {
			return "Cancel";
		}

		if(this.langue == "esperanto") {
			return "Nuligi";
		}	

		if(this.langue == "german") {
			return "Abbrechen";
		}		

		return "Cancel";
	}

	public String getResetString() {
		if(this.langue == "french") {
			return "Réinitialiser";
		}

		if(this.langue == "english") {
			return "Reset";
		}	

		if(this.langue == "esperanto") {
			return "Restarigi";
		}	

		if(this.langue == "german") {
			return "Zurücksetzen";
		}

		return "Reset";
	}

	public String getHardString() {
		if(this.langue == "french") {
			return "Difficile";
		}

		if(this.langue == "english") {
			return "Hard";
		}		

		if(this.langue == "esperanto") {
			return "Malfacila";
		}	

		if(this.langue == "german") {
			return "Schwer";
		}

		return "Hard";
	}

	public String getNormalString() {
		if(this.langue == "french") {
			return "Normal";
		}

		if(this.langue == "english") {
			return "Normal";
		}	

		if(this.langue == "esperanto") {
			return "Normala";
		}	

		if(this.langue == "german") {
			return "Normal";
		}

		return "Normal";
	}

	public String getSoloString() {
		if(this.langue == "french") {
			return "Seul";
		}

		if(this.langue == "english") {
			return "Solo";
		}		

		if(this.langue == "esperanto") {
			return "Sola";
		}

		if(this.langue == "german") {
			return "Allein";
		}

		return "Solo";
	}

	public String getDualString() {
		if(this.langue == "french") {
			return "Duel";
		}

		if(this.langue == "english") {
			return "Dual";
		}		

		if(this.langue == "esperanto") {
			return "Duelo";
		}

		if(this.langue == "german") {
			return "Duell";
		}

		return "Dual";
	}

	public String getFrenchString() {
		if(this.langue == "french") {
			return "Français";
		}

		if(this.langue == "english") {
			return "French";
		}

		if(this.langue == "esperanto") {
			return "Francoj";
		}

		if(this.langue == "german") {
			return "Französisch";
		}

		return "French";
	}

	public String getEnglishString() {
		if(this.langue == "french") {
			return "Anglais";
		}

		if(this.langue == "english") {
			return "English";
		}	

		if(this.langue == "esperanto") {
			return "Angla";
		}	

		if(this.langue == "german") {
			return "Englisch";
		}

		return "english";
	}

	public String getEsperantoString() {
		if(this.langue == "french") {
			return "Esperanto";
		}

		if(this.langue == "english") {
			return "Esperanto";
		}	

		if(this.langue == "esperanto") {
			return "Esperanto";
		}	

		if(this.langue == "german") {
			return "Esperanto";
		}

		return "esperanto";
	}

	public String getGermanString() {
		if(this.langue == "french") {
			return "Allemand";
		}

		if(this.langue == "english") {
			return "German";
		}	

		if(this.langue == "esperanto") {
			return "Germana";
		}	

		if(this.langue == "german") {
			return "Deutsche";
		}

		return "german";
	}




// Autres
	public String getPlayedGameString() {
		if(this.langue == "french") {
			return "Parties jouées";
		}

		if(this.langue == "english") {
			return "Played Game";
		}	

		return "Played Game";
	}

	public String getCreditsString() {
		if(this.langue == "french") {
			return "Crédits";
		}

		if(this.langue == "english") {
			return "Credits";
		}	

		return "Credits";
	}

}
