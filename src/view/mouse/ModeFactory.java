package view.mouse;

//static factory
public class ModeFactory {
    public static IMode getDrawModeCommand() { return new DrawMode();}
    public static IMode getSelectModeCommand() { return new SelectMode();}
    public static IMode getMoveModeCommand() { return new MoveMode();}
}
