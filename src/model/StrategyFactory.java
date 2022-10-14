package model;

import controller.FilledInDrawStrategy;
import controller.IShapeShadingTypeStrategy;
import controller.OutlineAndFilledInDrawStrategy;
import controller.OutlineOnlyDrawStrategy;

public class StrategyFactory {
    public IShapeShadingTypeStrategy createStrategy (ShapeShadingType shadingType) {
        IShapeShadingTypeStrategy strategy = null;
        switch(shadingType) {
            case OUTLINE:
                strategy = new OutlineOnlyDrawStrategy();
                break;
            case FILLED_IN:
                strategy = new FilledInDrawStrategy();
                break;
            case OUTLINE_AND_FILLED_IN:
                strategy = new OutlineAndFilledInDrawStrategy();
                break;
        }
        return strategy;
    }
}
