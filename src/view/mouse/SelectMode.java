package view.mouse;

import controller.ICommand;
import controller.SelectShapes;
import model.interfaces.IApplicationState;
import view.gui.ICanvas;

public class SelectMode implements IMode {
    @Override
    public ICommand createCommand(Point start, Point end, IApplicationState mode, ICanvas paintCanvas) {
        return new SelectShapes(start,end);
    }
}
