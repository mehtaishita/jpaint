package controller;


import model.interfaces.IApplicationState;
import view.gui.ICanvas;
import view.mouse.IMode;
import view.mouse.ModeFactory;
import view.mouse.Point;

public class CommandFactory {
    private IMode paintmode;
    private IApplicationState appstate;

    public CommandFactory(IApplicationState appstate) {
        switch (appstate.getActiveStartAndEndPointMode()) {
            case DRAW:
                paintmode = ModeFactory.getDrawModeCommand();
                break;
            case MOVE:
                paintmode = ModeFactory.getMoveModeCommand();
                break;
            case SELECT:
                paintmode = ModeFactory.getSelectModeCommand();
                break;
        }
        this.appstate = appstate;
    }

    public ICommand createCommand(Point start, Point end, ICanvas paintCanvas) {
        return paintmode.createCommand(start,end,appstate,paintCanvas);
    }
}