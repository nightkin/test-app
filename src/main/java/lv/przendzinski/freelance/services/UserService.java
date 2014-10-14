package lv.przendzinski.freelance.services;

import org.springframework.stereotype.Service;

import lv.przendzinski.freelance.domain.User;

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
        User user1 = new User("admin", "qwerty", "admin");
        User user2 = new User("freelancer", "qwerty", "employee");
        User user3 = new User("client", "qwerty", "employer");

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
}
