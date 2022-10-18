package library.students.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.entities.Students;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Students> tbStudents;
    public TableColumn<Students, Integer> sId;
    public TableColumn<Students, String> sName;
    public TableColumn<Students, String> sEmail;
    public TableColumn<Students, String> sTel;

    public static String connectionString = "jdbc:mysql://localhost:3306/t2203ejava";
    public final static String user = "root";
    public final static String pwd = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sId.setCellValueFactory(new PropertyValueFactory<Students, Integer>("SId"));
        sName.setCellValueFactory(new PropertyValueFactory<Students, String>("SName"));
        sEmail.setCellValueFactory(new PropertyValueFactory<Students, String>("SEmail"));
        sTel.setCellValueFactory(new PropertyValueFactory<Students, String>("STel"));

        ObservableList<Students> slist = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = con.createStatement();
            String sql_txt = "select * from students";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("SId");
                String name = rs.getString("SName");
                String email = rs.getString("SEmail");
                String tel = rs.getString("STel");
                Students s = new Students(id,name,email,tel);
                slist.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudents.setItems(slist);
        }
    }

    public void gotoHome(ActionEvent actionEvent) {
    }
}
