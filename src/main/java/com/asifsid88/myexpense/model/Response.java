package com.asifsid88.myexpense.model;

import lombok.Data;

/**
 * Created by mhussaa on 4/30/17.
 */
@Data
public class Response {
    private int status;
    private String message;
    private Object data;
}
