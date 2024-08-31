package top.ethanliang.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.ethanliang.Domain.commentart;
import top.ethanliang.Domain.goodart;

import java.util.List;
@Mapper
public interface GoodMapper {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:15
     * @ description  写下注释时请使用@方法名 描述
     **/
    @Select("select * from goodart where articleId = #{id}")
    public List<goodart> getGoodByArticleId(String id);

    @Insert("insert goodart value(#{articleId},#{userGood})")
    public int insertComment(goodart goodart);

    @Delete("delete from goodart where articleId = #{articleId} and userGood = #{userGood}")
    public int delete(goodart goodart);
}
