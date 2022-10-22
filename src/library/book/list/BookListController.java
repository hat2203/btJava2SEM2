package library.book.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.dao.impls.BookRepository;
import library.entities.Book;
import library.helper.Connector;

import java.net.URL;
import java.sql.*;
import java.util.Collections;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    public TableView<Book> tbBook;
    public TableColumn<Book, Integer> bId;
    public TableColumn<Book, String> bName;
    public TableColumn<Book, String> bAuthor;
    public TableColumn<Book, Integer> bQty;
    public  TableColumn<Book, Button> bEdit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        bName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        bAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        bQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));
        bEdit.setCellValueFactory(new PropertyValueFactory<Book, Button>("edit"));

        ObservableList<Book> ls = FXCollections.observableArrayList();

        BookRepository rp = new BookRepository();
        ls.addAll(rp.all());
        tbBook.setItems(ls);

    }

    public void gotoHome(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void createBook(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/createBook.fxml"));
        library.Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
