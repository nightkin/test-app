package lv.przendzinski.freelance.services;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;
import org.springframework.stereotype.Service;

import lv.przendzinski.freelance.domain.User;
import lv.przendzinski.freelance.domain.UserAlreadyExistsException;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
@Service
public class UserService {

    private List<User> userList = new ArrayList<User>();
    private Long userID = 0L;

    @PostConstruct
    public void init() {
        userList = getUsers();
    }

    private List<User> getUsers() {
        try {
            InputStream file = new FileInputStream("users");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                userList = (ArrayList<User>) input.readObject();
            }
            finally {
                input.close();
            }
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex);
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        return userList;
    }

    private void saveUsers(List<User> users) {
        try {
            OutputStream file = new FileOutputStream("users");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                output.writeObject(users);
            }
            finally {
                output.close();
            }
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public Boolean authenticateUser(String userName, String password) {
        if (userName != null) {
            for (User user : userList) {
                if ((user.getName().equals(userName)) && (user.getPassword().equals(password))) {
                    System.out.println(user);
                    System.out.println(user.getId());
                    return true;
                }
            }
        }
        return false;
    }

    public User getUserByID(Long userID) {
        if (userID != null) {
            for (User user : userList) {
                if ((user.getId().equals(userID))) {
                    System.out.println(user);
                    return user;
                }
            }
        }
        return null;
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
            User newUser = new User(userID++, userName, password, userRole);
            userList.add(newUser);
            saveUsers(userList);
            return newUser;
        }
        throw new UserAlreadyExistsException("User already exists");
    }

    public void deleteUser(String userID) {
        //TODO: write some code
    }

}
