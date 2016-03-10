package com.hopever.springexample.integration.sftp;

import com.hopever.springexample.integration.util.UtilCommand;
import com.jcraft.jsch.ChannelSftp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.SftpRemoteFileTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.io.File;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
//@Configuration
//@Order(18)
//@ImportResource("META-INF/spring/integration/sftp/SftpOutboundTransferSample-context.xml")
public class SftpOutboundTransferSample extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        final String sourceFileName = "README.md";
        final String destinationFileName = sourceFileName + "_foo";

        @SuppressWarnings("unchecked")
        SessionFactory<ChannelSftp.LsEntry> sessionFactory = applicationContext.getBean(CachingSessionFactory.class);
        RemoteFileTemplate<ChannelSftp.LsEntry> template = new RemoteFileTemplate<ChannelSftp.LsEntry>(sessionFactory);
        SftpTestUtils.createTestFiles(template); // Just the directory
        SftpRemoteFileTemplate a;
        try {
            final File file = new File(sourceFileName);

            final Message<File> message = MessageBuilder.withPayload(file).build();
            final MessageChannel inputChannel = applicationContext.getBean("inputChannel", MessageChannel.class);

            inputChannel.send(message);
            Thread.sleep(2000);
            System.out.println("really exists:"+SftpTestUtils.fileExists(template, destinationFileName));
            System.out.println(String.format("Successfully transferred '%s' file to a " +
                    "remote location under the name '%s'", sourceFileName, destinationFileName));
        } finally {
            SftpTestUtils.cleanUp(template, destinationFileName);
        }
    }
}
