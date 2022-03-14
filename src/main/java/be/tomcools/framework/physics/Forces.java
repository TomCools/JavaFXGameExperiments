package be.tomcools.framework.physics;

public class Forces {
    public static final Vector2 GRAVITY = new Vector2(0, 0.45f);
    public static final Vector2 JUMP = new Vector2(0, -15f);
    public static final Vector2 PULL_WALL = new Vector2(-1f, 0);

    public static Vector2 gravity(Item drawable) {
        float x = GRAVITY.getXFloat();
        float y = GRAVITY.getYFloat();
        return new Vector2(x, y * drawable.getMass());
    }

    public static Vector2 fullstop() {
        return new Vector2(0, 0);
    }
}
