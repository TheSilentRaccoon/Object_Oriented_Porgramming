/**
 * @author Maksims Kazoha R00188979
 */

package application;

import java.util.Date;
import java.util.Random;

public class SecondVaccineNeeded extends Vaccination{//subclass
	String nextVacinationDate;
	String displayInfo;
	String dose;
	String name1;
	SecondVaccineNeeded(String name, int eff, Date start, String secondStart, String info, String name1) {
		super(name, eff, start);
		this.nextVacinationDate = secondStart;
		this.displayInfo = info;
		this.name1 = name1;
	}
	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getNextVacinationDate() {
		return nextVacinationDate;
	}
	public void setNextVacinationDate(String nextVacinationDate) {
		this.nextVacinationDate = nextVacinationDate;
	}
	public String getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(String displayInfo) {
		this.displayInfo = displayInfo;
	}
	public String deliveryInfo() {
		
		Random rand = new Random();
		int min = 1;
		int max = 150;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return dose = randomNum+" ml";
		
	}
	@Override
	public String toString() {
		System.out.print(deliveryInfo());
		return " Vaccine Name: " + name + ", Efficiency: " + efficiency + "%, Start Dose Date: " + startDoseDate+ ", Dose: " + dose + ", Info: " + name1+", Second Vaccine needed "+ displayInfo +" "+ nextVacinationDate  ;
	}

	
}
