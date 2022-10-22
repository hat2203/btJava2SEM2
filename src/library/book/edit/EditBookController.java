package library.book.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import library.dao.impls.BookRepository;
import library.entities.Book;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditBookController implements Initializable {
    public TextField ebName;
    public TextField ebAuthor;
    public TextField ebQty;
    public static Book editdBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editdBook != null){
            ebName.setText(editdBook.getName());
            ebAuthor.setText(editdBook.getAuthor());
            ebQty.setText(editdBook.getQty().toString());
        }
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = ebName.getText();
            String author = ebAuthor.getText();
            int qty = Integer.parseInt(ebQty.getText());
            editdBook.setName(name);
            editdBook.setAuthor(author);
            editdBook.setQty(qty);
            BookRepository rp = new BookRepository();
            if(rp.update(editdBook)){
                gtBack();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert al = new Alert(Alert.AlertType.CONFIRMATION);
            al.setTitle("Delete book ?");
            al.setHeaderText("Are you sure delete book: "+editdBook.getName());
            Optional<ButtonType> option = al.showAndWait();

            if (option.get()== ButtonType.OK);
            BookRepository rp = new BookRepository();
                if(rp.delete(editdBook)){
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
