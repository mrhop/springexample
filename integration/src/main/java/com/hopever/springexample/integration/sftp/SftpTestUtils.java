package com.hopever.springexample.integration.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.file.remote.SessionCallback;
import org.springframework.integration.file.remote.session.Session;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class SftpTestUtils {

    public static void createTestFiles(RemoteFileTemplate<ChannelSftp.LsEntry> template, final String... fileNames) {
        if (template != null) {
            final ByteArrayInputStream stream = new ByteArrayInputStream("foo".getBytes());
            template.execute(new SessionCallback<ChannelSftp.LsEntry, Void>() {

                @Override
                public Void doInSession(Session<ChannelSftp.LsEntry> session) throws IOException {
                    try {
                        session.mkdir("si.sftp.sample");
                    }
                    catch (Exception e) {
                           e.printStackTrace();
                    }
                    for (int i = 0; i < fileNames.length; i++) {
                        stream.reset();
                        session.write(stream, "si.sftp.sample/" + fileNames[i]);
                    }
                    return null;
                }
            });
        }
    }

    public static void cleanUp(RemoteFileTemplate<ChannelSftp.LsEntry> template, final String... fileNames) {
        if (template != null) {
            template.execute(new SessionCallback<ChannelSftp.LsEntry, Void>() {

                @Override
                public Void doInSession(Session<ChannelSftp.LsEntry> session) throws IOException {
                    // TODO: avoid DFAs with Spring 4.1 (INT-3412)
                    ChannelSftp channel = (ChannelSftp) new DirectFieldAccessor(new DirectFieldAccessor(session)
                            .getPropertyValue("targetSession")).getPropertyValue("channel");
                    for (int i = 0; i < fileNames.length; i++) {
                        try {
                            session.remove("si.sftp.sample/" + fileNames[i]);
                        }
                        catch (IOException e) {}
                    }
                    try {
                        // should be empty
                        channel.rmdir("si.sftp.sample");
                    }
                    catch (SftpException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            });
        }
    }

    public static boolean fileExists(RemoteFileTemplate<ChannelSftp.LsEntry> template, final String... fileNames) {
        if (template != null) {
            return template.execute(new SessionCallback<ChannelSftp.LsEntry, Boolean>() {

                @Override
                public Boolean doInSession(Session<ChannelSftp.LsEntry> session) throws IOException {
                    // TODO: avoid DFAs with Spring 4.1 (INT-3412)
                    ChannelSftp channel = (ChannelSftp) new DirectFieldAccessor(new DirectFieldAccessor(session)
                            .getPropertyValue("targetSession")).getPropertyValue("channel");
                    for (int i = 0; i < fileNames.length; i++) {
                        try {
                            SftpATTRS stat = channel.stat("si.sftp.sample/" + fileNames[i]);
                            if (stat == null) {
                                System.out.println("stat returned null for " + fileNames[i]);
                                return false;
                            }
                        }
                        catch (SftpException e) {
                            System.out.println("Remote file not present: " + e.getMessage() + ": " + fileNames[i]);
                            return false;
                        }
                    }
                    return true;
                }
            });
        }
        else {
            return false;
        }
    }

}
