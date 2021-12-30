package com.ofben.autordemo.response.resp;

import lombok.Data;

/**
 * TODO
 *
 * @date 2021-12-29
 * @since TODO
 */
@Data
public class Result<T> {

    private int code;

    private String message;

    private T data;

    private Result() {
    }

    private Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultMsgEnum.SUCCESS.getCode());
        result.setMessage(ResultMsgEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     */
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message);
    }
}
