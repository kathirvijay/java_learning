package org.example.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApiResponseEnum {

    SUCCESS("200","成功"),
    SERVER_INTERNAL_ERROR("500","服务器处理失败");
    private String code;
    private String desc;

}
