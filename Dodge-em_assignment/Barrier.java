import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used to design a barrier (looks like an anchor)
 * acting as an obstacle to the user's car since it
 * slowly moves towards him. Colliding with an object of this
 * class results in the game ending. Unlike the ObstacleCars, this
 * obstacle never has a lot but constant speed, therefore staying
 * on the screen longer than the cars. Thus, it provides a different
 * kind of challenge to the player since it slowly but surely
 * arrives near the car.
 * 
 * @author Venkata Adapala (@AvianSilk) 
 * @version 12-03-2023
 */
public class Barrier extends Actor {
    private int initXPos;
    private int initYPos;
    private int speed;

    /**
     * Creates a new instance of a Barrier with the
     * initial coordinates given by the user
     * 
     * @param initXPosIn The initial X position of the object
     * @param initYPosIn The initial Y position of the object
     */
    public Barrier(int initXPosIn, int initYPosIn) {
        initXPos = initXPosIn;
        initYPos = initYPosIn + 20;
        speed = -1;
    }

    /**
     * Act - do whatever the Barrier wants to do.
     * This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move(speed);
        resetPos();
    }

    /**
     * Gets the X position of the object
     * when it was intially created
     * 
     * @return initXPos the Initial X position of the object
     */
    public int getInitXPos() {
        return initXPos;
    }

    /**
     * Gets the Y position of the object
     * when it was intially created
     * 
     * @return initYPos the Initial Y position of the object
     */
    public int getInitYPos() {
        return initYPos;
    }

    /**
     * This method mainly resets the position of the barrier once it goes
     * beyond the screen. While doing so, it randomizes the position
     * at which it'll appear again. Unlike an ObstacleCar, the speed
     * isn't randomized after being reset.
     */
    public void resetPos() {
        if (getX() <= 10) {    
            // Places the barrier at the far right edge on a random Y position
            setLocation(
            getWorld().getWidth() - 10,
            Greenfoot.getRandomNumber(440) + 10);
        }
    }

    /**
     * This method uses the isTouching method to check if
     * an object of a certain class has collided with the
     * obstacle car
     * 
     * @param cls The class which contains the objects that are checked for collisions
     * @return isTouching(cls) True if it collided, false if not
     */
    public boolean hasCollided(java.lang.Class<?> cls) {
        return isTouching(cls);
    }
}