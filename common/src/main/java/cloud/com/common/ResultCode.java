package cloud.com.common;
/**
 *功能描述 请求错误代码
 * @author 老默
 * @date 2020/7/16
 * @time 12:05
 * @return
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(0, "请求成功"),
    /* 失败状态码 */
    ERROR(-1,"请求失败"),
    /* 系统错误： */
    SYSTEM_ERROR(10001, "系统繁忙，请稍后重试"),
    /* 参数错误： */
    PARAM_ERROR(10002, "参数有误"),
    /* 非法登录：*/
    ILLEGAL_ERROR(10003, "用户非法登录"),
    /* 用户模块：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "用户名或者密码错误，请检查重试"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_HAS_EXISTED(20004, "用户已存在");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
