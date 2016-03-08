package com.hopever.springexample.integration.sftp;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.util.Assert;

import java.io.File;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class SftpOutboundTransferSample {
    public static void main(String[] args) throws InterruptedException {
        final String sourceFileName = "README.md";
        final String destinationFileName = sourceFileName +"_foo";

        final ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("META-INF/spring/integration/sftp/SftpOutboundTransferSample-context.xml");
        @SuppressWarnings("unchecked")
        SessionFactory<ChannelSftp.LsEntry> sessionFactory = ac.getBean(CachingSessionFactory.class);
        RemoteFileTemplate<ChannelSftp.LsEntry> template = new RemoteFileTemplate<ChannelSftp.LsEntry>(sessionFactory);
        SftpTestUtils.createTestFiles(template); // Just the directory

        try {
            final File file = new File(sourceFileName);

            Assert.isTrue(file.exists(), String.format("File '%s' does not exist.", sourceFileName));

            final Message<File> message = MessageBuilder.withPayload(file).build();
            final MessageChannel inputChannel = ac.getBean("inputChannel", MessageChannel.class);

            inputChannel.send(message);
            Thread.sleep(2000);

            System.out.println(String.format("Successfully transferred '%s' file to a " +
                    "remote location under the name '%s'", sourceFileName, destinationFileName));
        }
        finally {
            SftpTestUtils.cleanUp(template, destinationFileName);
            ac.close();
        }
    }
}
