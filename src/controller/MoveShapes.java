package controller;

import model.AShape;
import model.interfaces.IIterator;
import model.persistence.CommandHistory;
import model.persistence.ShapeListManager;
import model.persistence.ShapeList;
import view.mouse.Point;

public class MoveShapes implements ICommand, IUndoable {
    private ShapeList selectedShapes = ShapeListManager.getSelectedShapeList();
    private ShapeList shapeList = ShapeListManager.getShapeList();
    private ShapeList movingShapes = ShapeListManager.getMovingShapeList();

    public MoveShapes(Point end) {
        IIterator iterator = selectedShapes.getIterator();
        while(iterator.hasNext()) {
            AShape current = iterator.getNext();
            AShape changed = current.copy();
            int xDelta = end.getX() - current.getStart().getX();
            int yDelta = end.getY() - current.getStart().getY();
            Point newEnd = new Point(current.getEnd().getX() + xDelta,current.getEnd().getY() + yDelta);
            changed.setStart(end);
            changed.setEnd(newEnd);
            movingShapes.addShape(changed);
        }
    }

    @Override
    public void run() {
        IIterator iterator = selectedShapes.getIterator();
        while(iterator.hasNext()) {
            shapeList.removeShape(iterator.getNext());
        }
        IIterator iterator1 = movingShapes.getIterator();
        while (iterator1.hasNext()) {
            shapeList.addShape(iterator1.getNext());
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        IIterator iterator = movingShapes.getIterator();
        while(iterator.hasNext()) {
            shapeList.removeShape(iterator.getNext());
        }
        IIterator iterator1 = selectedShapes.getIterator();
        while (iterator1.hasNext()) {
            shapeList.addShape(iterator1.getNext());
        }
    }

    @Override
    public void redo() {
        IIterator iterator = selectedShapes.getIterator();
        while(iterator.hasNext()) {
            shapeList.removeShape(iterator.getNext());
        }
        IIterator iterator1 = movingShapes.getIterator();
        while (iterator1.hasNext()) {
            shapeList.addShape(iterator1.getNext());
        }
    }
}
