package com.hopever.springexample.integration.file;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
@Configuration
@Order(6)
@ImportResource("/META-INF/spring/integration/file/file-context.xml")
public class FileCommand extends UtilCommand implements CommandLineRunner {



    @Override
    @SuppressWarnings("unchecked")
    public void run(String... args) throws Exception {
        this.displayDirectories();
    }

    @SuppressWarnings("unchecked")
    public void displayDirectories() throws Exception {
//        File inDir = (File) new DirectFieldAccessor(applicationContext.getBean(FileReadingMessageSource.class)).getPropertyValue("directory");
//        LiteralExpression expression = (LiteralExpression) new DirectFieldAccessor(applicationContext.getBean(FileWritingMessageHandler.class)).getPropertyValue("destinationDirectoryExpression");
//        File outDir = new File(expression.getValue());
//        System.out.println("Input directory is: " + inDir.getAbsolutePath());
//        System.out.println("Output directory is: " + outDir.getAbsolutePath());
//        System.out.println("===================================================");
    }
}
