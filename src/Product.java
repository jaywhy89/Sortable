public class Product {
	private String productName;
	private String manufacturer;
	private String family;
	private String model;
	private String announcedDate;

	public Product() {
		// family is optional, so set to empty string in case of NULL
		family = "";
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

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setAnnouncedDate(String date) {
		this.announcedDate = date;
	}

}