package be.tomcools.framework.gameloop;

/**
 * Created by tomco on 6/12/2016.
 */

public interface Game {

    Audio getAudio();

    Input getInput();

    FileIO getFileIO();

    Graphics getGraphics();

    void setScreen(Screen screen);

    Screen getCurrentScreen();

    Screen getInitScreen();
}