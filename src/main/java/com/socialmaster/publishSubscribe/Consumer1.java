package com.socialmaster.publishSubscribe;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created by liuxiaojun on 2016/6/15.
 */
public class Consumer1 {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = "tcp://118.192.138.88:61616";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory=new ActiveMQConnectionFactory(Consumer1.USERNAME, Consumer1.PASSWORD, Consumer1.BROKEURL);

        try {
            connection=connectionFactory.createConnection();
            connection.start();
            session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination=session.createTopic("test123");
            messageConsumer=session.createConsumer(destination);
            messageConsumer.setMessageListener(new Listener1());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
