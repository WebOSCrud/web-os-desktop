package cn.donting.web.os.desktop.domain.par;

import lombok.Data;

@Data
public class FileRenamePar {
    private String newName;
    private String oldPath;
}
