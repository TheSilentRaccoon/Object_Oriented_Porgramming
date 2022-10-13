/**
 * @author Maksims Kazoha R00188979
 */

package application;

import java.io.Serializable;

public class Client implements Serializable{//superclass
	Name name;
	String id;
	String phoneNumber;
	Vaccination vaccination;
	Client(Name name, String id, String pNumber, Vaccination vac){
		this.name = name;
		this.id = id;
		this.phoneNumber = pNumber;
		this.vaccination = vac;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Vaccination getVaccination() {
		return vaccination;
	}
	public void setVaccination(Vaccination vaccination) {
		this.vaccination = vaccination;
	}
	@Override
	public String toString() {
		return "Name: " + name + " Identification: " + id + " Phone Number: " + phoneNumber + vaccination+ "\n";
	}
	
}
