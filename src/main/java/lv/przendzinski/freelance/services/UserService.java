package lv.przendzinski.freelance.services;

import org.springframework.stereotype.Service;

import lv.przendzinski.freelance.domain.User;
import lv.przendzinski.freelance.domain.UserAlreadyExistsException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
@Service
public class UserService {

    private List<User> userList = new ArrayList<User>();

    @PostConstruct
    public void init() {
        User user1 = new User("admin", "qwerty", 2);
        User user2 = new User("freelancer", "qwerty", 0);
        User user3 = new User("client", "qwerty", 1);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public Boolean authenticateUser(String userName, String password) {
        if (userName != null) {
            for (User user : userList) {
                if ((user.getName().equals(userName)) && (user.getPassword().equals(password))) {
                    System.out.println(user);
                    return true;
                }
            }
        }
        return false;
    }

    public User getUserByName(String userName) {
        if (userName != null) {
            for (User user : userList) {
                if ((user.getName().equals(userName))) {
                    System.out.println(user);
                    return user;
                }
            }
        }
        return null;
    }

    public User createUser(String userName, String password, String role) throws UserAlreadyExistsException {

        if (userName.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("You must fill in all the fields");
        }

        boolean nameIsAvailable = getUserByName(userName) == null;

        if (nameIsAvailable) {
            Integer userRole = role != null ? 1 : 0;
            User newUser = new User(userName, password, userRole);
            userList.add(newUser);
            System.out.println(userList);
            return newUser;
        }
        throw new UserAlreadyExistsException("User already exists");
    }
}
