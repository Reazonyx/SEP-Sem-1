import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;

public class Gui_CreateMatch extends Application
{
   ObservableList<String> CMmatchTypesList = FXCollections
         .observableArrayList("Friendly", "Cup", "League");
   ObservableList<Integer> CMhourList = FXCollections.observableArrayList(00, 1,
         2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
         22, 23);
   ObservableList<Integer> CMminuteList = FXCollections.observableArrayList(00,
         15, 30, 45);
   ObservableList<Player> CMMPlayerList = FXCollections.observableArrayList();

   @FXML
   private TextField CMopponent;
   @FXML
   private TextField CMsubPlayer;
   @FXML
   private Button CMcreateMatch;
   // @FXML private TabPane createM;
   @FXML
   private TextField CMdate;

   // combo boxes
   @FXML
   private ComboBox<String> CMmatchTypes;
   @FXML
   private ComboBox<Integer> CMhours;
   @FXML
   private ComboBox<Integer> CMminutes;

   // Buttons
   @FXML
   private Button CMaddP;
   @FXML
   private Button CMremoveP;
   @FXML
   private Button CMcreate;

   // tableView Available
   @FXML
   private TableView<Player> CMaplayerTableView;
   @FXML
   private TableColumn<Player, String> CManameColumn;
   @FXML
   private TableColumn<Player, String> CMapositionColumn;
   @FXML
   private TableColumn<Player, Integer> CManumberColumn;
   @FXML
   private TableColumn<Player, String> CManoteColumn;

   // tableView usedplayers

   @FXML
   private TableView<Player> CMuplayerTableView;
   @FXML
   private TableColumn<Player, String> CMunameColumn;
   @FXML
   private TableColumn<Player, String> CMupositionColumn;
   @FXML
   private TableColumn<Player, Integer> CMunumberColumn;
   @FXML
   private TableColumn<Player, String> CMunoteColumn;

   @FXML
   private Alert CMtooManyP;
   @FXML
   private Alert CMmatchNS;

   // @FXML private EventHandler handle;
   // @FXML private MyActionListener listner;
   // @FXML private MyActionListener listener;

   private PlayerList CMplayerList = new PlayerList();
   private PlayerList CMuplayerList = new PlayerList();
   private CreateMatchAdapter CMadapter;
   private CreateMatchAdapter CMadapterM;

