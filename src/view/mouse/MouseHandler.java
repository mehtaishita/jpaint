package view.mouse;

import controller.CommandFactory;
import controller.ICommand;
import model.interfaces.IApplicationState;
import view.gui.ICanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;


public class MouseHandler extends MouseAdapter {

    private Point startPoint;
    private Point endPoint;
    private CommandFactory commandFactory;
    private IApplicationState applicationState;
    private ICommand command;
    private ICanvas paintCanvas;

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(),e.getY());
        commandFactory = new CommandFactory(applicationState);
        command = commandFactory.createCommand(startPoint,endPoint,paintCanvas);
        command.run();
    }

    public MouseHandler(IApplicationState applicationState, ICanvas paintCanvas) {
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        addMouseListener(this);
    }

}
