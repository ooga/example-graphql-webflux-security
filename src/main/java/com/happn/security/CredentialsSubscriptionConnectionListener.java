package com.happn.security;

import graphql.kickstart.execution.subscriptions.SubscriptionSession;
import graphql.kickstart.execution.subscriptions.apollo.ApolloSubscriptionConnectionListener;
import graphql.kickstart.execution.subscriptions.apollo.OperationMessage;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.HashMap;

@Slf4j
public class CredentialsSubscriptionConnectionListener implements ApolloSubscriptionConnectionListener {

    @Override
    @SuppressWarnings("unchecked")
    public void onConnect(SubscriptionSession session, OperationMessage message) {
        val payload = message.getPayload();
        if (payload instanceof HashMap) {
            HashMap<String, String> httpHeaders = (HashMap<String, String>) payload;
            session.getUserProperties().putAll(httpHeaders);
        }
    }
}
