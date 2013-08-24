package model.unit;

/**
 * Declares the capability of an object to observe.
 *
 * @author Jonathan Trudeau
 *
 */
public interface Observer {

    public void update(Observable observable);
    
}
