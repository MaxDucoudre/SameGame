/**
* Classe Langue
* Cette classe permet de définir des chaîne de caractère de chaque label et de chaque bouton en fonction d'une langue séléctionnée
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

	// TEXTES DU MENU TITRE
	public String getStartString() {

		if(this.langue == "French") {
			return "Lancer";
		}

		if(this.langue == "English") {
			return "Start";
		}		

		return "Start";
	}


	// TEXTES DU MENU PRINCIPAL
	public String getLaunchGameString() {
		if(this.langue == "French") {
			return "Lancer la partie";
		}

		if(this.langue == "English") {
			return "Launch Game";
		}		

		return "Launch Game";
	}

	public String getLaunchGameVsString() {
		if(this.langue == "French") {
			return "Lancer un duel";
		}

		if(this.langue == "English") {
			return "Launch Game 1v1";
		}		

		return "Launch Game 1v1";
	}

	public String getShopString() {
		if(this.langue == "French") {
			return "Boutique";
		}

		if(this.langue == "English") {
			return "Shop";
		}		

		return "Shop";
	}

	public String getSettingsString() {
		if(this.langue == "French") {
			return "Options";
		}

		if(this.langue == "English") {
			return "Settings";
		}		

		return "Settings";
	}


	public String getStatisticsString() {
		if(this.langue == "French") {
			return "Statistiques";
		}

		if(this.langue == "English") {
			return "Statistics";
		}		

		return "Statistics";
	}

	public String getSavesString() {
		if(this.langue == "French") {
			return "Sauvegardes";
		}

		if(this.langue == "English") {
			return "Saves";
		}		

		return "Saves";
	}

	public String getLeftGameString() {
		if(this.langue == "French") {
			return "Quitter le jeux";
		}

		if(this.langue == "English") {
			return "Left Game";
		}		

		return "Left Game";
	}

	// TEXTES DU JEUX
	public String getScoreString() {
		if(this.langue == "French") {
			return "Score";
		}

		if(this.langue == "English") {
			return "Score";
		}		

		return "Score";
	}

	public String getHightScoreString() {
		if(this.langue == "French") {
			return "Record";
		}

		if(this.langue == "English") {
			return "Hight Score";
		}		

		return "Hight Score";
	}

	public String getNewHightScoreString() {
		if(this.langue == "French") {
			return "Nouveau Record";
		}

		if(this.langue == "English") {
			return "New Hight Score";
		}		

		return "New Hight Score";
	}


	public String getFinalScoreString() {
		if(this.langue == "French") {
			return "Score final";
		}

		if(this.langue == "English") {
			return "Final score";
		}		

		return "Final score";
	}

	public String getTimeString() {
		if(this.langue == "French") {
			return "Chrono";
		}

		if(this.langue == "English") {
			return "Timer";
		}		

		return "Timer";
	}

	public String getPauseString() {
		if(this.langue == "French") {
			return "Pause";
		}

		if(this.langue == "English") {
			return "Pause";
		}		

		return "Pause";
	}

	public String getResumeString() {
		if(this.langue == "French") {
			return "Reprendre";
		}

		if(this.langue == "English") {
			return "Resume";
		}		

		return "Resume";
	}


	public String getMainMenuString() {
		if(this.langue == "French") {
			return "Menu Principal";
		}

		if(this.langue == "English") {
			return "Main Menu";
		}		

		return "Main Menu";
	}

	public String getRestartString() {
		if(this.langue == "French") {
			return "Relancer";
		}

		if(this.langue == "English") {
			return "Restart";
		}		

		return "Restart";
	}

	public String getAbandonString() {
		if(this.langue == "French") {
			return "Abandonner";
		}

		if(this.langue == "English") {
			return "Abandon";
		}		

		return "Abandon";
	}

	public String getEndString() {
		if(this.langue == "French") {
			return "Fin de la partie";
		}

		if(this.langue == "English") {
			return "End of the game";
		}		

		return "End of the game";
	}


	// MENU DES OPTIONS
	public String getDifficultyString() {
		if(this.langue == "French") {
			return "Difficulté";
		}

		if(this.langue == "English") {
			return "Difficulty";
		}		

		return "Difficulty";
	}

	public String getModString() {
		if(this.langue == "French") {
			return "Mode";
		}

		if(this.langue == "English") {
			return "Mod";
		}		

		return "Mod";
	}

	public String getLanguageString() {
		if(this.langue == "French") {
			return "Langue";
		}

		if(this.langue == "English") {
			return "Language";
		}		

		return "Language";
	}

	public String getSaveString() {
		if(this.langue == "French") {
			return "Enregistrer";
		}

		if(this.langue == "English") {
			return "Save";
		}		

		return "Save";
	}

	public String getCancelString() {
		if(this.langue == "French") {
			return "Annuler";
		}

		if(this.langue == "English") {
			return "Cancel";
		}		

		return "Cancel";
	}

	public String getResetString() {
		if(this.langue == "French") {
			return "Réinitialiser";
		}

		if(this.langue == "English") {
			return "Reset";
		}		

		return "Reset";
	}

	public String getHardString() {
		if(this.langue == "French") {
			return "Difficile";
		}

		if(this.langue == "English") {
			return "Hard";
		}		

		return "Hard";
	}

	public String getNormalString() {
		if(this.langue == "French") {
			return "Normal";
		}

		if(this.langue == "English") {
			return "Normal";
		}		

		return "Normal";
	}

	public String getSoloString() {
		if(this.langue == "French") {
			return "Seul";
		}

		if(this.langue == "English") {
			return "Solo";
		}		

		return "Solo";
	}

	public String getDualString() {
		if(this.langue == "French") {
			return "Duel";
		}

		if(this.langue == "English") {
			return "Dual";
		}		

		return "Dual";
	}

	public String getFrenchString() {
		if(this.langue == "French") {
			return "Français";
		}

		if(this.langue == "English") {
			return "French";
		}		

		return "French";
	}

	public String getEnglishString() {
		if(this.langue == "French") {
			return "Anglais";
		}

		if(this.langue == "English") {
			return "English";
		}		

		return "English";
	}

}
