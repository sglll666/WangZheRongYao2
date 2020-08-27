package Servlet;

import dao.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：接收用户提交表单时候输入的值
        String id = req.getParameter("id");
        //String username = req.getParameter("username");
        String password = req.getParameter("password");
       // String  email = req.getParameter("email");
        //2.根据用户输入的用户名和密码查找数据库中是否有这个人
        BaseDao bd = new BaseDao();
        //3.根据查询的结果返回对应的响应
        //向数据库中添加这条信息
        String sql = "INSERT INTO servlet(id,`password`) values(?,?)";
        bd.register_mysql(sql,id,password) ;
    }
}
