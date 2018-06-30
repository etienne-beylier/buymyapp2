package netgloo.controllers;

import netgloo.models.User;
import netgloo.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import hello.GetMapping;
//import hello.UserRepository;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 */
@Controller
public class UserController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
	@Autowired
	private UserDao userD;
	
	@RequestMapping("/user/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userD.findAll();
	}
	
  /**
   * /create  --> Create a new user and save it in the database.
   * 
   * @param password User's password
   * @param name User's name
   * @return A string describing if the user is successfully created or not.
   */
  @RequestMapping("/user/create")
  @ResponseBody
  public String create(String password, String name) {
    User user = null;
    try {
      user = new User(password, name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created! (id = " + user.getId() + ")";
  }
  
  /**
   * /delete  --> Delete the user having the passed id.
   * 
   * @param id The id of the user to delete
   * @return A string describing if the user is successfully deleted or not.
   */
  @RequestMapping("/user/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User successfully deleted!";
  }
  
  
  @RequestMapping("/user/get-by-name")
  @ResponseBody
  public String getByName(String name) {
    String userId;
    String password;
    try {
      User user = userDao.findByName(name);
      userId = String.valueOf(user.getId());
      password = String.valueOf(user.getPassword());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId +" Name: "+ name +" password: "+ password;
  }
  
  /**
   * /update  --> Update the password and the name for the user in the database 
   * having the passed id.
   * 
   * @param id The id for the user to update.
   * @param password The new password.
   * @param name The new name.
   * @return A string describing if the user is successfully updated or not.
   */
  
  @RequestMapping("/user/update")
  @ResponseBody
  public String updateUser(long id, String password, String name) {
    try {
      User user = userDao.findOne(id);
      user.setPassword(password);
      user.setName(name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User successfully updated!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserDao userDao;
  
} // class UserController
