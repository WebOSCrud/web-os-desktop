package cn.donting.web.os.desktop.domain.vo;

import lombok.Data;

@Data
public class DiskVo {
    String name;
    String path;

    long totalSpace;
    long freeSpace ;
    long usableSpace ;


}
