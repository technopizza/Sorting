package goldandglory;


import org.newdawn.slick.Animation;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.SpriteSheet;

import org.newdawn.slick.geom.Rectangle;

import org.newdawn.slick.geom.Shape;


public class Enemy {
    private static int numberOfEnemies = 0;
    private int id;
    boolean[][] eblocked = Blocked.getblocked();
    private Animation skeleton, skup, skdown, skleft, skright, skwait, skdead, shootUp, shootDown, shootRight, shootLeft;
    int SIZE = 64;
    //static int crewsize;
 boolean isMove;
    float Bx;
    float By;
    float projectedright;
    float projectedleft;
    float projecteddown;
    float projectedup;
    boolean canmove;
    boolean cangoright;
    boolean cangoleft;
    boolean cangoup;
    boolean cangodown;
    int health = 100;
    Animation currentanime = new Animation();
    private float fdelta;
    int MapWidth = 50;
    int MapHeight = 100;
    double rightlimit = (MapWidth * SIZE) - (SIZE * 0.75);
    double downlimit = (MapHeight * SIZE) - (SIZE * 0.75);
    private boolean icangoup;
    private boolean icangodown;
    private boolean icangoleft;
    private boolean icangoright;
  private boolean isAlive;
    private int startX, startY, width = 62, height = 62;
    float hitboxX = this.Bx;

    float hitboxY = this.By;

    String direction = "down";
    
    public Shape rect;

    

    Direction mydirection;




