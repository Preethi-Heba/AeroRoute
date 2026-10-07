package service;

import model.User;

import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users;

    // Constructor
    public UserService() {

        users = new ArrayList<>();

        // Default admin/user
        users.add(
                new User("admin", "admin123")
        );
    }

    // =========================================================
    // REGISTER
    // =========================================================

    public void register(String username,
                         String password) {

        // Check existing username
        for (User user : users) {

            if (user.getUsername()
                    .equalsIgnoreCase(username)) {

                System.out.println(
                        "Username already exists.");

                return;
            }
        }

        User newUser =
                new User(username, password);

        users.add(newUser);

        System.out.println(
                "Registration successful.");
    }

    // =========================================================
    // LOGIN
    // =========================================================

    public boolean login(String username,
                         String password) {

        for (User user : users) {

            if (user.getUsername()
                    .equalsIgnoreCase(username)
                    &&
                user.getPassword()
                    .equals(password)) {

                return true;
            }
        }

        return false;
    }
}