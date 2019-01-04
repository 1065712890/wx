package cn.dengbin97.wx.message;

import lombok.Data;

/**
 * @program: wx
 * @description:
 * @author: dengbin
 * @create: 2018-12-11 11:55
 **/

@Data
public class MusicMessage extends BaseMessage{
    /**
     * 音乐
     */
    private Music Music;
}
