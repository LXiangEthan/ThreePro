package top.ethanliang.Service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.commentart;
import top.ethanliang.Util.pocketClass;

import java.util.List;
public interface CommentService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:21
     * @ description  写下注释时请使用@方法名 描述
     **/
    public pocketClass getCommentByArticleId(String id);

    public pocketClass insertComment(commentart comment);

    public pocketClass deleteComment(String id);
}
