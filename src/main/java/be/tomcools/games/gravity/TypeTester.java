package be.tomcools.games.gravity;

import be.tomcools.framework.gameloop.Screen;
import be.tomcools.framework.gameloop.javafx.JavaFxGame;

public class TypeTester extends JavaFxGame {
    @Override
    public Screen getInitScreen() {
        return new TypeTesterScreen(this);
    }
}
