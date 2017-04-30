package com.asifsid88.myexpense.constants;

/**
 * Created by mhussaa on 4/30/17.
 */
public enum ResponseStatus {
    ERROR(500, "Internal Server Error"),
    COMPLETE(200, "Success");

    private int code;
    private String description;

    ResponseStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
