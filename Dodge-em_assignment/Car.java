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
    private int acclnCounter;
    private int time;
    Car() {
        this("Green", 3);
    }

    Car(String colourIn, int speedIn) {
        colour = colourIn;
        speed = speedIn;
        maxSpeed = 60;
        if (speed > maxSpeed)
            speed = maxSpeed;
        acclnCounter = 0;
        time = 0;
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
                && acclnCounter <= 3) {
            accelerate(2);
            //acclnCounter++;
        }
    }
    
    private void resetPos() {
        if (getX() >= (MyWorld.scenWidth - 10)) {
            setRotation(0);
            move(-(MyWorld.scenWidth - 10));
        } else if (getX() <= (MyWorld.scenWidth - 630)) {
            setRotation(180);
            move(-(MyWorld.scenWidth - 10));
        } else if (getY() >= (MyWorld.scenHeight - 10)) {
            setRotation(90);
            move(-(MyWorld.scenHeight - 10));
        } else if (getY() <= (MyWorld.scenHeight - 470)) {
            setRotation(270);
            move(-(MyWorld.scenHeight - 10));
        }
    }

    public void startTimer() {
        time++;
    }

    public int getTime() {
        return time;
    }
    
    public void setSpeed(int speedIn) {
        speed = speedIn;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }
    
    public void accelerate(int deltaV) {
        int newSpeed = speed + deltaV;
        if (newSpeed > maxSpeed)
            newSpeed = maxSpeed;
        move(newSpeed);
    }
}