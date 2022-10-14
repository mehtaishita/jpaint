package controller;

import model.AShape;
import model.interfaces.IIterator;
import model.persistence.ShapeList;
import model.persistence.ShapeListManager;

public class CopyCommand implements ICommand {
    private ShapeList copiedShapeList = ShapeListManager.getClipboardShapeList();
    private ShapeList selectedShapes = ShapeListManager.getSelectedShapeList();

    @Override
    public void run() {
        IIterator iterator = selectedShapes.getIterator();
        if (iterator.hasNext()) {
            AShape current = iterator.getNext().copy();
            current.translate(10,10);
            copiedShapeList.addShape(current);
        }
    }
}
