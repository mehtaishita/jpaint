package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeDrawer;
import model.persistence.ApplicationState;
import model.persistence.ShapeListManager;
import view.gui.ComponentHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import view.mouse.MouseHandler;

public class Main {
    public static void main(String[] args){
        PaintCanvas canvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        MouseHandler mouse = new MouseHandler(appState,canvas);
        canvas.addMouseListener(mouse);
        ShapeDrawer shapeDrawer = new ShapeDrawer(canvas);
        ShapeListManager.getShapeList().registerObserver(shapeDrawer);
        ComponentHandler resizeComponent = new ComponentHandler(shapeDrawer);
        ((GuiWindow) guiWindow).addComponentListener(resizeComponent);
        controller.setup();
    }
}
