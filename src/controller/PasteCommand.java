package controller;

import model.AShape;
import model.interfaces.IIterator;
import model.persistence.CommandHistory;
import model.persistence.ShapeList;
import model.persistence.ShapeListManager;

//pastes copied shapes
public class PasteCommand implements ICommand,IUndoable{
    private ShapeList shapeList = ShapeListManager.getShapeList();
    private ShapeList copiedShapes = ShapeListManager.getClipboardShapeList();

    public PasteCommand() {
    }

    @Override
    public void run() {
        IIterator iterator = copiedShapes.getIterator();
        while(iterator.hasNext()) {
            shapeList.addShape(iterator.getNext());
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        IIterator iterator = copiedShapes.getIterator();
        while (iterator.hasNext()) {
            shapeList.removeShape(iterator.getNext());
        }
    }

    @Override
    public void redo() {
        IIterator iterator = copiedShapes.getIterator();
        while(iterator.hasNext()) {
            shapeList.addShape(iterator.getNext());
        }
    }
}
