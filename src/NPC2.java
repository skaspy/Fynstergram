import com.google.gson.*;
import com.google.gson.annotations.Expose;
import ea.Bild;
import ea.Knoten;

import java.lang.reflect.Type;

public class NPC2 extends Knoten {

    @Expose
    public String name;
    //@Expose
    private Bild img;


    private final String highlighterPath = "./Assets/NPCs/highLight.png";
    private final Bild highLightImg;
    private boolean highlightState = true;

    @Expose
    private float posX;
    @Expose
    private float posY;
    @Expose
    private float relativPosX;
    @Expose
    private float relativPosY;
    @Expose
    private int houseNumber;

    @Expose
    public String lastLine; //letzte DialogZeile

    public NPC2(int pX, int pY, int rX, int rY, int hN, String n, String mlastLine){
        this.posX=pX;
        this.posY=pY;
        this.relativPosX = rX;
        this.relativPosY = rY;
        this.name = n;
        this.houseNumber = hN;
        this.lastLine = mlastLine;




        try{
            String path = "./Assets/NPCs/" + name + ".png";
            img = new Bild(pX,pY,path);
            this.add(img);
        }
        catch(Exception e){
            System.out.println("NPC2: Fehler beim importieren der Datei");
            System.out.println("NPC2: " + e);
            e.printStackTrace();
        }
        highLightImg = new Bild(posX-5, posY-5, highlighterPath);
        this.add(highLightImg);
        highLightImg.sichtbarSetzen(highlightState);

    }

    public void setLastLine(String code){
        this.lastLine = code;
    }
    @Override
    public void verschieben(float dX, float dY) {
        posX=posX +dX;
        posY=posY +dY;
        super.verschieben(dX, dY);

    }

    @Override
    public void positionSetzen(float x, float y) {
        posX = x;
        posY = y;
        super.positionSetzen(x, y);
    }
    public void setRelativPos(int x, int y){
        relativPosX = x;
        relativPosY = y;
    }

    public float getRelativPosX() {
        return relativPosX;
    }

    public float getRelativPosY() {
        return relativPosY;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public float getPosY() {
        return posY;
    }

    public float getPosX() {
        return posX;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public boolean isInHouse(){
        if(houseNumber == -1){
            return false;
        }
        else if(houseNumber >= 0){
            return true;
        }
        else{
            System.out.println("NPC2: Fetter Fail: Spieler ist in dem negativen Haus: " + houseNumber + " und nicht >=(-1)");
            return false;
        }
    }

    public void setHighlightState(boolean h){
        highlightState = h;
        highLightImg.sichtbarSetzen(highlightState);
    }

    @Override
    public String toString() {
        return "NPC2{" +
                "name='" + name + '\'' +
                ", img=" + img +
                ", highlighterPath='" + highlighterPath + '\'' +
                ", highLightImg=" + highLightImg +
                ", highlightState=" + highlightState +
                ", posX=" + posX +
                ", posY=" + posY +
                ", relativPosX=" + relativPosX +
                ", relativPosY=" + relativPosY +
                ", houseNumber=" + houseNumber +
                ", lastLine='" + lastLine + '\'' +
                '}';
    }

    public static class Deserializer implements JsonDeserializer<NPC2> {

        public NPC2 deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException{

            JsonObject jsonObject = (JsonObject) jsonElement;
            return new NPC2(jsonObject.get("posX").getAsInt(), jsonObject.get("posY").getAsInt(), jsonObject.get("relativPosX").getAsInt(), jsonObject.get("relativPosY").getAsInt(),jsonObject.get("houseNumber").getAsInt(), jsonObject.get("name").getAsString(), jsonObject.get("lastLine").getAsString());
        }
    }
}
