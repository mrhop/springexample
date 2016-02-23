package com.hopever.springexample.db.mongodb;

import org.springframework.integration.transaction.PseudoTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * Created by huodh on 2/23/16.
 */
public class TestMongoTransactionManager extends PseudoTransactionManager {
    @Override
    protected Object doGetTransaction() throws TransactionException {
        return new Object();
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
        //noop
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) throws TransactionException {
        //noop
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
        //noop
    }

}
