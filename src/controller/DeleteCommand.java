package controller;

import model.AShape;
import model.interfaces.IIterator;
import model.persistence.CommandHistory;
import model.persistence.ShapeList;
import model.persistence.ShapeListManager;

//deletes selected shapes
public class DeleteCommand implements ICommand,IUndoable {
    private ShapeList shapeList = ShapeListManager.getShapeList();
    private ShapeList selectedShapes = ShapeListManager.getSelectedShapeList();
    private ShapeList movingShapes = ShapeListManager.getMovingShapeList();

    @Override
    public void run() {
        IIterator iterator = selectedShapes.getIterator();
        while(iterator.hasNext()) {
            AShape current = iterator.getNext();
            shapeList.removeShape(current);
        }
        IIterator iterator1 = movingShapes.getIterator();
        while(iterator1.hasNext()) {
            AShape current = iterator1.getNext();
            shapeList.removeShape(current);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        IIterator iterator = selectedShapes.getIterator();
        while(iterator.hasNext()) {
            AShape current = iterator.getNext();
            shapeList.addShape(current);
        }
    }

    @Override
    public void redo() {
        IIterator iterator = selectedShapes.getIterator();
        while(iterator.hasNext()) {
            AShape current = iterator.getNext();
            shapeList.removeShape(current);
        }
    }
}
