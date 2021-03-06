package shapes;

import java.awt.*;


/**
 * Created by zw on 2/5/16.
 */
public class Smiley extends Shape {

    private final int width = height = 30;

    public void display(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, width, height);
        g.setColor(Color.black);
        g.fillOval(x+7, y+8, 4, 4);
        g.fillOval(x+20, y+8, 4, 4);
        if (moveY > 0) {
            g.fillArc(x+8, y+15, 15, 13, -10, 200);
        } else {
            g.fillArc(x+8, y+10, 15, 13, 190, 160);
        }
    }
}
