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
   

   
   public void start(Stage window) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("VIAClub.fxml"));
      Scene scene = new Scene(loader.load());
      
      window.setScene(scene);
      window.setResizable(false);
      window.show();
   
   }
   
   public void initialize() {
      tcName.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getName()));
      tcNum.setCellValueFactory(celldata -> new SimpleObjectProperty<Integer>(celldata.getValue().getNumber()));
      tcPos.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getPosition()));
      tcNote.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getNote()));
      
           
      
      adapter = new PlayerListFileAdapter("players.bin");
      if (adapter != null)
      {
         playerList = adapter.getAllPlayers();
      }
      UpdateTableView();
   }
   
   private ObservableList<Player> obList = FXCollections.observableArrayList();
   
   private void UpdateTableView()
   {
      obList.clear();
      obList.addAll(playerList.getAllPlayers());
   }
   
   private PlayerList playerList = new PlayerList();
   
   
   
   
   public static void main(String[] args)
   {
   launch(args);
   }


}
