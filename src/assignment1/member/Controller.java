package assignment1.member;

import assignment1.Main;
import assignment1.book.BookList;
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
    public ListView<MemberList> memberList;
    public static ObservableList<MemberList> mList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        memberList.setItems(mList);
    }

    public void gtHome(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("trangChu.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(formScene);
    }

    public void editMember(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../member/edit/editMember.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("Edit Member");
        Main.rootStage.setScene(formScene);
    }

    public void moreMember(ActionEvent actionEvent) throws Exception {
        Parent formPage = FXMLLoader.load(getClass().getResource("../member/more/moreMember.fxml"));
        Scene formScene = new Scene(formPage,800,600);
        Main.rootStage.setTitle("More Member");
        Main.rootStage.setScene(formScene);
    }
}
