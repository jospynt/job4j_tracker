package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = user.isValid() && user.getUsername().length() > 3;
        if (rsl) {
            return true;
        } else {
            throw new UserInvalidException("Invalid user.");
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Ivan Ivanov", false)
        };
        try {
            User user = findUser(users, "Anton Antonov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uie) {
            uie.printStackTrace();
        } catch (UserNotFoundException unfe) {
            unfe.printStackTrace();
        }
    }
}
