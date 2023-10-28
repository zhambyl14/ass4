import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InstagramApp {
    public static void main(String[] args) {
        Instagram instagram = new Instagram(); // Create an Instagram instance.
        List<InstagramAccount> accounts = new ArrayList<>(); // List to store created Instagram accounts.
        List<InstagramAccountFactory> factories = new ArrayList<>(); // List to store account factories.

        factories.add(new PeopleAccountFactory()); // Add a factory for creating person accounts.
        factories.add(new NewsAccountFactory()); // Add a factory for creating news accounts.

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" ________________________________________________");
            System.out.println("|     1. Create an account                       |");
            System.out.println("|     2. Delete an account                       |");
            System.out.println("|     3. Choose an account to make a post        |");
            System.out.println("|     4. Exit                                    |");
            System.out.println("|________________________________________________|");
            System.out.println("           Choose an action:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("_____________________");
                    System.out.println("   1. Person      ");
                    System.out.println("   2. Blogger      ");
                    System.out.println("_____________________");
                    System.out.println("  Choose the account type:");

                    int accountTypeChoice = scanner.nextInt();

                    if (accountTypeChoice >= 1 && accountTypeChoice <= factories.size()) {
                        System.out.print("Enter the account name: @");
                        scanner.nextLine();
                        String accountName = scanner.nextLine();

                        // Check for duplicate account names
                        boolean isDuplicate = accounts.stream().anyMatch(account -> account.getAccountName().equals(accountName));

                        if (isDuplicate) {
                            System.out.println("An account with the same name already exists. Please choose another name.");
                        } else {
                            InstagramAccountFactory factory = factories.get(accountTypeChoice - 1);
                            InstagramAccount newAccount = factory.createAccount(accountName);

                            instagram.addObserver(newAccount); // Register the new account as an observer.
                            accounts.add(newAccount); // Add the new account to the list of accounts.
                        }
                    }
                    else {
                        System.out.println("Invalid choice.");
                    }

                    break;
                case 2:
                    System.out.println("Choose an account to delete:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". @" + accounts.get(i).getAccountName());
                    }

                    int deleteChoice = scanner.nextInt();

                    if (deleteChoice >= 1 && deleteChoice <= accounts.size()) {
                        InstagramAccount accountToDelete = accounts.get(deleteChoice - 1);
                        instagram.removeObserver(accountToDelete); // Unregister the account as an observer.
                        accounts.remove(accountToDelete); // Remove the account from the list of accounts.
                        System.out.println("Account deleted.");
                    } else {
                        System.out.println("Invalid choice.");
                    }

                    break;
                case 3:
                    if (accounts.isEmpty()) {
                        System.out.println("First, create some accounts.");
                    } else {
                        System.out.println("Choose an account to make a post:");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println((i + 1) + ". @" + accounts.get(i).getAccountName());
                        }

                        int accountChoice = scanner.nextInt();

                        if (accountChoice >= 1 && accountChoice <= accounts.size()) {
                            InstagramAccount chosenAccount = accounts.get(accountChoice - 1);

                            System.out.println("Enter the post text:");
                            scanner.nextLine();
                            String message = scanner.nextLine();

                            instagram.post(chosenAccount.getAccountName(), message); // Post a message to the chosen account.
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }

                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
