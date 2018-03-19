package team.ants.shop.controller.common;

import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.POST;
import cn.jants.common.annotation.action.Param;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.JsonMap;
import cn.jants.common.utils.StrUtil;
import cn.jants.plugin.oss.OssResult;
import cn.jants.plugin.tool.AliOssTool;
import cn.jants.restful.render.Json;
import team.ants.shop.service.system.SysConfigService;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author MrShun
 * @version 1.0
 */
@Controller("upload")
public class UploadController {

    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 上传文件到OSS阿里云服务
     *
     * @param files 文件对象
     * @param dir   上传目录
     * @param gen   是否重命名 0/否 1/是
     * @return
     * @throws IOException
     */
    @POST("/oss")
    public Object ossUpload(Part[] files, @Param String dir, Integer gen) throws IOException {
        gen = gen == null ? 1 : 0;
        if (files == null) {
            return Json.fail("没有任何可以上传的文件!");
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            Part file = files[i];
            String fileName = file.getSubmittedFileName();
            if (gen == 1) {
                fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
            }
            InputStream inputStream = file.getInputStream();
            JsonMap aliOss = sysConfigService.getConfig("ali_oss");
            OssResult ossResult = AliOssTool.getAliOss(aliOss.getStr("ossUrl")
                    , aliOss.getStr("ossKeyId")
                    , aliOss.getStr("ossKeySecret"))
                    .uploadStream2OSS(inputStream, fileName, StrUtil.joinLastSuffix(dir, "/"));
            if (ossResult.isOk()) {
                list.add(ossResult.getUrl());
            }
        }
        return Json.success(list);
    }
}
