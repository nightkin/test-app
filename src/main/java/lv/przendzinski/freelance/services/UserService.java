package lv.przendzinski.freelance.services;

import lv.przendzinski.freelance.domain.User;
import lv.przendzinski.freelance.domain.UserAlreadyExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
@Service
public class UserService {

    private List<User> userList = new ArrayList<User>();
    private long userID = 0L;
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @PostConstruct
    public void init() {
        userList = getUsers();
    }

    private List<User> getUsers() {
        try {
            InputStream file = new FileInputStream("users");
            GZIPInputStream gz = new GZIPInputStream(file);
            InputStream buffer = new BufferedInputStream(gz);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                userList = (ArrayList<User>) input.readObject();
            }
            finally {
                input.close();
            }
        }
        catch(ClassNotFoundException ex){
            LOG.error("Error: {}", ex);
        }
        catch(FileNotFoundException ex) {
            LOG.error("Error: {}", ex);
        }
        catch(IOException ex){
            LOG.error("Error: {}", ex);
        }
        return userList;
    }

    private void saveUsers(List<User> users) {
        try {
            OutputStream file = new FileOutputStream("users");
            GZIPOutputStream gz = new GZIPOutputStream(file);
            OutputStream buffer = new BufferedOutputStream(gz);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                output.writeObject(users);
            }
            finally {
                output.close();
            }
        }
        catch (IOException ex) {
            LOG.error("Error: {}", ex);
        }
    }

    public Boolean authenticateUser(String userName, String password) {
        if (userName != null) {
            for (User user : userList) {
                if ((user.getName().equals(userName)) && (user.getPassword().equals(password))) {
                    LOG.info("User logged in: {}", user.getId());
                    return true;
                }
            }
        }
        LOG.error("Authentication failed: {}/{}", userName, password);
        return false;
    }

    public User getUserByID(long userID) {
        for (User user : userList) {
            if ((user.getId() == userID)) {
                LOG.info("User found by ID: {}", user);
                return user;
            }
        }
        return null;
    }

    public User getUserByName(String userName) {
        if (userName != null) {
            for (User user : userList) {
                if ((user.getName().equals(userName))) {
                    LOG.info("User found by name: {}", user);
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
