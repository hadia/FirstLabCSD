public class AuthUserService {
    UserDao userDao;

    public AuthUserService(UserDao userDao) {
       this.userDao= userDao;
    }

    public boolean authUserInfo(UserInfo userInfo) {
        if (userInfo != null) {
            UserInfo userDaoInfo = userDao.getUser_byName();
            if ((userDaoInfo.userName.toUpperCase() + userDaoInfo.password).equals(userInfo.userName.toUpperCase().trim() + userInfo.password))
                return true;
        }
        return false;
    }
}
