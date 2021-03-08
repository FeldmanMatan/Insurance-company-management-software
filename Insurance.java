package application;

public class Insurance {

	private String Name;
	private String LastName;
	private String date;
	private String Remarks;
	private String Type;
	
	
	public Insurance(String Name,String LastName,String Date,String Remarks,String Type) {
		this.Name=Name;
		this.LastName=LastName;
		this.date=Date;
		this.Remarks=Remarks;
		this.Type=Type;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
}
