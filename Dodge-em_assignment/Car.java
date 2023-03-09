import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author Venkata
 * @version (Day1)
 */
public class Car extends Actor {
    private final String colour;
    private final int maxSpeed;  
    private int speed;
    private int boostCounter;
    private boolean boosted = true;
    Car() {
        this("Green", 3);
    }

    Car(String colourIn, int speedIn) {
        colour = colourIn;
        speed = speedIn;
        maxSpeed = 60;
        if (speed > maxSpeed)
            speed = maxSpeed;
        boostCounter = 0;
    }

    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        controlledMovement();
        resetPos();
        /*startTimer();
         * if (getTime() >= 10000)
            ;*/
    }

    private void controlledMovement() {
        /*
        if (Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("up")) {
            setRotation(270);
            move(getSpeed());
        } else if (Greenfoot.isKeyDown("a")
                || Greenfoot.isKeyDown("left")) {
            setRotation(180);
            move(getSpeed());
        } else if (Greenfoot.isKeyDown("s")
                || Greenfoot.isKeyDown("down")) {
            setRotation(90);
            move(getSpeed());
        } else if (Greenfoot.isKeyDown("d")
                || Greenfoot.isKeyDown("right")) {
           setRotation(0);
           move(getSpeed());
        } else if (Greenfoot.isKeyDown("space")
                && boostCounter <= 3) {
            boost(2);
            if (boosted) {
                boostCounter++;
                boosted = !boosted;
            }
        }
        */
        if (Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("up")) {
            setRotation(270);
            move(getSpeed());
        } else if (Greenfoot.isKeyDown("s")
                || Greenfoot.isKeyDown("down")) {
            setRotation(270);
            move(-getSpeed());
        }
    }

    private void resetPos() {
        if (getX() >= (getWorld().getWidth() - 10)) {
            setRotation(0);
            move(-(getWorld().getWidth() - 10));
        } else if (getX() <= 10) {
            setRotation(180);
            move(-(getWorld().getWidth() - 10));
        } else if (getY() >= (getWorld().getHeight() - 10)) {
            setRotation(90);
            move(-(getWorld().getHeight() - 10));
        } else if (getY() <= 10) {
            setRotation(270);
            move(-(getWorld().getHeight() - 10));
        }
    }
    
    public void setSpeed(int speedIn) {
        speed = speedIn;
    }
    
    public int getSpeed() {
        return speed;
    }

    public void boost(int extraV) {
        int newSpeed = speed + extraV;
        if (newSpeed > maxSpeed)
            newSpeed = maxSpeed;
        move(newSpeed);
    }
}