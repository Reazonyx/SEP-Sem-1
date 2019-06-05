import java.io.IOException;
import javafx.application.Application;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class VIAClub extends Application
{
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                          General                                                     ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   private PlayerFileAdapter adapter;
   private MyListListener CEPlistListener;
   private PlayerList CMplayerList = new PlayerList();
   private PlayerList CMuplayerList = new PlayerList();
   private CreateMatchAdapter CMadapter;
   private CreateMatchAdapter CMadapterM;
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                       Create Edit Player                                             ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   @FXML private Button CEPnewButton;
   @FXML private Button CEPremoveButton;
   @FXML private Button CEPsaveButton;
   
   @FXML private TextField CEPnameTextField;
   @FXML private TextField CEPpositionTextField;
   @FXML private TextField CEPnumberTextField;
   @FXML private TextField CEPnoteTextField;
   
   @FXML private TableView<Player> CEPplayerTableView;
   @FXML private TableColumn<Player, String> CEPnameColumn;
   @FXML private TableColumn<Player, String> CEPpositionColumn;   
   @FXML private TableColumn<Player, Integer> CEPnumberColumn;
   @FXML private TableColumn<Player, String> CEPnoteColumn;
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                       Create Edit Match                                             ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   @FXML
   private TextField CMopponent;
   @FXML
   private TextField CMsubPlayer;
   
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
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                          Player List                                                 ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
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
   
      
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                          Match List                                                  ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   @FXML
   private TableView<Match> twMatch;
   @FXML
   private TableColumn<Match, Date> tcDate;
   @FXML
   private TableColumn<Match, Date> tcTime;
   @FXML
   private TableColumn<Match, String> tcOppo;
   @FXML
   private TableColumn<Match, String> tcType;
   @FXML
   private TableColumn<Match, Integer> tcSubs;
   
   private MatchListFileAdapter MLadapter;
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   public void start(Stage window) throws IOException
   {
   window.setTitle("VIA Club Management System");

   FXMLLoader loader = new FXMLLoader();
   loader.setLocation(getClass().getResource("VIAClub.fxml"));
   Scene scene = new Scene(loader.load());
   window.setScene(scene);
   window.show();
   
   }
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                                                                                      ///
   ///                                       Create Edit Player                                             ///
   ///                                                                                                      ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////

   @FXML
   public void initialize()
   {
      
      CEPnameColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("name"));
      CEPnumberColumn.setCellValueFactory(
            new PropertyValueFactory<Player, Integer>("number"));
      CEPpositionColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("position"));
      CEPnoteColumn.setCellValueFactory(
            new PropertyValueFactory<Player, String>("note"));
      
      // 2nd. method to set up the columns in the table. 
      /*
      CEPnameColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getName()));
      CEPnumberColumn.setCellValueFactory(celldata -> new SimpleObjectProperty<Integer> (celldata.getValue().getNumber()));
      CEPpositionColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getPosition()));
      CEPnoteColumn.setCellValueFactory(celldata -> new SimpleStringProperty( celldata.getValue().getNote()));
      */
      
      CEPplayerTableView.setItems(CEPobList);
      
      //Edit column set to true.
      CEPplayerTableView.setEditable(true);
      CEPnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      CEPnumberColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
      CEPpositionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      CEPnoteColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      
      CEPnewButton.setOnAction(event -> {
         newButton();
      });
      
      adapter = new PlayerFileAdapter("players.bin");
      if (adapter != null)
      {
         playerList = adapter.getAllPlayers();
      }
      UpdateTableView();
      CEPlistListener = new MyListListener();
      CEPplayerTableView.getSelectionModel().selectedItemProperty().addListener(CEPlistListener);
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
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

      CMUpdateTableView();
      
      /////////////////////////////////////////////////////////////////////////////////////////////////
      
      //PLinitialize();
   }
   
   private ObservableList<Player> CEPobList = FXCollections.observableArrayList();
   
   private PlayerList playerList = new PlayerList();
   
   private void UpdateTableView()
   {
      playerList = adapter.getAllPlayers();
      CEPobList.clear();
      CEPobList.addAll(playerList.getAllPlayers());
   }
   
   public void newButton()
   {
      Player players = new Player(CEPnameTextField.getText(), 
                                 Integer.parseInt(CEPnumberTextField.getText()), 
                                 CEPpositionTextField.getText(), 
                                 CEPnoteTextField.getText());
      
      playerList = adapter.getAllPlayers();
      playerList.addPlayer(players);
      
      adapter.savePlayers(playerList);
      UpdateTableView();
      
   }
   
   public void removeButton(ActionEvent actionEvent)
   {
      
      ObservableList<Player> allPlayer;
      ObservableList<Player> singlePlayer;
      allPlayer = CEPplayerTableView.getItems();
      singlePlayer = CEPplayerTableView.getSelectionModel().getSelectedItems();
      singlePlayer.forEach(allPlayer::remove);
      
      PlayerList temp = new PlayerList();
      
      for (int i = 0; i < allPlayer.size(); i++)
      {
         temp.addPlayer(allPlayer.get(i));
      }
      
      adapter.savePlayers(temp);
   }
   
   public void onEditChangedInt(TableColumn.CellEditEvent<Player, Integer> playerIntegerCellEditEvent)
   {
      Player player = CEPplayerTableView.getSelectionModel().getSelectedItem();
      
      if(playerIntegerCellEditEvent.getTableColumn()==CEPnumberColumn)
      {
         player.setNumber(playerIntegerCellEditEvent.getNewValue());
      }
      
      Player temp = CEPplayerTableView.getSelectionModel().getSelectedItem();
      
      if (temp != null)
      {
         CEPnumberTextField.setText(temp.getNumber()+"");
      }
      
   }
   
   public void onEditChanged(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent)
   {      
      Player player = CEPplayerTableView.getSelectionModel().getSelectedItem();
      
      if(playerStringCellEditEvent.getTableColumn()==CEPnameColumn)
      {
         player.setName(playerStringCellEditEvent.getNewValue());
      }
      
      if(playerStringCellEditEvent.getTableColumn()==CEPpositionColumn)
      {
         player.setPosition(playerStringCellEditEvent.getNewValue());
      }
      
      if(playerStringCellEditEvent.getTableColumn()==CEPnoteColumn)
      {
         player.setNote(playerStringCellEditEvent.getNewValue());
      }

      adapter.savePlayers(playerList); 
      
      Player temp = CEPplayerTableView.getSelectionModel().getSelectedItem();
      
      if (temp != null)
      {
        
         CEPnameTextField.setText(temp.getName());
       
         CEPpositionTextField.setText(temp.getPosition());
         CEPnoteTextField.setText(temp.getNote());
         
      }
     
   }
   
   public void handle(ActionEvent e)
   {
      if (!CEPnameTextField.getText().isEmpty() 
            && !CEPnumberTextField.getText().isEmpty() 
            && !CEPpositionTextField.getText().isEmpty() 
            && !CEPnoteTextField.getText().isEmpty());
      
         String name = CEPnameTextField.getText();
         int number = 0;
         if (!CEPnumberTextField.getText().isEmpty())
         {
            number = Integer.parseInt(CEPnumberTextField.getText());
         } 
         String position = CEPpositionTextField.getText();
         String note = CEPnoteTextField.getText();

         if (name.equals(""))
         {
            name = "?";
         }
         

         adapter.changeName(name, number, position, note);
         UpdateTableView();
         CEPnameTextField.setText("");
      }
   
   private class MyListListener implements ChangeListener<Player>
   {
      public void changed(ObservableValue<? extends Player> player, Player oldPlayer, Player newPlayer)
      {
         Player temp = CEPplayerTableView.getSelectionModel().getSelectedItem();
        
         if (temp != null)
         {
           
            CEPnameTextField.setText(temp.getName());
            CEPnumberTextField.setText(temp.getNumber()+"");
            CEPpositionTextField.setText(temp.getPosition());
            CEPnoteTextField.setText(temp.getNote());
            
         }
      }
   }
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                                                                                      ///
   ///                                       Create Edit Match                                              ///
   ///                                                                                                      ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   ObservableList<String> CMmatchTypesList = FXCollections
         .observableArrayList("Friendly", "Cup", "League");
   ObservableList<Integer> CMhourList = FXCollections.observableArrayList(00, 1,
         2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
         22, 23);
   ObservableList<Integer> CMminuteList = FXCollections.observableArrayList(00,
         15, 30, 45);
   ObservableList<Player> CMMPlayerList = FXCollections.observableArrayList();
   
   

   private void CMUpdateTableView()
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
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                                                                                      ///
   ///                                          Player List                                                 ///
   ///                                                                                                      ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   /**
    * A method that initializes the cell data of the table view columns, also runs the if-statement that connects the adapter to the ArrayList if adapter is not connected;
    * @param tcDate represents column "Date";
    * @param tcOppo represents column "Opponent";
    * @param tcType represents column "Type";
    * @param tcSubs represents column "Substitute Players";
    * @param twMatch represents table view "Match List";
    * @param adapter represents the adapter that is a "sub" class with supporting methods for initializing fields;
    * @
    */
   
   public void PLinitialize() {
      
      tcName.setCellValueFactory(
            new PropertyValueFactory<Player, String>("name"));
      tcNum.setCellValueFactory(
            new PropertyValueFactory<Player, Integer>("number"));
      tcPos.setCellValueFactory(
            new PropertyValueFactory<Player, String>("position"));
      tcNote.setCellValueFactory(
            new PropertyValueFactory<Player, String>("note"));      
     
      
      playerList = adapter.getAllPlayers();
      
      UpdateTableView2();
   }
   
   /**
    * Method that clears the data in the observable list and then adds all data again, like this the "refresh" function is made;
    */
   
   private void UpdateTableView2()
   {
      playerList = adapter.getAllPlayers();
      CEPobList.clear();
      CEPobList.addAll(playerList.getAllPlayers());
   }
      
   
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                                                                                      ///
   ///                                          Match List                                                  ///
   ///                                                                                                      ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   /**
    * A method that initializes the cell data of the table view columns, also runs the if-statement that connects the adapter to the ArrayList if adapter is not connected;
    * @param tcDate represents column "Date";
    * @param tcOppo represents column "Opponent";
    * @param tcType represents column "Type";
    * @param tcSubs represents column "Substitute Players";
    * @param twMatch represents table view "Match List";
    * @param adapter represents the adapter that is a "sub" class with supporting methods for initializing fields;
    * @
    */
   
   public void  MLinitialize() {
      
      tcDate.setCellValueFactory(
            new PropertyValueFactory<Match, Date>("date"));
      //tcTime.setCellValueFactory(
            //new PropertyValueFactory<Match, Date>("time"));
      tcOppo.setCellValueFactory(
            new PropertyValueFactory<Match, String>("opponent"));
      tcType.setCellValueFactory(
            new PropertyValueFactory<Match, String>("matchType"));
      tcSubs.setCellValueFactory(
            new PropertyValueFactory<Match, Integer>("numOfSubPlayers"));
      
      
      twMatch.setItems(MLobList);
      
      MLadapter = new MatchListFileAdapter("Matches.bin"); 
      if (MLadapter != null)
      {
         matchList = MLadapter.getAllMatches();
      }
      MLUpdateTableView();
      
   }
   
   /**
    * @param obList gives a possibility to the table view to display the data;
    */
   
   private ObservableList<Match> MLobList = FXCollections.observableArrayList();
   
   /**
    * 
    */
   
   private MatchList matchList = new MatchList();
   
   /**
    * Method that clears the data in the observable list and then adds all data again, like this the "refresh" function is made;
    */
   
   private void MLUpdateTableView()
   {
      MLobList.clear();
      MLobList.addAll(matchList.getAllMatches());
   }
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                                                                                      ///
   ///                                                Print                                                 ///
   ///                                                                                                      ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   /**
    * method for building match report as HTML page
    * @param fileName name of HTML file report
    * @param date day of match
    * @param opponent 
    * @param relevance
    */
   public static void build(String fileName, String[] date, String[] opponent, String[] relevance)
   {
      //HTML file IO class object
      MyHtmlFileIO mhfio = new MyHtmlFileIO();
      
      //initial content of table
      String tableContents = "";
      
      //generating table content
      for(int index = 0; index < date.length; index++)
      {
         //table row
         tableContents += "<tr>";
         
         /*-------Date-------*/
         //table data
         tableContents += "<td>";
         tableContents += date[index];
         //end of table data
         tableContents += "</td>";
         
         /*-------Opponent-------*/
         //table data
         tableContents += "<td>";
         tableContents += opponent[index];
         //end of table data
         tableContents += "</td>";
         
         /*-------Relevance-------*/
         //table data
         tableContents += "<td>";
         tableContents += relevance[index];
         //end of table data
         tableContents += "</td>";
         
         //end of table row
         tableContents += "<tr>";
      }
      
      //output of table content
      try 
      {
         mhfio.writeToFile(fileName, "$tableContents", tableContents);
      }
      catch(Exception e)
      {
         System.out.println("HTML template file was not found. Exception message: " + e.getMessage());
      }
   }
   
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                                                                                      ///
   ///                                             Launch(args)                                             ///
   ///                                                                                                      ///
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   public static void main(String[] args)
   {
   launch(args);
   }

}