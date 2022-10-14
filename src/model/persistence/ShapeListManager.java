package model.persistence;

public final class ShapeListManager {
    private static ShapeList shapeList = new ShapeList();
    private static ShapeList selectedShapeList = new ShapeList();
    private static ShapeList clipboardShapeList = new ShapeList();
    private static ShapeList movingShapeList = new ShapeList();

    public static ShapeList getShapeList() {
        return shapeList;
    }

    public static ShapeList getSelectedShapeList() {
        return selectedShapeList;
    }

    public static ShapeList getClipboardShapeList() {
        return clipboardShapeList;
    }

    public static ShapeList getMovingShapeList() { return movingShapeList; }

}
