package contacts.milestone;

import java.io.Serializable;

public class BusinessContact extends BaseContact  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private int number;
	private String email;
	private String hours;
	private Location location;
	private Photo photo;
	
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	//public int getNumber() {
		//return number;
	//}

	//public void setNumber( int number) {
	//	this.number = number;
	//}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public BusinessContact(int number, String name, String phone,String email, String hours,Location location) {
		super(number, name, phone);
		 //location= new Location("street","city","state");
		
	}

	public BusinessContact(int number,String name, String  phone,String email, String hours,Location location,Photo photo) {
		super( number, name, phone);
	 
		this.location = location;
		this.photo =photo;
		this.email = email;
		this.hours = hours;
		
	}
	
	public String toString() {
		
		return "BusinessContact [ email=" + email + ", hours=" + hours +",Location=" + location +",Photo=" + photo +", toString()=" + super.toString() + "]";
	
	}

	
	
	
	
}


