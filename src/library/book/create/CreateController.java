package library.book.create;

import assignment1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.dao.impls.BookRepository;
import library.entities.Book;
import library.helper.Connector;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CreateController {
    public TextField nbName;
    public TextField nbAuthor;
    public TextField nbQty;


    public void submit(ActionEvent actionEvent) {
        try {
            String name = nbName.getText();
            String author = nbAuthor.getText();
            int qty = Integer.parseInt(nbQty.getText());
            Book book = new Book(null,name,author,qty);
            BookRepository rp = new BookRepository();
            if(rp.create(book)){
                gtBack();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void gtBack() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        library.Main.rootStage.setTitle("Books");
        library.Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
