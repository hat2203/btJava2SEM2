package library.book.list;

import assignment1.Main;
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
import library.entities.Book;

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
    public static String connectionString = "jdbc:mysql://localhost:3306/t2203ejava";
    public final static String user = "root";
    public final static String pwd = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        bName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        bAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        bQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));

        ObservableList<Book> ls = FXCollections.observableArrayList();
//        ls.add(new Book(1,"Trí tuệ Do Thái","ABC",12));
//        ls.add(new Book(2,"Dế mèn phiêu lưu kí","Tô Hoài",10));
//         lấy dữ liệu data

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from books";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id,name,author,qty);
                ls.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbBook.setItems(ls);
        }
    }

    public void gotoHome(ActionEvent actionEvent) throws Exception {

    }
}
