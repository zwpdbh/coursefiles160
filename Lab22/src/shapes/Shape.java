package shapes;

import java.awt.*;
import java.util.Random;

/**
 * Created by wzhao on 2/5/16.
 */
public class Shape {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    private int moveX = 1;
    private int moveY = 1;

    private int change = 1;
    private int size = 0;

    public Shape() {
        this.width = randomeRange(10, 30);
        this.height = width;
        this.size = width;
        this.x = randomeRange(0, 400 - width);
        this.y = randomeRange(0, 400 - height);
        this.color = new Color(randomeRange(0,255), randomeRange(0,255), randomeRange(0, 255));

        // If shapes initially draw in the lower half of the screen, they travel upwards rather then downwards
        if (y > 200) {
            moveY = -1;
        }
    }

    // (10) -> [0, 9],  20-30 -> (30-20)
    public int randomeRange(int lo, int hi) {
        Random generator = new Random();
        return generator.nextInt(hi - lo + 1) + lo;
    }

    public void display(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }


    public void move() {
        // bounce back when meet boundary
        if (y<=0 || y >= (400-height)) {
            moveY = -moveY;
        } else if (x<=0 || x >= (400-width)) {
            moveX = -moveX;
        }
        // size bigger than 15, move up and down, smaller one move left and right
        if (width >= 15) {
            y += moveY;
        } else {
            x += moveX;
            y += moveY;
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

    public String toString() {
        return String.format("x: %d, y: %d, width: %d, height: %d", x, y, width, height);
    }
}
