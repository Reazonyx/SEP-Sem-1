import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PlayerListTab extends Tab
{
   private AnchorPane aPanePlayer;
   
   private TableView<Player> twPlayer;

   private TableColumn<Player, String> tcName;
 
   private TableColumn<Player, Integer> tcNum;
  
   private TableColumn<Player, String> tcPos;
  
   private TableColumn<Player, String> tcNote;
   
   private Button getButton;

   private MyActionListener listener;

   private PlayerListFileAdapter adapter;
   
   public PlayerListTab(String title, PlayerListFileAdapter adapter) {
      
      super(title);

      this.adapter = adapter;

      listener = new MyActionListener();
      
      aPanePlayer = new AnchorPane();
      
      twPlayer = new TableView<Player>();
      
      tcName = new TableColumn<Player, String>("Name");
      tcNum = new TableColumn<Player, Integer>("Number");
      tcPos = new TableColumn<Player, String>("Position");
      tcNote = new TableColumn<Player, String>("Note");
      
      twPlayer.getColumns().add(tcName);
      twPlayer.getColumns().add(tcNum);
      twPlayer.getColumns().add(tcPos);
      twPlayer.getColumns().add(tcNote);
     
      tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
      tcNum.setCellValueFactory(new PropertyValueFactory<>("number"));
      tcPos.setCellValueFactory(new PropertyValueFactory<>("position"));
      tcNote.setCellValueFactory(new PropertyValueFactory<>("note"));
      
      getButton = new Button("Get Students");
      getButton.setOnAction(listener);
      
      aPanePlayer.getChildren().add(getButton);
      
      super.setContent(aPanePlayer);
   }
   
   public void updatePlayerArea()
   {
      twPlayer.getItems().clear();
      PlayerList matches = adapter.getAllPlayers();
      
      for(int i = 0; i<matches.getNumOfPlayers(); i++)
      {
         twPlayer.getItems().add(matches.getPlayer(i));
      }
   }
   
   private class MyActionListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         if (e.getSource() == getButton)
         {
            updatePlayerArea();
         }
      }
   }

}
