package com.hopever.springexample.integration.sftp;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public interface ToSftpFlowGateway {
    public List<Boolean> lsGetAndRmFiles(String dir);
}
