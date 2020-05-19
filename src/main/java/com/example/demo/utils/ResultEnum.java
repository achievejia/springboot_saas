package com.example.demo.utils;

/**
 * 返回结果枚举
 *
 * @author 李嘉
 * @version 1.0
 * @Description 返回结果枚举
 * @date 2019/1/8 15:24
 */
public enum ResultEnum {

    /**
     * 无操作
     */
    None("无操作", 0),

    /**
     * 成功
     */
    Success("成功", 10200),

    /**
     * 失败
     */
    Fail("失败", 10300),

    /**
     * 错误请求
     */
    ErrorRequest("错误请求", 10400),

    /**
     * 未授权
     */
    NoAuthorization("未授权", 10401),

    /**
     * 拒绝请求
     */
    RefuseRequest("拒绝请求", 10403),

    /**
     * 未找到
     */
    NotFound("未找到", 10404),

    /**
     * 参数不符合
     */
    NotParameter("参数不符合", 10406),

    /**
     * 请求超时
     */
    RequestTimeOut("请求超时", 10408),

    /**
     * 登录超时
     */
    LoginTimeOut("登录超时", 10409),

    /**
     * 服务器错误
     */
    Error("服务器错误", 10500),

    /**
     * http协议错误
     */
    ErrorHttp("http协议错误", 10505),

    /**
     * 业务问题
     */
    Business("业务问题", 10400);

    private String name;
    private int index;

    ResultEnum() {
    }

    ResultEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (ResultEnum info : ResultEnum.values()) {
            if (info.getIndex() == index) {
                return info.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
