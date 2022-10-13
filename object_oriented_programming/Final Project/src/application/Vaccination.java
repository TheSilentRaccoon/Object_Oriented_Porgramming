/**
 * @author Maksims Kazoha R00188979
 */

package application;

import java.io.Serializable;
import java.util.Date;

public class Vaccination implements Serializable{//superclass
	String name;
	int efficiency;//range 1%-100%
	Date startDoseDate;
	
	Vaccination(String name, int eff, Date start){
		this.name = name;
		this.efficiency= eff;
		this.startDoseDate = start;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEfficancy() {
		return efficiency;
	}

	public void setEfficancy(int efficancy) {
		this.efficiency = efficancy;
	}

	public Date getStartDoseDate() {
		return startDoseDate;
	}

	public void setStartDoseDate(Date startDoseDate) {
		this.startDoseDate = startDoseDate;
	}
	
	//public abstract void deliveryInfo();
	@Override
	public String toString() {
		return " Vaccination: " + name + " Efficiency: " + efficiency + "% Start Dose Date: " + startDoseDate;
	}

	
	
}
