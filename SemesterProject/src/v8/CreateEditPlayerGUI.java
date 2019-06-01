import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateEditPlayerGUI extends Application
{
   private PlayerFileAdapter adapter;
   
   @FXML private Button newButton;
   @FXML private Button removeButton;
   @FXML private Button saveButton;
   
   @FXML private TextField nameTextField;
   @FXML private TextField positionTextField;
   @FXML private TextField numberTextField;
   @FXML private TextField noteTextField;
   
   @FXML private TableView<Player> playerTableView;
   @FXML private TableColumn<Player, String> nameColumn;
   @FXML private TableColumn<Player, String> positionColumn;   
   @FXML private TableColumn<Player, Integer> numberColumn;
   @FXML private TableColumn<Player, String> noteColumn;
   
   //@FXML private MyActionListener listener;
   //@FXML private MyListListener listListener;
   
   
   
   
   public void start(Stage window) throws IOException
   {
   window.setTitle("A Simple Window 2");
   
   
   
   FXMLLoader loader = new FXMLLoader();
   loader.setLocation(getClass().getResource("CreateEditPlayerGUI.fxml"));
   Scene scene = new Scene(loader.load());
   window.setScene(scene);
   window.show();
   
   }
   

   
   public void initialize()
   {
      //Sets up the columns in the table.
      nameColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getName()));
      numberColumn.setCellValueFactory(celldata -> new SimpleObjectProperty<Integer> (celldata.getValue().getNumber()));
      positionColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getPosition()));
      noteColumn.setCellValueFactory(celldata -> new SimpleStringProperty( celldata.getValue().getNote()));
      
      
      newButton.setOnAction(event -> {
         newButton();
      });
      
      
      playerTableView.setItems(obList);
      
      adapter = new PlayerFileAdapter("players.bin");
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
   
   public void newButton()
   {
      Player players = new Player(nameTextField.getText(), 
                                 Integer.parseInt(numberTextField.getText()), 
                                 positionTextField.getText(), 
                                 noteTextField.getText());
      
      playerList.addPlayer(players);
      
      adapter.savePlayers(playerList);
      UpdateTableView();
      
   }
   
   public void handle(ActionEvent e)
   {
      
   }
   
   public static void main(String[] args)
   {
   launch(args);
   }

}