package top.ethanliang.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.ethanliang.Domain.commentart;

import java.util.List;
@Mapper
public interface CommentMapper {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午9:02
     * @ description  写下注释时请使用@方法名 描述
     **/
    @Select("select * from commentart where articleId = #{id}")
    public List<commentart> getCommentByArticleId(String id);

    @Insert("insert commentart value(#{articleId},#{userGood},#{info},#{id})")
    public int insertComment(commentart comment);

    @Delete("delete from commentart where id = #{id}")
    public int deleteComment(String id);
}
