package be.tomcools.framework;

import be.tomcools.framework.gameloop.Drawable;
import be.tomcools.framework.physics.Item;
import be.tomcools.framework.physics.Vector2;

public abstract class DrawableItem extends Item implements Drawable {
    public DrawableItem(Vector2 location) {
        super(location);
    }

    public DrawableItem(Vector2 location, float mass) {
        super(location, mass);
    }
}
