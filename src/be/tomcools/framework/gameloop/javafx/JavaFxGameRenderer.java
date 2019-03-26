package be.tomcools.framework.gameloop.javafx;

import be.tomcools.framework.gameloop.*;
import javafx.animation.AnimationTimer;

public class JavaFxGameRenderer extends AnimationTimer {
    private Game game;

    public JavaFxGameRenderer(Game game) {
        this.game = game;
    }

    public void resume() {
        this.start();
    }

    public void pause() {
        this.stop();
    }

    @Override
    public void handle(long now) {
        game.getCurrentScreen().update(now);
        game.getCurrentScreen().paint(now);
    }
}
