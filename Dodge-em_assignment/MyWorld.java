import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Venkata) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    public String gameState = "start";
    public Button button1;
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
        MouseInfo mouse = Greenfoot.getMouseInfo();

        switch(gameState) {
            case "start":
                setBackground("woodenBG.jpg");
                button1 = new Button(" Test ", 50, true);
                addObject(button1, getWidth() / 2, getHeight() / 2);

                if (mouse != null) {
                    Actor interactingActor = mouse.getActor();
                    if (interactingActor != null) {
                        Button currentButton = (Button) interactingActor;
                        int mouseButtonPressed = mouse.getButton();
                        int mouseClickCount = mouse.getClickCount();
                        System.out.println(mouseButtonPressed + " - " + mouseClickCount);
                        if (mouseClickCount == 1) {
                            currentButton.buttonToggle();
                        }
                    }
                }
                break;

            case "gameInit":
                setBackground("roadBGCropped.png");

                // Creating & placing a car and obstacles
                car = new Car();
                addObject(car, 90, getHeight() / 2);
                car.setRotation(270);

                elephant1 = new Obstacle(
                                625,
                                Greenfoot.getRandomNumber(440));
                elephant2 = new Obstacle(
                                625,
                                Greenfoot.getRandomNumber(440));
                elephant3 = new Obstacle(
                                625,
                                Greenfoot.getRandomNumber(440));
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
                removeObjects(getObjects(Car.class));
                removeObjects(getObjects(Obstacle.class));
                break;
        }
    }

    private void buttonWork(MouseInfo mouseIn) {
        if (mouseIn != null) {
            Actor interactingActor = mouseIn.getActor();
            if (interactingActor != null) {
                Button currentButton = (Button) interactingActor;
                //int mouseButtonPressed = mouseIn.getButton();
                int mouseClickCount = mouseIn.getClickCount();
                //System.out.println(mouseButtonPressed + " - " + mouseClickCount);
                if (mouseClickCount == 1) {
                    currentButton.buttonToggle();
                }
            }
        }
    }
}