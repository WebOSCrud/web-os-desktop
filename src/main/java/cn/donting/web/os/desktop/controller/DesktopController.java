package cn.donting.web.os.desktop.controller;

import cn.donting.web.os.api.OsApi;
import cn.donting.web.os.api.spaces.FileSpaces;
import cn.donting.web.os.api.user.User;
import cn.donting.web.os.desktop.domain.ResponseBody;
import cn.donting.web.os.desktop.domain.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/desktop")
public class DesktopController {


    @Autowired
    OsApi osApi;

    @GetMapping("/files")
    public ResponseBody<List<FileVo>> files() {
        User loginUser = osApi.userService().getLoginUser();
        File desktopSpacesFolder = osApi.fileSpaces().getDesktopSpacesFolder(loginUser);
        List<FileVo> fileVos=new ArrayList<>();
        for (File file : desktopSpacesFolder.listFiles()) {
            FileVo fileVo = new FileVo(file);
            fileVos.add(fileVo);
        }
        return ResponseBody.success(fileVos);
    }

}
