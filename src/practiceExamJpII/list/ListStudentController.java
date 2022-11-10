package practiceExamJpII.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import practiceExamJpII.Students;

import java.net.URL;
import java.util.ResourceBundle;

public class ListStudentController implements Initializable {
    public TableView tbStudent;
    public TableColumn<Students, String> sId;
    public TableColumn<Students, String> sName;
    public TableColumn<Students, String> sAddress;
    public TableColumn<Students, String> sPhone;

    ObservableList<Students> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sId.setCellValueFactory(new PropertyValueFactory<>("id"));
        sName.setCellValueFactory(new PropertyValueFactory<>("name"));
        sAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        sPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
         tbStudent.setItems(list);
    }

    public void gtHome(ActionEvent actionEvent) throws Exception {
        Parent home = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(home,800,600));
    }

    public void crStudent(ActionEvent actionEvent) throws Exception {
        Parent create = FXMLLoader.load(getClass().getResource("../creat/createStudent.fxml"));
        practiceExamJpII.Main.rootStage.setTitle("Create");
        practiceExamJpII.Main.rootStage.setScene(new Scene(create, 800,600));
    }
}
