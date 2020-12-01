import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Erzeugt das SPIEL Objekt und setzt Fenster Einstellungen.
 * Es ist die höchste Klasse in der Hierarchie
 *
 *
 */


public class MAIN {

    public static int x = 1368;
    public static int y = 768;

    public static int blackThreshold = 4;// für die Kolliderbildbearbeitung
    public static int whiteThreshold = 250;// für die Kolliderbildbearbeitung

    //GAMESAVE
    public static final String gameSaveFilePath = "./Assets/Files/GameSave.json";
    public static final String gameSaveTemplateFilePath = "./Assets/Files/GameSave-Template.json";

    //NPCS
    public static final String npcTemplatePath = "./Assets/Files/NPCs-Template.json";
    public static final String npcFilePath = "./Assets/Files/NPCs_NEW.json";
    public static final String npcPositionPath = "./Assets/Files/NPCs_Positions.json";

    //SOUNDS, MUSIC
    public static final String musicMainPath = "./Assets/Audio/";


    public static void main(String[] args){

        SPIEL spiel  = new SPIEL();







    }


}
