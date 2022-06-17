package gR;

public class Retail {
	private String id;
	private String compName;
	private String address;
	private String salesContact;
	private String gizmolistbyID;
	
	public Retail() {
		super();
	}
	
	public Retail(String id, String compName, String address, String salesContact, String gizmolistbyID) {
		super();
		this.id = id;
		this.compName = compName;
		this.address = address;
		this.salesContact = salesContact;
		this.gizmolistbyID = gizmolistbyID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalesContact() {
		return salesContact;
	}
	public void setSalesContact(String salesContact) {
		this.salesContact = salesContact;
	}
	public String getGizmolistbyID() {
		return gizmolistbyID;
	}
	public void setGizmolistbyID(String gizmolistbyID) {
		this.gizmolistbyID = gizmolistbyID;
	}

	@Override
	public String toString() {
		return  id + ", " + compName + ", " + address + ", " + salesContact
				+ ", " + gizmolistbyID;
	}
	
	
}
