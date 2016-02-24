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
        return this;
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
        //noop
        //System.out.println("begin");
        //definition.getName()
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) throws TransactionException {
        //noop
        //System.out.println("after commit");
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
        //noop
       // System.out.println("after exception");
    }

}
