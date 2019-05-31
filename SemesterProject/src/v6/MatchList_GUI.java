import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
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
   private AnchorPane aPaneMatch;
   @FXML 
   private AnchorPane aPanePlayer;
   @FXML 
   private AnchorPane aPaneNewMatch;
   @FXML 
   private AnchorPane aPaneNewPlayer;
   @FXML 
   private AnchorPane aPanePrint;
   @FXML 
   private TableView twMatch;
   @FXML 
   private TableView twPlayer;
   @FXML 
   private TableColumn tcDate;
   @FXML 
   private TableColumn tcOppo;
   @FXML 
   private TableColumn tcType;
   @FXML 
   private TableColumn tcSubs;
   @FXML 
   private TableColumn tcRel;
   @FXML 
   private TableColumn tcName;
   @FXML 
   private TableColumn tcNum;
   @FXML 
   private TableColumn tcPos;
   @FXML 
   private TableColumn tcNote;
}

