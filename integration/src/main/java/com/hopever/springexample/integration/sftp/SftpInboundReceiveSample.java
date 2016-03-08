package com.hopever.springexample.integration.sftp;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

import java.io.File;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class SftpInboundReceiveSample {

    public static void main(String[] args){
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/integration/sftp/SftpInboundReceiveSample-context.xml");
        RemoteFileTemplate<ChannelSftp.LsEntry> template = null;
        String file1 = "a.txt";
        String file2 = "b.txt";
        String file3 = "c.bar";
        new File("local-dir", file1).delete();
        new File("local-dir", file2).delete();
        try {
            PollableChannel localFileChannel = context.getBean("receiveChannel", PollableChannel.class);
            @SuppressWarnings("unchecked")
            SessionFactory<ChannelSftp.LsEntry> sessionFactory = context.getBean(CachingSessionFactory.class);
            template = new RemoteFileTemplate<ChannelSftp.LsEntry>(sessionFactory);
            SftpTestUtils.createTestFiles(template, file1, file2, file3);

            SourcePollingChannelAdapter adapter = context.getBean(SourcePollingChannelAdapter.class);
            adapter.start();

            Message<?> received = localFileChannel.receive();
            System.out.println("Received first file message: " + received);
            received = localFileChannel.receive();
            System.out.println("Received second file message: " + received);
            received = localFileChannel.receive(1000);
            System.out.println("No third file was received as expected");
        }
        finally {
            SftpTestUtils.cleanUp(template, file1, file2, file3);
            context.close();
        }
    }

}
