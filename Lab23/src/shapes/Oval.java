package shapes;

import java.awt.*;

/**
 * Created by zw on 2/5/16.
 */
public class Oval extends Circle {
    public Oval() {
        height = width * 4;
        y = super.randomRange(0, 400 - height);
    }
}
