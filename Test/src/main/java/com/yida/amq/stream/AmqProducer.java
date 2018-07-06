package com.yida.amq.stream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.StreamMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *********************
 * 主题发送生产者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日14:14:17
 ***********************
 */
public class AmqProducer {

	public static final String BROKER_URL = "tcp://localhost:61616";
	public static final String TOPIC_NAME = "com.yida.test.file";

	private ConnectionFactory connectionFactory;

	private Connection connection;

	private Session session;

	private Destination destination;

	private MessageProducer messageProducer;

	public static void main(String[] args) {
		AmqProducer producer = new AmqProducer();
		producer.doSend();
	}

	@SuppressWarnings("resource")
	public void doSend() {
		try {
			ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin",
					BROKER_URL);
			connectionFactory = activeMQConnectionFactory;

			connection = connectionFactory.createConnection();

			connection.start();

			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

			destination = session.createTopic("com.yida.test.file");

			messageProducer = session.createProducer(destination);
			messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			messageProducer.setTimeToLive(60000);

			// 发送文件
			StreamMessage message = session.createStreamMessage();
			File file = new File("C:\\Users\\0\\Desktop\\apache-activemq-5.15.3.zip");
			FileInputStream in = new FileInputStream(file.getAbsolutePath());

			int len;
			byte[] buf = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = in.read(buf, 0, 1024)) != -1) {
				bos.write(buf, 0, len);
			}

			message.writeBytes(bos.toByteArray());
			message.setStringProperty("name", file.getName());
			new HashSet<String>().add("aa");
			new HashMap<String, Object>();
			messageProducer.send(message);
			System.out.println("消息发送完成！");
			session.commit();

			messageProducer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
