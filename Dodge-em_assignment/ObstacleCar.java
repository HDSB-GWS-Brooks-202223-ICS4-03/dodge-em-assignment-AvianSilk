import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A description of class ObstacleCar:
 * 
 * This class is used to design a car acting as an obstacle
 * to the user's car since it moves towards him. Colliding with
 * an object of this class results in the game ending. This is
 * a different kind of Obstacle class (when compared to Barrier).
 * 
 * @author Venkata Adapala (@AvianSilk) 
 * @version 12-03-2023
 */
public class ObstacleCar extends Actor {
    private int initXPos;
    private int initYPos;
    private int speed;
    
    // The number of times the car goes
    // beyond the screen and has to be reset
    private int beyondScreenCounter;

    // The number of times the car has been sped up
    private int speedUpCounter;

    /**
     * Creates a new instance of an ObstacleCar with the
     * initial coordinates given by the user
     * 
     * @param initXPosIn The initial X position of the object
     * @param initYPosIn The initial Y position of the object
     */
    public ObstacleCar(int initXPosIn, int initYPosIn) {
        initXPos = initXPosIn;
        initYPos = initYPosIn + 20;
        speedUpCounter = 0;
        beyondScreenCounter = 0;
        speed = -(Greenfoot.getRandomNumber(4) + 2);
    }

    /**
     * Act - do whatever the ObstacleCar wants to do.
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
     * This method mainly resets the position of the car once it goes
     * beyond the screen. While doing so, it randomizes the position
     * at which it'll appear again and its speed. Based on the number of
     * times the car's position has been reset, the speed will keep
     * increasing, therefore, making the game harder with time.
     */
    public void resetPos() {
        if (getX() <= 10) {
            /**
             * Randomizing the speed of the car when it gets reset.
             * Also notice that the maximum limit of the speed is
             * constantly changing due to a variable.
             * Thus, the more the car travels and gets reset,
             * the higher its possible speed can be
             */
            speed = -(Greenfoot.getRandomNumber(3 + speedUpCounter) + 2);
    
            // Places the car at the far right edge on a random Y position
            setLocation(
            getWorld().getWidth() - 10,
            Greenfoot.getRandomNumber(440) + 10);
            
            // For every 2 times that the car gets reset, the upper
            // limit on its speed is increased by 1
            beyondScreenCounter++;
            if (beyondScreenCounter % 2 == 0)
                speedUpCounter++;
        }
    }

    /**
     * This method zeroes the counters, which is necessary since if
     * the counters weren't zeroed, the past speeds of the cars will
     * carry onto the next game.
     */
    public void zeroCounters() {
        speedUpCounter = 0;
        beyondScreenCounter = 0;
    }

    /**
     * This method uses the isTouching method to check if
     * an object of a certain class has collided with the
     * obstacle car
     * 
     * @return true if it collided, false if not
     */
    public boolean hasCollided(java.lang.Class<?> cls) {
        return isTouching(cls);
    }
}