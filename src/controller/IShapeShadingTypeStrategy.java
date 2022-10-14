package controller;

import model.Ellipse;
import model.Rectangle;
import model.Triangle;

public interface IShapeShadingTypeStrategy {
    void draw(Rectangle r);
    void draw(Triangle t);
    void draw(Ellipse e);

}

