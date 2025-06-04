package com.site.blog.my.core.util;

import org.springframework.util.StringUtils;

/**
 * 响应结果生成工具
 *
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static <T> Result<T> genSuccessResult() {
        Result<T> result = new Result<>();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static <T> Result<T> genSuccessResult(String message) {
        Result<T> result = new Result<>();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> genSuccessResult(T data) {
        Result<T> result = new Result<>();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> genFailResult(String message) {
        Result<T> result = new Result<>();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        if (!StringUtils.hasText(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static <T> Result<T> genErrorResult(int code, String message) {
        Result<T> result = new Result<>();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
