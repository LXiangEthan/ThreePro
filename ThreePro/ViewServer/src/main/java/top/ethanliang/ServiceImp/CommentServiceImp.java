package top.ethanliang.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.commentart;
import top.ethanliang.Mapper.CommentMapper;
import top.ethanliang.Service.CommentService;
import top.ethanliang.Util.pocketClass;

import java.util.List;
@Service
public class CommentServiceImp implements CommentService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:23
     * @ description  写下注释时请使用@方法名 描述
     **/
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public pocketClass getCommentByArticleId(String id) {
        List<commentart> commentart = commentMapper.getCommentByArticleId(id);
        return new pocketClass(commentart.size() != 0?"当前文章下的所有评论":"赶快来占领无人区吧",200,commentart);
    }

    @Override
    public pocketClass insertComment(commentart comment) {
        int row = commentMapper.insertComment(comment);
        return new pocketClass(row != 0?"发布朋友圈成功":"发布失败请等待网络连接",row != 0?200:400);
    }

    @Override
    public pocketClass deleteComment(String id) {
        int row = commentMapper.deleteComment(id);
        return new pocketClass(row != 0?"删除成功":"删除失败",row != 0?200:400);
    }

}
