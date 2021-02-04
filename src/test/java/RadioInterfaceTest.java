
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class RadioInterfaceTest {

    @Test
    void shouldSetCurrentRadioStationFromConstructor() {
        RadioInterface radio = new RadioInterface(10);
        int expect = 10;
        int actual = radio.getLastStation();
        assertEquals(expect, actual);
    }




    @Test
    void shouldSetCurrentRadioStationCorrect() {
        RadioInterface radio = new RadioInterface();
        int actual = radio.setCurrentRadioStation(6);
        int expect = 6;
        assertEquals(expect, actual);
    }

    @Test
    void shouldCurrentRadioStationMoreThenLast(){
        RadioInterface radio = new RadioInterface();
        int actual = radio.setCurrentRadioStation(15);
        int expect = 10;
        assertEquals(expect, actual);

    }

    @Test
    void shouldCurrentRadioStationMoreThenFirst(){
        RadioInterface radio = new RadioInterface();
        int actual = radio.setCurrentRadioStation(-2);
        int expect = 0;
        assertEquals(expect, actual);

    }

    @Test
    void shouldNextRadioStationCorrect() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentRadioStation(6);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 7;
        assertEquals(expect, actual);
    }

    @Test
    void shouldNextRadioStationUltimate(){
        RadioInterface radioInterface = new RadioInterface();
        radioInterface.setCurrentRadioStation(10);
        radioInterface.nextRadioStation();
        int actual = radioInterface.getCurrentStation();
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test
    void shouldNextRadioStationUnderLimits(){
        RadioInterface radio = new RadioInterface();
        radio.setCurrentRadioStation(14);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test
    void shouldNextRadioStationBeforeLimits(){
        RadioInterface radio = new RadioInterface(-3);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevRadioStationCorrect() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentRadioStation(4);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevRadioStationEqualMinStation() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentRadioStation(0);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expected = 10;
        assertEquals(expected, actual);
    }


    @Test
    void shouldPrevRadioStationEqualLimitStation() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentRadioStation(10);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevRadioStationUnderLimits() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentRadioStation(143);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 9;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundCorrect() {
        RadioInterface radio = new RadioInterface();
        int actual = radio.setCurrentLevelSound(45);
        int expect = 45;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundMoreThenMax() {
        RadioInterface radio = new RadioInterface();
        int actual = radio.setCurrentLevelSound( 140);
        int expect = 100;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundMoreThenMix() {
        RadioInterface radio = new RadioInterface();
        int actual = radio.setCurrentLevelSound(-5);
        int expect = 0;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetMaxSoundCorrect() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentLevelSound(60);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 61;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMaxSoundMoreThenMax() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentLevelSound(130);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 100;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMinSoundCorrect() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentLevelSound(70);
        radio.setMinVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 69;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMinSoundMoreThenMin() {
        RadioInterface radio = new RadioInterface();
        radio.setCurrentLevelSound(-9);
        radio.setMinVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 0;
        assertEquals(expect,actual);
    }


}
