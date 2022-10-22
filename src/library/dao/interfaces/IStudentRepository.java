package library.dao.interfaces;

import library.entities.Students;

import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<Students> all();
    boolean create(Students students);
    boolean update(Students students);
    boolean delete(Students students);

}
