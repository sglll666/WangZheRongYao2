package dao;

import Util.JDBCUtils;
import cn.kgc.entity.User;
import jdk.nashorn.internal.scripts.JD;

import java.lang.reflect.Field;
import java.sql.*;

public class BaseDao {

    public static void main(String[] args) {
            String sql="select * from servlet where id=?";
            User user = BaseDao.login_mysql(User.class, sql, 101);
            System.out.println(user);
    }

        /*编写公共的增删改的方法
         * sql: 谁调用此方法就传入sql
         * args 表示的是给sql中赋值
         **/
        //注册
        public void register_mysql(String sql,Object...args){
            Connection con = null;
            PreparedStatement pstm = null;
            try {
                con = JDBCUtils.getConnection();
                pstm = con.prepareStatement(sql);
                for(int i = 0;i<args.length;i++){
                    pstm.setObject((i+1),args[i]);
                }
                pstm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(pstm,con);
            }
        }
        //登录
        public static <T> T login_mysql(Class<T> clazz,String sql,Object...args){
            Connection con = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            try {
                con = JDBCUtils.getConnection();
                pstm = con.prepareStatement(sql);
                for(int i=0;i<args.length;i++){
                    pstm.setObject((i+1),args[i]);
                }
                pstm.executeQuery();
                //获取元数据
                ResultSetMetaData metaData = pstm.getMetaData();
                //获取列的个数
                int count = metaData.getColumnCount();
                T t = clazz.newInstance();
                if(rs.next()){
                    for(int i = 0;i<count;i++){
                        //获取字段值
                        Object value = rs.getObject((i + 1));
                        String label = metaData.getColumnLabel(i+1);
                        //获取别名
                        Field field = clazz.getDeclaredField(label);
                        //开启权限
                        field.setAccessible(true);
                        field.set(t,value);
                    }
                    return  t;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(rs,pstm,con);
            }
            return  null;
        }
}
