import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Venkata) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    public static Car car;
    public static int scenWidth, scenHeight;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {    
        /* Creating a new world with 600x400 cells,
         * with a cell size of 1x1 pixels.*/
        super(640, 480, 1);
        scenWidth = getWidth();
        scenHeight = getHeight();

        prepare();
    }

    public void act() {
        car.act();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        // Creating the background and placing it
        setBackground(new GreenfootImage("woodenBG.jpg"));
        
        // Creating a car and placing it
        car = new Car();
        addObject(car, scenWidth / 2,scenHeight / 2);
    }
}