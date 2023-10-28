import java.util.ArrayList;
import java.util.List;

// Create the ConcreteSubject class (Instagram) that implements the Subject interface.
public class Instagram implements Subject {
    private List<Observer> observers = new ArrayList<>(); // List to store registered observers.

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer); // Add an observer to the list.
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); // Remove an observer from the list.
    }

    @Override
    public void post(String account, String message) {
        for (Observer observer : observers) {
            // Notify observers of posts, excluding the posting account itself.
            if (!(observer instanceof InstagramAccount && ((InstagramAccount) observer).getAccountName().equals(account))) {
                observer.update(account + " posted: \"" + message + "\"");
            }
        }
    }
}
