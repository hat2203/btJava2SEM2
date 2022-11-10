package practiceExamJpII.creat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import practiceExamJpII.Main;
import practiceExamJpII.Students;

public class CreateStudentController {

    public TextField crSid;
    public TextField crSname;
    public TextField crSaddress;
    public TextField crSphone;
    public Text check;

    ObservableList<Students> list = FXCollections.observableArrayList();
    public void createS(ActionEvent actionEvent) {
        try{
          check.setVisible(false);
          if (crSid.getText().isEmpty() || crSname.getText().isEmpty() || crSaddress.getText().isEmpty() || crSphone.getText().isEmpty()) {
              throw new Exception("Vui long dien du thong tin");
          }
          Students s = new Students(crSid.getText(),crSname.getText(),crSaddress.getText(),crSphone.getText());
          list.add(s);
          gbList(null);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void gbList(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../list/listStudent.fxml"));
        Main.rootStage.setTitle("List");
        Main.rootStage.setScene(new Scene(listStudent, 800,600));
    }
}
