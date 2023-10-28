// Create the ConcreteObserver class (InstagramAccount) that implements the Observer interface.
public class InstagramAccount implements Observer {
    private String accountName;

    public InstagramAccount(String accountName) {
        this.accountName = accountName; // Initialize the account name.
    }

    @Override
    public void update(String message) {
        // Display a notification message when the observer is updated.
        System.out.println(" __________________________________________________________");
        System.out.println("|  " + accountName + ", you received a notification: ");
        System.out.println("|             " + message);
        System.out.println("|__________________________________________________________");
    }

    public String getAccountName() {
        return accountName; // Get the account name.
    }
}
