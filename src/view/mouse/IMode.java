package view.mouse;

import controller.ICommand;
import model.interfaces.IApplicationState;
import view.gui.ICanvas;

//strategy
public interface IMode {
    ICommand createCommand(Point start, Point end, IApplicationState mode, ICanvas paintCanvas);
}
