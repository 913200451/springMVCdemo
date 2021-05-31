package spring.service.imple;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import spring.Util.DelUtil;
import spring.Util.GetmainPartUtil;
import spring.Util.StringCompareUtil;
import spring.dao.CollageDao;
import spring.resource.templeresource;
import spring.service.CheckService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class CheckServiceImple implements CheckService {

    @Autowired
    CollageDao collageDao;
    public ModelAndView checkline(File f,int id,ModelAndView mv)
    {
        String linerule=collageDao.SelectById(id).getW_linerule();
        String linemax=collageDao.SelectById(id).getW_line_max();
        String linemin=collageDao.SelectById(id).getW_line_min();
        int mainpartIndex=0;
        List<String> errmsg = new ArrayList<String>();
        int LineError = 0;
        try {
            mainpartIndex= GetmainPartUtil.getmain(f);
            if(mainpartIndex==0) {
                mv.addObject("errmsg","未找到文章正文部分");
                return mv;
            }
            //2.解析xml文档，加载文档进内存，获取Jsoup 的document对象
            Document document = Jsoup.parse(f, "UTF-8");
            //解析xml
            Elements elements1 = document.getElementsByTag("w:p");
            for(int j=mainpartIndex;j<elements1.size();j++) {
                Element elements2 = elements1.get(j);
                Elements elements3 = elements2.getElementsByTag("w:spacing");
                for (int i = 0; i < elements3.size(); i++) {
                    if (!elements3.attr("w:line").isEmpty()) {
                        if (StringCompareUtil.firstbig(elements3.attr("w:line"), linemax) || StringCompareUtil.firstbig(linemin, elements3.attr("w:line")) || !elements3.attr("w:lineRule").equals(linerule)) {
                            if (!elements2.getElementsByTag("w:t").isEmpty()) {
                                LineError++;
                                errmsg.add("行间距错误，错误位于" + "\"" + elements2.getElementsByTag("w:t").text() + "\"" + "<br/>");
                            }
                        }
                    }
                }

            }

            mv.addObject("LineError", Integer.toString(LineError));
            mv.addObject("errmsg",errmsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }

    @Override
    public ModelAndView checktitles(File f, int id, ModelAndView mv) {
        String titlesize=collageDao.SelectById(id).getTitle_size();
        String titlebold=collageDao.SelectById(id).getTitle_isbold();
        String subtitlesize=collageDao.SelectById(id).getSubtitle_size();
        String subtitlebold=collageDao.SelectById(id).getSubtitle_isbold();
        boolean titlesizeok=false;
        boolean titleboldok=false;
        List<String> errmsg = new ArrayList<String>();
        Document document = null;
        try {
            document = Jsoup.parse(f, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //解析xml
        Elements elements1 = document.getElementsByTag("w:p");
        for(int j=0;j<elements1.size();j++) {
            Element elements2 = elements1.get(j);
            Elements elements3 = elements2.getElementsByTag("w:t");
            if(elements3.html().equals("本科毕业设计（论文）")){
                Elements elements4 = elements2.getElementsByTag("w:b");
                if (elements4!=null){
                    if(!elements4.attr("w:val").equals("0")){
                        titleboldok=true;
                    }
                }
                Elements elements5 = elements2.getElementsByTag("w:sz");
                if(elements5.attr("w:val").equals(titlesize)) titlesizeok=true;
            }
        }
        Map<String,Object> errMap=(Map<String,Object>)mv.getModel();
        errmsg=(List<String>) errMap.get("errmsg");
    if(!titleboldok) errmsg.add("标题未加粗<br/>");
    if(!titlesizeok) errmsg.add("标题字体大小错误<br/>");
    mv.addObject("errmsg",errmsg);
    return mv;
    }
}


