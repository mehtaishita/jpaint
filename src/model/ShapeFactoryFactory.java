package model;

import model.interfaces.IShapeFactory;

public class ShapeFactoryFactory {
    public static IShapeFactory getFactory(ShapeType shapeType) {
        IShapeFactory shapeFactory = null;
        switch (shapeType){
            case ELLIPSE:
                shapeFactory = new EllipseFactory();
                break;
            case TRIANGLE:
                shapeFactory = new TriangleFactory();
                break;
            case RECTANGLE:
                shapeFactory = new RectangleFactory();
                break;
        }
        return shapeFactory;
    }
}
