package library.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import library.Main;
import library.students.edit.EditStudentController;

public class Students {
    public Integer id;
    public String name;
    public String email;
    public String tel;
    public Button edit;

    public Students() {
    }

    public Students(Integer id, String name, String email, String tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try{
                EditStudentController.editedStudent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../students/edit/editStudent.fxml"));
                Main.rootStage.setScene(new Scene(edit,800,600));
            }catch (Exception e){

            }
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return getName();
    }
}
