package be.tomcools.games.portal;

import be.tomcools.framework.DrawableItem;
import be.tomcools.framework.gameloop.Graphics;
import be.tomcools.framework.gameloop.javafx.JavaFxImage;
import be.tomcools.framework.physics.BoundingBox;
import be.tomcools.framework.physics.Collisionable;
import be.tomcools.framework.physics.Vector2;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

public class Cube extends DrawableItem implements Collisionable {
    private JavaFxImage image;

    public Cube(Vector2 location, float weight) {
        super(location, weight);
        image = new JavaFxImage(new File("c:cube.png").toURI().toString());
    }

    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, location.getX(), location.getY());
    }

    @Override
    public Collection<BoundingBox> hitBoxes() {
        return Collections.singleton(new BoundingBox(location.getX(), location.getY(), image.getWidth(), image.getWidth()));
    }
}
