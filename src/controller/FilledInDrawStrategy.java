package controller;

import model.*;
import model.Rectangle;

import java.awt.*;

public class FilledInDrawStrategy implements IShapeShadingTypeStrategy {
    private ShapeColorMap colorMap = ShapeColorMap.getInstance();
    @Override
    public void draw(Rectangle r) {
        DrawingCalculations calc = new DrawingCalculations(r.getStart(),r.getEnd());
        Graphics2D graphics2D = r.getPaintCanvas().getGraphics2D();
        graphics2D.setColor(colorMap.get(r.getPrimaryColor()));
        graphics2D.fillRect(calc.getX(),calc.getY(),calc.getW(),calc.getH());
    }

    @Override
    public void draw(Triangle t) {
        int[] x = new int[]{t.getStart().getX(),t.getStart().getX(),t.getEnd().getX()};
        int[] y = new int[]{t.getStart().getY(),t.getEnd().getY(),t.getEnd().getY()};
        Graphics2D graphics2D = t.getPaintCanvas().getGraphics2D();
        graphics2D.setColor(colorMap.get(t.getPrimaryColor()));
        graphics2D.fillPolygon(x,y,3);
    }

    @Override
    public void draw(Ellipse e) {
        DrawingCalculations calc = new DrawingCalculations(e.getStart(),e.getEnd());
        Graphics2D graphics2D = e.getPaintCanvas().getGraphics2D();
        graphics2D.setColor(colorMap.get(e.getPrimaryColor()));
        graphics2D.fillOval(calc.getX(),calc.getY(),calc.getW(),calc.getH());
    }
}
