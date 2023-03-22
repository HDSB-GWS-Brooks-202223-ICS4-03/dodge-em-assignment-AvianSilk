import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates images that look like buttons on the screen.
 * Using mouse info, objects of this class can switch game states.
 * This class has also been used to make Title images which don't
 * function as buttons.
 * 
 * @author Venkata Adapala (@AvianSilk) 
 * @version 12-03-2023
 */
public class Button extends Actor {
    String text;
    int textSize;
    Color textColor, bgColor;

    /**
     * Creates a new instance of a Button with
     * certain default values such as:
     * Text to be displayed, Text size,
     * foreground and background colors
     */
    public Button() {
        this("Button", 40, Color.GREEN, Color.BLACK);
    }

    /**
     * Creates a new instance of a Button with the
     * main values derived from the parameters
     * 
     * @param textIn The text to be displayed
     * @param textSizeIn The size of the display text
     * @param textColorIn The color of the text (foreground)
     * @param bgColorIn The color of the background of the text
     */
    public Button(String textIn, int textSizeIn, Color textColorIn, Color bgColorIn) {
        text = textIn;
        textSize = textSizeIn;
        textColor = textColorIn;
        bgColor = bgColorIn;
        createButton();
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }

    /**
     * This method creates a GreenfootImage using the input values
     * given by the user in the Constructor, and then sets it to
     * the object, therefore giving it the appearance of a button
     */
    public void createButton() {
        GreenfootImage buttonImage = new GreenfootImage(
                                            text,
                                            textSize,
                                            textColor,
                                            bgColor);
        setImage(buttonImage);
    }
}