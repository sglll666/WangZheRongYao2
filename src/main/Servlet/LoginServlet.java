package Servlet;

import cn.kgc.entity.User;
import dao.UserDao;
import dao.UserDaoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：接收用户提交表单时候输入的值
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.根据用户输入的id和用户名和密码查找数据库中是否有这个人
        //假设id、用户名、密码分别是101、admin、abc123
        //3.根据查询的结果返回对应的响应
        if("101".equals(id) && "admin".equals(username) && "abc123".equals(password)){
            //表示登录成功  转发
            //req.setAttribute("mess","成功！！！");
            req.getRequestDispatcher("PlayIntroduce.html").forward(req,resp);
        }else{
            //表示登录失败   重定向
            resp.sendRedirect("HomePage.html");
        }

        /*UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setid("101");
        user.setusername("admin");
        user.setpassword("abc123");
        User userByUserNameANDPassword = userDao.getUserByUserNameANDPassword(user);
        System.out.println(userByUserNameANDPassword);*/

    }
}
