package spring.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

public class GetmainPartUtil {
    public static int  getmain(File f) throws IOException {
        ModelAndView mv = new ModelAndView();
        int mainIndex = 0;
        int LineError = 0;
        //2.解析xml文档，加载文档进内存，获取Jsoup 的document对象
        Document document = Jsoup.parse(f, "UTF-8");
        //解析xml
        Elements elements1 = document.getElementsByTag("w:p");
        for (int i = 0; i < elements1.size(); i++) {
            Element elements2 = elements1.get(i);
            String elementtext = elements2.getElementsByTag("w:t").text();
            if (elementtext.matches("目.*录")) {
                mainIndex = i;

            }

        }
        return mainIndex;
    }
}
