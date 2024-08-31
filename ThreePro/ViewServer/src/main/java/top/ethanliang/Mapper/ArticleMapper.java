package top.ethanliang.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.ethanliang.Domain.article;

import java.util.List;
@Mapper
public interface ArticleMapper {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午9:01
     * @ description  写下注释时请使用@方法名 描述
     **/
    @Select("select * from article order by time desc")
    public List<article> getAllArticle();

    @Select("select * from article where id = #{id}")
    public article getArticleById(String id);

    @Insert("insert article values(#{id},#{authorId},#{infoData},#{time})")
    public int addArticle(article article);

    @Select("select * from article where authorId = #{authorId}")
    public article getArticleByAuthorId(String authorId);

    @Update("update article set infoData = #{infoData} where id = #{id} and authorId = #{authorId}")
    public int updateArticle(article article);

    @Delete("delete from article where id = #{id}")
    public int deleteArticle(String id);
}
