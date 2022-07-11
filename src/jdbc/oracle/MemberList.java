package jdbc.oracle;

import java.sql.*;

public class MemberList {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id = "jun";
        String pwd = "java1234";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver); //jdbc driver 로딩 (생략가능)
            conn = DriverManager.getConnection(url,id,pwd);
            System.out.println("오라클 서버에 접속되었습니다.");
            String sql = "select * from member";
            pstmt = conn.prepareStatement(sql); // sql 처리 객체
            rs = pstmt.executeQuery(); // 쿼리문 실행
            while (rs.next()) { // 다음 레코드가 준비되면 true
                String userid = rs.getString("userid"); // index값 or column name
                String passwd = rs.getString("passwd");
                String name = rs.getString("name");
                System.out.println(userid + "\t" + passwd + "\t " + name);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                if ( rs != null ) rs.close();
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
            try {
                if ( pstmt != null ) pstmt.close();
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
            try {
                if ( conn != null ) conn.close();
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
            // TODO: handle exception
        }
    }
}
