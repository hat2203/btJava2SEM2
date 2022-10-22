package library.students.list;

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
import library.dao.impls.StudentRepository;
import library.entities.Book;
import library.entities.Students;
import library.helper.Connector;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Students> tbStudents;
    public TableColumn<Students, Integer> sId;
    public TableColumn<Students, String> sName;
    public TableColumn<Students, String> sEmail;
    public TableColumn<Students, String> sTel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sId.setCellValueFactory(new PropertyValueFactory<Students, Integer>("id"));
        sName.setCellValueFactory(new PropertyValueFactory<Students, String>("name"));
        sEmail.setCellValueFactory(new PropertyValueFactory<Students, String>("email"));
        sTel.setCellValueFactory(new PropertyValueFactory<Students, String>("tel"));

        ObservableList<Students> slist = FXCollections.observableArrayList();

        StudentRepository srp = new StudentRepository();
        slist.addAll(srp.all());
        tbStudents.setItems(slist);

    }

    public void gotoHome(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listBook,800,600));

    }

    public void createStudent(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/createStudent.fxml"));
        library.Main.rootStage.setTitle("Student");
        library.Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
