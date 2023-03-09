import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Venkata) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    public String gameState = "gameInit";
    public Car car;
    public Obstacle elephant1, elephant2, elephant3;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {    
        /* Creating a new world with 600x400 cells,
         * with a cell size of 1x1 pixels.*/
        super(690, 470, 1);
    }

    public void act() {
        switch(gameState) {
            case "start":
                setBackground("greenfoot.png");
                break;
            case "gameInit":
                setBackground("roadBGCropped.png");

                // Creating & placing a car and obstacles
                car = new Car();
                addObject(car, 90, getHeight() / 2);
                car.setRotation(270);

                elephant1 = new Obstacle(625, Greenfoot.getRandomNumber(440));
                elephant2 = new Obstacle(625, Greenfoot.getRandomNumber(440));
                elephant3 = new Obstacle(625, Greenfoot.getRandomNumber(440));
                addObject(elephant1, elephant1.getXPos(), elephant1.getYPos());
                addObject(elephant2, elephant2.getXPos(), elephant2.getYPos());
                addObject(elephant3, elephant3.getXPos(), elephant3.getYPos());

                gameState = "game";
            case "game":
                car.act();
                elephant1.act();
                elephant2.act();
                elephant3.act();
                if (elephant1.hasCollided(Car.class)
                        || (elephant2.hasCollided(Car.class)
                        || (elephant3.hasCollided(Car.class))))
                        gameState = "end";
                break;
            case "end":
                setBackground("you_loseBG.jpg");
                removeObjects(getObjects(Car.class));
                removeObjects(getObjects(Obstacle.class));
                break;
        }
    }
}