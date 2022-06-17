package gR;

public class Gizmo {
	private String id;
	private String NameOfGizmo;
	private double stockqtt;
	private double price;
	private String supplierId;
	
	public Gizmo() {}
	
	public Gizmo(String id, String nameOfGizmo, double stockqtt, double price, String supplierId) {
		super();
		this.id = id;
		NameOfGizmo = nameOfGizmo;
		this.stockqtt = stockqtt;
		this.price = price;
		this.supplierId = supplierId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNameOfGizmo() {
		return NameOfGizmo;
	}
	public void setNameOfGizmo(String nameOfGizmo) {
		NameOfGizmo = nameOfGizmo;
	}
	public double getStockqtt() {
		return stockqtt;
	}
	public void setStockqtt(double d) {
		this.stockqtt = d;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return  id + ", " + NameOfGizmo + ", " + stockqtt + ", " + price
				+ ", " + supplierId;
	}
	
}
