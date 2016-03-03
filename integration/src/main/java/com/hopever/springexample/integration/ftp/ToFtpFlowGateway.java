package com.hopever.springexample.integration.ftp;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
public interface ToFtpFlowGateway {
    public List<Boolean> lsGetAndRmFiles(String dir);
}
