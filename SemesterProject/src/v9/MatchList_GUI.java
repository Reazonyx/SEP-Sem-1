import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class MatchList_GUI extends Application
{
   @FXML 
   private Scene scene;
   @FXML 
   private Stage stage;
   @FXML 
   private TitledPane mainPane;
   @FXML 
   private AnchorPane aPaneMain;
   @FXML 
   private TabPane tabPane;
   @FXML 
   private Tab matchList;
   @FXML 
   private Tab playerList;
   @FXML 
   private Tab newMatch;
   @FXML 
   private Tab newPlayer;
   @FXML 
   private Tab print;
  

   @FXML 
   private AnchorPane aPaneNewMatch;
   @FXML 
   private AnchorPane aPaneNewPlayer;
   @FXML 
   private AnchorPane aPanePrint;
   
   
   
//   private ObservableList<Match> MatchesData = FXCollections.observableArrayList();
   
   public void start(Stage window) {
      
      mainPane = new TitledPane("VIACLUB manager",aPaneMain);
      aPaneMain = new AnchorPane();
      tabPane = new TabPane();
      matchList = new Tab();
      playerList = new Tab();
      newMatch = new Tab();
      newPlayer = new Tab();
      print = new Tab();
      aPaneNewMatch = new AnchorPane();
      aPaneNewPlayer = new AnchorPane();
      aPanePrint = new AnchorPane();
     
      
      mainPane.getChildrenUnmodifiable().add(aPaneMain);
      aPaneMain.getChildren().add(tabPane);
      tabPane.getTabs().addAll(matchList, playerList,newMatch, newPlayer, print);
      matchList.setContent(aPaneMatch);
      playerList.setContent(aPanePlayer);
      newMatch.setContent(aPaneNewMatch);
      newPlayer.setContent(aPaneNewPlayer);
      print.setContent(aPanePrint);
      
      
   }
   
}

