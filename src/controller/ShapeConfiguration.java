package controller;

import model.*;

public class ShapeConfiguration {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private ShapeType shapeType;

    public ShapeConfiguration(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, ShapeType shapeType) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.shapeType = shapeType;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
