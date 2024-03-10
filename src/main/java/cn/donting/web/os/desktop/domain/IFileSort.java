package cn.donting.web.os.desktop.domain;

import java.io.File;
import java.util.List;

public interface IFileSort {

    List<File> sort(File[] files,boolean desc);

}
