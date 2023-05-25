package lam.controller;
import lam.model.entity.User;
import lam.model.service.user.IUserService;
import lam.model.service.user.UserServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    private IUserService userService = new UserServiceIMPL();

    @GetMapping("/showToAdmin")
    public String showToAdmin(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("user", list);
        return "admin/user/userManager";
    }

    @GetMapping("/changePass")
    public String editPass(@RequestParam("idUser") int id, Model model) {
        User userEdit = userService.findById(id);
        model.addAttribute("editPass", userEdit);
        return "changePass";
    }

    @PostMapping("/upPass")
    public String updatePass(@RequestParam("oldPass") String oldPass,
                             @RequestParam("newPass") String newPass,
                             @RequestParam("rePass") String rePass,
                             Model model, HttpSession session) {
        String message = "";
        User userlogin = (User) session.getAttribute("userlogin");
        int userId = userlogin.getIdUser();
        String pass = userService.findById(userId).getPassword();
        if (!userService.checkValidatePassword(oldPass) && !userService.checkValidatePassword(newPass) && !userService.checkValidatePassword(rePass)) {
            message = "Mật khẩu chưa đúng định dạng!";
        } else if (!userService.checkRePassword(oldPass, pass)) {
            message = "Không trùng khớp mật khẩu cũ!";
        } else if (!userService.checkRePassword(rePass, newPass)) {
            message = "Không trùng khớp mật khẩu!";
        }
        model.addAttribute("message", message);
        User user = new User(userId, newPass);
        if (message.length() == 0) {
            userService.changePassword(user);
            return "redirect:/userController/login";
        } else {

            return "changePass";
        }

    }

    @GetMapping("/editUser")
    public String edit(@RequestParam("idUser") int id, Model model) {
        User userEdit = userService.findById(id);
        model.addAttribute("userEdit", userEdit);
        return "changeInfo";
    }

    @PostMapping("/update")
    public String update(@RequestParam("fullname") String fullname,
                         @RequestParam("email") String email,
                         HttpSession session, HttpServletRequest request) {
        User userlogin = (User) session.getAttribute("userlogin");
        int userId = userlogin.getIdUser();
        User user = new User(userId, fullname, email);
        userService.update(user);
        userService.findById(userId);
        request.getSession().setAttribute("userlogin", user);
        return "redirect:/productController/show";
    }

    @GetMapping("/changeStatus")
    public String changeStatus(@RequestParam("idUser") int id,
                               @RequestParam("status") boolean status,
                               Model model) {
        User user = new User(id, status);
        userService.changeStatus(user);
        return "redirect:/userController/showToAdmin";
    }

    @GetMapping("/login")
    public String login() {
        return "LR/login";
    }

    @GetMapping("/register")
    public String register() {
        return "LR/register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userlogin");
        return "redirect:/productController/show";
    }

    @PostMapping("/newLogin")
    public String newLogin(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model,
                           HttpServletRequest request) {
        String message = "";
        User user = userService.login(new User(username, password));
        if (user == null) {
            message = "Không tồn tại tài khoản hoặc đã bị khóa!";
            model.addAttribute("message", message);
            return "LR/login";
        } else {
            request.getSession().setAttribute("userlogin", user);
            if (user.isRole() && user.isStatus()) {
                // đây là admin
                return "redirect:/adminController/homeAdmin";
            } else if (!user.isRole()) {
                // đây là người dùng
                return "redirect:/productController/show";
            } else {
                return "redirect:/productController/show";
            }
        }

    }

    @PostMapping("/newRegister")
    public String newRegister(@RequestParam("fullname") String fullname,
                              @RequestParam("username") String username,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password,
                              @RequestParam("rePassword") String rePassword,
                              Model model) {

        String message = "";

        if (userService.checkExitUserLogin(username)) {
            message = "Tên đăng nhập đã tồn tại!";
        } else if (!userService.checkValidateUsername(username)) {
            message = "Tên đăng nhập chưa đúng định dạng!";
        } else if (!userService.checkValidateEmail(email)) {
            message = "Email chưa đúng định dạng!";
        } else if (!userService.checkValidatePassword(password)) {
            message = "Mật khẩu chưa đúng định dạng!";
        } else if (!userService.checkRePassword(rePassword, password)) {
            message = "Không trùng khớp mật khẩu!";
        }

        model.addAttribute("message", message);

        if (message.length() == 0) {
            userService.save(new User(fullname, username, email, password));
            return "redirect:/userController/login";
        } else {

            return "LR/register";
        }

    }
}