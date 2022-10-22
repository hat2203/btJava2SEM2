package library.dao.impls;

import javafx.fxml.Initializable;
import library.dao.interfaces.IStudentRepository;
import library.entities.Students;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentRepository implements IStudentRepository {

    @Override
    public ArrayList<Students> all() {
        ArrayList<Students> slist = new ArrayList<>();
        try {
            String sql_txt = "select * from students";
            Connector con = Connector.getInstance();
            ResultSet rs = con.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                String email = rs.getString("semail");
                String tel = rs.getString("stel");
                Students s = new Students(id,name,email,tel);
                slist.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return slist;
    }

    @Override
    public boolean create(Students students) {
        try {
            String sql_txt = "insert into students(sname,semail,stel) values(?,?,?)";
            Connector con = Connector.getInstance();
            ArrayList ar = new ArrayList();
            ar.add(students.getName());
            ar.add(students.getEmail());
            ar.add(students.getTel());
            if (con.execute(sql_txt,ar)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Students students) {
        try {
            String sql_txt = "update students set name=? ,email=? ,tel=? where id=?";
            Connector con = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(students.getName());
            arr.add(students.getEmail());
            arr.add(students.getTel());
            arr.add(students.getId());
            if(con.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean delete(Students students) {
        try {
            String sql = "delete from students where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(students.getId());
            if(conn.execute(sql,arr)){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
}
