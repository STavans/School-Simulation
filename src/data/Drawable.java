package data;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface Drawable {

    void draw(Graphics2D g);
    void setTarget(Point2D point2D);
    Point2D getPosition();
    void setPosition(Point2D position);
}
