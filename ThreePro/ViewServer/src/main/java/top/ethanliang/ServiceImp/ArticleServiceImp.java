package top.ethanliang.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.article;
import top.ethanliang.Mapper.ArticleMapper;
import top.ethanliang.Service.ArticleService;
import top.ethanliang.Util.pocketClass;

import java.util.List;
@Service
public class ArticleServiceImp implements ArticleService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:23
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public pocketClass getAllArticle(){
        List<article> articles = articleMapper.getAllArticle();
        return new pocketClass(articles.size() != 0?"这是所有的朋友圈数据":"很抱歉这里空空如也",200,articles);
    }
    @Override
    public pocketClass getArticleById(String id){
        article article = articleMapper.getArticleById(id);
        return new pocketClass(article!=null?"这是文章数据":"并没有查询到文章",200,article);
    }
    @Override
    public pocketClass addArticle(article article){
        int row = articleMapper.addArticle(article);
        return new pocketClass(row != 0 ?"插入成功":"插入失败",row != 0?200:400);
    }
    @Override
    public pocketClass getArticleByAuthorId(String authorId){
        article article  = articleMapper.getArticleByAuthorId(authorId);
        return new pocketClass(article != null?"查询到了":"没查询到",200,article);
    }
    @Override
    public pocketClass updateArticle(article article){
        int row =  articleMapper.updateArticle(article);
        return new pocketClass(row != 0?"更新成功":"更新失败",row != 0?200:400);
    }
    @Override
    public pocketClass deleteArticle(String id){
        int row =  articleMapper.deleteArticle(id);
        return new pocketClass(row != 0?"删除成功":"删除失败",row != 0?200:400);
    }
}
