package be.tomcools.framework.gameloop.javafx;

import be.tomcools.framework.gameloop.Input;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaFxInput implements Input {
    private Set<KeyCode> pressedKeys;

    private Node node;

    public JavaFxInput(Node node) {
        this.node = node;
        init();
    }

    private void init() {
        pressedKeys = new HashSet<>();
        node.setOnKeyPressed(e -> {
            System.out.println("Key pressed: " + e.getCode());
            pressedKeys.add(e.getCode());
        });
        node.setOnKeyReleased(e -> pressedKeys.remove(e.getCode()));
    }

    @Override
    public boolean isKeyPressed(KeyCode character) {
        return pressedKeys.contains(character);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return false;
    }

    @Override
    public int getTouchX(int pointer) {
        return 0;
    }

    @Override
    public int getTouchY(int pointer) {
        return 0;
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return null;
    }
}
