package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "listshop")
public class Shop {
	  // ------------------------
	  // PRIVATE FIELDS
	  // ------------------------
	  
	  // An id matching user id
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  
	  // item name
	  @NotNull
	  private String name;
	  
	  @NotNull
	  private String username;

	  // ------------------------
	  // PUBLIC METHODS
	  // ------------------------
	  
	  public Shop() { }

	  public Shop(long id) { 
	    this.id = id;
	  }
	  
	  public Shop(String name) {
	    this.name = name;
	  }
	  
	  public Shop(String name, String username) {
		    this.username = username;
		    this.name = name;
		  }

	  // Getter and setter methods

	  public long getId() {
	    return id;
	  }

	  public void setId(long value) {
	    this.id = value;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String value) {
	    this.name = value;
	  }
	  
	  public String getUserName() {
		    return username;
		  }
	  public void setUserName(String value) {
		    this.username = value;
		  }
}
