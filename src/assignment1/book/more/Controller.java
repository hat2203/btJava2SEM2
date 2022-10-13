package assignment1.book.more;

import assignment1.Main;
import assignment1.book.BookList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;

public class Controller {
    public TextField bmId;
    public TextField bmName;
    public TextField bmAuthor;
    public Text check;

    public void gtBook(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource(".../edit/book/bookList"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(formScene);
    }

    public void bmSubmit(ActionEvent actionEvent) {
        try{
            check.setVisible(false);
            if (bmId.getText().isEmpty() || bmName.getText().isEmpty()|| bmAuthor.getText().isEmpty())
                throw new Exception("Vui long dien day du thong tin");
            for (BookList b : assignment1.book.Controller.list){
                if(b.getId().equals(bmId.getText()))
                    throw new Exception("Ma sach da ton tai");
            }
            assignment1.book.Controller.list.add(new BookList(bmId.getText(),bmName.getText(),bmAuthor.getText()));
            gtBook(null);
        }catch (Exception e){
            bmId.setText(e.getMessage());
            bmId.setVisible(true);
            bmName.setText(e.getMessage());
            bmName.setVisible(true);
            bmAuthor.setText(e.getMessage());
            bmAuthor.setVisible(true);
        }

    }
}

