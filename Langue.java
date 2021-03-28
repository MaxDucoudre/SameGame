/**
* Classe <code>Langue</code>
* Cette classe permet de récupérer les chaînes de caractère de chaque label et de chaque bouton en fonction d'une langue séléctionnée
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/


public class Langue {

	// Attribut contenant la langue du jeux sous forme de String
	private String langue;


/**
* Constructeur de <b>Langue</b>
* @param langue correspond à la langue qu'on souahite appliquer
* langues possibles :
* "french" / "english" / "esperanto" / "german"
*/

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

		if(this.langue == "russian") {
			return "Запуск";
		}

		if(this.langue == "portuguese") {
			return "Lançar";
		}

		if(this.langue == "spanish") {
			return "Lanzamiento";
		}

		if(this.langue == "chinese") {
			return "發射";
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

		if(this.langue == "russian") {
			return "Начать игру";
		}

		if(this.langue == "portuguese") {
			return "Comece o jogo";
		}
		
		if(this.langue == "spanish") {
			return "Comienza el juego";
		}

		if(this.langue == "chinese") {
			return "開始遊戲";
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

		if(this.langue == "russian") {
			return "Запуск из файла";
		}

		if(this.langue == "portuguese") {
			return "Iniciar a partir do arquivo";
		}

		if(this.langue == "spanish") {
			return "Lanzar desde archivo";
		}

		if(this.langue == "chinese") {
			return "從文件啟動";
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

		if(this.langue == "russian") {
			return "Магазин";
		}

		if(this.langue == "portuguese") {
			return "Comprar";
		}

		if(this.langue == "spanish") {
			return "Tienda";
		}

		if(this.langue == "chinese") {
			return "店鋪";
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

		if(this.langue == "russian") {
			return "Опции";
		}

		if(this.langue == "portuguese") {
			return "Opções";
		}

		if(this.langue == "spanish") {
			return "Opciones";
		}

		if(this.langue == "chinese") {
			return "選項";
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

		if(this.langue == "russian") {
			return "Статистика";
		}

		if(this.langue == "portuguese") {
			return "Estatisticas";
		}

		if(this.langue == "spanish") {
			return "Estadísticas";
		}

		if(this.langue == "chinese") {
			return "統計數據";
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

		if(this.langue == "russian") {
			return "Резервные копии";
		}	

		if(this.langue == "portuguese") {
			return "Backups";
		}

		if(this.langue == "spanish") {
			return "Copias de seguridad";
		}

		if(this.langue == "chinese") {
			return "備份文件";
		}

		return "Saves";
	}

	public String getLeftGameString() {
		if(this.langue == "french") {
			return "Quitter le jeu";
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

		if(this.langue == "russian") {
			return "Выйти из игры";
		}	

		if(this.langue == "portuguese") {
			return "Saia do jogo";
		}	

		if(this.langue == "spanish") {
			return "Abandonar el juego";
		}

		if(this.langue == "chinese") {
			return "離開遊戲";
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

		if(this.langue == "russian") {
			return "Счет";
		}		

		if(this.langue == "portuguese") {
			return "Pontuação";
		}

		if(this.langue == "spanish") {
			return "Puntaje";
		}

		if(this.langue == "chinese") {
			return "分數";
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

		if(this.langue == "russian") {
			return "Записывать";
		}		

		if(this.langue == "portuguese") {
			return "Registro";
		}

		if(this.langue == "spanish") {
			return "Registro";
		}

		if(this.langue == "chinese") {
			return "記錄";
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

		if(this.langue == "russian") {
			return "Новый рекорд";
		}		

		if(this.langue == "portuguese") {
			return "Novo Registro";
		}		

		if(this.langue == "spanish") {
			return "Nuevo Registro";
		}

		if(this.langue == "chinese") {
			return "新紀錄";
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

		if(this.langue == "russian") {
			return "Финальный счет";
		}

		if(this.langue == "portuguese") {
			return "Pontuação final";
		}

		if(this.langue == "spanish") {
			return "Puntuación final";
		}

		if(this.langue == "chinese") {
			return "最終成績";
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

		if(this.langue == "russian") {
			return "Секундомер";
		}

		if(this.langue == "portuguese") {
			return "Cronômetro";
		}

		if(this.langue == "spanish") {
			return "Cronógrafo";
		}

		if(this.langue == "chinese") {
			return "跑表";
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

		if(this.langue == "russian") {
			return "Пауза";
		}

		if(this.langue == "portuguese") {
			return "Pausa";
		}

		if(this.langue == "spanish") {
			return "Pausa";
		}

		if(this.langue == "chinese") {
			return "暫停";
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
		if(this.langue == "russian") {
			return "Продолжить";
		}

		if(this.langue == "portuguese") {
			return "Retomar";
		}

		if(this.langue == "spanish") {
			return "Retomar";
		}

		if(this.langue == "chinese") {
			return "恢復";
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

		if(this.langue == "russian") {
			return "Главное меню";
		}

		if(this.langue == "portuguese") {
			return "Menu principal";
		}

		if(this.langue == "spanish") {
			return "Menú principal";
		}

		if(this.langue == "chinese") {
			return "主菜單";
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

		if(this.langue == "russian") {
			return "Возродить";
		}

		if(this.langue == "portuguese") {
			return "Reviver";
		}

		if(this.langue == "spanish") {
			return "Reanimar";
		}

		if(this.langue == "chinese") {
			return "復活";
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

		if(this.langue == "russian") {
			return "Отказаться";
		}

		if(this.langue == "portuguese") {
			return "Abandonar";
		}

		if(this.langue == "spanish") {
			return "Abandonar";
		}

		if(this.langue == "chinese") {
			return "放棄";
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

		if(this.langue == "russian") {
			return "Игра окончена";
		}

		if(this.langue == "portuguese") {
			return "Fim do jogo";
		}

		if(this.langue == "spanish") {
			return "Juego terminado";
		}

		if(this.langue == "chinese") {
			return "遊戲結束";
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

		if(this.langue == "russian") {
			return "Сложность";
		}

		if(this.langue == "portuguese") {
			return "Dificuldade";
		}

		if(this.langue == "spanish") {
			return "Dificultad";
		}

		if(this.langue == "chinese") {
			return "困難";
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

		if(this.langue == "russian") {
			return "Мода";
		}

		if(this.langue == "portuguese") {
			return "Moda";
		}

		if(this.langue == "spanish") {
			return "Moda";
		}

		if(this.langue == "chinese") {
			return "時尚";
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

		if(this.langue == "russian") {
			return "Язык";
		}

		if(this.langue == "portuguese") {
			return "Língua";
		}

		if(this.langue == "spanish") {
			return "Lengua";
		}

		if(this.langue == "chinese") {
			return "語言";
		}

		return "Language";
	}

	public String getSaveString() {
		if(this.langue == "french") {
			return "Sauvegardes";
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

		if(this.langue == "russian") {
			return "Резервные копии";
		}

		if(this.langue == "portuguese") {
			return "Backups";
		}

		if(this.langue == "spanish") {
			return "Copias de seguridad";
		}

		if(this.langue == "chinese") {
			return "備份文件";
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

		if(this.langue == "russian") {
			return "Отменить";
		}	

		if(this.langue == "portuguese") {
			return "Cancelar";
		}

		if(this.langue == "spanish") {
			return "Anular";
		}

		if(this.langue == "chinese") {
			return "取消";
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

		if(this.langue == "russian") {
			return "Перезагрузить";
		}	

		if(this.langue == "portuguese") {
			return "Redefinir";
		}

		if(this.langue == "spanish") {
			return "Reiniciar";
		}

		if(this.langue == "chinese") {
			return "重置";
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

		if(this.langue == "russian") {
			return "Трудно";
		}

		if(this.langue == "portuguese") {
			return "Difícil";
		}

		if(this.langue == "spanish") {
			return "Difícil";
		}

		if(this.langue == "chinese") {
			return "難的";
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

		if(this.langue == "russian") {
			return "Нормальный";
		}

		if(this.langue == "portuguese") {
			return "Normal";
		}

		if(this.langue == "spanish") {
			return "Normal";
		}

		if(this.langue == "chinese") {
			return "普通的";
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

		if(this.langue == "russian") {
			return "Один";
		}

		if(this.langue == "portuguese") {
			return "Sozinho";
		}

		if(this.langue == "spanish") {
			return "Sólo";
		}

		if(this.langue == "chinese") {
			return "獨自的";
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

		if(this.langue == "russian") {
			return "Дуэль";
		}

		if(this.langue == "portuguese") {
			return "Duelo";
		}

		if(this.langue == "spanish") {
			return "Duelo";
		}

		if(this.langue == "chinese") {
			return "決鬥";
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

		if(this.langue == "russian") {
			return "Французский";
		}

		if(this.langue == "portuguese") {
			return "Francês";
		}

		if(this.langue == "spanish") {
			return "Francés";
		}

		if(this.langue == "chinese") {
			return "法語";
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

		if(this.langue == "russian") {
			return "английский";
		}

		if(this.langue == "portuguese") {
			return "Inglês";
		}

		if(this.langue == "spanish") {
			return "Inglés";
		}

		if(this.langue == "chinese") {
			return "英語";
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

		if(this.langue == "russian") {
			return "эсперанто";
		}

		if(this.langue == "portuguese") {
			return "Esperanto";
		}

		if(this.langue == "spanish") {
			return "Esperanto";
		}

		if(this.langue == "chinese") {
			return "世界語";
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

		if(this.langue == "russian") {
			return "Немецкий";
		}

		if(this.langue == "portuguese") {
			return "Alemão";
		}

		if(this.langue == "spanish") {
			return "Alemán";
		}

		if(this.langue == "chinese") {
			return "德語";
		}

		return "german";
	}

	public String getRussianString() {
		if(this.langue == "french") {
			return "Russe";
		}

		if(this.langue == "english") {
			return "Russian";
		}	

		if(this.langue == "esperanto") {
			return "Rusa";
		}	

		if(this.langue == "german") {
			return "Russisch";
		}

		if(this.langue == "russian") {
			return "русский";
		}

		if(this.langue == "portuguese") {
			return "Russo";
		}

		if(this.langue == "spanish") {
			return "Ruso";
		}

		if(this.langue == "chinese") {
			return "俄語";
		}

		return "russian";
	}

	public String getPortugueseString() {
		if(this.langue == "french") {
			return "Portugais";
		}

		if(this.langue == "english") {
			return "Portuguese";
		}	

		if(this.langue == "esperanto") {
			return "Portugala";
		}	

		if(this.langue == "german") {
			return "Portugiesisch";
		}

		if(this.langue == "russian") {
			return "португальский";
		}

		if(this.langue == "portuguese") {
			return "Português";
		}

		if(this.langue == "spanish") {
			return "Portugués";
		}

		if(this.langue == "chinese") {
			return "葡萄牙語";
		}

		return "portuguese";
	}

	public String getSpanishString() {
		if(this.langue == "french") {
			return "Espagnol";
		}

		if(this.langue == "english") {
			return "Spanish";
		}	

		if(this.langue == "esperanto") {
			return "Hispana";
		}	

		if(this.langue == "german") {
			return "Spanisch";
		}

		if(this.langue == "russian") {
			return "испанский";
		}

		if(this.langue == "portuguese") {
			return "Espanhol";
		}

		if(this.langue == "spanish") {
			return "Español";
		}

		if(this.langue == "chinese") {
			return "西班牙語";
		}

		return "portuguese";
	}

	public String getChineseString() {
		if(this.langue == "french") {
			return "Chinois";
		}

		if(this.langue == "english") {
			return "Chinese";
		}	

		if(this.langue == "esperanto") {
			return "Ĉina";
		}	

		if(this.langue == "german") {
			return "Chinesisch";
		}

		if(this.langue == "russian") {
			return "Китайский";
		}

		if(this.langue == "portuguese") {
			return "Chinês";
		}

		if(this.langue == "spanish") {
			return "Chino";
		}

		if(this.langue == "chinese") {
			return "中國人";
		}

		return "chinese";
	}





// AUTRES
	public String getPlayedGameString() {
		if(this.langue == "french") {
			return "Parties jouées";
		}

		if(this.langue == "english") {
			return "Played Game";
		}	

		if(this.langue == "esperanto") {
			return "Ludoj ludis";
		}

		if(this.langue == "german") {
			return "Spiele gespielt";
		}

		if(this.langue == "russian") {
			return "Игр сыграно";
		}

		if(this.langue == "portuguese") {
			return "Jogos jogados";
		}

		if(this.langue == "spanish") {
			return "Juegos jugados";
		}

		if(this.langue == "chinese") {
			return "玩過的遊戲";
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

		if(this.langue == "esperanto") {
			return "Kreditoj";
		}

		if(this.langue == "german") {
			return "Credits";
		}

		if(this.langue == "russian") {
			return "Кредиты";
		}

		if(this.langue == "portuguese") {
			return "Créditos";
		}

		if(this.langue == "spanish") {
			return "Créditos";
		}

		if(this.langue == "chinese") {
			return "學分";
		}

		return "Credits";
	}

	public String getHightScoreNotCountedString() {
		if(this.langue == "french") {
			return "Record non comptabilisé";
		}

		if(this.langue == "english") {
			return "Hight score not counted";
		}	

		if(this.langue == "esperanto") {
			return "Rekordo ne kalkulita";
		}

		if(this.langue == "german") {
			return "Datensatz nicht gezählt";
		}

		if(this.langue == "russian") {
			return "Запись не засчитывается";
		}

		if(this.langue == "portuguese") {
			return "Registro não contado";
		}
		
		if(this.langue == "spanish") {
			return "Registro no contado";
		}

		if(this.langue == "chinese") {
			return "記錄不計";
		}

		return "Hight score not counted";
	}

	public String getOldHightScoreString() {
		if(this.langue == "french") {
			return "Ancien record";
		}

		if(this.langue == "english") {
			return "Old hight score";
		}	

		if(this.langue == "esperanto") {
			return "Malnova Rekordo";
		}

		if(this.langue == "german") {
			return "Alter Rekord";
		}

		if(this.langue == "russian") {
			return "Старая запись";
		}

		if(this.langue == "portuguese") {
			return "Registro antigo";
		}

		if(this.langue == "spanish") {
			return "Registro antiguo";
		}

		if(this.langue == "chinese") {
			return "舊唱片";
		}

		return "Old hight score";
	}

	public String getNewString() {
		if(this.langue == "french") {
			return "Nouveau";
		}

		if(this.langue == "english") {
			return "New";
		}	

		if(this.langue == "esperanto") {
			return "Nova";
		}

		if(this.langue == "german") {
			return "Neu";
		}

		if(this.langue == "russian") {
			return "Новый";
		}

		if(this.langue == "portuguese") {
			return "Novo";
		}

		if(this.langue == "spanish") {
			return "Nuevo";
		}

		if(this.langue == "chinese") {
			return "新的";
		}

		return "New";
	}

	public String getDeleteString() {
		if(this.langue == "french") {
			return "Supprimer";
		}

		if(this.langue == "english") {
			return "Delete";
		}	

		if(this.langue == "esperanto") {
			return "Forigi";
		}

		if(this.langue == "german") {
			return "Entfernen";
		}

		if(this.langue == "russian") {
			return "Удалять";
		}

		if(this.langue == "portuguese") {
			return "Retirar";
		}

		if(this.langue == "spanish") {
			return "Eliminar";
		}

		if(this.langue == "chinese") {
			return "消除";
		}

		return "Delete";
	}


	public String getSelectString() {
		if(this.langue == "french") {
			return "Sélectionner";
		}

		if(this.langue == "english") {
			return "Select";
		}	

		if(this.langue == "esperanto") {
			return "Por elekti";
		}

		if(this.langue == "german") {
			return "Zur Auswahl";
		}

		if(this.langue == "russian") {
			return "Выбирать";
		}

		if(this.langue == "portuguese") {
			return "Selecionar";
		}

		if(this.langue == "spanish") {
			return "Para seleccionar";
		}

		if(this.langue == "chinese") {
			return "選擇";
		}

		return "Select";
	}

	public String getSaveNameString() {
		if(this.langue == "french") {
			return "Nom de la sauvegarde";
		}

		if(this.langue == "english") {
			return "Save name";
		}	

		if(this.langue == "esperanto") {
			return "Rezerva nomo";
		}

		if(this.langue == "german") {
			return "Sicherungsname";
		}

		if(this.langue == "russian") {
			return "Имя резервной копии";
		}

		if(this.langue == "portuguese") {
			return "Nome de backup";
		}

		if(this.langue == "spanish") {
			return "Nombre de la copia de seguridad";
		}

		if(this.langue == "chinese") {
			return "備份名稱";
		}

		return "Save name";
	}

	public String getCreateString() {
		if(this.langue == "french") {
			return "Créer";
		}

		if(this.langue == "english") {
			return "Create";
		}	

		if(this.langue == "esperanto") {
			return "Kreu";
		}

		if(this.langue == "german") {
			return "Erstellen";
		}

		if(this.langue == "russian") {
			return "Создавать";
		}

		if(this.langue == "portuguese") {
			return "Crio";
		}

		if(this.langue == "spanish") {
			return "Crear";
		}

		if(this.langue == "chinese") {
			return "創建";
		}

		return "Create";
	}

	public String getEmptySlotString() {
		if(this.langue == "french") {
			return "Emplacement vide";
		}

		if(this.langue == "english") {
			return "Empty Slot";
		}	

		if(this.langue == "esperanto") {
			return "Malplena spaco";
		}

		if(this.langue == "german") {
			return "Freiraum";
		}

		if(this.langue == "russian") {
			return "Пустое место";
		}

		if(this.langue == "portuguese") {
			return "Espaço vazio";
		}

		if(this.langue == "spanish") {
			return "Espacio vacio";
		}

		if(this.langue == "chinese") {
			return "空的空間";
		}

		return "Empty Slot";
	}

	public String getAverageScoreString() {
		if(this.langue == "french") {
			return "Score moyen";
		}

		if(this.langue == "english") {
			return "Average score";
		}	

		if(this.langue == "esperanto") {
			return "Meza Poentaro";
		}

		if(this.langue == "german") {
			return "Durchschnittliche Punktzahl";
		}

		if(this.langue == "russian") {
			return "Средний счет";
		}

		if(this.langue == "portuguese") {
			return "Pontuação média";
		}

		if(this.langue == "spanish") {
			return "Puntuación media";
		}

		if(this.langue == "chinese") {
			return "平均分";
		}

		return "Average score";
	}

	public String getAPointsString() {
		if(this.langue == "french") {
			return "Points";
		}

		if(this.langue == "english") {
			return "Points";
		}	

		if(this.langue == "esperanto") {
			return "Punktoj";
		}

		if(this.langue == "german") {
			return "Punkte";
		}

		if(this.langue == "russian") {
			return "Точки";
		}

		if(this.langue == "portuguese") {
			return "Pontos";
		}

		if(this.langue == "spanish") {
			return "Puntos";
		}

		if(this.langue == "chinese") {
			return "點數";
		}

		return "Points";
	}

	public String getRegisterString() {
		if(this.langue == "french") {
			return "Enregistrer";
		}

		if(this.langue == "english") {
			return "Register";
		}	

		if(this.langue == "esperanto") {
			return "Rekordo";
		}

		if(this.langue == "german") {
			return "Aufzeichnung";
		}

		if(this.langue == "russian") {
			return "Записывать";
		}

		if(this.langue == "portuguese") {
			return "Registro";
		}

		if(this.langue == "spanish") {
			return "Registro";
		}

		if(this.langue == "chinese") {
			return "記錄";
		}

		return "Register";
	}

}
