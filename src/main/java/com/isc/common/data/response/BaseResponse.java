package com.isc.common.data.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;

    public static BaseResponse successNoData() {
        return BaseResponse.builder()
                .build();
    }

    public static <T> BaseResponse<T> successWithData(T data) {
        return BaseResponse.<T>builder()
                .data(data)
                .code("200")
                .message("success")
                .build();
    }

    public static BaseResponse error(String message, String code) {
        return BaseResponse.builder()
                .message(message)
                .code(code)
                .build();
    }
}
