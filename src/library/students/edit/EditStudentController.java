package library.students.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import library.dao.impls.StudentRepository;
import library.entities.Students;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditStudentController implements Initializable {
    public TextField esName;
    public TextField esEmail;
    public TextField esTel;
    public static Students editedStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedStudent != null){
            esName.setText(editedStudent.getName());
            esEmail.setText(editedStudent.getEmail());
            esTel.setText(editedStudent.getTel());
        }
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = esName.getText();
            String email = esEmail.getText();
            String tel = esTel.getText();
            editedStudent.setName(name);
            editedStudent.setEmail(email);
            editedStudent.setTel(tel);
            StudentRepository srp = new StudentRepository();
            if (srp.update(editedStudent)){
                gtBack(null);
            }else{
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert al = new Alert(Alert.AlertType.CONFIRMATION);
            al.setTitle("Delete student?");
            al.setHeaderText("Are you sure delete student: "+editedStudent.getName());
            Optional<ButtonType> option = al.showAndWait();

            if(option.get()== ButtonType.OK){
                StudentRepository srp = new StudentRepository();
                        if(srp.delete(editedStudent)){
                            gtBack(null);
                        }else {
                            System.out.println("Error");
                        }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void gtBack(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/students.fxml"));
        library.Main.rootStage.setTitle("Students");
        library.Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
