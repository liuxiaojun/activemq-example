package com.socialmaster.activemq;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created by liuxiaojun on 2016/6/15.
 */
public class Consumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String BROKEURL = "tcp://118.192.138.88:61616";

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(Consumer.USERNAME, Consumer.PASSWORD, Consumer.BROKEURL);
        Connection connection = null;
        connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("Demo");
        MessageConsumer messageConsumer = session.createConsumer(destination);
        while(true){
            TextMessage textMessage = (TextMessage)messageConsumer.receive(100000);
            if(textMessage != null){
                System.out.println("receive "+textMessage.getText());
            }
        }
    }
}
