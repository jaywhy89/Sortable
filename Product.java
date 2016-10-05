public class Product {
	private String productName;
	private String manufacturer;
	private String family;
	private String model;
	private String announcedDate;

	public Product() {
		//Set family to blank, since it is optional
		this.family = "";
	}
	
	public String getProductName() {
		return productName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getFamily() {
		return family;
	}

	public String getModel() {
		return model;
	}

	public String getAnnouncedDate() {
		return announcedDate;
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public void getManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void getFamily(String family) {
		this.family = family;
	}

	public void getModel(String model) {
		this.model = model;
	}

	public void getAnnouncedDate(String date) {
		this.announcedDate = date;
	}

}