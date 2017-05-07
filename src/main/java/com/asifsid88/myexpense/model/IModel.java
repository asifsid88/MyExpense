package com.asifsid88.myexpense.model;

import java.io.Serializable;

/**
 * Created by mhussaa on 4/30/17.
 */
public interface IModel extends Serializable {
    String toJSON(IModel model);
    IModel fromJSON(String data);
}
