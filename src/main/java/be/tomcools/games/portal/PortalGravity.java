package be.tomcools.games.portal;

import be.tomcools.framework.gameloop.Screen;
import be.tomcools.framework.gameloop.javafx.JavaFxGame;

public class PortalGravity extends JavaFxGame {
    @Override
    public Screen getInitScreen() {
        return new PortalScreen(this);
    }
}
