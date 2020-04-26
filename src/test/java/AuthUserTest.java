import org.junit.After;
import org.junit.Before;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class AuthUserTest {

    UserInfo userInfo;
    UserDao userDao = mock(UserDao.class);;
    UserInfo storeduserinfo;
    AuthUserService authUserService = new AuthUserService(userDao);

    @Before
    public void setup() {
        storeduserinfo = new UserInfo("admin", "password");
        when(userDao.getUser_byName()).thenReturn(storeduserinfo);
    }

    @After
    public void tearDown() {
        userDao = null;
        storeduserinfo = null;
    }

    @Test
    public void testAuthUser() {
        userInfo = new UserInfo("admin", "password");
        boolean result =authUserService.authUserInfo(userInfo);
        Mockito.verify(userDao).getUser_byName();
        Assert.assertTrue(result);
    }
    @Test
    public void testAuthUserFailure() {
        userInfo = new UserInfo("admin123", "password");
        boolean result =authUserService.authUserInfo(userInfo);
        Mockito.verify(userDao).getUser_byName();
        Assert.assertFalse(result);

    }
    @Test
    public void testAuthUserInfoNull() {
        userInfo = null;
        boolean result = authUserService.authUserInfo(userInfo);
        Assert.assertFalse(result);
    }

    @Test
    public void testAuthUserWrongPassword() {
        userInfo= new UserInfo("admin","1");
        boolean result = authUserService.authUserInfo(userInfo);
        Mockito.verify(userDao).getUser_byName();
        Assert.assertFalse(result);
    }
    @Test
    public void testAuthUserEmptyData() {
        userInfo= new UserInfo("","");
        boolean result = authUserService.authUserInfo(userInfo);
        Mockito.verify(userDao).getUser_byName();
        Assert.assertFalse(result);
    }
    @Test
    public void testAuthUserNameCase() {
        userInfo= new UserInfo("Admin","password");
        boolean result = authUserService.authUserInfo(userInfo);
        Mockito.verify(userDao).getUser_byName();
        Assert.assertTrue(result);
    }
    @Test
    public void testAuthPasswordCase() {
        userInfo= new UserInfo("admin","Password");
        boolean result = authUserService.authUserInfo(userInfo);
        Mockito.verify(userDao).getUser_byName();
        Assert.assertFalse(result);
    }
    
    @Test
    public void testAuthUserNameSpace() {
        userInfo= new UserInfo("Admin ","password");
        boolean result = authUserService.authUserInfo(userInfo);
        Mockito.verify(userDao).getUser_byName();
        Assert.assertTrue(result);
    }
}
