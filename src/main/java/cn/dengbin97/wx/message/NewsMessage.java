package cn.dengbin97.wx.message;

import lombok.Data;

import java.util.List;

/**
 * @program: wx
 * @description:
 * @author: dengbin
 * @create: 2018-12-11 11:57
 **/

@Data
public class NewsMessage extends BaseMessage{
    /**
     * 图文消息个数，限制为10条以内
     */
    private Integer ArticleCount;

    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private List<Article> Articles;
}
