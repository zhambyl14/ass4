// Create the Subject interface to define the methods that Instagram will use.
public interface Subject {
    void addObserver(Observer observer); // Method to add an observer.

    void removeObserver(Observer observer); // Method to remove an observer.

    void post(String account, String message); // Method to post a message.
}
