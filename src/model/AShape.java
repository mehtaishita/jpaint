package model;

import controller.IShapeShadingTypeStrategy;
import controller.ShapeConfiguration;
import view.gui.ICanvas;
import view.mouse.Point;

import java.awt.*;

public abstract class AShape {
    protected ShapeConfiguration config;
    protected Graphics2D graphics2d;
    protected ICanvas paintCanvas;
    protected ShapeColor primaryColor;
    protected ShapeColor secondaryColor;
    protected ShapeShadingType shadingType;
    protected Point start;
    protected Point end;
    protected IShapeShadingTypeStrategy strategy;
    StrategyFactory strategyFactory = new StrategyFactory();

    public AShape (ShapeInfo info, ICanvas paintCanvas) {
        this.config = info.getShapeConfiguration();
        graphics2d = paintCanvas.getGraphics2D();
        this.paintCanvas = paintCanvas;
        this.primaryColor = info.getShapeConfiguration().getPrimaryColor();
        this.secondaryColor = info.getShapeConfiguration().getSecondaryColor();
        this.shadingType = info.getShapeConfiguration().getShadingType();
        this.start = info.getStart();
        this.end = info.getEnd();

        strategy = strategyFactory.createStrategy(shadingType);
    }

    public abstract void draw();

    public abstract AShape copy();

    public Graphics2D getGraphics2d() {
        return graphics2d;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public ICanvas getPaintCanvas() {
        return paintCanvas;
    }

    public Point getStart() { return start; }

    public Point getEnd() {
        return end;
    }

    public String toString() {
        return "Shape " + start.toString();
    }

    public void translate(int xDelta, int yDelta) {
        start = new Point(start.getX() + xDelta,start.getY() + yDelta);
        end = new Point(end.getX() + xDelta, end.getY() + yDelta);
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
