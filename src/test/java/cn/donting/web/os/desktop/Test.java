package cn.donting.web.os.desktop;

import cn.hutool.system.oshi.OshiUtil;
import oshi.hardware.HWDiskStore;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws MalformedURLException {
        // 获取文件系统视图

        // 获取所有分区
        File[] roots = File.listRoots();

        for (File root : roots) {
            // 检查是否是逻辑驱动器，以过滤掉虚拟磁盘等
            // 获取分区显示名称
            // 获取分区路径
            String path = root.getPath();
            System.out.println("Drive: " + root.getName() + " (" + path + ")");
        }
    }

}
