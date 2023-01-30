package be.tomcools.games.portal;

import be.tomcools.framework.gameloop.ARGBColor;
import be.tomcools.framework.gameloop.Game;
import be.tomcools.framework.gameloop.Graphics;
import be.tomcools.framework.gameloop.Screen;
import be.tomcools.framework.physics.Vector2;
import be.tomcools.games.gravity.Floor;
import javafx.scene.input.KeyCode;

public class PortalScreen extends Screen {
    public static final Vector2 GRAVITY = new Vector2(0, 0.2f);
    private final Floor floor;
    private Cube cc;
    public PortalScreen(Game game) {
        super(game);
        Graphics g = game.getGraphics();
        resetCube();
        floor = new Floor(new Vector2(0, g.getHeight()-20), g.getWidth());
    }

    @Override
    public void update(float deltaTime) {
        doLogic();

        cc.update();
    }

    private void doLogic() {
        if(game.getInput().isKeyPressed(KeyCode.SPACE)) {
            resetCube();
            return;
        }

        if(cc.collidesWith(floor)) {
            cc.setVelocity(Vector2.zero());
        } else {
             cc.applyForce(Vector2.mult(GRAVITY,cc.getMass()));
        }
    }

    @Override
    public void paint(float deltaTime) {
        game.getGraphics().clearScreen(ARGBColor.WHITE);

        floor.draw(game.getGraphics());
        cc.draw(game.getGraphics());
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

    private void resetCube() {
        System.out.println("Resetting cube.");
        this.cc = new Cube(new Vector2(500, 0), 0.1f);
    }
}
