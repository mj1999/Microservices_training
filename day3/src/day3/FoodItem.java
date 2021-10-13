package day3;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the food_item database table.
 * 
 */
@Entity
@Table(name="food_item")
@NamedQuery(name="FoodItem.findAll", query="SELECT f FROM FoodItem f")
public class FoodItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="added_on")
	private Date addedOn;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="item_name")
	private String itemName;

	private int price;

	//bi-directional many-to-one association to Cart
	@ManyToOne
	@JoinColumn(name="item_id", referencedColumnName="item_id")
	private Cart cart;

	//bi-directional many-to-many association to Rating
	@ManyToMany(mappedBy="foodItems")
	private List<Rating> ratings;

	public FoodItem() {
	}

	public Date getAddedOn() {
		return this.addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}