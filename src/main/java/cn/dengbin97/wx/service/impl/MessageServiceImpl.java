package cn.dengbin97.wx.service.impl;

import cn.dengbin97.wx.message.TextMessage;
import cn.dengbin97.wx.service.MessageService;
import cn.dengbin97.wx.utils.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @program: wx
 * @description:
 * @author: dengbin
 * @create: 2018-12-10 16:13
 **/

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    /**
     * 微信公众号处理
     *
     * @param request
     * @return
     */
    @Override
    public String newMessageRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String content = requestMap.get("Content");
            log.info("fromUserName:{} toUserName:{} msgType:{} content:{}", fromUserName, toUserName, msgType, content);
            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                //这里根据关键字执行相应的逻辑
                /*if(content.equals("xxx")){

                }*/
                //自动回复
                TextMessage text = new TextMessage();
                text.setContent("reply:"+content);
                text.setToUserName(fromUserName);
                text.setFromUserName(toUserName);
                text.setCreateTime(System.currentTimeMillis());
                text.setMsgType(msgType);
                respMessage = MessageUtil.textMessageToXml(text);
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                log.info(eventType);
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    //文本消息
                    TextMessage text = new TextMessage();
                    text.setContent("来了,老弟!");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(System.currentTimeMillis());
                    text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    respMessage = MessageUtil.textMessageToXml(text);
                }
                // 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {

                }
            } else {
                return "success";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }
}
