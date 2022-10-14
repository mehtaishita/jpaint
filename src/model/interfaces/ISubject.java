package model.interfaces;

import model.interfaces.IObserver;

public interface ISubject {
    void registerObserver (IObserver observer);
    void removeObserver (IObserver observer);
}
