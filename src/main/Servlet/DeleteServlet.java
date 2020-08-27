package Servlet;

import dao.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：接收用户提交表单时候输入的值
        String id = req.getParameter("del_id");
        BaseDao bd = new BaseDao();
        //删除id的数据
        String sql = "delete from servlet where id=?";
        bd.register_mysql(sql,id);
    }
}
