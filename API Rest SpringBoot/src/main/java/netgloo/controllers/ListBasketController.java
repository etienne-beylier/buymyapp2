package netgloo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.Basket;
import netgloo.models.BasketDao;

@Controller
public class ListBasketController {

	  // ------------------------
	  // PUBLIC METHODS
	  // ------------------------
		@Autowired
		private BasketDao basketD;
		
		@RequestMapping("/itembasket/all")
		public @ResponseBody Iterable<Basket> getAllUsers() {
			// This returns a JSON or XML with the users
			return basketD.findAll();
		}
		
	  /**
	   * /create  --> Create a new user and save it in the database.
	   * 
	   * @param password User's password
	   * @param name User's name
	   * @return A string describing if the user is successfully created or not.
	   */
	  @RequestMapping("/itembasket/create")
	  @ResponseBody
	  public String create(String name, String username) {
	    Basket Basket = null;
	    try {
	      Basket = new Basket(name, username);
	      userBasket.save(Basket);
	    }
	    catch (Exception ex) {
	      return "Error creating the item: " + ex.toString();
	    }
	    return "Item succesfully created! (id = " + Basket.getId() + ")";
	  }
	  
	  /**
	   * /delete  --> Delete the user having the passed id.
	   * 
	   * @param id The id of the user to delete
	   * @return A string describing if the user is successfully deleted or not.
	   */
	  @RequestMapping("/itembasket/delete")
	  @ResponseBody
	  public String delete(long id) {
	    try {
	      Basket Basket = new Basket(id);
	      userBasket.delete(Basket);
	    }
	    catch (Exception ex) {
	      return "Error deleting the item: " + ex.toString();
	    }
	    return "Item successfully deleted!";
	  }
	  
	  
	  @RequestMapping("/itembasket/get-by-name")
	  @ResponseBody
	  public String getByName(String name) {
	    String itemId;
	    try {
	      Basket Basket = userBasket.findByName(name);
	      itemId = String.valueOf(Basket.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The item id is: " + itemId +" Name: "+ name;
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
	  @RequestMapping("/itembasket/update")
	  @ResponseBody
	  public String updateBasket(long id, String name, String username) {
	    try {
	      Basket Basket = userBasket.findOne(id);
	      Basket.setName(name);
	      Basket.setUserName(username);
	      userBasket.save(Basket);
	    }
	    catch (Exception ex) {
	      return "Error updating the item: " + ex.toString();
	    }
	    return "Item successfully updated!";
	  }

	  // ------------------------
	  // PRIVATE FIELDS
	  // ------------------------

	  @Autowired
	  private BasketDao userBasket;

	
}
