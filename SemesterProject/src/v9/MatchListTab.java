import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class MatchListTab extends Tab
{
   private AnchorPane aPaneMatch;
 
   private TableView<Match> twMatch;
   private TableColumn<Match, String> tcDate;
   private TableColumn<Match, String> tcOppo;
   private TableColumn<Match, String> tcType;
   private TableColumn<Match, Integer> tcSubs;
   private TableColumn<Match, Boolean> tcRel;
   
   private Button getButton;

   private MyActionListener listener;

   private MatchListFileAdapter adapter;
   
   
   public MatchListTab(String title, MatchListFileAdapter adapter) {
      
      super(title);

      this.adapter = adapter;

      listener = new MyActionListener();
      
      aPaneMatch = new AnchorPane();
      
      twMatch = new TableView<Match>();
      
      tcDate = new TableColumn<Match, String>("Date");
      tcOppo = new TableColumn<Match, String>("Opponent");
      tcType = new TableColumn<Match, String>("Type");
      tcSubs = new TableColumn<Match, Integer>("SubsPlayers");
      tcRel = new TableColumn<Match, Boolean>("Relation");
      
      aPaneMatch.getChildren().add(twMatch);
      twMatch.getColumns().add(tcDate);
      twMatch.getColumns().add(tcOppo);
      twMatch.getColumns().add(tcType);
      twMatch.getColumns().add(tcSubs);
      twMatch.getColumns().add(tcRel);
      
      tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
      tcOppo.setCellValueFactory(new PropertyValueFactory<>("opponent"));
      tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
      tcSubs.setCellValueFactory(new PropertyValueFactory<>("subsPlayers"));
      tcRel.setCellValueFactory(new PropertyValueFactory<>("relation"));
     
      getButton = new Button("Get Students");
      getButton.setOnAction(listener);
      
      aPaneMatch.getChildren().add(getButton);
      
      super.setContent(aPaneMatch);
   }
   
   public void updateStudentArea()
   {
      twMatch.getItems().clear();
      MatchList matches = adapter.getAllMatches();
      
      for(int i = 0; i<matches.getNumOfMatches(); i++)
      {
         twMatch.getItems().add(matches.getMatch(i));
      }
   }
   
   private class MyActionListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         if (e.getSource() == getButton)
         {
            updateStudentArea();
         }
      }
   }
   
   
}
