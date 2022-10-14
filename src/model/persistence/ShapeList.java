package model.persistence;

import model.AShape;
import model.interfaces.IIterator;
import model.interfaces.IObserver;
import model.interfaces.ISubject;


import java.util.ArrayList;
import java.util.Iterator;

public class ShapeList implements ISubject {
    private ArrayList<AShape> shapeList = new ArrayList<AShape>();
    private ArrayList<IObserver> observers = new ArrayList<>();
    private int size;

    public void addShape(AShape shape) {
        this.shapeList.add(shape);
        size++;
        notifyObservers();
    }

    public void removeShape(AShape shape) {
        this.shapeList.remove(shape);
        size--;
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers() {
        for (IObserver o: observers) {o.update();}
    }

    public IIterator getIterator() {
        return new ShapeListIterator();
    }

    public String toString() {
        String s = "";
        for (AShape a : shapeList) {
            s = s + a.toString() + ", ";
        }
        return s;
    }

    public void clear() {
        shapeList.clear();
    }

    public boolean isEmpty() {
        return shapeList.isEmpty();
    }

    public int getSize() { return size;}

    class ShapeListIterator implements IIterator{

        private Iterator<AShape> iterator = shapeList.iterator();

        @Override
        public boolean hasNext() { return iterator.hasNext(); }

        @Override
        public AShape getNext() {
            return iterator.next();
        }

    }
}
