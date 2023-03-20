import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A description of class PlayerCar:
 * 
 * This is the user-controlled car. It is green in color and has a
 * fixed speed and only moves vertically. If it goes beyond the screen,
 * it snaps back to the opposing edge of the screen.
 * 
 * @author Venkata Adapala (@AvianSilk)
 * @version 12-03-2023
 */
public class PlayerCar extends Actor { 
    private int speed;
    private final int maxSpeed;

    /**
     * Creates a new instance of PlayerCar
     * with the default speed value of 3
     */
    public PlayerCar() {
        this(3);
    }

    /**
     * Creates a new instance of PlayerCar
     * with the given speed value (parameter)
     * The speed is capped at a certain arbitrary
     * value (maxSpeed) to ensure that the game
     * is user-friendly
     * 
     * @param The speed the car object
     *         is supposed to move at
     */
    public PlayerCar(int speedIn) {
        speed = speedIn;
        maxSpeed = 60;
        if (speed > maxSpeed)
            speed = maxSpeed;
    }

    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        controlledMovement();
        resetPos();
    }

    /**
     * This method allows for the user to manually control
     * the movement of the PlayerCar on screen. It takes keyboard
     * inputs from certain keys ("w", "up arrow", "s", "down arrow"),
     * sets the rotation of the car appropriately and moves it
     * in that direction using the speed
     */
    private void controlledMovement() {
        if (Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("up")) {
            setRotation(270);
            move(speed);
        } else if (Greenfoot.isKeyDown("s")
                || Greenfoot.isKeyDown("down")) {
            setRotation(270);
            move(-speed);
        }
    }

    /**
     * This method ensures that the car doesn't get stuck at the
     * edge of the screen. It does so by checking if the car is
     * either stuck on the top edge or the bottom edge and
     * then moves it to the opposing edge in an instant
     */
    private void resetPos() {
        if (getY() >= (getWorld().getHeight() - 10)) {
            setRotation(90);
            move(-(getWorld().getHeight() - 10));
        } else if (getY() <= 10) {
            setRotation(270);
            move(-(getWorld().getHeight() - 10));
        }
    }
}