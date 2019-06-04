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
   
   public void start(Stage window) throws IOException{
      
      
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("VIAClub.fxml"));
      Scene scene = new Scene(loader.load());
      
      window.setScene(scene);
      window.setResizable(false);
      window.show();
   }
   
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
   
   private ObservableList<Match> obList = FXCollections.observableArrayList();
   
   private MatchList matchList = new MatchList();
   
   private void UpdateTableView()
   {
      obList.clear();
      obList.addAll(matchList.getAllMatches());
   }
   
   public static void main(String[] args)
   {
   launch(args);
   }
   
}
