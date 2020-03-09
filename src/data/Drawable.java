package data;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface Drawable {
    void update(ArrayList<Person> people);
    void draw(Graphics2D g);
    void setTarget(Point2D point2D);
    Point2D getPosition();
}
