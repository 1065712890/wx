package cn.dengbin97.wx.controller;

import cn.dengbin97.wx.service.MessageService;
import cn.dengbin97.wx.utils.SHA1Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @program: wx
 * @description: 验证微信token
 * @author: dengbin
 * @create: 2018-12-10 12:01
 **/
@Controller
@Slf4j
public class Token {
    @Autowired
    MessageService messageService;

    private String TOKEN = "dengbin";

    @RequestMapping(value="/token", method = RequestMethod.GET)
    public void token(HttpServletResponse response, String signature, String echostr, String timestamp, String nonce) throws IOException {
        String[] str = { TOKEN, timestamp, nonce };
        // 字典序排序
        Arrays.sort(str);
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密
        String digest = SHA1Util.getSHA1(TOKEN, timestamp, nonce);
        // 确认请求来至微信
        if (digest.equals(signature)) {
            response.getWriter().print(echostr);
        }
    }

    @RequestMapping(value="/token", method = RequestMethod.POST)
    public void sendMessage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.info("request:{}", request);
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = messageService.newMessageRequest(request);

        // 响应消息
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;
        }
    }
}
