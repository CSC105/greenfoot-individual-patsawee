import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flamingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamingo extends Character
{
    private final int GRAVITY = 1;
    private int velocity;
    private int score = 0;
    
    public Flamingo(){
        velocity = 0;
    }
    public void act() 
    {
        if(isTouching(Rock.class)) {
            Greenfoot.stop();
            getWorld().addObject(new GameOver(), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
        else {
            fall();
            if(Greenfoot.isKeyDown("space")
            && getY() > getWorld().getHeight() - 80) {
                jump();
            }  
            if(isTouching(Candy.class)) {
                removeTouching(Candy.class);
                score++;
                
                this.updateScore();
            }
        }
        
    }
    public void fall(){
        setLocation(getX(), getY() + velocity);
        
        if(getY() > getWorld().getHeight() - 80) {
            velocity = 0;
        }
        else {
            velocity += GRAVITY;
        }
    }
    public void jump(){
        velocity = -20;
        
    }
    
    private void updateScore() {
        getWorld().showText("SCORE : " + score, 50, 20);
    }
}
