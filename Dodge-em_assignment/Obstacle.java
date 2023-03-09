import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor {
    private int xPos;
    private int yPos;
    private int speed;
    Obstacle(int xPosIn, int yPosIn) {
        xPos = xPosIn;
        yPos = yPosIn + 20;
        speed = -(Greenfoot.getRandomNumber(4) + 1);
    }
    
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move(speed);
        resetPos();
    }
    
    public int getXPos() {
        return xPos;
    }
    
    public int getYPos() {
        return yPos;
    }
    
    public void resetPos() {
        if (getX() <= 10) {
            move(getWorld().getWidth() - 10);
            speed = -(Greenfoot.getRandomNumber(4) + 1);
            setRotation(270);
            move(Math.abs(Greenfoot.getRandomNumber(440) - getY()));
            setRotation(0);
        }
    }

    public boolean hasCollided(java.lang.Class<?> cls) {
        return isTouching(cls);
    }
}