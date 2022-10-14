package model;

import model.interfaces.IShapeFactory;
import view.gui.ICanvas;

public class TriangleFactory implements IShapeFactory {
    @Override
    public AShape createShape(ShapeInfo info, ICanvas canvas) {
        return new Triangle(info,canvas);
    }
}
