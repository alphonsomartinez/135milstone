package contacts.milestone;

import java.io.Serializable;

public class Photo  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int  id;
	private String filename;
	private String photodate;
	private String description2;
	
	public Photo(int id , String filename,String photodate,String description2) {
		super();
		this.id = id;
		this.filename = filename;
		this.photodate = photodate;
		this.description2 = description2;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", filename=" + filename + ", photodate=" + photodate +", decription2=" + description2 + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getPhotodate() {
		return photodate;
	}

	public void setPhotodate(String photodate) {
		this.photodate = photodate;
	}
	
	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description) {
		this.description2 = description;
	}
	

} 


