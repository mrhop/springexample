package com.hopever.springexample.integration.tcpclientserver;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.util.TestingUtilities;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
//@Configuration
//@Order(21)
//@ImportResource("META-INF/spring/integration/tcp-client-server/tcpClientServerDemo-context.xml")
//@ImportResource("META-INF/spring/integration/tcp-client-server/tcpClientServerDemo-conversion-context.xml")
//@ImportResource("META-INF/spring/integration/tcp-client-server/tcpServerConnectionDeserialize-context.xml")
//@ImportResource("META-INF/spring/integration/tcp-client-server/tcpServerCustomSerialize-context.xml")
public class TcpCommand extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        final SimpleGateway gateway = applicationContext.getBean(SimpleGateway.class);
        final AbstractServerConnectionFactory crLfServer = applicationContext.getBean(AbstractServerConnectionFactory.class);

        System.out.print("Waiting for server to accept connections...");
        TestingUtilities.waitListening(crLfServer, 10000L);
        System.out.println("running.\n\n");


        //final String input = "test 123";
        //for deserializer
        final String input = "123testtestte000003abc";
        final String result = gateway.send(input);
        System.out.println(result);

        System.out.println("Exiting application...bye.");

    }
}
