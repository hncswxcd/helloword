package models;

public class Menu {
private int id;
private String Cuisine;
private int price;
public Menu()
{super();}
public Menu(int id,String Cuisine,int Price)
{
	super();
	this.id=id;
	this.Cuisine=Cuisine;
	this.price=Price;
}
public Menu(String Cuisine,int Price)
{
	super();
	this.Cuisine=Cuisine;
	this.price=Price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCuisine() {
	return Cuisine;
}
public void setCuisine(String cuisine) {
	Cuisine = cuisine;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
