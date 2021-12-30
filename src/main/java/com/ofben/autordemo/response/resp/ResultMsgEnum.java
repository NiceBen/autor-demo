package com.ofben.autordemo.response.resp;

/**
 * TODO
 *
 * @date 2021-12-29
 * @since TODO
 */
public enum ResultMsgEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    AUTH_ERROR(502, "授权失败！"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试！"),
    DATABASE_OPERATION_FAILED(504, "数据库操作失败");

    private int code;
    private String message;

    ResultMsgEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
