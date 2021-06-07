package com.li.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    //获取外部资源
    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        user=properties.getProperty("user");
        password=properties.getProperty("password");
    }

    //获取数据库连接

    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //查询语句公共类
    public static ResultSet queryInquire(Connection conn, PreparedStatement pstm, ResultSet rs, String sql, Object[]params) throws SQLException {
        pstm = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1,params[i]);
        }
        rs = pstm.executeQuery();

        return rs;
    }
    //更新语句公共类
    public static int queryUpdate(Connection connection,PreparedStatement pstm, String sql,Object[] params) throws Exception{
        int updateRows = 0;
        pstm = connection.prepareStatement(sql);
        for(int i = 0; i < params.length; i++){
            pstm.setObject(i+1, params[i]);
        }
        updateRows = pstm.executeUpdate();
        return updateRows;
    }




    //资源回收
    public static boolean closeResource(Connection conn ,ResultSet rs,PreparedStatement pstm){
        boolean flag=true;
        if(rs!=null){
            try {
                rs.close();
                //GC回收
                rs=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }

        if(pstm!=null){
            try {
                pstm.close();
                //GC回收
                pstm=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }

        if(conn!=null){
            try {
                conn.close();
                //GC回收
                conn=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }
}
