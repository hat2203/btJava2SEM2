package assignment1.borrowBook;

import assignment1.Main;
import assignment1.book.BookList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ListView<BorrowList> borrowList;
    public static ObservableList<BorrowList> brList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borrowList.setItems(brList);
    }

    public void gtHome(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("trangChu.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(formScene);
    }

    public void editBorrow(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../borrowBook/edit/editBorrow.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Edit Renter");
        Main.rootStage.setScene(formScene);
    }

    public void moreBorrow(ActionEvent actionEvent) throws Exception{
        Parent formPage = FXMLLoader.load(getClass().getResource("../borrowBook/more/moreBorrow.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("More Renter");
        Main.rootStage.setScene(formScene);
    }
}
