package shapes;

import java.awt.*;

/**
 * Created by zw on 2/5/16.
 */
public class Circle extends Shape {

    public void display(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