   /**
    * Initializes
    */
   @FXML
   private void initialize()
   {
      CMmatchTypes.setValue("Match Type");
      CMmatchTypes.setItems(CMmatchTypesList);

      CMhours.setValue(00);
      CMhours.setItems(CMhourList);

      CMminutes.setValue(00);
      CMminutes.setItems(CMminuteList);

      CMadapter = new CreateMatchAdapter("players.bin");
      CMadapterM = new CreateMatchAdapter("matches.bin");

      CManameColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("Name"));
      CManumberColumn.setCellValueFactory(
            new PropertyValueFactory<Player, Integer>("Number"));
      CMapositionColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("Position"));
      CManoteColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("Note"));

      CMunameColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("Name"));
      CMunumberColumn.setCellValueFactory(
            new PropertyValueFactory<Player, Integer>("Number"));
      CMupositionColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("Position"));
      CMunoteColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("Note"));

      if (CMadapter != null)
      {
         CMplayerList = CMadapter.getAllPlayers();
      }

      UpdateTableView();
   }

   public void start(Stage window) throws IOException

   {
      window.setTitle("VIAClub Manager");

      // createM = new Tab();

      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("CreateMatchGUI.fxml"));
      Scene scene = new Scene(loader.load());
      window.setScene(scene);
      window.setResizable(false);
      window.show();
   }

   private void UpdateTableView()
   {
      CMplayerList = CMadapter.getAllPlayers();
      CMaplayerTableView.getItems().clear();
      CMaplayerTableView.getItems().addAll(CMplayerList.getAllPlayers());
   }

   public void CMhandle(ActionEvent e)
   {

      if (e.getSource() == CMaddP)
      {

         if (CMmatchTypes.getSelectionModel().getSelectedItem().equals("Cup"))
         {
            if (CMuplayerTableView.getItems().size() < 16)
            {
               if (!CMuplayerTableView.getItems().contains(
                     CMaplayerTableView.getSelectionModel().getSelectedItem()))
               {
                  CMuplayerTableView.getItems().add(CMaplayerTableView
                        .getSelectionModel().getSelectedItem());
               }
            }
            else
            {
               CMtooManyP = new Alert(AlertType.INFORMATION);
               CMtooManyP.setTitle("Too Many Players!");
               CMtooManyP.setHeaderText(
                     "You are adding too many players to the Match of this Type");
               CMtooManyP.showAndWait();
            }
            // uplayerList.addPlayer(playerTableView.getItems().add(playerTableView.getSelectionModel().getSelectedItem()));
         }
         else if (CMmatchTypes.getSelectionModel().getSelectedItem()
               .equals("League"))
         {
            if (CMuplayerTableView.getItems().size() < 15)
            {
               if (!CMuplayerTableView.getItems().contains(
                     CMaplayerTableView.getSelectionModel().getSelectedItem()))
               {
                  CMuplayerTableView.getItems().add(CMaplayerTableView
                        .getSelectionModel().getSelectedItem());
               }
            }
            else
            {
               CMtooManyP = new Alert(AlertType.INFORMATION);
               CMtooManyP.setTitle("Too Many Players!");
               CMtooManyP.setHeaderText(
                     "You are adding too many players to the Match of this Type");
               CMtooManyP.showAndWait();
            }
         }
         else if (CMmatchTypes.getSelectionModel().getSelectedItem()
               .equals("Friendly"))
         {
            if (CMuplayerTableView.getItems().size() <= CMplayerList
                  .getNumOfPlayers())
            {
               if (!CMuplayerTableView.getItems().contains(
                     CMaplayerTableView.getSelectionModel().getSelectedItem()))
               {
                  CMuplayerTableView.getItems().add(CMaplayerTableView
                        .getSelectionModel().getSelectedItem());
               }
            }
            else
            {
               CMtooManyP = new Alert(AlertType.INFORMATION);
               CMtooManyP.setTitle("Too Many Players!");
               CMtooManyP.setHeaderText(
                     "You are adding too many players to the Match of this Type");
               CMtooManyP.showAndWait();
            }
         }
         else
         {
            CMmatchNS = new Alert(AlertType.INFORMATION);
            CMmatchNS.setTitle("Select Match");
            CMmatchNS.setHeaderText("You haven't selected match type");
            CMmatchNS.showAndWait();
         }
      }
      // remove Player object from Arraylist uPlayersList
      if (e.getSource() == CMremoveP)

      {
         CMuplayerTableView.getItems().remove(
               CMuplayerTableView.getSelectionModel().getSelectedItem());
      }

      // create match to bin
      if (e.getSource() == CMcreate)
      {

         String CMop = CMopponent.getText();

         String CMtype = CMmatchTypes.getSelectionModel().getSelectedItem();

         String CMdate = this.CMdate.getText();

         String[] datespl = CMdate.split("/");

         int day = Integer.parseInt(datespl[0]);
         int month = Integer.parseInt(datespl[1]);
         int year = Integer.parseInt(datespl[2]);
         int hour = CMhours.getSelectionModel().getSelectedItem();
         int minute = CMminutes.getSelectionModel().getSelectedItem();

         CMuplayerList = new PlayerList();

         for (int i = 0; i < CMuplayerTableView.getItems().size(); ++i)
         {

            CMuplayerList.addPlayer(CMuplayerTableView.getItems().get(i));
         }

         Match newMatch = new Match(CMop, 0, CMtype,
               new Date(day, month, year, hour, minute), CMuplayerList);

         CMadapterM.saveMatch(newMatch);
         
      }

   }

   public static void main(String[] args)
   {
      launch(args);
   }
}
