package assignment1.book.edit;

import assignment1.Main;
import assignment1.book.BookList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField beId;
    public TextField beName;
    public TextField beAuthor;
    public Text check;


    public void gtBook(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource(".../edit/book/bookList"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(formScene);
    }

    public void eSubmit(ActionEvent actionEvent) {
        try {
            check.setVisible(false);
            if(beName.getText().isEmpty() || beAuthor.getText().isEmpty())
                throw new Exception("Vui long dien du thong tin");
            assignment1.book.Controller.uppdateBook.setName(beName.getText());
            assignment1.book.Controller.uppdateBook.setAuthor(beAuthor.getText());
            gtBook(null);
        }catch (Exception e){
            beName.setText(e.getMessage());
            beName.setVisible(true);
            beAuthor.setText(e.getMessage());
            beAuthor.setVisible(true);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (assignment1.book.Controller.uppdateBook == null) {
                gtBook(null);
            }
            beId.setText(assignment1.book.Controller.uppdateBook.getId());
            beName.setText(assignment1.book.Controller.uppdateBook.getName());
            beAuthor.setText(assignment1.book.Controller.uppdateBook.getAuthor());
            beId.setEditable(false);
        }catch (Exception f){

        }
    }
}
