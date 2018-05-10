
package com.yida.amq.stream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.StreamMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;

import com.yida.utils.StreamUtils;

/**
 *********************
 * @author wj
 * @version 1.0
 * @created 2018年4月28日 上午11:50:33
 ***********************
 */
public class AmqConnectTest2 {

	public static void main(String[] args) {
		try {
			String brokerURL = "tcp://localhost:61616";
			ConnectionFactory fac = new ActiveMQConnectionFactory("admin", "admin", brokerURL);
			Connection conn = fac.createConnection("", "");
			conn.start();
			ActiveMQSession createSession = (ActiveMQSession) conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageConsumer createConsumer = createSession
					.createConsumer(createSession.createTopic("com.yida.test.file"));

			createConsumer.setMessageListener(new MessageListener() {

				public void onMessage(Message message) {
					System.err.println("fffffff");
					System.err.println(message.getClass().getName());
					try {
						if (message instanceof BytesMessage) {
							BytesMessage bytesMessage = (BytesMessage) message;
							byte[] b = new byte[8196];
							bytesMessage.readBytes(b);
							StreamUtils.bytesToFile(b, new File("C:\\Users\\0\\Desktop\\temp\\sdf.doc"));
						} else if (message instanceof BlobMessage) {
							BlobMessage blobMessage = (BlobMessage) message;
							InputStream inputStream = blobMessage.getInputStream();
							StreamUtils.inputstreamToFile(inputStream,
									new File("C:\\Users\\0\\Desktop\\temp\\aasdab.jpg"));
						} else if (message instanceof StreamMessage) {
							StreamMessage streamMessage = (StreamMessage) message;

							byte[] buf = new byte[1024];
							int len;
							ByteArrayOutputStream bos = new ByteArrayOutputStream();
							while ((len = streamMessage.readBytes(buf)) != -1) {
								bos.write(buf, 0, len);
							}

							String filename = streamMessage.getStringProperty("name");
							StreamUtils.bytesToFile(bos.toByteArray(),
									new File("C:\\Users\\0\\Desktop\\temp\\" + filename));
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
