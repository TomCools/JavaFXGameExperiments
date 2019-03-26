package be.tomcools.games.gravity;

import be.tomcools.framework.DrawableItem;
import be.tomcools.framework.Helpers;
import be.tomcools.framework.gameloop.ARGBColor;
import be.tomcools.framework.gameloop.Graphics;
import be.tomcools.framework.physics.BoundingBox;
import be.tomcools.framework.physics.Collisionable;
import be.tomcools.framework.physics.Vector2;

import java.util.Collection;
import java.util.Collections;

public class Floor extends DrawableItem implements Collisionable {

    private static final int HEIGHT = 20;
    private int screenWidth;

    public Floor(Vector2 location, int width) {
        super(location);
        this.screenWidth = width;
    }

    @Override
    public void draw(Graphics g) {
        Helpers.drawBoundingBoxes(hitBoxes(), g);
    }

    @Override
    public Collection<BoundingBox> hitBoxes() {
        return Collections.singletonList(Helpers.toBoundingBox(location, screenWidth, HEIGHT));
    }
}
