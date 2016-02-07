package shapes;

import java.awt.*;
import java.util.Random;

/**
 * Created by wzhao on 2/5/16.
 */
abstract class Shape {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;

    protected int moveX = 1;
    protected int moveY = 1;

    public Shape() {
        this.width = randomRange(10, 30);
        this.height = width;
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

    abstract void display(Graphics g);


    public void move() {
        // bounce back when meet boundary
        if (y<=0 || y >= (400-height)) {
            moveY = -moveY;
        } else if (x<=0 || x >= (400-width)) {
            moveX = -moveX;
        }

        if (!(this instanceof Swirl) && !(this instanceof Smiley)) {
            // size bigger than 15, move up and down, smaller one move left and right
            if (width >= 15) {
                y += moveY;
            } else {
                x += moveX;
            }
        } else {
            y += moveY;
            x += moveX;
        }


    }
    public String toString() {
        return String.format("x: %d, y: %d, width: %d, height: %d", x, y, width, height);
    }
}
