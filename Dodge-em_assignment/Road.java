import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A description of class Road:
 * 
 * This is the World class i.e. where all of my actors are placed.
 * There are various game states and various instances of the same
 * kind of objects.
 * 
 * @author Venkata (@AvianSilk) 
 * @version 12-03-2023
 */
public class Road extends World {
    private String gameState;
    private Button 
            title, // The title of the game
            buttonPlay, // The Play button on the start screen
            buttonHelp, // The Help button on the start screen
            buttonPlayAgain, // The Play Again button on the end screen
            buttonScore; // The score being displayed all the time
    private PlayerCar car; // The player-controlled car
    //Four instances of an obstacle car
    private ObstacleCar obsCar1, obsCar2, obsCar3, obsCar4;
    private Barrier barrier1; // An instance of a barrier
    private MouseInfo mouse; // For button interaction
    private int score; // The score (essentially a timer)
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Road() {    
        /* Creating a new world with 600x400 cells,
         * with a cell size of 1x1 pixels.*/
        super(690, 470, 1, false);

        gameState = "start";
        
        // Creating most of the buttons & display images
        title = new Button(
            " Dodge 'em all! ",
            75,
            Color.BLACK,
            Color.RED);
        buttonPlay = new Button(
            " Play ",
            60,
            Color.BLACK,
            Color.GREEN);
        buttonHelp = new Button(
            " Help ",
            60,
            Color.BLACK,
            Color.CYAN);
        buttonPlayAgain = new Button(
            " Play Again ",
            50,
            Color.BLACK,
            Color.MAGENTA);
        
        car = new PlayerCar(); // Creating the player-controlled car
    }

    public void act() {
        mouse = Greenfoot.getMouseInfo();

        // Stopping it at the end screen to display the score properly
        if (gameState != "end")
            score++; // Creating the score by using it as a timer

        // The score button needs to be created constantly to be updated
        buttonScore = new Button(
                " Score: " + Integer.toString(score) + " ",
                40,
                Color.RED,
                Color.DARK_GRAY);

        switch(gameState) {
            case "start":
                
                setBackground("roadBG.png");
                
                addObject(title, 345, 100);
                addObject(buttonPlay, 345, 300);
                addObject(buttonHelp, 345, 380);
                
                buttonInteract(buttonPlay, "level1Init");
                buttonInteract(buttonHelp, "help");

                break;
                
            case "help":
                setBackground("helpBG.png");
                // Removing previous objects
                removeObjects(getObjects(Button.class));
                // And then adding
                addObject(buttonPlay, 345, 400);
                
                buttonInteract(buttonPlay, "level1Init");
        
                break;

            case "level1Init":
                // Zeroing the score at the beginning of the game
                score = 0;
                
                setBackground("roadBG.png");
                
                removeObjects(getObjects(Button.class));

                // Creating & placing a car and ObstacleCars
                addObject(car, 75, getHeight() / 2);
                car.setRotation(270);
                
                obsCar1 = new ObstacleCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                obsCar2 = new ObstacleCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                addObject(
                    obsCar1,
                    obsCar1.getInitXPos(),
                    obsCar1.getInitYPos());
                addObject(
                    obsCar2,
                    obsCar2.getInitXPos(),
                    obsCar2.getInitYPos());
                obsCar1.zeroCounters();
                obsCar2.zeroCounters();
                // Creating and using two obstacle cars since it's level 1

                gameState = "level1";
            
            case "level1":
                
                addObject(buttonScore,585, 25); // The score display
        
                car.act();
                obsCar1.act();
                obsCar2.act();
                // If the car collides with an obstacle,
                // the end screen is brought up
                if (obsCar1.hasCollided(PlayerCar.class)
                    || (obsCar2.hasCollided(PlayerCar.class)))
                    gameState = "end";
                // The next level is introduced once the player crosses
                // a score of 500
                if (score >= 500) {
                    gameState = "level2Init";
                }
        
                break;

            case "level2Init":
        
                setBackground("roadBG.png");
                removeObjects(getObjects(Button.class));

                // Creating & placing a car and ObstacleCars
                addObject(car, 75, getHeight() / 2);
                car.setRotation(270);
                obsCar3 = new ObstacleCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                obsCar3.setImage("car01.png");
                addObject(
                    obsCar3,
                    obsCar3.getInitXPos(),
                    obsCar3.getInitYPos());
                obsCar3.zeroCounters();
                // A third obstacle car is introduced in this new level

                gameState = "level2";
            
            case "level2":
                
                addObject(buttonScore, 585, 25);
                
                car.act();
                obsCar1.act();
                obsCar2.act();
                obsCar3.act();
                //Collision detection
                if (obsCar1.hasCollided(PlayerCar.class)
                    || (obsCar2.hasCollided(PlayerCar.class)
                    || (obsCar3.hasCollided(PlayerCar.class))))
                    gameState = "end";
                // Moving to level 3
                if (score >= 1000) {
                    gameState = "level3Init";
                }
                break;
            
            case "level3Init":
                setBackground("roadBG.png");
                removeObjects(getObjects(Button.class));

                // Creating & placing a car and ObstacleCars
                addObject(car, 75, getHeight() / 2);
                car.setRotation(270);
                obsCar4 = new ObstacleCar(
                                625,
                                Greenfoot.getRandomNumber(440));
                obsCar4.setImage("car01.png");
                barrier1 = new Barrier(
                                625,
                                Greenfoot.getRandomNumber(440));
                addObject(
                    obsCar4,
                    obsCar4.getInitXPos(),
                    obsCar4.getInitYPos());
                addObject(
                    barrier1,
                    barrier1.getInitXPos(),
                    barrier1.getInitYPos());
                obsCar4.zeroCounters();
                // Adding a fourth car and the barrier in this level

                gameState = "level3";

            case "level3":
                addObject(buttonScore, 585, 25);
    
                car.act();
                obsCar1.act();
                obsCar2.act();
                obsCar3.act();
                obsCar4.act();
                barrier1.act();
        
                // Collision detection
                if (obsCar1.hasCollided(PlayerCar.class)
                    || (obsCar2.hasCollided(PlayerCar.class)
                    || (obsCar3.hasCollided(PlayerCar.class)
                    || (obsCar4.hasCollided(PlayerCar.class)
                    || (barrier1.hasCollided(PlayerCar.class))))))
                    gameState = "end";

                break;

            case "end":
        
                setBackground("you_loseBG.jpg");
            
                removeObjects(getObjects(Button.class));
                removeObjects(getObjects(PlayerCar.class));
                removeObjects(getObjects(ObstacleCar.class));
                removeObjects(getObjects(Barrier.class));
            
                addObject(buttonScore, 330, 320);
                addObject(buttonPlayAgain, 330, 380);

                // The play again button
                buttonInteract(buttonPlayAgain, "level1Init");
                
                break;
        }
    }

    /**
     * This method takes a button, checks if the mouse is clicking it,
     * and if it is, then switches the gameState to whatever was given
     * 
     * @param buttonIn The button
     * @param gameStateIn The resultant gameState 
     */
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