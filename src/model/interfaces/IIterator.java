package model.interfaces;
import model.AShape;

public interface IIterator {
    boolean hasNext ();
    AShape getNext();
}