    Enemy(int a, int b, String dir,boolean canMove) throws SlickException {


        Bx = a;

        By = b;

        hitboxX = this.getskhitboxX();

        hitboxY = this.getskhitboxY();

        rect = new Rectangle(hitboxX, hitboxY, width, height);

        direction = dir;

        int BHealth;
        
        this.isAlive=true;

        boolean isBAlive = true;

        canmove = canMove;

        currentanime = skwait;

        id = ++numberOfEnemies;

        this.mydirection = Direction.WAIT;


        SpriteSheet skeletonSS = new SpriteSheet("res/indianBow.png", 64, 64, 0);

        skup = new Animation();

        skup.setAutoUpdate(true);

        skup.addFrame(skeletonSS.getSprite(0, 8), 330);

        skup.addFrame(skeletonSS.getSprite(1, 8), 330);

        skup.addFrame(skeletonSS.getSprite(2, 8), 330);

        skup.addFrame(skeletonSS.getSprite(3, 8), 330);

        skup.addFrame(skeletonSS.getSprite(4, 8), 330);

        skup.addFrame(skeletonSS.getSprite(5, 8), 330);

        skup.addFrame(skeletonSS.getSprite(6, 8), 330);

        skup.addFrame(skeletonSS.getSprite(7, 8), 330);

        skup.addFrame(skeletonSS.getSprite(8, 8), 330);

        shootUp = new Animation();

        shootUp.setAutoUpdate(true);

        shootUp.addFrame(skeletonSS.getSprite(0, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(1, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(2, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(3, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(4, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(5, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(6, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(7, 16), 330);

        shootUp.addFrame(skeletonSS.getSprite(8, 16), 330);

        skdown = new Animation();

        skdown.setAutoUpdate(false);

        skdown.addFrame(skeletonSS.getSprite(0, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(1, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(2, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(3, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(4, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(5, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(6, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(7, 10), 330);

        skdown.addFrame(skeletonSS.getSprite(8, 10), 330);

shootDown = new Animation();

        shootDown.setAutoUpdate(true);

        shootDown.addFrame(skeletonSS.getSprite(0, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(1, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(2, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(3, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(4, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(5, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(6, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(7, 18), 200);

        shootDown.addFrame(skeletonSS.getSprite(8, 18), 200);
        
        
        skleft = new Animation();

        skleft.setAutoUpdate(false);

        skleft.addFrame(skeletonSS.getSprite(0, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(1, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(2, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(3, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(4, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(5, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(6, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(7, 9), 330);

        skleft.addFrame(skeletonSS.getSprite(8, 9), 330);

shootLeft = new Animation();

        shootLeft.setAutoUpdate(true);

        shootLeft.addFrame(skeletonSS.getSprite(0, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(1, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(2, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(3, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(4, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(5, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(6, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(7, 17), 330);

        shootLeft.addFrame(skeletonSS.getSprite(8, 17), 330);
        
        
        skright = new Animation();

        skright.setAutoUpdate(false);

        skright.addFrame(skeletonSS.getSprite(0, 11), 330);

        skright.addFrame(skeletonSS.getSprite(1, 11), 330);

        skright.addFrame(skeletonSS.getSprite(2, 11), 330);

        skright.addFrame(skeletonSS.getSprite(3, 11), 330);

        skright.addFrame(skeletonSS.getSprite(4, 11), 330);

        skright.addFrame(skeletonSS.getSprite(5, 11), 330);

        skright.addFrame(skeletonSS.getSprite(6, 11), 330);

        skright.addFrame(skeletonSS.getSprite(7, 11), 330);

        skright.addFrame(skeletonSS.getSprite(8, 11), 330);

        
        shootRight = new Animation();

        shootRight.setAutoUpdate(true);

        shootRight.addFrame(skeletonSS.getSprite(0, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(1, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(2, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(3, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(4, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(5, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(6, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(7, 19), 330);

        shootRight.addFrame(skeletonSS.getSprite(8, 19), 330);
        
        
        

        skwait = new Animation();

        skwait.setAutoUpdate(true); //turn autoupdate to false so he stops

        skwait.addFrame(skeletonSS.getSprite(0, 14), 733);

        skwait.addFrame(skeletonSS.getSprite(1, 14), 733);

        skwait.addFrame(skeletonSS.getSprite(2, 14), 733);

        skwait.addFrame(skeletonSS.getSprite(3, 14), 733);

        

        skdead = new Animation();

        skdead.setAutoUpdate(false); //turn autoupdate to false so he stops

        skdead.addFrame(skeletonSS.getSprite(2, 20), 733);

        skdead.addFrame(skeletonSS.getSprite(3, 20), 733);

        skdead.addFrame(skeletonSS.getSprite(4, 20), 733);

        skdead.addFrame(skeletonSS.getSprite(5, 20), 733);

        

        currentanime = skwait;


    }
    
   

    boolean isBlocked(float xcheck, float ycheck) {

        // System.out.println("The skeleton " + this.getID() + " Checking on the tile at x " + xcheck + " and at y " + ycheck);

        int xBlock = (int) (xcheck / SIZE);

        int yBlock = (int) (ycheck / SIZE);


        if ((xBlock < MapWidth && yBlock < MapHeight) && (xBlock > 0

                && yBlock > 0)) {


            // System.out.println("Am I blocked ? " + blocked.blocked[xBlock][yBlock] );

            return Blocked.blocked[xBlock][yBlock];

        } else {

            return true;

        }

    }


    private boolean canigoup() {

        fdelta = Player.getpdelta();

        return (!isBlocked(this.Bx, this.By - fdelta)

                || !isBlocked(this.Bx + SIZE - 1, this.By - fdelta));

    }


    private boolean canigodown() {

        fdelta = Player.getpdelta();

        return ((!isBlocked(this.Bx, this.By + SIZE + 8)

                || !isBlocked(this.Bx + SIZE - 1, this.By + SIZE + fdelta)));


    }


    private boolean canigoright() {

        // fdelta = player.getpdelta();

        //System.out.println("Can I go right? " + (!isBlocked(this.Bx + SIZE + fdelta, this.By) || !isBlocked(this.Bx + SIZE + fdelta, this.By - 1)));

        return (!isBlocked(this.Bx + SIZE + 6, this.By - 16)

                || !isBlocked(this.Bx + SIZE + 16, this.By));

        //return true;       


    }


    private boolean canigoleft() {

        fdelta = Player.getpdelta();

        //if (!(!isBlocked(this.Bx - SIZE, this.By) || !isBlocked(this.Bx - fdelta, this.By + SIZE - 16)) || !isBlocked(this.Bx, this.By + SIZE/2) || !isBlocked(this.Bx -16, this.By -64))

        //{System.out.println("I can't go left. My id is " + this.getID());

        // }   

        //{}

        return (!isBlocked(this.Bx - SIZE / 2, this.By + SIZE / 2)

                || !isBlocked(this.Bx - SIZE, this.By)

                || !isBlocked(this.Bx - fdelta, this.By + SIZE - 16) //|| !isBlocked(this.Bx, this.By + SIZE/2)

                // || !isBlocked(this.Bx -16, this.By -64)

                // || !isBlocked(this.Bx + 9, this.By + 8)

                );


        //|| !isBlocked(this.Bx + SIZE/2 -1,this.By + SIZE )));

    }


    void moveup() throws SlickException {

        if (this.canigoup()) {


            fdelta = Player.getpdelta();

            this.currentanime = skup;

            this.By -= fdelta / 2;

            this.rect.setLocation(this.Bx, this.By);

        } else {

            this.currentanime = skwait;

        }

    }


    void movedown() throws SlickException {

        if (this.canigodown()) {

            fdelta = Player.getpdelta();

            this.currentanime = skdown;

            this.By += fdelta / 2;

            this.rect.setLocation(this.Bx, this.By);

        }

    }


    void moveleft() throws SlickException {

        if (this.canigoleft()) {

            fdelta = Player.getpdelta();

            this.currentanime = skleft;

            this.Bx -= fdelta / 2;

            this.rect.setLocation(this.Bx, this.By);

        }

    }


    void moveright() throws SlickException {

        if (this.canigoright()) {

            fdelta = Player.getpdelta();

            this.currentanime = skright;

            this.Bx += fdelta / 2;

            this.rect.setLocation(this.Bx, this.By);

        }

    }


    void setdirection() {

        if (Player.getplayersY() < this.By) {

            this.mydirection = Direction.UP;

        }

        if ((Player.getplayersY() > this.By)) {

            this.mydirection = Direction.DOWN;

        }

        if ((Player.getplayersX() > this.Bx)) {

            this.mydirection = Direction.RIGHT;

        }

        if ((Player.getplayersX() < this.Bx) && canigoleft()) {

            this.mydirection = Direction.LEFT;

        } else {

            this.mydirection = Direction.DOWN;

        }

    }

    
    void configBow(){
        if(this.direction == "up"){
            this.currentanime = shootUp;
        }
        else if(this.direction == "down"){
            this.currentanime = shootDown;
        }
        else if(this.direction == "left"){
            this.currentanime = shootLeft;
        }
        else if(this.direction == "right"){
            this.currentanime = shootRight;
        }
    }

    
    
    void move() throws SlickException {

        //float fdelta = 18 * 0.1f;

        
if (this.canmove){
        if (true){

        if (this.Bx > Player.getplayersX()) {

            this.moveleft();

        } else if (this.Bx < Player.getplayersX()) {

            this.moveright();

            // System.out.println("I'm moving right. My id is " + this.getID() + " My x is " + this.Bx + " and my Y is " + this.By);

            //System.out.println("By the way the player's X is " + player.x + " and the player's Y " + player.y);


        } else {//System.out.println("I can't move left or right. My x is " + this.Bx + " and my Y is " + this.By);

        }


        if (this.By > Player.getplayersY()) {

            this.moveup();

        } else if (this.By < Player.getplayersY()) {

            this.movedown();

        } else {

            int r = (int) (Math.random() * (5 - 1)) + 1;

            //System.out.println("The number is : " + r);

            if (r == 1) {

                this.moveup();

            } else if (r == 2) {

                this.movedown();

            } else if (r == 3) {

                this.moveleft();

            } else if (r == 4) {

                this.moveright();

            }

        }

    } else {this.currentanime = skdead;}

    }
}
    

    
    
    public float getskX() {

        return this.Bx;

    }


    public float getskY() {

        return this.By;

    }


    public float getskhitboxX() {

        return this.Bx +1;

    }


    public float getskhitboxY() {

        return this.By +1;

    }


    public void setskhitboxX(float cBx) {

        this.hitboxX = cBx;

    }


    public void setskhitboxY(float cBy) {

        this.hitboxY = cBy;

    }


    public int getID() {

        return id;

    }


    public static int getNumberOfEnemies() {

        return numberOfEnemies;

    }
public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }


    //System.out.println("Right limit: " + rightlimit);

    public enum Direction {


        UP, DOWN, LEFT, RIGHT, WAIT

    }


}
//for (Obama i : obamas) {
//
//            if (Player.rect.intersects(i.hitbox)) {
//                //System.out.println("yay");
//                if (i.isvisible) {
//
//                    Player.speed = .5f;
//                    i.isvisible = false;
//                }
//
//            }
//        }
//
//        for (Item i : stuff) {
//
//            if (Player.rect.intersects(i.hitbox)) {
//                //System.out.println("yay");
//                if (i.isvisible) {
//
//                    Player.health += 10000;
//                    i.isvisible = false;
//                }
//
//            }
//        }
//
//        for (Item1 h : stuff1) {
//
//            if (Player.rect.intersects(h.hitbox)) {
//                //System.out.println("yay");
//                if (h.isvisible) {
//
//                    Player.speed += 0.2f;
//                    h.isvisible = false;
//                }
//
//            }
//        }
//
//        for (ItemWin w : stuffwin) {
//
//            if (Player.rect.intersects(w.hitbox)) {
//                //System.out.println("yay");
//                if (w.isvisible) {
//                    w.isvisible = false;
//                    makevisible();
//                    sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
//
//                }
//
//            }
//        }