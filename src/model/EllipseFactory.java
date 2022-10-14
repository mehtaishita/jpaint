package model;

import model.interfaces.IShapeFactory;
import view.gui.ICanvas;

public class EllipseFactory implements IShapeFactory {
    @Override
    public AShape createShape(ShapeInfo info, ICanvas canvas) {
        return new Ellipse(info,canvas);
    }
}
