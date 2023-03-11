import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Venkata) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private String gameState;
    private Button buttonPlay, buttonPlayAgain, buttonEnd;
    private Car car;
    private Obstacle elephant1, elephant2, elephant3;
    private MouseInfo mouse;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {    
        /* Creating a new world with 600x400 cells,
         * with a cell size of 1x1 pixels.*/
        super(690, 470, 1);

        gameState = "start";
        buttonPlay = new Button(" Play ", 50, false);
        buttonPlayAgain = new Button(" Play Again ", 50, false);
        buttonEnd = new Button(" End ", 50, false);
        car = new Car();
        elephant1 = new Obstacle(
                            625,
                            Greenfoot.getRandomNumber(440));
        elephant2 = new Obstacle(
                            625,
                            Greenfoot.getRandomNumber(440));
        elephant3 = new Obstacle(
                            625,
                            Greenfoot.getRandomNumber(440));
    }

    public void act() {
        mouse = Greenfoot.getMouseInfo();

        switch(gameState) {
            case "start":
                setBackground("woodenBG.jpg");
                addObject(buttonPlay, getWidth() / 2, 300);
                addObject(buttonEnd, getWidth() / 2, 380);
                buttonInteract(mouse, buttonPlay, "gameInit");
                buttonInteract(mouse, buttonEnd, "end");
                break;

            case "gameInit":
                setBackground("roadBGCropped.png");
                removeObjects(getObjects(Button.class));

                // Creating & placing a car and obstacles
                addObject(car, 90, getHeight() / 2);
                car.setRotation(270);

                addObject(
                        elephant1,
                        elephant1.getInitXPos(),
                        elephant1.getInitYPos());
                addObject(
                        elephant2,
                        elephant2.getInitXPos(),
                        elephant2.getInitYPos());
                addObject(
                        elephant3,
                        elephant3.getInitXPos(),
                        elephant3.getInitYPos());

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
                removeObjects(getObjects(Button.class));
                removeObjects(getObjects(Car.class));
                removeObjects(getObjects(Obstacle.class));
                addObject(buttonPlayAgain, getWidth() / 2, 380);
                buttonInteract(mouse, buttonPlayAgain, "gameInit");
                break;
        }
    }

    private void buttonInteract(MouseInfo mouseIn, Button buttonIn, String gameStateIn) {
        if (mouseIn != null) {
            Actor interactingActor = mouseIn.getActor();
            if (interactingActor == buttonIn) {
                buttonIn = (Button) interactingActor;
                if (mouseIn.getClickCount() == 1)
                    gameState = gameStateIn;
            }
        }
    }
}