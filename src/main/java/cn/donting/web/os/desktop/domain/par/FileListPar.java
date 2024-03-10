package cn.donting.web.os.desktop.domain.par;

import cn.donting.web.os.desktop.domain.FileSort;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FileListPar extends FilePathPar {

    private FileSort sort = FileSort.NAME;
    private boolean desc = false;

    public static enum Sort {
        Name,
    }
}
