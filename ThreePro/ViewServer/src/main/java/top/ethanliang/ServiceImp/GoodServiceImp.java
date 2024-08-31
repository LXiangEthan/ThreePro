package top.ethanliang.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.goodart;
import top.ethanliang.Mapper.GoodMapper;
import top.ethanliang.Service.GoodService;
import top.ethanliang.Util.pocketClass;

import java.util.List;
@Service
public class GoodServiceImp implements GoodService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:23
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public pocketClass getGoodByArticleId(String id) {
        List<goodart> goods = goodMapper.getGoodByArticleId(id);
        return new pocketClass(goods.size()!=0?"来自点赞":"还没有人点过赞哦",200,goods);
    }

    @Override
    public pocketClass insertComment(goodart goodart) {
        int row = goodMapper.insertComment(goodart);
        return new pocketClass(row!=0?"点赞成功成功":"点赞失败请网络连接",row!=0?200:400);
    }

    @Override
    public pocketClass delete(goodart goodart) {
        int row = goodMapper.delete(goodart);
        return new pocketClass(row!=0?"点赞成功":"点赞失败",row!=0?200:400);
    }

}
