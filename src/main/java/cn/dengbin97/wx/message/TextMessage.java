package cn.dengbin97.wx.message;

import lombok.Data;

/**
 * @program: wx
 * @description:
 * @author: dengbin
 * @create: 2018-12-10 16:11
 **/

@Data
public class TextMessage extends BaseMessage{
    /**
    * @description: 消息内容
    * @author: dengbin
    * @date: 2018/12/11 上午11:53
    */
    private String Content;
}
