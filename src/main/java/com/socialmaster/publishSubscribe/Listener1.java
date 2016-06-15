package com.socialmaster.publishSubscribe;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by liuxiaojun on 2016/6/15.
 */
public class Listener1  implements MessageListener{
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        try {
            System.out.println("consumer1 "+((TextMessage)message).getText());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
