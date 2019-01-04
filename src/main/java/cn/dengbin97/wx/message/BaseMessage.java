package cn.dengbin97.wx.message;

import lombok.Data;

/**
 * @program: wx
 * @description:
 * @author: dengbin
 * @create: 2018-12-10 16:11
 **/
@Data
public class BaseMessage {
    /**
    * @description: 开发者微信号
    * @author: dengbin
    * @date: 2018/12/11 上午11:55
    */
    private String ToUserName;
    /**
    * @description: 发送方帐号（一个OpenID）
    * @author: dengbin
    * @date: 2018/12/11 上午11:56
    */
    private String FromUserName;
    /**
    * @description: 消息创建时间 （整型）
    * @author: dengbin
    * @date: 2018/12/11 上午11:56
    */
    private long CreateTime;
    /**
    * @description: 消息类型（text/image/location/link）
    * @author: dengbin
    * @date: 2018/12/11 上午11:56
    */
    private String MsgType;
    /**
    * @description: 消息id，64位整型
    * @author: dengbin
    * @date: 2018/12/11 上午11:56
    */
    private long MsgId;
    /**
     * 位0x0001被标志时，星标刚收到的消息
     */
    private int FuncFlag;

}