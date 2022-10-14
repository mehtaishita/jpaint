package controller;

import model.AShape;
import model.DrawingCalculations;
import view.mouse.Point;

import java.awt.*;

public class CollisionDetector {
    private static Graphics2D graphics2D;

    public static boolean isCollision(AShape current, Point boundaryStart, Point boundaryEnd) {
        graphics2D = current.getGraphics2d();
        DrawingCalculations calc = new DrawingCalculations(boundaryStart,boundaryEnd);
        graphics2D.setClip(calc.getX(),calc.getY(),calc.getW(),calc.getH());
        calc.setNewPoints(current.getStart(),current.getEnd());
        return graphics2D.hitClip(calc.getX(),calc.getY(),calc.getW(),calc.getH());
    }

}
