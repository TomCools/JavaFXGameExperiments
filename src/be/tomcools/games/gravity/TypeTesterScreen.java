package be.tomcools.games.gravity;

import be.tomcools.framework.gameloop.ARGBColor;
import be.tomcools.framework.gameloop.Game;
import be.tomcools.framework.gameloop.Screen;
import be.tomcools.framework.physics.Collisionable;
import be.tomcools.framework.physics.Vector2;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class TypeTesterScreen extends Screen {
    public static final Vector2 GRAVITY = new Vector2(0, 0.1f);
    private Collisionable floor;
    private boolean gameOver = false;
    private Set<FallingText> texts = Set.of(new FallingText(new Vector2(100,0), KeyCode.T.name(), ARGBColor.WHITE));
    public TypeTesterScreen(Game game) {
        super(game);
        floor = new Floor(new Vector2(0,game.getGraphics().getHeight()-20),game.getGraphics().getWidth());
    }

    @Override
    public void update(float deltaTime) {
        texts.forEach(c -> {
            if(gameOver || floor.collides(c)) {
                gameOver();
            } else {
                continueLoop();
            }
        });
    }

    private void continueLoop() {
        HashSet<FallingText> remainingTexts = new HashSet<>();

        texts.forEach(c -> {
            String character = c.getCharacter();
            if(!game.getInput().isKeyPressed(KeyCode.valueOf(character))) {
                remainingTexts.add(c);
            } else {
                System.out.println("Was removed: " + c);
            }
        });

        if(remainingTexts.isEmpty()) {
            game.getGraphics().drawString("VICTORY",100,100, ARGBColor.WHITE);
        }


        remainingTexts.forEach(c -> {
            c.applyForce(GRAVITY);
            c.getVelocity().limit(1);
            c.update();
        });

        while(remainingTexts.size() < 3) {
            remainingTexts.add(new FallingText(new Vector2(RandomGenerator.integer(game.getGraphics().getWidth()),0), RandomGenerator.character().getName(), ARGBColor.WHITE));
        }

        texts = remainingTexts;
    }

    private void gameOver() {
        gameOver = true;
        if(game.getInput().isKeyPressed(KeyCode.SPACE)) {
            gameOver = false;
            // Reset all characters to top of the screen.
            texts.forEach(c -> {
                c.setLocation(new Vector2(c.getLocation().getX(), 0));
            });
        }
    }

    @Override
    public void paint(float deltaTime) {
        game.getGraphics().clearScreen(ARGBColor.BLACK);

        if(gameOver) {
            game.getGraphics().drawString("GAME OVER",100,100, ARGBColor.RED);
        } else {
            texts.forEach(c -> {
                c.draw(game.getGraphics());
            });
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}
