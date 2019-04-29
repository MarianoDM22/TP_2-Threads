package com.marianofernandez;

import java.sql.*;

public class Jdbc {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/TP_2";

    static final String USER = "root";
    static final String PASS = "";


    public Palabra getPalabra(){
        Connection conn = null;
        Statement stmt = null;
        Palabra palabra = null;
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT palabra, longitud FROM palabras ORDER BY RAND() LIMIT 1;";
            stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                palabra = new Palabra(rs.getString("palabra"), rs.getInt("longitud"));
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return palabra;
    }

    public void insertarGanador(Jugador jugador, Palabra palabra){
        Connection conn = null;
        Statement stmt = null;
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd");

        String currentTime = sdf.format(dt);
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.prepareStatement("INSERT INTO ganadores (nombre, palabra, fecha) "
                    + "VALUES(?,?,?)");

            ((PreparedStatement) stmt).setString(1, jugador.getNombre());
            ((PreparedStatement) stmt).setString(2, palabra.getPalabra());
            ((PreparedStatement) stmt).setString(3, currentTime);
            ((PreparedStatement) stmt).executeUpdate();


        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
