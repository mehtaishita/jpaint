package controller;

import model.persistence.CommandHistory;

public class RedoCommand implements ICommand {
    @Override
    public void run() {
        CommandHistory.redo();
    }
}
