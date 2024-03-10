package cn.donting.web.os.desktop.domain;

import cn.donting.web.os.desktop.service.file.FileNameSort;

public enum FileSort {

    NAME(new FileNameSort()),
    ;
    private IFileSort fileSort;

    FileSort(IFileSort fileSort) {
        this.fileSort = fileSort;
    }

    public IFileSort getFileSort() {
        return fileSort;
    }
}
