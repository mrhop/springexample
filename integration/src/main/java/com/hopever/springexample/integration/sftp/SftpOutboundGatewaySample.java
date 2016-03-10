package com.hopever.springexample.integration.sftp;

import com.hopever.springexample.integration.util.UtilCommand;
import com.jcraft.jsch.ChannelSftp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;

import java.io.File;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
//@Configuration
//@Order(18)
//@ImportResource("META-INF/spring/integration/sftp/SftpOutboundGatewaySample-context.xml")
public class SftpOutboundGatewaySample extends UtilCommand implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        ToSftpFlowGateway toFtpFlow = applicationContext.getBean(ToSftpFlowGateway.class);
        RemoteFileTemplate<ChannelSftp.LsEntry> template = null;
        String file1 = "1.ftptest";
        String file2 = "2.ftptest";
        File tmpDir = new File(System.getProperty("java.io.tmpdir"));

        try {
            // remove the previous output files if necessary
            new File(tmpDir, file1).delete();
            new File(tmpDir, file2).delete();

            @SuppressWarnings("unchecked")
            SessionFactory<ChannelSftp.LsEntry> sessionFactory = applicationContext.getBean(CachingSessionFactory.class);
            template = new RemoteFileTemplate<ChannelSftp.LsEntry>(sessionFactory);
            SftpTestUtils.createTestFiles(template, file1, file2);

            // execute the flow (ls, get, rm, aggregate results)
            List<Boolean> rmResults = toFtpFlow.lsGetAndRmFiles("si.sftp.sample");


            //Check everything went as expected, and clean up
            for (Boolean result : rmResults) {
            }

        }
        finally {
            SftpTestUtils.cleanUp(template, file1, file2);
        }
    }
}
