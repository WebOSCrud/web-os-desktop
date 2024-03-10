package cn.donting.web.os.desktop.controller;

import cn.donting.web.os.desktop.domain.ResponseBody;
import cn.donting.web.os.desktop.domain.vo.DiskVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/disk")
@Slf4j
public class DiskController {

    @PostMapping({"/list"})
    public ResponseBody<List<DiskVo>> list() {
        File[] files = File.listRoots();
        List<DiskVo> diskVos = new ArrayList<>();
        for (File file : files) {
            DiskVo diskVo = new DiskVo();
            diskVo.setName(file.getPath());
            diskVo.setPath(file.getPath());
            diskVo.setFreeSpace(file.getFreeSpace());
            diskVo.setTotalSpace(file.getTotalSpace());
            diskVo.setUsableSpace(file.getUsableSpace());
            diskVos.add(diskVo);
        }
        return ResponseBody.success(diskVos);
    }
}
