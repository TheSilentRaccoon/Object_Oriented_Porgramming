/**
 * @author Maksims Kazoha R00188979
 */

package application;
	
//import java.text.SimpleDateFormat; could implement this because it gave weird errors and trying to resolve it was impossible
import java.util.Date;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Stage window;
	Scene scene1, scene2;
	
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		ClientCollection client_list = new ClientCollection();
		
		try {
			
			//Scene 1 Stuff
			Label label1 = new Label("Welcome to The Bandon Vaccination Center Menu");
			Button button1 = new Button("Applications");
			//Date
			Date date = new Date();
			
			//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			//System.out.println("Today's date is: "+dateFormat.format(date));
			//Scene 1 Stuff
			VBox layout1 = new VBox(20);
			layout1.setAlignment(Pos.CENTER);
			layout1.getChildren().addAll(label1, button1);
			scene1 = new Scene(layout1,800,400);
			
			//Scene 2 Stuff
			Label label2 = new Label("						This is the application menu here you will be able to manage all the clients");
			VBox layout2 = new VBox();
			VBox vertical = new VBox();
			label2.setAlignment(Pos.TOP_CENTER);
			Button button2 = new Button("Back");
			button2.setOnAction(e -> window.setScene(scene1));
			
			Label fName = new Label("First name:  ");
			Label lName = new Label("Last name:  ");
			Label id = new Label("ID:  ");
			Label pNumber = new Label("Phone Number:  ");
			Label Vac = new Label("Vaccine:  ");
			Label secondVac = new Label("Second Vaccine:  ");
			//TextArea
			TextArea details = new TextArea();
	        details.setEditable(false);
	        details.setPromptText("The list is currently empty.");
	        details.setPrefWidth(390);
	        button1.setOnAction(e -> {
				window.setScene(scene2);
				client_list.loadClient();
				String show = client_list.showClient();
				details.setText(show);
			});
			//TextFields
			TextField textFName = new TextField();
			textFName.setPromptText("First Name");
			TextField textLName = new TextField();
			textLName.setPromptText("Last Name");
			TextField textId = new TextField();
			textId.setPromptText("Client ID");
			TextField textPNumber = new TextField();
			textPNumber.setPromptText("Phone Number");
			TextField textVac = new TextField();
			textVac.setPromptText("Vaccine Name");
			TextField textVacEfficiency = new TextField();
			textVacEfficiency.setPromptText("Vaccine Efficiency");
			TextField textVacDate = new TextField();
			textVacDate.setPromptText("Vaccine Date");
			TextField textSecondsVac = new TextField();
			textSecondsVac.setPromptText("Second Vaccine if needed");
			TextField textSecondsVacInfo = new TextField();
			textSecondsVacInfo.setPromptText("Vaccine Info");
			TextField textSecondsVacDate = new TextField();
			textSecondsVacDate.setPromptText("Second Vaccine Date");
			TextField searchId = new TextField();
			searchId.setPromptText("Enter Client ID");
			//Buttons
			Button add = new Button("Add");
			add.setOnAction(e -> {
				//, textId.getText(), textPNumber.getText(), textVac.getText()
				String VacEfficiency = textVacEfficiency.getText();
				int vacEfficiency = Integer.parseInt(VacEfficiency);
				Name name = new Name(textFName.getText(), textLName.getText());
				Vaccination vac = new Vaccination(textVac.getText(), vacEfficiency, date);
				SecondVaccineNeeded secVac = new SecondVaccineNeeded(textVac.getText(), vacEfficiency, date, textSecondsVacDate.getText(),textSecondsVac.getText(), textSecondsVacInfo.getText());
				//secVac = vac;
				Client data = new Client(name, textId.getText(), textPNumber.getText(), secVac);
				client_list.addClient(data);
				String show = client_list.showClient();
				details.setText(show);
			});
			Button addDummy = new Button("Create Dummies");
			String dummyFName = "";
			String dummyLName = "";
			String dummyVac = "";
			String dummyDate = "";
			String dummySecVac = "";
			String dummyVacInfo = "";
			String dummyId = "";
			String dummyPNumber = "";
			int [] capacity = new int[1000];
			int dummyVacEfficiency = 0;
			addDummy.setOnAction(e->{
				for(int i = 0;i<capacity.length; i++) {
					Name name = new Name(dummyFName+i, dummyLName+i);
					Vaccination vac = new Vaccination(dummyVac+i, dummyVacEfficiency+i, date);
					SecondVaccineNeeded secVac = new SecondVaccineNeeded(dummyVac+i, dummyVacEfficiency+i, date, dummyDate+i,dummySecVac+i, dummyVacInfo+i);
					Client data = new Client(name, dummyId+i, dummyPNumber+i, secVac);
					client_list.addClient(data);
					String show = client_list.showClient();
					details.setText(show);
					
					//client_list.client_list.add(i, i);
				}
			});
			
			Button remove = new Button("Remove");
			remove.setOnAction(e -> {
				client_list.removeClient();
				String show = client_list.showClient();
				details.setText(show);
			});
			Button save = new Button("Save");
			save.setOnAction(e -> {
				client_list.saveClient();
				String show = client_list.showClient();
				details.setText(show);
			});
			Button load = new Button("Load");
			load.setOnAction(e -> {
				client_list.loadClient();
				String show = client_list.showClient();
				details.setText(show);
			});
			Button search = new Button("Search");
			search.setOnAction(e -> {
				String show = client_list.searchId(searchId.getText());
				details.setText(show);
			});
			
			//Menu
			Menu display = new Menu("Display");
			MenuItem display1 = new MenuItem("Display By Vaccine");
				display1.setOnAction(e -> {
				
			});
			MenuItem display2 = new MenuItem("Display By ID");
		        display2.setOnAction(e -> {
					
		    });
	        MenuItem display3 = new MenuItem("Display By Second Vaccine");
	        	display3.setOnAction(e -> {
				
			});
	        display.getItems().add(display1);
	        display.getItems().add(display2);
	        display.getItems().add(display3);
	        MenuBar menuDisplay = new MenuBar();
	        
	        menuDisplay.getMenus().add(display);
			//Grid Stuff
			GridPane grid = new GridPane();
			GridPane grid1 = new GridPane();
			grid.add(fName, 0, 1);
			grid.add(lName, 0, 2);
			grid.add(id, 0, 3);
			grid.add(pNumber, 0, 4);
			grid.add(Vac, 0, 5);
			grid.add(secondVac, 0, 8);
			grid.add(textFName, 1, 1);
			grid.add(textLName, 1, 2);
			grid.add(textId, 1, 3);
			grid.add(textPNumber, 1, 4);
			grid.add(textVac, 1, 5);
			grid.add(textVacEfficiency, 1, 6);
			grid.add(textSecondsVacInfo, 1, 7);
			grid.add(textSecondsVac, 1, 8);
			grid.add(textSecondsVacDate, 2, 8);
			grid1.add(add, 0, 0);
			grid1.add(remove, 1, 0);
			grid1.add(save, 2, 0);
			grid1.add(load, 3, 0);
			grid.add(search, 3, 1);
			grid.add(searchId, 4, 1);
			grid1.add(menuDisplay, 4, 0);
			grid1.add(addDummy, 5, 0);
			
			layout2.setPadding(new Insets(5, 5, 5, 5));
			grid1.setPadding(new Insets(5, 5, 5, 0));
			vertical.getChildren().addAll(grid1,details, button2);
			layout2.getChildren().addAll(label2, grid, vertical);
			scene2 = new Scene(layout2,700,400);
			
			//Window Stuff
			window.setResizable(false);
			window.setScene(scene1);
			window.setTitle("Bandon Vaccination Center");
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
