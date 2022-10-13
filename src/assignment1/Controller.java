package assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {



    public void gtBook(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../book/bookList.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(formScene);
    }

    public void gtMember(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../member/memberList.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Members");
        Main.rootStage.setScene(formScene);
    }

    public void gtRenter(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../borrowBook/borrowBookList.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Renters");
        Main.rootStage.setScene(formScene);
    }
}
