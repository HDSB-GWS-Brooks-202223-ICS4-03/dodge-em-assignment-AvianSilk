import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Venkata) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private String gameState;
    private Button title, buttonPlay, buttonPlayAgain, buttonHelp;
    private Car car;
    private RedCar redCar1, redCar2, redCar3, redCar4;
    //private GreenfootImage title;
    private MouseInfo mouse;
    /*private Background background;

    private int offset = 0;
    private GreenfootImage bgImage;

    public void redrawBackground() {
    drawImage(bgImage, offset, 0);
    }*/
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {    
        /* Creating a new world with 600x400 cells,
         * with a cell size of 1x1 pixels.*/
        super(690, 470, 1);

        gameState = "start";
        //background = new Background();
        title = new Button(
            " Dodge 'em all! ",
            75,
            Color.BLACK,
            Color.RED);
        buttonPlay = new Button(
            " Play ",
            50,
            Color.BLACK,
            Color.GREEN);
        buttonHelp = new Button(
            " Help ",
            50,
            Color.BLACK,
            Color.CYAN);
        buttonPlayAgain = new Button(
            " Play Again ",
            50,
            Color.BLACK,
            Color.MAGENTA);
        car = new Car();
    }

    public void act() {
        mouse = Greenfoot.getMouseInfo();

        switch(gameState) {
            case "start":
                setBackground("carRoadBG.jpg");
                //GreenfootImage.drawRect(getWidth() / 2, 150, 20, 30);
                addObject(title, getWidth() / 2, 80);
                addObject(buttonPlay, 500, 300);
                //addObject(buttonHelp, 500, 350);
                buttonInteract(buttonPlay, "l1Init");
                //buttonInteract(buttonHelp, "end");
                break;

            case "l1Init":
                setBackground("roadBGCropped.png");
                removeObjects(getObjects(Button.class));

                // Creating & placing a car and RedCars
                addObject(car, 75, getHeight() / 2);
                car.setRotation(270);
                
                redCar1 = new RedCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                redCar2 = new RedCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                addObject(
                    redCar1,
                    redCar1.getInitXPos(),
                    redCar1.getInitYPos());
                addObject(
                    redCar2,
                    redCar2.getInitXPos(),
                    redCar2.getInitYPos());
                redCar1.zeroResetPosCounters();
                redCar2.zeroResetPosCounters();

                gameState = "l1";
            
            case "l1":
                car.act();
                redCar1.act();
                redCar2.act();
                if (redCar1.hasCollided(Car.class)
                    || (redCar2.hasCollided(Car.class)))
                    gameState = "end";
                if (redCar1.getResetPosCounterCounter() >= 3) {
                    gameState = "l2Init";
                }
                break;

            case "l2Init":
                setBackground("roadBGCropped.png");
                removeObjects(getObjects(Button.class));

                // Creating & placing a car and RedCars
                addObject(car, 75, getHeight() / 2);
                car.setRotation(270);
                redCar3 = new RedCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                addObject(
                    redCar3,
                    redCar3.getInitXPos(),
                    redCar3.getInitYPos());
                redCar3.zeroResetPosCounters();

                gameState = "l2";
            
            case "l2":
                car.act();
                redCar1.act();
                redCar2.act();
                redCar3.act();
                if (redCar1.hasCollided(Car.class)
                    || (redCar2.hasCollided(Car.class)
                    || (redCar3.hasCollided(Car.class))))
                    gameState = "end";
                if (redCar1.getResetPosCounterCounter() >= 6) {
                    gameState = "l3Init";
                }
                break;
            
            case "l3Init":
                setBackground("roadBGCropped.png");
                removeObjects(getObjects(Button.class));

                // Creating & placing a car and RedCars
                addObject(car, 75, getHeight() / 2);
                car.setRotation(270);
                redCar4 = new RedCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                addObject(
                    redCar4,
                    redCar4.getInitXPos(),
                    redCar4.getInitYPos());
                redCar4.zeroResetPosCounters();

                gameState = "l3";

            case "l3":
                car.act();
                redCar1.act();
                redCar2.act();
                redCar3.act();
                redCar4.act();
                if (redCar1.hasCollided(Car.class)
                    || (redCar2.hasCollided(Car.class)
                    || (redCar3.hasCollided(Car.class)
                    || (redCar4.hasCollided(Car.class)))))
                    gameState = "end";
                break;

            case "end":
                setBackground("you_loseBG.jpg");
                removeObjects(getObjects(Button.class));
                removeObjects(getObjects(Car.class));
                removeObjects(getObjects(RedCar.class));
                addObject(buttonPlayAgain, 330, 380);
                buttonInteract(buttonPlayAgain, "l1Init");
                break;
        }
    }

    private void buttonInteract(Button buttonIn, String gameStateIn) {
        if (mouse != null) {
            Actor interactingActor = mouse.getActor();
            if (interactingActor == buttonIn) {
                buttonIn = (Button) interactingActor;
                if (mouse.getClickCount() == 1)
                    gameState = gameStateIn;
            }
        }
    }
}