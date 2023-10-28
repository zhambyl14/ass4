// Create specific factories for each account type.
public class PeopleAccountFactory implements InstagramAccountFactory {
    @Override
    public InstagramAccount createAccount(String accountName) {
        return new InstagramAccount(accountName); // Create an Instagram account for a person.
    }
}
