package view.mouse;

import controller.ICommand;
import controller.MoveShapes;
import model.interfaces.IApplicationState;
import view.gui.ICanvas;

public class MoveMode implements IMode {
    @Override
    public ICommand createCommand(Point start, Point end, IApplicationState mode, ICanvas paintCanvas) {
        return new MoveShapes(end);
    }
}
