import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.cell.TextFieldTableCell;
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
   @FXML private MyListListener listListener;
   
   
   
   
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
      
      
      //Edit column set to true.
      playerTableView.setEditable(true);
      nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      //numberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      positionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      noteColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      
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
   
   public void removeButton(ActionEvent actionEvent)
   {
      ObservableList<Player> allPlayer, singlePlayer;
      allPlayer = playerTableView.getItems();
      singlePlayer = playerTableView.getSelectionModel().getSelectedItems();
      singlePlayer.forEach(allPlayer::remove);
   }
   
   public void onEditChanged(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent)
   {
      Player player = playerTableView.getSelectionModel().getSelectedItem();
      player.setName(playerStringCellEditEvent.getNewValue());
      //player.setNumber(playerStringCellEditEvent.getNewValue());
      player.setPosition(playerStringCellEditEvent.getNewValue());
      player.setNote(playerStringCellEditEvent.getNewValue());
      
      adapter.savePlayers(playerList);
      UpdateTableView();
   }
   
   public void handle(ActionEvent e)
   {
         String name = nameTextField.getText();
         int number = Integer.parseInt(numberTextField.getText());
         String position = positionTextField.getText();
         String note = noteTextField.getText();

         if (name.equals(""))
         {
            name = "?";
         }

         adapter.changeName(name, number, position, note);
         UpdateTableView();
         nameTextField.setText("");
      }
   
   private class MyListListener implements ChangeListener<Player>
   {
      public void changed(ObservableValue<? extends Player> player, Player oldPlayer, Player newPlayer)
      {
         Player temp = playerTableView.getSelectionModel().getSelectedItem();
        
         if (temp != null)
         {
           
            nameTextField.setText(temp.getName());
            //numberTextField.setText(Integer.parseInt(temp.getNumber()));
            positionTextField.setText(temp.getPosition());
            noteTextField.setText(temp.getNote());
            
         }
      }
   }
   
   public static void main(String[] args)
   {
   launch(args);
   }

}