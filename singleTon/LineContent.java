package singleTon;

import java.util.Date;

public class LineContent implements Comparable {
    String content;

    Date createDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println(this.getCreateDate()+ " "+((LineContent) o).getCreateDate());
        return this.getCreateDate().compareTo(((LineContent) o).getCreateDate());
    }
}
