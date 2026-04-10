package org.example.common.exception;


import org.example.common.enums.CommonBizExceptionEnum;

public class CommonBizException extends RuntimeException{
    private String errorCode;
    private String errorMsg;

    public CommonBizException(){}

    public CommonBizException(String code, String msg) {
        super(msg);
        this.errorCode = code;
        this.errorMsg = msg;
    }

    public CommonBizException(CommonBizExceptionEnum commonBizExceptionEnum) {
        this.errorCode = commonBizExceptionEnum.getErrorCode();
        this.errorMsg = commonBizExceptionEnum.getErrorMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
