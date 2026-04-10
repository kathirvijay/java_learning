package org.example.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CommonBizExceptionEnum {

    INVOKE_METHOD_EXCEPTION("E100001","调用远程接口异常"),
    TRANSACTION_EXCEPTION("E100002","事务处理异常");

    private String errorCode;
    private String errorMsg;

}
