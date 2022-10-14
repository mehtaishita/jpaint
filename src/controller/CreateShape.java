package controller;

import model.*;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeFactory;
import model.persistence.CommandHistory;
import model.persistence.ShapeList;
import model.persistence.ShapeListManager;
import view.gui.ICanvas;
import view.mouse.Point;

public class CreateShape implements ICommand, IUndoable{
    private ShapeInfo shapeInfo;
    private ICanvas paintCanvas;
    private ShapeList shapeList = ShapeListManager.getShapeList();
    private AShape shape;


    public CreateShape(Point start, Point end, IApplicationState applicationState, ICanvas paintCanvas) {
        ShapeConfiguration config = new ShapeConfiguration(applicationState.getActivePrimaryColor(),
                applicationState.getActiveSecondaryColor(),
                applicationState.getActiveShapeShadingType(),
                applicationState.getActiveShapeType());
        shapeInfo = new ShapeInfo(start,end,config);
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        IShapeFactory factory = ShapeFactoryFactory.getFactory(shapeInfo.getShapeConfiguration().getShapeType());
        shape = factory.createShape(shapeInfo,paintCanvas);
        shapeList.addShape(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShape(shape);
    }

    @Override
    public void redo() {
        shapeList.addShape(shape);
    }
}
