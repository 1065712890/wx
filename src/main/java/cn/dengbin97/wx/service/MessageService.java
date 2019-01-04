package cn.dengbin97.wx.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: wx
 * @description:
 * @author: dengbin
 * @create: 2018-12-10 16:12
 **/

public interface MessageService {
    /**
     * 微信公众号处理
     * @param request
     * @return
     */
    String newMessageRequest(HttpServletRequest request);
}
