package library.borrow.create;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import library.Main;
import library.dao.impls.BookRepository;
import library.entities.Book;
import library.entities.Students;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookRentController implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox<Students> cbStudent;
    public DatePicker Expired;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookRepository rp = new BookRepository();
        ObservableList<Book> ls =FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbBook.setItems(ls);

    }

    public void submit(ActionEvent actionEvent) {
        Book selected = cbBook.getSelectionModel().getSelectedItem();
        Students sSelect = cbStudent.getSelectionModel().getSelectedItem();
        LocalDate dp = Expired.getValue();
        System.out.println(selected.getName());
        System.out.println(sSelect.getName());

    }

    public void gtHome(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
