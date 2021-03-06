package com.asifsid88.myexpense.helper;

import com.asifsid88.myexpense.constants.ResponseStatus;
import com.asifsid88.myexpense.model.Expense;
import com.asifsid88.myexpense.model.IModel;
import com.asifsid88.myexpense.model.Response;

import java.util.List;

/**
 * Created by mhussaa on 4/30/17.
 */
public class ResponseBuilder {

    public static Response buildResponse(ResponseStatus responseStatus, List<Expense> object) {
        Response response = new Response();
        response.setStatus(responseStatus.getCode());
        response.setMessage(responseStatus.getDescription());
        response.setData(object);

        return response;
    }

    public static Response buildResponse(ResponseStatus responseStatus, IModel object) {
        Response response = new Response();
        response.setStatus(responseStatus.getCode());
        response.setMessage(responseStatus.getDescription());
        response.setData(object);

        return response;
    }

    public static Response buildErrorResponse(ResponseStatus responseStatus) {
        Response response = new Response();
        response.setStatus(responseStatus.getCode());
        response.setMessage(responseStatus.getDescription());

        return response;
    }
}
