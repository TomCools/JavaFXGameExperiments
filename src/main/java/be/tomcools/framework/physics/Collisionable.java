package be.tomcools.framework.physics;

import java.util.Collection;

public interface Collisionable {
    Collection<BoundingBox> hitBoxes();

    default boolean collidesWith(Collisionable collisionable) {
        Collection<BoundingBox> externalBoxes = collisionable.hitBoxes();
        Collection<BoundingBox> currentObjectBoxes = hitBoxes();
        for (BoundingBox externalBox : externalBoxes) {
            for (BoundingBox currentObjectBox : currentObjectBoxes) {
                if(externalBox.collidesWith(currentObjectBox)) {
                    return true;
                }
            }
        }
        return false;
    }

    default boolean collides(Item item) {
        Collection<BoundingBox> currentObjectBoxes = hitBoxes();
        for (BoundingBox box : currentObjectBoxes) {
            if(box.collidesWith(item.getLocation())) {
                return true;
            }
        }
        return false;
    }
}
