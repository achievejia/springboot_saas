package com.example.demo.model;

import com.example.demo.utils.CustomUtil;
import com.example.demo.utils.DateUtil;
import com.example.demo.utils.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义消息返回体
 *
 * @author 李嘉
 * @version 1.0
 * @Description 自定义消息返回体
 * @date 2019/1/8 19:40
 */
public class CustomResult<T> {
    /**
     * 结果Id
     */
    @Getter
    private final String resultId = CustomUtil.GenerateID();

    /**
     * 是否成功
     */
    @Getter
    @Setter
    private boolean success;

    /**
     * 代码编号
     */
    @Getter
    @Setter
    private Integer code;

    /**
     * 数据集
     */
    @Getter
    @Setter
    private T data;

    /**
     * 消息
     */
    @Getter
    @Setter
    private String message;

    /**
     * 堆栈异常错误消息
     */
    @Getter
    @Setter
    private String stackMessage;

    /**
     * 数据大小
     */
    @Getter
    @Setter
    private long count;

    /**
     * 最后更新时间
     */
    @Getter
    private final String lastTime = DateUtil.GetFormatTime();

    public CustomResult() {

    }

    public CustomResult(boolean success, Integer code, T data, String message, long count) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
        this.count = count;
    }

    public CustomResult(boolean success, Integer code, T data, String message, long count, String stackMessage) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
        this.count = count;
        this.stackMessage = stackMessage;
    }

    /**
     * 自定义生成结果对象
     *
     * @param success
     * @param code
     * @return
     */
    public static <T> CustomResult Build(boolean success, Integer code) {
        return new CustomResult(success, code, null, null, 0, null);
    }

    /**
     * 自定义生成结果对象
     *
     * @param success
     * @param code
     * @param data
     * @return
     */
    public static <T> CustomResult Build(boolean success, Integer code, T data) {
        return new CustomResult(success, code, data, null, 0, null);
    }

    /**
     * 自定义生成结果对象
     *
     * @param success
     * @param code
     * @param data
     * @param count
     * @return
     */
    public static <T> CustomResult Build(boolean success, Integer code, T data, long count) {
        return new CustomResult(success, code, data, null, count, null);
    }

    /**
     * 自定义生成结果对象
     *
     * @param success
     * @param code
     * @param message
     * @return
     */
    public static <T> CustomResult Build(boolean success, Integer code, String message) {
        return new CustomResult(success, code, null, message, 0, null);
    }

    /**
     * 自定义生成结果对象
     *
     * @param success
     * @param code
     * @param data
     * @param message
     * @return
     */
    public static <T> CustomResult Build(boolean success, Integer code, T data, String message) {
        return new CustomResult(success, code, data, message, 0, null);
    }

    /**
     * 自定义生成结果对象
     *
     * @param success
     * @param code
     * @param data
     * @param message
     * @param count
     * @return
     */
    public static <T> CustomResult Build(boolean success, Integer code, T data, String message, long count) {
        return new CustomResult(success, code, data, message, count, null);
    }

    /**
     * 成功
     *
     * @return
     */
    public static <T> CustomResult Ok() {
        return new CustomResult(true, ResultEnum.Success.getIndex(), null, null, 0, null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static <T> CustomResult Ok(T data) {
        return new CustomResult(true, ResultEnum.Success.getIndex(), data, null, 0, null);
    }

    /**
     * 成功
     *
     * @param code
     * @param data
     * @return
     */
    public static <T> CustomResult Ok(Integer code, T data) {
        return new CustomResult(true, code, data, null, 0, null);
    }

    /**
     * 成功
     *
     * @param data
     * @param count
     * @return
     */
    public static <T> CustomResult Ok(T data, long count) {
        return new CustomResult(true, ResultEnum.Success.getIndex(), data, null, count, null);
    }

    /**
     * 成功
     *
     * @param code
     * @param data
     * @param count
     * @return
     */
    public static <T> CustomResult Ok(Integer code, T data, long count) {
        return new CustomResult(true, code, data, null, count);
    }

    /**
     * 失败
     *
     * @param message
     * @return
     */
    public static <T> CustomResult Fail(String message) {
        return new CustomResult(false, ResultEnum.Fail.getIndex(), null, message, 0, null);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @return
     */
    public static <T> CustomResult Fail(Integer code, String message) {
        return new CustomResult(false, code, null, message, 0, null);
    }

    /**
     * 失败
     *
     * @param message
     * @param stackMessage
     * @return
     */
    public static <T> CustomResult Fail(String message, String stackMessage) {
        return new CustomResult(false, ResultEnum.Fail.getIndex(), null, message, 0, stackMessage);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @param stackMessage
     * @return
     */
    public static <T> CustomResult Fail(Integer code, String message, String stackMessage) {
        return new CustomResult(false, code, null, message, 0, stackMessage);
    }
}
