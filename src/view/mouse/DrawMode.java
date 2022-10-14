package view.mouse;

import controller.CreateShape;
import controller.ICommand;
import model.interfaces.IApplicationState;
import view.gui.ICanvas;

public class DrawMode implements IMode {
    @Override
    public ICommand createCommand(Point start, Point end, IApplicationState mode, ICanvas paintCanvas) {
        return new CreateShape(start,end,mode,paintCanvas);
    }
}
