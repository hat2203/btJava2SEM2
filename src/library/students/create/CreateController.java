package library.students.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.dao.impls.StudentRepository;
import library.entities.Students;
import library.helper.Connector;

import java.util.ArrayList;

public class CreateController  {

    public TextField nsName;
    public TextField nsEmail;
    public TextField nsTel;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = nsName.getText();
            String email = nsEmail.getText();
            String tel = nsTel.getText();
            Students students = new Students(null,name,email,tel);
            StudentRepository srp = new StudentRepository();
            if (srp.create(students)){
                btList();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void btList()throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/students.fxml"));
        library.Main.rootStage.setTitle("Student");
        library.Main.rootStage.setScene(new Scene(listBook,800,600));

    }


}
