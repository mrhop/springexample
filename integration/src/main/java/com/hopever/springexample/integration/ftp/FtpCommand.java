package com.hopever.springexample.integration.ftp;

import com.hopever.springexample.integration.util.UtilCommand;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

import java.io.File;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
@Configuration
@Order(7)
@ImportResource("/META-INF/spring/integration/ftp/ftp-context.xml")
public class FtpCommand extends UtilCommand implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilCommand.class);

    public static final String FTP_ROOT_DIR       = "target" + File.separator + "ftproot";
    public static final String LOCAL_FTP_TEMP_DIR = "target" + File.separator + "local-ftp-temp";
    public static final String SERVER_PORT_SYSTEM_PROPERTY = "availableServerPort";
    private final File baseFolder = new File("target" + File.separator + "toSend");


    public static FtpServer server;
    public static void setupFtpServer() throws FtpException {
        final int availableServerSocket;

        if (System.getProperty(SERVER_PORT_SYSTEM_PROPERTY) == null) {
//            availableServerSocket = SocketUtils.findAvailableTcpPort(4444);
            availableServerSocket = 3333;
            System.setProperty(SERVER_PORT_SYSTEM_PROPERTY, Integer.valueOf(availableServerSocket).toString());
        } else {
            availableServerSocket = Integer.valueOf(System.getProperty(SERVER_PORT_SYSTEM_PROPERTY));
        }

        LOGGER.info("Using open server port..." + availableServerSocket);

        File ftpRoot = new File (FTP_ROOT_DIR);
        ftpRoot.mkdirs();

        UserManager userManager = new UserManager(ftpRoot.getAbsolutePath());

        FtpServerFactory serverFactory = new FtpServerFactory();
        serverFactory.setUserManager(userManager);
        ListenerFactory factory = new ListenerFactory();

        factory.setPort(availableServerSocket);

        serverFactory.addListener("default", factory.createListener());

        server = serverFactory.createServer();

        server.start();
    }
    @Override
    public void run(String... args) throws Exception {
        setupFtpServer();

        //write
//        MessageChannel ftpChannelOut = applicationContext.getBean("ftpChannelOut", MessageChannel.class);
//
//        baseFolder.mkdirs();
//
//        final File fileToSendA = new File(baseFolder, "a.txt");
//        final File fileToSendB = new File(baseFolder, "b.txt");
//
//        final InputStream inputStreamA = FtpCommand.class.getResourceAsStream("/META-INF/spring/integration/ftp/test-files/a.txt");
//        final InputStream inputStreamB = FtpCommand.class.getResourceAsStream("/META-INF/spring/integration/ftp/test-files/b.txt");
//
//        FileUtils.copyInputStreamToFile(inputStreamA, fileToSendA);
//        FileUtils.copyInputStreamToFile(inputStreamB, fileToSendB);
//
//
//        final Message<File> messageA = MessageBuilder.withPayload(fileToSendA).build();
//        final Message<File> messageB = MessageBuilder.withPayload(fileToSendB).build();
//
//        ftpChannelOut.send(messageA);
//        ftpChannelOut.send(messageB);
//
//        Thread.sleep(2000);
//
//
//        LOGGER.info("Successfully transfered file 'a.txt' and 'b.txt' to a remote FTP location.");
//
//        //read
//
//        PollableChannel ftpChannelIn = this.applicationContext.getBean("ftpChannel", PollableChannel.class);
//
//        Message<?> message1 = ftpChannelIn.receive(2000);
//        Message<?> message2 = ftpChannelIn.receive(2000);
//        Message<?> message3 = ftpChannelIn.receive(1000);
//
//        LOGGER.info(String.format("Received first file message: %s.", message1));
//        LOGGER.info(String.format("Received second file message: %s.", message2));
//        LOGGER.info(String.format("Received nothing else: %s.", message3));


        //execute command
        final ToFtpFlowGateway toFtpFlow = applicationContext.getBean(ToFtpFlowGateway.class);

        // execute the flow (ls, get, rm, aggregate results)
        List<Boolean> rmResults = toFtpFlow.lsGetAndRmFiles("/");

        //Check everything went as expected, and clean up
        LOGGER.info(String.format("Was expecting the collection 'rmResults' to contain %s elements.", rmResults.size()));





    }
}
