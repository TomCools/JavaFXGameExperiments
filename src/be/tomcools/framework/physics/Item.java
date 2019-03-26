package be.tomcools.framework.physics;


public abstract class Item {
    private static final float DEFAULT_MASS = 1;

    protected Vector2 location;
    protected Vector2 velocity;
    protected Vector2 acceleration;
    private final float mass;

    public Item(Vector2 location) {
        this(location, DEFAULT_MASS);
    }

    public Item(Vector2 location, float mass) {
        this.location = location;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
        this.mass = mass;
    }

    public void applyForce(Vector2 force) {
        // Copy, because else, you are changing the original force! :s
        Vector2 forceCopy = force.copy();
        forceCopy.div(mass);
        acceleration.add(forceCopy);
    }

    public void update() {
        velocity.add(acceleration);
        location.add(velocity);

        //Revert to 0
        acceleration.mult(0);
    }

    public Vector2 getLocation() {
        return location;
    }

    public void setLocation(Vector2 location) {
        this.location = location;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public float getMass() {
        return mass;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
