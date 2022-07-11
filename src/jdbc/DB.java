package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
    // static : 자주쓰이는 메소드는 static 처리하면 유용
    public static Connection oraConn() {
        Connection conn = null;
        try {
            FileInputStream fis = new FileInputStream("c:\\driver\\oracle.prop");
            Properties prop = new Properties(); //key와 valueㄹ르 세트로 저장
            prop.load(fis);
            String url = prop.getProperty("url");
            String id = prop.getProperty("id");
            String pwd = prop.getProperty("pwd");
            // DB 접속
            conn = DriverManager.getConnection(url,id,pwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
