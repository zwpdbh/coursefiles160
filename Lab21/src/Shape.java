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

    public Shape() {
        this.width = randomeRange(10, 30);
        this.height = width;
        this.x = randomeRange(0, 400 - width);
        this.y = randomeRange(0, 400 - height);
        this.color = new Color(randomeRange(0,255), randomeRange(0,255), randomeRange(0, 255));
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
}
