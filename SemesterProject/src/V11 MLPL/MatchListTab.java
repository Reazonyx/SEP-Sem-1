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

public class MatchListTab extends Application
{
   @FXML
   private TableView<Match> twMatch;
   @FXML
   private TableColumn<Match, Date> tcDate;
   @FXML
   private TableColumn<Match, String> tcOppo;
   @FXML
   private TableColumn<Match, String> tcType;
   @FXML
   private TableColumn<Match, Integer> tcSubs;
   
   private MatchListFileAdapter adapter;
   
   /**
    * A method that starts the GUI
    * @param window represents the overall window of the program;
    * @param scene represents the location on the window where the GUI is built
    * @param loader FXMLLoader that loads in the pre-made fxml;
    * @throws exception that signals that an I/O exception of some sort has occurred.
    */
   
   public void start(Stage window) throws IOException{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("VIAClub.fxml"));
      Scene scene = new Scene(loader.load());
      
      window.setScene(scene);
      window.setResizable(false);
      window.show();
   }
   
   
   /**
    * A method that initialises the cell data of the table view columns, also runs the if-statement that connects the adapter to the ArrayList if adapter is not connected;
    * @param tcDate represents column "Date";
    * @param tcOppo represents column "Opponent";
    * @param tcType represents column "Type";
    * @param tcSubs represents column "Substitute Players";
    * @param twMatch represents table view "Match List";
    * @param adapter represents the adapter that is a "sub" class with supporting methods for initialising fields;
    * @
    */
   
   public void  initialize() {
      tcDate.setCellValueFactory(celldata -> new SimpleObjectProperty<Date>(celldata.getValue().getDate()));
      tcOppo.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getOpponent()));
      tcType.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getMatchType()));
      tcSubs.setCellValueFactory(celldata -> new SimpleObjectProperty<Integer>(celldata.getValue().getSubstitutePlayer()));
      
      twMatch.setItems(obList);
      
      adapter = new MatchListFileAdapter("players.bin"); ////dont forget to change the .bin to the .bin file that Create/edit match section uses to write in
      if (adapter != null)
      {
         matchList = adapter.getAllMatches();
      }
      UpdateTableView();
      
   }
   
   /**
    * @param obList gives a possibility to the table view to display the data;
    */
   
   private ObservableList<Match> obList = FXCollections.observableArrayList();
  
   private MatchList matchList = new MatchList();
  
   /**
    * Method that clears the data in the observable list and then adds all data again, like this the "refresh" function is made;
    */
   private void UpdateTableView()
   {
      obList.clear();
      obList.addAll(matchList.getAllMatches());
   }
   
   /**
    * Launcher that starts the program;
    * @param args
    */
   public static void main(String[] args)
   {
   launch(args);
   }
   
}
