import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RadioInterface {

    private int currentStation;
    private short levelSound;
    private int firstStation = 0;
    private int lastStation = 10;
    private short minSound = 0;
    private short maxSound = 100;

    public RadioInterface(int currentStation) {
        if (currentStation > lastStation || currentStation < firstStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public RadioInterface(short levelSound) {
       if(levelSound < minSound || levelSound > maxSound){
           return;
        }
        this.levelSound = levelSound;
    }


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


    public short setCurrentLevelSound(short levelSound){
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
