package top.ethanliang.Service;

import org.springframework.stereotype.Service;
import top.ethanliang.Domain.article;
import top.ethanliang.Util.pocketClass;

import java.util.List;
public interface ArticleService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:21
     * @ description  写下注释时请使用@方法名 描述
     **/
    public pocketClass getAllArticle();

    public pocketClass getArticleById(String id);

    public pocketClass addArticle(article article);

    public pocketClass getArticleByAuthorId(String authorId);

    public pocketClass updateArticle(article article);

    public pocketClass deleteArticle(String id);
}
