package controller;


import model.AShape;
import model.interfaces.IIterator;
import model.persistence.ShapeListManager;
import model.persistence.ShapeList;
import view.mouse.Point;


public class SelectShapes implements ICommand {
    private ShapeList shapeList = ShapeListManager.getShapeList();
    private ShapeList selectedShapes = ShapeListManager.getSelectedShapeList();
    private Point boundaryStart;
    private Point boundaryEnd;

    public SelectShapes(Point start, Point end) {
        selectedShapes.clear();
        boundaryStart = start;
        boundaryEnd = end;
    }

    @Override
    public void run() {
        IIterator iterator = shapeList.getIterator();
        while(iterator.hasNext()){
            AShape current = iterator.getNext();
            if(CollisionDetector.isCollision(current,boundaryStart,boundaryEnd)) {
                selectedShapes.addShape(current);
            }
        }
    }
}