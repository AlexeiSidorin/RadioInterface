import lombok.Data;

@Data
public class RadioInterface {

    private int currentStation;
    private int levelSound;
    private int firstStation = 0;
    private int lastStation = 9;
    private int minSound = 0;
    private int maxSound = 10;



    public int setCurrentRadioStation(int currentStation){
        if(currentStation > lastStation) { return this.currentStation=lastStation;  }
        else if(currentStation < firstStation) { return this.currentStation = firstStation; }
        return this.currentStation = currentStation;
    }

    public void nextRadioStation(){
        if(currentStation == lastStation) {
            this.currentStation = firstStation;
        } else {
            currentStation++;
        }

    }


    public void prevRadioStation(){
        if(currentStation == firstStation) {
            currentStation = lastStation;
        } else {
            currentStation--;
        }

    }


    public int setCurrentLevelSound(int levelSound){
        if(levelSound > maxSound) return this.levelSound = maxSound;
        if(levelSound < minSound) return this.levelSound = minSound;
        return this.levelSound = levelSound;
    }


    public void setMaxVolumeSound(){
        if(levelSound == maxSound){
            levelSound = maxSound;
        } else {
            levelSound++;
        }

    }


    public void setMinVolumeSound(){
        if(levelSound == minSound){
            levelSound = minSound;
        } else {
            levelSound--;
        }
    }


}
