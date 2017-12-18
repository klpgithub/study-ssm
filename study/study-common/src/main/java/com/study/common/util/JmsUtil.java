package com.study.common.util;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 
 * @author KLP
 * @date 2017年12月18日下午4:10:18
 */
public class JmsUtil {

	/**
	 * 发送文本消息
	 * 
	 * @author : KLP
	 * @param jmsTemplate
	 * @param destination
	 * @param textMessage
	 */
	public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final String textMessage) {
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(textMessage);
			}
		});
	}

	/**
	 * 发送对象消息
	 * 
	 * @author : KLP
	 * @param jmsTemplate
	 * @param destination
	 * @param objectMessage
	 */
	public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final Serializable objectMessage) {
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(objectMessage);
			}
		});
	}

	/**
	 * 延迟发送对象消息
	 * 
	 * @author : KLP
	 * @param jmsTemplate
	 * @param destination
	 * @param objectMessage
	 * @param delay
	 */
	public static void sendMessageDelay(JmsTemplate jmsTemplate, Destination destination,
			final Serializable objectMessage, final long delay) {
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage message = session.createObjectMessage();
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 1 * 1000);
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 1);
				return message;
			}
		});
	}

}
