public class DVD {
	private String name;
	private String zone;
	private int rating;
	private String time;
	
	// Constructor
	public DVD(String name, String zone, int rating, String time) {
		this.name = name;
		this.zone = zone;
		this.rating = rating;
		this.time = time;
	}
	
	// getters
	public String getName() {
		return name;
	}
	
	public String getZone() {
		return zone;
	}
	
	public int getRating() {
		return rating;
	}
	
	public String getTime() {
		return time;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
}  