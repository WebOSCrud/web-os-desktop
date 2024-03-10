package cn.donting.web.os.desktop.service.file;

import cn.donting.web.os.desktop.domain.FileSort;
import cn.donting.web.os.desktop.domain.IFileSort;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileNameSort implements IFileSort {
    public List<File> sort(List<File> files,boolean desc) {
        files.sort((o1, o2) -> {
            if(desc){
                return o2.getName().compareTo(o1.getName());
            }
            return o1.getName().compareTo(o2.getName());
        });
        return files;
    }

    @Override
    public List<File> sort(File[] files, boolean desc) {
        List<File> dir = new ArrayList<>();
        List<File> file = new ArrayList<>();
        for (File f : files) {
            if (f.isDirectory()) {
                dir.add(f);
            } else {
                file.add(f);
            }
        }
        List<File> sort = sort(dir, desc);
        sort.addAll(sort(file, desc));
        return sort;
    }
}
