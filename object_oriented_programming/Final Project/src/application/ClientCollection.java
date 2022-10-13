/**
 * @author Maksims Kazoha R00188979
 */
package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class ClientCollection implements Serializable {
	
	/**
	 * @param Client Arraylist which is linked to the Client Class
	 *
	 */
	public static ArrayList<Client> client_list;
	/**
	 * @param We create a new ClientCollection Arraylist
	 */
	public ClientCollection(){
		client_list = new ArrayList<Client>();
	}
	/**
	 * 
	 * @param Adding clients to the ClientCollection Array
	 */
	public void addClient(Client c) {
		client_list.add(c);
		
	}
	/**
	 * 
	 * @return Removing the top person from the Array list
	 * We use a simple For loop to cycle through the arraylist and get the first person from the arraylist.
	 */
	public String removeClient() {
		for (int i = 0; i < client_list.size();i++) {
			if (((i>-1))&&(i < client_list.size())) {
				client_list.remove(i);
				break;
			}
		}
		return null;	
	}
	/**
	 * @param Saving the client to a serializable file called Client.ser 
	 * we create a file output stream fos into the file and object output stream to get the objects from the arraylist
	 * and write them into the file.
	 */
	public void saveClient() {
		try {
			FileOutputStream fos = new FileOutputStream("Client.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(client_list);
			oos.close();
			fos.close();
			System.out.println("The Data was serialized and saved as Client.ser");
		}catch(IOException i){
			i.printStackTrace();
		}
	}
	
	/**
	 * @param Loading the the file into the arraylist using a file input stream to get info from the file
	 * and object input stream to input the information into the arraylist
	 */
	public void loadClient() {
		
		File f = new File("C:/Users/Admin/eclipse-workspace/Repeat_Project/Client.ser");
		/**
		 * @param we check if the file exisits and if not we send a error message
		 */
		if(f.isFile()) {
		try {
			FileInputStream fi = new FileInputStream("Client.ser");
			ObjectInputStream ois = new ObjectInputStream(fi);
			client_list = (ArrayList<Client>) ois.readObject();
			ois.close();
			fi.close();
			
		}catch(IOException i){
			i.printStackTrace();
			
		} catch(ClassNotFoundException c) {
			c.printStackTrace();
			
		}
		/**
		 * for loop to get the information out of the file and store it within the arraylist
		 * and a simple print statement to see if it worked
		 */
		for(int i = 0; i < client_list.size(); i++) {
			Client name = client_list.get(i);
			Client id = (Client)client_list.get(i);
			Client pNumber = (Client)client_list.get(i);
			Client vac = client_list.get(i);
			System.out.println(name.getName() +" "+id.getId() +" "+ pNumber.getPhoneNumber() +" "+ vac.getVaccination());
			
		}
		System.out.println("The information was deserialized and loaded into the system.");
		}else {
			System.out.println("Such file doesnt exists please create one!");
		}
	}
	/**
	 * 
	 * 
	 * @return we go through the arraylist and add it into a empty string which will allow use
	 * to use that string in a TextArea
	 */
	public String showClient() {
		
		String list = "";
		for(int i = 0; i < client_list.size(); i++) {
			list = list+client_list.get(i);
		}
		return list;
	}
	public String showClientId() {
		
		return null;
	}
	public String showClientSecondDose() {
		return null;
	}
	/**
	 * @param name Name class to store first and last names
	 * @param id string id number to find the information easier
	 * @param pNumber String phone number to be able to call the client if something is wrong
	 * @param vac Vaccination Class to keep all vaccine information in one class and call it all at once
	 * @return show what results we got by looking up the persons id
	 */
	public String searchId(Name name, String id, String pNumber, Vaccination vac) {
		return searchId(name +" "+ id +" "+pNumber +" "+vac);
	}
	/**
	 * 
	 * @param idLook What id are we looking for with in the system
	 * @return we return what we found
	 */
	public String searchId(String idLook) {
		String list = "";
		for(int i = 0; i<client_list.size(); i++) {
			if(client_list.get(i).getId().equals(idLook)) {
				list = list+client_list.get(i);
				System.out.println(list);
				return list;
			}
		}
		return list;
	}
	
}
