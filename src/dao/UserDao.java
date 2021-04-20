package dao;

import entity.User;

/**
 * User Data Access Object interface
 */
public interface UserDao {
    /**
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @return if username does not exist, return the newly created user, else return null
     */
    public User addUser(String username, String password,
                        String firstName, String lastName,
                        String email, boolean admin);

    /**
     * see if username already exist
     *
     * @param username
     * @return
     */
    public boolean usernameExist(String username);

    /**
     * see if username exist and the password and username match
     * @param username
     * @param password
     * @return
     */
    public User verifyUsername(String username,String password);
    
    /**
     * Returns the username given the id of the user
     * @param user_id
     * @return username
     */
    public String getUsername(int user_id);

}
