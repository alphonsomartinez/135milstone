package contacts.milestone;

import java.io.Serializable;

public class BaseContact implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private String name;
	private String phone;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public BaseContact(int number, String name,String phone) {
		super();
		this.number = number;
		this.name = name;
		this.phone= phone;
		//this.id = id;
	}

	
	

	@Override
	public String toString() {
		return "BaseContact n=" + number + ", name =" + name + ", phone =" + phone + "]";
	}
	
	

}

