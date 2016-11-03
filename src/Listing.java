// Listing class 

public class Listing {
	private String title;
	private String manufacturer;
	private String currency;
	private String price;

	public Listing() {
	} 

	public String getTitle() {
		return title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getCurrency() {
		return currency;
	}

	public String getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title=title;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer=manufacturer;
	}
	public void setCurrency(String currency) {
		this.currency=currency;
	}
	public void setPrice(String price) {
		this.price=price;
	}
}

