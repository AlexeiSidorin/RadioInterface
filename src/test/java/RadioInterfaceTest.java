
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
        int expect = 9;
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
        int expect = 9;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundCorrect() {
        int actual = radio.setCurrentLevelSound(4);
        int expect = 4;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundMoreThenMax() {
        int actual = radio.setCurrentLevelSound(14);
        int expect = 10;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundMoreThenMix() {
        int actual = radio.setCurrentLevelSound(-5);
        int expect = 0;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetMaxSoundCorrect() {
        radio.setCurrentLevelSound(5);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 6;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMaxSoundMoreThenMax() {
        radio.setCurrentLevelSound(13);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 10;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMinSoundCorrect() {
        radio.setCurrentLevelSound(7);
        radio.setMinVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 6;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMinSoundMoreThenMin() {
        radio.setCurrentLevelSound(-9);
        radio.setMinVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 0;
        assertEquals(expect,actual);
    }
}