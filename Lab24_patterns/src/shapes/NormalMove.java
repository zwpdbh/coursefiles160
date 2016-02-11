package shapes;

/**
 * Created by wzhao on 2/11/16.
 */
public class NormalMove implements MoveBehavior{
    public void move() {
                // bounce back when meet boundary
        if (y<=0 || y >= (400-height)) {
            moveY = -moveY;
        } else if (x<=0 || x >= (400-width)) {
            moveX = -moveX;
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
}
