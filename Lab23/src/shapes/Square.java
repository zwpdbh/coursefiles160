package shapes;

import java.awt.*;

/**
 * Created by zw on 2/5/16.
 */
public class Square extends Shape {
    public void display(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}
