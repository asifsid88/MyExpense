package com.asifsid88.myexpense.model;

import lombok.Data;

/**
 * Created by mhussaa on 5/5/17.
 */
@Data
public class User implements IModel {
    private String userId;
    private String userName;

    public String toJSON(IModel model) {
        return null;
    }

    public IModel fromJSON(String data) {
        return null;
    }
}
