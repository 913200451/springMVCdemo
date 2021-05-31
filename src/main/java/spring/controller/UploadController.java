package spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import spring.Util.*;
import spring.service.CheckService;
import spring.service.FileUploadService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @Autowired
    private CheckService checkService;
    @RequestMapping(value = "/springUpload.do")
    public ModelAndView upload(@RequestParam MultipartFile file,@RequestParam("id") String id) throws Exception {
        String location=System.getProperty("os.name");
        String savelocation;
        if(location.equals("Windows 10")) savelocation="E:/javatest/";
        else savelocation="/home/springfiles/";
        ModelAndView mv = new ModelAndView();
        int sid=Integer.parseInt(id);
        if(file==null)
        {
            mv.setViewName("error");
            mv.addObject("reason","文件为空！");
            return mv;
        }
        if(!TypecheckUtil.checktype(file))
        {
            mv.setViewName("error");
            mv.addObject("reason","不是docx文件！");
            return mv;
        }

        File nfile=new File(savelocation + UUID.randomUUID() + file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."))+".zip");
        File dec = new File(nfile.getParent()+"/unzip/"+nfile.getName().substring(0, nfile.getName().lastIndexOf(".")));
        try {
            file.transferTo(nfile);
            UnzipUtil.decompression(nfile.toString(),dec.toString());
            nfile.delete();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mv = checkService.checkline(new File(dec.getAbsolutePath()+"/word/document.xml"),sid,mv);
        mv = checkService.checktitles(new File(dec.getAbsolutePath()+"/word/document.xml"),sid,mv);
        DelUtil.delFolder(dec.getAbsolutePath());
        mv.setViewName("show");
        return mv;
    }


}
