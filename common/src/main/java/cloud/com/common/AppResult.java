package cloud.com.common;


/**
 *功能描述 返回数据格式
 * @author 老默
 * @date 2020/7/16
 * @time 12:09
 * @return
 */
public class AppResult {
    private static Integer successCode = ResultCode.SUCCESS.getCode();
    private static String successMsg = ResultCode.SUCCESS.getMsg();

    private static Integer errorCode = ResultCode.ERROR.getCode();
    private static String errorMsg = ResultCode.ERROR.getMsg();

    //成功，不返回具体数据
    public static Result<String> ok(){
        Result<String> result = new Result<String>();
        result.setCode(successCode);
        result.setMsg(successMsg);
        result.setData("");
        return result;
    }
    //成功，返回数据
    public static <T> Result<T> ok(T t){
        Result<T> result = new Result<T>();
        result.setCode(successCode);
        result.setMsg(successMsg);
        result.setData(t);
        return result;
    }
    //失败，返回失败信息
    public static <T> Result<T> err(){
        Result<T> result = new Result<T>();
        result.setCode(errorCode);
        result.setMsg(errorMsg);
        return result;
    }

    //失败，返回失败信息
    public static <T> Result<T> err(ResultCode code){
        Result<T> result = new Result<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

    //失败，返回失败信息
    public static <T> Result<T> err(ResultCode code,String extraMsg){
        Result<T> result = new Result<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg() + "," + extraMsg);
        return result;
    }

    //失败，返回失败信息
    public static <T> Result<T> err(Integer code,String extraMsg){
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMsg(extraMsg);
        return result;
    }

}
