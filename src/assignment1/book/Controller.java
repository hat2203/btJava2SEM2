package assignment1.book;

import assignment1.Main;
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
    public ListView<BookList> bookList;
    public static ObservableList<BookList> list = FXCollections.observableArrayList();
    public static BookList uppdateBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookList.setItems(list);
    }

    public void gtHome(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("trangChu.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(formScene);
    }

    public void editBook(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../book/edit/editBook.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Edit Books");
        Main.rootStage.setScene(formScene);
    }

    public void moreBook(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../book/more/moreBook.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("More Books");
        Main.rootStage.setScene(formScene);
    }
}
