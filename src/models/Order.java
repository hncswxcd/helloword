package models;
public class Order {
private int id;
private String Cuisine;
private int Price;
private int num;
private int sum;
public Order()
{super();}
public Order(String Cuisine,int Price,int num,int sum)
{
 super();
 this.Cuisine=Cuisine;
 this.Price=Price;
 this.num=num;
 this.sum=sum;
	}
public Order(int id,String Cuisine,int Price,int num,int sum)
{
 super();
 this.id=id;
 this.Cuisine=Cuisine;
 this.Price=Price;
 this.num=num;
 this.sum=sum;
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
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}

}
