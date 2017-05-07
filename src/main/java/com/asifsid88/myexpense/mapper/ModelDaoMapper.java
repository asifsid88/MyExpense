package com.asifsid88.myexpense.mapper;

import com.asifsid88.myexpense.dal.dao.IDao;
import com.asifsid88.myexpense.model.IModel;

/**
 * Created by mhussaa on 5/5/17.
 */
public interface ModelDaoMapper<D extends IDao, M extends IModel> {
    D toDao(M model);
    M toModel(D dao);
}
