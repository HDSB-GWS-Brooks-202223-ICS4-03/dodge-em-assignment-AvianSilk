import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor {
    private int initXPos;
    private int initYPos;
    private int speed;
    Obstacle(int initXPosIn, int initYPosIn) {
        initXPos = initXPosIn;
        initYPos = initYPosIn + 20;
        speed = -(Greenfoot.getRandomNumber(4) + 1);
    }

    /**
     * Act - do whatever the Obstacle wants to do.
     * This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move(speed);
        resetPos();
    }
    
    public int getInitXPos() {
        return initXPos;
    }
    
    public int getInitYPos() {
        return initYPos;
    }
    
    public void resetPos() {
        if (getX() <= 10) {
            speed = -(Greenfoot.getRandomNumber(4) + 1);
            setLocation(
            getWorld().getWidth() - 10,
            Greenfoot.getRandomNumber(440) + 10);
        }
    }

    public boolean hasCollided(java.lang.Class<?> cls) {
        return isTouching(cls);
    }
}