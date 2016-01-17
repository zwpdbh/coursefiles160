import java.rmi.*;

// helper class
public class Customer {
	private String name;
	private boolean child;
	private boolean student;
	private boolean booked = false;
	
	public Customer(String name, int age, boolean studentIn) {
		this.name = name;
		
		if (age >= 5 && age <=16) {
			this.child = true;
		} else {
			this.child = false;
		}
		
		this.student = studentIn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isChild() {
		return this.child;
	}
	
	public boolean isStudent() {
		return this.student;
	}
	
	public String toString() {
		String info = this.name + " " + this.child + " " + this.student;
		return info; 
	}
	
	public boolean isBooked() {
		return this.booked;
	}
	
	// setter
	public void setBooked() {
		this.booked = true;
	}
}