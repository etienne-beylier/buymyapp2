package netgloo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.Shop;
import netgloo.models.ShopDao;

@Controller
public class ListShopController {
	

	  // ------------------------
	  // PUBLIC METHODS
	  // ------------------------
		@Autowired
		private ShopDao shopD;
		
		@RequestMapping("/itemshop/all")
		public @ResponseBody Iterable<Shop> getAllUsers() {
			// This returns a JSON or XML with the users
			return shopD.findAll();
		}
		
	  /**
	   * /create  --> Create a new user and save it in the database.
	   * 
	   * @param password User's password
	   * @param name User's name
	   * @return A string describing if the user is successfully created or not.
	   */
	  @RequestMapping("/itemshop/create")
	  @ResponseBody
	  public String create(String name, String username) {
	    Shop shop = null;
	    try {
	      shop = new Shop(name, username);
	      userShop.save(shop);
	    }
	    catch (Exception ex) {
	      return "Error creating the item: " + ex.toString();
	    }
	    return "Item succesfully created! (id = " + shop.getId() + ")";
	  }
	  
	  /**
	   * /delete  --> Delete the user having the passed id.
	   * 
	   * @param id The id of the user to delete
	   * @return A string describing if the user is successfully deleted or not.
	   */
	  @RequestMapping("/itemshop/delete")
	  @ResponseBody
	  public String delete(long id) {
	    try {
	      Shop shop = new Shop(id);
	      userShop.delete(shop);
	    }
	    catch (Exception ex) {
	      return "Error deleting the item: " + ex.toString();
	    }
	    return "Item successfully deleted!";
	  }
	  
	  
	  @RequestMapping("/itemshop/get-by-name")
	  @ResponseBody
	  public String getByName(String name) {
	    String itemId;
	    try {
	      Shop shop = userShop.findByName(name);
	      itemId = String.valueOf(shop.getId());
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
	  @RequestMapping("/itemshop/update")
	  @ResponseBody
	  public String updateShop(long id, String name, String username) {
	    try {
	      Shop shop = userShop.findOne(id);
	      shop.setName(name);
	      shop.setUserName(username);
	      userShop.save(shop);
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
	  private ShopDao userShop;

}
