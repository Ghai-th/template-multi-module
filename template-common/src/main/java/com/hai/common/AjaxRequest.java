package com.hai.common;

import lombok.Data;

/**
 * @author Ghai-th
 * @date 2022/7/15 16:44
 */
@Data
public class AjaxRequest<T> {
    String accessKey;
    String accessId;
    String version;

    T data;

}
