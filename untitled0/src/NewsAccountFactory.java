public class NewsAccountFactory implements InstagramAccountFactory {
    @Override
    public InstagramAccount createAccount(String accountName) {
        return new InstagramAccount(accountName); // Create an Instagram account for a news entity.
    }
}
