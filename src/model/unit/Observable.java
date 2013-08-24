package model.unit;

/**
 * Declares the capability of an object to be observed.
 *
 * @author Jonathan Trudeau
 *
 */
public interface Observable {

    public void registerObserver(Observer observer);
    
}
