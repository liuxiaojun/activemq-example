package com.socialmaster.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by liuxiaojun on 2016/6/15.
 */
public class Listener implements MessageListener{
    public void onMessage(Message message) {
        try {
            System.out.println("receive "+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
