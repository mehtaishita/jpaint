package model;

import model.interfaces.IShapeFactory;
import view.gui.ICanvas;

public class RectangleFactory implements IShapeFactory {
    @Override
    public AShape createShape(ShapeInfo info, ICanvas canvas) {
        return new Rectangle(info,canvas);
    }
}
