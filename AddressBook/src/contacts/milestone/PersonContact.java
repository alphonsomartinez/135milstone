package contacts.milestone;

import java.io.Serializable;

public class PersonContact extends BaseContact  implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bday;
    private String description;
	private String relatives;
	private Photo photo;
	private Location location;
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getRelatives() {
		return relatives;
	}

	public void setRelatives(String relatives) {
		this.relatives = relatives;
	}

	public PersonContact( int number,String name, String phone, String bday , String description, String relatives, Location location) {
		super(number,name, phone);
		// TODO Auto-generated constructor stub
	}

	public PersonContact( int number,String name, String phone, String bday , String description, String relatives, Location location, Photo photo) {
		super(number,name, phone);
		this.bday = bday;
		this.description = description;
		this.relatives = relatives;
		this.photo = photo;
		this.location = location;
	}
	

	@Override
	public String toString() {
		return "PersonContact [ bday=" + bday + ", description=" + description +", relatives=" + relatives +", Location=" + location + ", Photo=" + photo + ",toString()=" + super.toString() + "]";
	}
	
	
	
	
}

