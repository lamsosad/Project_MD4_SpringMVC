package lam.controller;

import lam.model.entity.Comment;
import lam.model.entity.User;
import lam.model.service.comment.CommentServiceIMPL;
import lam.model.service.comment.ICommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/commentController")
public class CommentController {
    ICommentService commentService = new CommentServiceIMPL();

    @GetMapping("/showAllComment")
    public String showallComment(Model model) {
        List<Comment> commentList = commentService.findAll();
        model.addAttribute("comment", commentList);
        return "admin/feedback/commentManager";
    }

    @GetMapping("/changeStatus")
    public String changeStatus(@RequestParam("idComment") int id, Model model) {
        Comment comment = new Comment(id);
        commentService.update(comment);
        return "redirect:/commentController/showAllComment";
    }
    @PostMapping("/createComment")
    public String createComment(@RequestParam("idOrderDetail") int id,@RequestParam("comment") String comment, Model model, HttpSession session) {
        User user = (User) session.getAttribute("userlogin");
        int userId = user.getIdUser();
        commentService.save(new Comment(comment,id,userId));
        return "redirect:/productController/show";
    }
}
