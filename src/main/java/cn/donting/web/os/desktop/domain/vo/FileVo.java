package cn.donting.web.os.desktop.domain.vo;

import lombok.Data;

import java.io.File;

@Data
public class FileVo {
    private String name;
    private String path;
    private boolean  dir;
    private long size;
    private long lastModifiedTime;
    private String prentPath;
    private boolean hidde;
    public FileVo(File file) {
        name=file.getName();
        path=file.getAbsolutePath();
        dir=file.isDirectory();
        size=file.length();
        lastModifiedTime=file.lastModified();
        prentPath=file.getParentFile().getAbsolutePath();
        hidde=file.isHidden();
    }
}
