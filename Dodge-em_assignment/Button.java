import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    boolean state;
    String text;
    int textSize;

    Button() {
        this("Button", 40, false);
    }

    Button(String textIn, int textSizeIn,  boolean stateIn) {
        text = textIn;
        textSize = textSizeIn;
        //state = stateIn;
        if (stateIn)
            buttonOn();
        else
            buttonOff();
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void buttonOff() {
        GreenfootImage buttonImage = new GreenfootImage(
                                            text,
                                            textSize,
                                            Color.GREEN,
                                            Color.BLACK);
        setImage(buttonImage);
        state = false;
    }
    
    public void buttonOn() {
        GreenfootImage buttonImage = new GreenfootImage(
                                            text,
                                            textSize,
                                            Color.BLACK,
                                            Color.GREEN);
        setImage(buttonImage);
        state = true;
    }

    public void buttonToggle() {
        if (state)
            buttonOff();
        else
            buttonOn();
        //state = !state;
    }
}