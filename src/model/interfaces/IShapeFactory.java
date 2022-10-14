package model.interfaces;

import model.AShape;
import model.ShapeInfo;
import view.gui.ICanvas;

public interface IShapeFactory {
    AShape createShape(ShapeInfo info, ICanvas canvas);
}
