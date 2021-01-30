
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class RadioInterfaceTest {

    RadioInterface radio = new RadioInterface();

    @Test
    void shouldSetCurrentRadioStationCorrect() {
        int actual = radio.setCurrentRadioStation(6);
         int expect = 6;
        assertEquals(expect, actual);
    }

    @Test
    void shouldCurrentRadioStationMoreThenLast(){
        int actual = radio.setCurrentRadioStation(15);
        int expect = 10;
        assertEquals(expect, actual);

    }

    @Test
    void shouldCurrentRadioStationMoreThenFirst(){
        int actual = radio.setCurrentRadioStation(-2);
        int expect = 0;
        assertEquals(expect, actual);

    }

    @Test
    void shouldNextRadioStationCorrect() {
        radio.setCurrentRadioStation(5);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 6;
        assertEquals(expect, actual);
    }

    @Test
    void shouldNextRadioStationUnderLimits(){

        radio.setCurrentRadioStation(13);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test
    void shouldPrevRadioStationCorrect() {
        radio.setCurrentRadioStation(4);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevRadioStationUnderLimits() {
        radio.setCurrentRadioStation(-3);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 10;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundCorrect() {
        int actual = radio.setCurrentLevelSound((short) 4);
        int expect = 4;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundMoreThenMax() {
        int actual = radio.setCurrentLevelSound((short) 140);
        int expect = 100;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundMoreThenMix() {
        int actual = radio.setCurrentLevelSound((short) -5);
        int expect = 0;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetMaxSoundCorrect() {
        radio.setCurrentLevelSound((short) 60);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 61;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMaxSoundMoreThenMax() {
        radio.setCurrentLevelSound((short) 130);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 100;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMinSoundCorrect() {
        radio.setCurrentLevelSound((short) 70);
        radio.setMinVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 69;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMinSoundMoreThenMin() {
        radio.setCurrentLevelSound((short) -9);
        radio.setMinVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 0;
        assertEquals(expect,actual);
    }

    @Test
    void shouldConstructorStationWorkCorrect() {
        RadioInterface radioInterface = new RadioInterface(5);
        int expected = 5;
        assertEquals(expected, radioInterface.getCurrentStation());
    }

    @Test
    void shouldConstructorStationWorkMinData() {
        RadioInterface radioInterface = new RadioInterface(0);
        int expected = 0;
        assertEquals(expected, radioInterface.getCurrentStation());
    }

    @Test
    void shouldConstructorStationWorkLastData() {
        RadioInterface radioInterface = new RadioInterface(10);
        int expected = 10;
        assertEquals(expected, radioInterface.getCurrentStation());
    }

    @Test
    void shouldConstructorStationWorkOutMaxData() {
        RadioInterface radioInterface = new RadioInterface(15);
        int expected = 0;
        assertEquals(expected, radioInterface.getCurrentStation());
    }

    @Test
    void shouldConstructorStationWorkOutMixData() {
        RadioInterface radioInterface = new RadioInterface(-56);
        int expected = 0;
        assertEquals(expected, radioInterface.getCurrentStation());
    }


    @Test
    void shouldConstructorSoundWorkOutCorrectedData() {
        RadioInterface radioInterface = new RadioInterface((short)45);
        short expected = 45;
        assertEquals(expected, radioInterface.getLevelSound());
    }

    @Test
    void shouldConstructorSoundWorkOutCorrectedMinData() {
        RadioInterface radioInterface = new RadioInterface((short)0);
        short expected = 0;
        assertEquals(expected, radioInterface.getLevelSound());
    }

    @Test
    void shouldConstructorSoundWorkOutCorrectedMaxData() {
        RadioInterface radioInterface = new RadioInterface((short)100);
        short expected = 100;
        assertEquals(expected, radioInterface.getLevelSound());
    }

    @Test
    void shouldConstructorSoundWorkOutCorrectedUnderMaxData() {
        RadioInterface radioInterface = new RadioInterface((short)176);
        short expected = 0;
        assertEquals(expected, radioInterface.getLevelSound());
    }

    @Test
    void shouldConstructorSoundWorkOutCorrectedUnderMixData() {
        RadioInterface radioInterface = new RadioInterface((short)-478);
        short expected = 0;
        assertEquals(expected, radioInterface.getLevelSound());
    }




}