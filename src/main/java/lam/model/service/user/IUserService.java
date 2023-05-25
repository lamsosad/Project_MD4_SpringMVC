package lam.model.service.user;

import lam.model.entity.User;
import lam.model.service.IService;

public interface IUserService extends IService<User> {
    User login(User user);
    boolean changeStatus(User user);
    boolean changePassword(User user);
    boolean checkExitUserLogin(String username);
    boolean checkValidateEmail(String email);
    boolean checkValidatePassword(String password);
    boolean checkValidateUsername(String username);
    boolean checkRePassword(String rePassword,String password);
}
