package cn.donting.web.os.desktop.util;

import java.io.File;

public class FileUtil {


    public static File creatNewFile(File prent,String fileName){
        String extName = cn.hutool.core.io.FileUtil.extName(fileName);
        String mainName = cn.hutool.core.io.FileUtil.mainName(fileName);
        File file = new File(prent,mainName + "." + extName);
        int index=1;
        while (file.exists()){
            file = new File(prent,mainName + "("+index+")." + extName);
            index++;
        }
        return file;
    }
}
