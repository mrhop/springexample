package com.hopever.springexample.integration.sftp;

import com.hopever.springexample.integration.util.UtilCommand;
import com.jcraft.jsch.ChannelSftp;
import org.springframework.boot.CommandLineRunner;
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
//@Configuration
//@Order(18)
//@ImportResource("META-INF/spring/integration/sftp/SftpInboundReceiveSample-context.xml")
public class SftpInboundReceiveSample extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
            RemoteFileTemplate<ChannelSftp.LsEntry> template = null;
        String file1 = "a.txt";
        String file2 = "b.txt";
        String file3 = "c.bar";
        new File("local-dir", file1).delete();
        new File("local-dir", file2).delete();
        try {
            PollableChannel localFileChannel = applicationContext.getBean("receiveChannel", PollableChannel.class);
            @SuppressWarnings("unchecked")
            SessionFactory<ChannelSftp.LsEntry> sessionFactory = applicationContext.getBean(CachingSessionFactory.class);
            template = new RemoteFileTemplate<ChannelSftp.LsEntry>(sessionFactory);
            SftpTestUtils.createTestFiles(template, file1, file2, file3);

            SourcePollingChannelAdapter adapter = applicationContext.getBean(SourcePollingChannelAdapter.class);
            adapter.start();

            Message<?> received = localFileChannel.receive();
            System.out.println("Received first file message: " + received);
            received = localFileChannel.receive();
            System.out.println("Received second file message: " + received);
            received = localFileChannel.receive(1000);
            System.out.println("No third file was received as expected");
        } finally {
            SftpTestUtils.cleanUp(template, file1, file2, file3);
        }
    }
}
