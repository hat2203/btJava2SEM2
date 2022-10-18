package library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void gtBooks(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("book/list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,900));

    }

    public void gotoStudents(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("students/list/students.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,900));
    }
}
