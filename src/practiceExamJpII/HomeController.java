package practiceExamJpII;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void sList(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("list/listStudent.fxml"));
        Main.rootStage.setTitle("List");
        Main.rootStage.setScene(new Scene(listStudent, 800,600));
    }

    public void sCreat(ActionEvent actionEvent) throws Exception{
        Parent listStudent = FXMLLoader.load(getClass().getResource("creat/createStudent.fxml"));
        Main.rootStage.setTitle("Create");
        Main.rootStage.setScene(new Scene(listStudent, 800,600));
    }
}
