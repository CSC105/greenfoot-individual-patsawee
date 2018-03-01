import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int spawnCandyTimer = 0;
    private int spawnRockTimer = 0;
    private final int spawnCandyTime = 100;
    
    public MyWorld()
    {    
        super(600, 400, 1); 
        prepare();
        Greenfoot.playSound("medcalpath.mp3");
    }
    
    private void prepare()
    {
        this.spawnCandyTimer = this.spawnCandyTime;
        this.spawnRockTimer = Greenfoot.getRandomNumber(200) + 100;
        showText("SCORE : 0", 50, 20);

        Flamingo flamingo = new Flamingo();
        addObject(flamingo, 57,330);
    }
    
    public void act() {
        this.spawnCandyTimer--;
        this.spawnRockTimer--;
        if(this.spawnCandyTimer <= 0) {
            spawnCandy();
        }
        
        if(this.spawnRockTimer <= 0) {
            spawnRock();
        }
    }
    
    private void spawnCandy() {
        Candy candy = new Candy();
        int posY = Greenfoot.getRandomNumber(120) + 100;
        addObject(candy, 600, posY);
        this.spawnCandyTimer = this.spawnCandyTime;
    }
    
    private void spawnRock() {
        Rock rock = new Rock();
        addObject(rock, 600, 377);
        this.spawnRockTimer = Greenfoot.getRandomNumber(200) + 100;
    }
}
