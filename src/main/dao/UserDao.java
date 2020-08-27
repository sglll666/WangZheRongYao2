package dao;

import cn.kgc.entity.User;

public interface UserDao {
        public User getUserByUserNameANDPassword(User user);
}
