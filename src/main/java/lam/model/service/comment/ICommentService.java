package lam.model.service.comment;

import lam.model.entity.Comment;
import lam.model.service.IService;

import java.util.List;

public interface ICommentService extends IService<Comment> {
    List<Comment> showAllToProduct(int id);
}
