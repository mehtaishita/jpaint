package model;

import controller.ShapeConfiguration;
import view.gui.ICanvas;
import view.mouse.Point;

public class Ellipse extends AShape{

    public Ellipse (ShapeInfo info, ICanvas paintCanvas) {
        super(info,paintCanvas);
    }

    @Override
    public void draw() {
        strategy.draw(this);
    }

    public AShape copy() {
        return new Ellipse(new ShapeInfo(new Point(this.start.getX(),this.start.getY()),
                                        new Point(this.end.getX(),this.end.getY()),
                                        new ShapeConfiguration(this.config.getPrimaryColor(),this.config.getSecondaryColor(),this.config.getShadingType(),this.config.getShapeType())),
                                        this.paintCanvas);
    }
}
