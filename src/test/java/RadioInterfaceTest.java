
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class RadioInterfaceTest {

    RadioInterface radio = new RadioInterface(10);

    @Test
    void shouldSetCurrentRadioStationCorrectFromConstructor() {
        RadioInterface radio = new RadioInterface(10);
         int expect = 10;
        assertEquals(expect, radio.getCurrentStation());
    }

    @Test
    void shouldCurrentRadioStationMoreThenLastFromConstructor(){
        RadioInterface radio = new RadioInterface(15);
        int expect = 0;
        assertEquals(expect, radio.getCurrentStation());

    }

    @Test
    void shouldCurrentRadioStationMoreThenFirstFromConstructor(){
        RadioInterface radio = new RadioInterface(-12);
        int expect = 0;
        assertEquals(expect, radio.getCurrentStation());

    }

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
        RadioInterface radio = new RadioInterface(6);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 7;
        assertEquals(expect, actual);
    }

    @Test
    void shouldNextRadioStationUltimate(){
        RadioInterface radio = new RadioInterface(10);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test
    void shouldNextRadioStationUnderLimits(){
        RadioInterface radio = new RadioInterface(15);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 1;
        assertEquals(expect, actual);
    }

    @Test void shouldNextRadioStationBeforeLimits(){
        RadioInterface radio = new RadioInterface(-3);
        radio.nextRadioStation();
        int actual = radio.getCurrentStation();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevRadioStationCorrect() {
        RadioInterface radio = new RadioInterface(4);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevRadioStationUnderLimits() {
        RadioInterface radio = new RadioInterface(156);
        radio.prevRadioStation();
        int actual = radio.getCurrentStation();
        int expect = 10;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundCorrect() {
        int actual = radio.setCurrentLevelSound(45);
        int expect = 45;
        assertEquals(expect, actual);

    }

    @Test
    void shouldSetCurrentLevelSoundMoreThenMax() {
        int actual = radio.setCurrentLevelSound( 140);
        int expect = 100;
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
        radio.setCurrentLevelSound(60);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 61;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMaxSoundMoreThenMax() {
        radio.setCurrentLevelSound(130);
        radio.setMaxVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 100;
        assertEquals(expect,actual);

    }

    @Test
    void shouldSetMinSoundCorrect() {
        radio.setCurrentLevelSound(70);
        radio.setMinVolumeSound();
        int actual = radio.getLevelSound();
        int expect = 69;
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


}