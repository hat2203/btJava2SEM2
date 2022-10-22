package library.helper;

import java.sql.*;
import java.util.ArrayList;

public class Connector {
    public static String connectionString = "jdbc:mysql://localhost:3306/t2203ejava";
    public final static String user = "root";
    public final static String pwd = "";
    Connection conn;
    private static  Connector instance;

    private Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(connectionString,user,pwd);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Connector getInstance(){
        if (instance == null){
            instance = new Connector();
        }
        return instance;
    }


    public Statement getStatement() throws Exception{
        return conn.createStatement();
    }

    public ResultSet query(String sql){
        try {

            return getStatement().executeQuery(sql);

        }catch (Exception e){
            //System.out.println(e.getCause());
            return null;
        }
    }

    public boolean executeQuery(String sql){
        try{
             getStatement().execute(sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public PreparedStatement getPreparedStatement(String sql) throws Exception{
        return conn.prepareStatement(sql);
    }

    public boolean execute(String sql, ArrayList paramenters) {
        try{
            PreparedStatement pstm = getPreparedStatement(sql);
            for (int i=0; i<paramenters.size();i++){
                if(paramenters.get(i) instanceof Integer){
                    pstm.setInt(i+1,(Integer)paramenters.get(i));
                }else if (paramenters.get(i) instanceof Double){
                    pstm.setDouble(i+1,(Double)paramenters.get(i));
                }else{
                    pstm.setString(i+1,(String)paramenters.get(i) );
                }
            }
            pstm.execute();
        }catch (Exception e){
            return false;
        }
            return true;
    }

    public ResultSet executeQuery(String sql, ArrayList parameters){
        try {
            PreparedStatement pstm = getPreparedStatement(sql);
            for(int i=0;i < parameters.size();i++){
                if(parameters.get(i) instanceof Integer){
                    pstm.setInt(i+1,(Integer)parameters.get(i));
                }else if(parameters.get(i) instanceof Double){
                    pstm.setDouble(i+1,(Double) parameters.get(i));
                }else{
                    pstm.setString(i+1,(String)parameters.get(i));
                }
            }
            return pstm.executeQuery();
        }catch (Exception e){
            return null;
        }
    }

}
