package spring.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.servlet.ModelAndView;
import spring.resource.templeresource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckUtil {
    public static ModelAndView anaXml(File f) {
        int mainpartIndex=0;
        ModelAndView mv = new ModelAndView();
        List<String> errmsg = new ArrayList<String>();
        int LineError = 0;
        try {

            mainpartIndex=GetmainPartUtil.getmain(f);
            //2.解析xml文档，加载文档进内存，获取Jsoup 的document对象
            Document document = Jsoup.parse(f, "UTF-8");
            //解析xml
            Elements elements1 = document.getElementsByTag("w:p");
            Iterator<Element> it = elements1.iterator();
            while (it.hasNext()) {
                Element elements2 = it.next();
                Elements elements3 = elements2.getElementsByTag("w:spacing");
                for (int i = mainpartIndex; i < elements3.size(); i++) {
                    if (!elements3.attr("w:line").equals(templeresource.line)) {
                        if(!elements2.getElementsByTag("w:t").isEmpty()) {
                            LineError++;
                            errmsg.add("行间距错误，错误位于" + "\"" + elements2.getElementsByTag("w:t").text() + "\"" + "<br/>");
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
}
