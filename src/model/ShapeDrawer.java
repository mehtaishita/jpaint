package model;

import model.interfaces.IObserver;
import model.interfaces.IIterator;
import model.persistence.ShapeList;
import model.persistence.ShapeListManager;
import view.gui.ICanvas;

import java.awt.*;

public class ShapeDrawer implements IObserver {
    private ShapeList shapeList = ShapeListManager.getShapeList();
    private ICanvas paintCanvas;
    private ShapeColorMap colorMap = ShapeColorMap.getInstance();

    public ShapeDrawer(ICanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void update() {
        clearCanvas();
        IIterator iterator = shapeList.getIterator();
        while (iterator.hasNext()) {
            iterator.getNext().draw();
        }
    }

    private void clearCanvas() {
        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(colorMap.get(ShapeColor.WHITE));
        graphics2D.fillRect(0,0,1200,800);
    }
}
