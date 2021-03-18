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

		if(this.langue == "french") {
			return "Lancer";
		}

		if(this.langue == "english") {
			return "Start";
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

		return "Launch Game";
	}

	public String getLaunchGameVsString() {
		if(this.langue == "french") {
			return "Lancer un duel";
		}

		if(this.langue == "english") {
			return "Launch Game 1v1";
		}		

		return "Launch Game 1v1";
	}

	public String getShopString() {
		if(this.langue == "french") {
			return "Boutique";
		}

		if(this.langue == "english") {
			return "Shop";
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

		return "Settings";
	}


	public String getStatisticsString() {
		if(this.langue == "french") {
			return "Statistiques";
		}

		if(this.langue == "english") {
			return "Statistics";
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

		return "Saves";
	}

	public String getLeftGameString() {
		if(this.langue == "french") {
			return "Quitter le jeux";
		}

		if(this.langue == "english") {
			return "Left Game";
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

		return "Score";
	}

	public String getHightScoreString() {
		if(this.langue == "french") {
			return "Record";
		}

		if(this.langue == "english") {
			return "Hight Score";
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

		return "New Hight Score";
	}


	public String getFinalScoreString() {
		if(this.langue == "french") {
			return "Score final";
		}

		if(this.langue == "english") {
			return "Final score";
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

		return "Timer";
	}

	public String getPauseString() {
		if(this.langue == "french") {
			return "Pause";
		}

		if(this.langue == "english") {
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

		return "Resume";
	}


	public String getMainMenuString() {
		if(this.langue == "french") {
			return "Menu Principal";
		}

		if(this.langue == "english") {
			return "Main Menu";
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

		return "Restart";
	}

	public String getAbandonString() {
		if(this.langue == "french") {
			return "Abandonner";
		}

		if(this.langue == "english") {
			return "Abandon";
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

		return "Difficulty";
	}

	public String getModString() {
		if(this.langue == "french") {
			return "Mode";
		}

		if(this.langue == "english") {
			return "Mod";
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

		return "Language";
	}

	public String getSaveString() {
		if(this.langue == "french") {
			return "Enregistrer";
		}

		if(this.langue == "english") {
			return "Save";
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

		return "Cancel";
	}

	public String getResetString() {
		if(this.langue == "french") {
			return "Réinitialiser";
		}

		if(this.langue == "english") {
			return "Reset";
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

		return "Hard";
	}

	public String getNormalString() {
		if(this.langue == "french") {
			return "Normal";
		}

		if(this.langue == "english") {
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

		return "Solo";
	}

	public String getDualString() {
		if(this.langue == "french") {
			return "Duel";
		}

		if(this.langue == "english") {
			return "Dual";
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

		return "French";
	}

	public String getEnglishString() {
		if(this.langue == "french") {
			return "Anglais";
		}

		if(this.langue == "english") {
			return "English";
		}		

		return "english";
	}

}
