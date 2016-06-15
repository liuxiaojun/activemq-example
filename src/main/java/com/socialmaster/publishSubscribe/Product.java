package com.socialmaster.publishSubscribe;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created by liuxiaojun on 2016/6/15.
 */
public class Product {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = "tcp://118.192.138.88:61616";
    private static final int SENDNUM = 10;

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(Product.USERNAME, Product.PASSWORD, Product.BROKEURL);
        connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createTopic("test123");
        MessageProducer messageProducer = session.createProducer(destination);
        sendMessage(session, messageProducer);
        session.commit();
    }

    public static void sendMessage(Session session,MessageProducer messageProducer)throws Exception{
        for(int i = 0; i < Product.SENDNUM; i++){
            TextMessage message=session.createTextMessage("activeMQ sendMessage"+i);
            System.out.println("activeMQ sendMessage"+i);
            messageProducer.send(message);
        }
    }
}
