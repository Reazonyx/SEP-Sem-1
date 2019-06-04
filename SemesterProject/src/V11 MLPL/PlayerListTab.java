import java.io.IOException;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
/**
 * A class representing the graphical user interface of Match List.
 * @author Romans Jefremovs
 * @version 3.0
 */

public class PlayerListTab extends Application
{
   @FXML
   private TableView<Player> twPlayer;
   @FXML
   private TableColumn<Player, String> tcName;
   @FXML
   private TableColumn<Player, Integer> tcNum;
   @FXML
   private TableColumn<Player, String> tcPos;
   @FXML
   private TableColumn<Player, String> tcNote;
   @FXML
   private PlayerListFileAdapter adapter;
   
   /**
    * A method that starts the GUI
    * @param window represents the overall window of the program;
    * @param scene represents the location on the window where the GUI is built
    * @param loader FXMLLoader that loads in the pre-made fxml;
    * @throws exception that signals that an I/O exception of some sort has occurred.
    */
   
   public void start(Stage window) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("VIAClub.fxml"));
      Scene scene = new Scene(loader.load());
      
      window.setScene(scene);
      window.setResizable(false);
      window.show();
   
   }
   
   /**
   * A method that initialises the cell data of the table view columns, also runs the if-statement that connects the adapter to the ArrayList if adapter is not connected;
   * @param tcName represents column "Name";
   * @param tcNum represents column "Number";
   * @param tcPos represents column "Pos";
   * @param tcNote represents column "Note";
   * @param twPlayer represents table view "Player List";
   * @param adapter represents the adapter that is a "sub" class with supporting methods for initialising fields;
   * @
   */
   
   public void initialize() {
      tcName.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getName()));
      tcNum.setCellValueFactory(celldata -> new SimpleObjectProperty<Integer>(celldata.getValue().getNumber()));
      tcPos.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getPosition()));
      tcNote.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getNote()));
      
      twPlayer.setItems(obList);
      
      adapter = new PlayerListFileAdapter("players.bin");
      if (adapter != null)
      {
         playerList = adapter.getAllPlayers();
      }
      UpdateTableView();
   }
   
   /**
    * Creates an arrayList;
    * @param obList gives a possibility to the table view to display the data;
    */
   
   private ObservableList<Player> obList = FXCollections.observableArrayList();
   
   /**
    * Method that clears the data in the observable list and then adds all data again, like this the "refresh" function is made;
    */
   
   private void UpdateTableView()
   {
      obList.clear();
      obList.addAll(playerList.getAllPlayers());
   }
   
   private PlayerList playerList = new PlayerList();
   
   /**
    * Launcher that starts the program;
    * @param args
    */
   
   public static void main(String[] args)
   {
   launch(args);
   }


}
