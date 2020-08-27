package dao.UserDaoImpl;

import cn.kgc.entity.User;
import dao.BaseDao;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByUserNameANDPassword(User user) {
        String sql = "select * from servlet where  username=? and password=?";
       return  BaseDao.login_mysql(User.class,sql,user.getusername(),user.getpassword());
    }
}
