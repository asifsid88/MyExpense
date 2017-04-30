package com.asifsid88.myexpense.helper;

import com.asifsid88.myexpense.model.IModel;
import com.asifsid88.myexpense.model.Response;
import com.asifsid88.myexpense.constants.ResponseStatus;

/**
 * Created by mhussaa on 4/30/17.
 */
public class ResponseBuilder {

    public static Response buildResponse(ResponseStatus responseStatus, IModel model) {
        Response response = new Response();
        response.setStatus(responseStatus.getCode());
        response.setMessage(responseStatus.getDescription());
        response.setData(model);

        return response;
    }
}
