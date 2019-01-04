package cn.dengbin97.wx.message;

import lombok.Data;

/**
 * @program: wx
 * @description:
 * @author: dengbin
 * @create: 2018-12-11 11:57
 **/

@Data
public class Article {
    /**
     * 图文消息描述
     */
    private String Description;

    /**
     * 图片链接，支持JPG、PNG格式，<br>
     * 较好的效果为大图640*320，小图80*80
     */
    private String PicUrl;

    /**
     * 图文消息名称
     */
    private String Title;

    /**
     * 点击图文消息跳转链接
     */
    private String Url;

}
