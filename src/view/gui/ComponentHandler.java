package view.gui;

import model.ShapeDrawer;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ComponentHandler extends ComponentAdapter {
    private ShapeDrawer shapeDrawer;

    public ComponentHandler(ShapeDrawer shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        shapeDrawer.update();
    }
}
