package shapes;

import java.awt.*;

/**
 * Created by zw on 2/5/16.
 */
public class Square extends Shape {
    public void display(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x, y, width, width);
    }
}
