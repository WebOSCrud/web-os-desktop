package cn.donting.web.os.desktop.controller;

import cn.donting.web.os.api.OsApi;
import cn.donting.web.os.api.user.User;
import cn.donting.web.os.desktop.domain.ResponseBody;
import cn.donting.web.os.desktop.domain.par.FilePathPar;
import cn.donting.web.os.desktop.domain.par.FileRenamePar;
import cn.donting.web.os.desktop.domain.vo.FileVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static cn.donting.web.os.desktop.util.FileUtil.creatNewFile;

@RestController
@RequestMapping("/files")
@Slf4j
public class FileController {


    @PostMapping("/rename")
    public ResponseBody<FileVo> rename(@RequestBody FileRenamePar fileRenamePar) {
        File oldFile = new File(fileRenamePar.getOldPath());
        File newFile = new File(oldFile.getParent(), fileRenamePar.getNewName());
        if (oldFile.renameTo(newFile)) {
            return ResponseBody.success(new FileVo(newFile));
        }
        return ResponseBody.fail("重命名失败");
    }

    @PostMapping("/list")
    public ResponseBody<List<FileVo>> list(@RequestBody FilePathPar filePathPar) {
        File dir = new File(filePathPar.getPath());
        List<FileVo> fileVos = new ArrayList<>();
        for (File file : dir.listFiles()) {
            fileVos.add(new FileVo(file));
        }
        return ResponseBody.success(fileVos);
    }

    @PostMapping("/delete")
    public ResponseBody delete(@RequestBody FilePathPar filePathPar) {
        File file = new File(filePathPar.getPath());
        try {
            if (file.delete()) {
                return ResponseBody.success();
            }
            return ResponseBody.fail("删除失败："+filePathPar.getPath());
        } catch (Exception ex) {
            return ResponseBody.fail(ex.getMessage());
        }
    }


    @PostMapping("/upload")
    public ResponseBody<FileVo> upload(@RequestParam("file") MultipartFile multipartFile,
                               @RequestParam("dir") String dir) {
        String originalFilename = multipartFile.getOriginalFilename();
        try {
            File file = creatNewFile(new File(dir), originalFilename);
            multipartFile.transferTo(file);
            return ResponseBody.success(new FileVo(file));
        } catch (IOException e) {
            log.error(e.getMessage(),e);
            return ResponseBody.fail(e.getLocalizedMessage());
        }
    }


}
