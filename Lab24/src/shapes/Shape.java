package shapes;

import java.awt.*;
import java.util.Random;

/**
 * Created by wzhao on 2/5/16.
 */
public abstract class Shape {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;

    protected int moveX = 1;
    protected int moveY = 1;

    private int change = 1;
    private int size = 0;

    public Shape() {
        this.width = randomRange(10, 30);
        this.height = width;
        this.size = width;
        this.x = randomRange(0, 400 - width);
        this.y = randomRange(0, 400 - height);
        this.color = new Color(randomRange(0,255), randomRange(0,255), randomRange(0, 255));

        // If shapes initially draw in the lower half of the screen, they travel upwards rather then downwards
        if (y > 200) {
            moveY = -1;
        }
    }

    public void showIndex(Graphics g, int index) {
        g.setColor(Color.black);
        g.drawString(""+index, x, y);
    }

    // (10) -> [0, 9],  20-30 -> (30-20)
    public int randomRange(int lo, int hi) {
        Random generator = new Random();
        return generator.nextInt(hi - lo + 1) + lo;
    }

   public abstract void display(Graphics g);


//    protected boolean meetBoundary() {
//        if (y<=0 || y >= (400-height)) {
//            return true;
//        } else if (x<=0 || x >= (400-width)) {
//            return true;
//        }
//        return false;
//    }

    public void move() {
        // bounce back when meet boundary
        if (y<=0 || y >= (400-height)) {
            moveY = -moveY;
            this.color = new Color(randomRange(0,255), randomRange(0,255), randomRange(0, 255));
        } else if (x<=0 || x >= (400-width)) {
            moveX = -moveX;
            this.color = new Color(randomRange(0,255), randomRange(0,255), randomRange(0, 255));
        }

        if ((this instanceof Swirl) || (this instanceof Smiley)) {
            y += moveY;
            x += moveX;
        } else {
            if (width >= 15) {
                y += moveY;
            } else {
                x += moveX;
            }

            // every move, the circle should become bigger and smaller
            int bigger = size + 5;
            int smaller = size - 5;

            if (width>=bigger || width<=smaller) {
                change = -change;
            }
            width += change;
            height += change;
        }


    }
    public String toString() {
        return String.format("x: %d, y: %d, width: %d, height: %d", x, y, width, height);
    }
}
