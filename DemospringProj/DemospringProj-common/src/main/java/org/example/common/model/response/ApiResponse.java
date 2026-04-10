package org.example.common.model.response;

import org.example.common.enums.ApiResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

    private String code;
    private String info;
    private T data;

    public static <T> ApiResponse<T> success(){
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(ApiResponseEnum.SUCCESS.getCode());
        response.setInfo(ApiResponseEnum.SUCCESS.getDesc());
        response.setData(null);
        return response;
    }

    public static <T> ApiResponse<T> error(ApiResponseEnum apiResponseEnum){
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(apiResponseEnum.getCode());
        response.setInfo(apiResponseEnum.getDesc());
        response.setData(null);
        return response;
    }

    public static <T> ApiResponse<T> wrap(ApiResponseEnum apiResponseEnum,T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(apiResponseEnum.getCode());
        response.setInfo(apiResponseEnum.getDesc());
        response.setData(data);
        return response;
    }



}
