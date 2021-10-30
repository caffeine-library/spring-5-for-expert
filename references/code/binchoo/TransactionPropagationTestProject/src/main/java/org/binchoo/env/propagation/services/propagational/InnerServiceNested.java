package org.binchoo.env.propagation.services.propagational;

import org.binchoo.env.propagation.services.ExceptionLocation;
import org.binchoo.env.propagation.services.InnerService;
import org.binchoo.env.propagation.services.inner.JdbcInnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.NESTED, transactionManager = "dataSourceTransactionManager")
@Service("innerServiceNested")
public class InnerServiceNested implements InnerService {

    @Autowired
    private JdbcInnerService impl;

    @Override
    public void updateColumn(Long id, ExceptionLocation eLocation) {
        impl.updateColumn(id, eLocation);
    }
}
