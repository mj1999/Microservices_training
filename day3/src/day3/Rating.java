package day3;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ratings database table.
 * 
 */
@Entity
@Table(name="ratings")
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	private float rating;

	@Column(name="rating_id")
	private int ratingId;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-many association to FoodItem
	@ManyToMany
	@JoinTable(
		name="users"
		, joinColumns={
			@JoinColumn(name="user_id", referencedColumnName="item_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id", referencedColumnName="item_id")
			}
		)
	private List<FoodItem> foodItems;

	public Rating() {
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<FoodItem> getFoodItems() {
		return this.foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

}