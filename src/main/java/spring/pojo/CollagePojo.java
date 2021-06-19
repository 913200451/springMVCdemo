package spring.pojo;

public class CollagePojo {
    int id;
    String collage_name;
    String w_linerule;
    String w_line_max;
    String w_line_min;
    String title_size;
    String title_isbold;
    String subtitle_size;
    String subtitle_isbold;
    String formatdiscribe;

    @Override
    public String toString() {
        return "CollagePojo{" +
                "id=" + id +
                ", collage_name='" + collage_name + '\'' +
                ", w_linerule='" + w_linerule + '\'' +
                ", w_line_max='" + w_line_max + '\'' +
                ", w_line_min='" + w_line_min + '\'' +
                ", title_size='" + title_size + '\'' +
                ", title_isbold='" + title_isbold + '\'' +
                ", subtitle_size='" + subtitle_size + '\'' +
                ", subtitle_isbold='" + subtitle_isbold + '\'' +
                ", formatdiscribe='" + formatdiscribe + '\'' +
                '}';
    }

    public String getFormatdiscribe() {
        return formatdiscribe;
    }

    public void setFormatdiscribe(String formatdiscribe) {
        this.formatdiscribe = formatdiscribe;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollage_name() {
        return collage_name;
    }

    public void setCollage_name(String collage_name) {
        this.collage_name = collage_name;
    }

    public String getW_linerule() {
        return w_linerule;
    }

    public void setW_linerule(String w_linerule) {
        this.w_linerule = w_linerule;
    }

    public String getW_line_max() {
        return w_line_max;
    }

    public void setW_line_max(String w_line_max) {
        this.w_line_max = w_line_max;
    }

    public String getW_line_min() {
        return w_line_min;
    }

    public void setW_line_min(String w_line_min) {
        this.w_line_min = w_line_min;
    }

    public String getTitle_size() {
        return title_size;
    }

    public void setTitle_size(String title_size) {
        this.title_size = title_size;
    }

    public String getTitle_isbold() {
        return title_isbold;
    }

    public void setTitle_isbold(String title_isbold) {
        this.title_isbold = title_isbold;
    }

    public String getSubtitle_size() {
        return subtitle_size;
    }

    public void setSubtitle_size(String subtitle_size) {
        this.subtitle_size = subtitle_size;
    }

    public String getSubtitle_isbold() {
        return subtitle_isbold;
    }

    public void setSubtitle_isbold(String subtitle_isbold) {
        this.subtitle_isbold = subtitle_isbold;
    }
}
