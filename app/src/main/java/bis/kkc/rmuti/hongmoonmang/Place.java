package bis.kkc.rmuti.hongmoonmang;

import java.io.Serializable;

/**
 * Created by I Am Coffee on 3/20/2018.
 */

public class Place implements Serializable {
    public int  pid;
    public  String name;
    public  int thumbnail;
    public  String detail;

    public  Place(){}
    public Place(int pid, String name, int thumbnail, String detail) {
        this.pid = pid;
        this.name = name;
        this.thumbnail = thumbnail;
        this.detail = detail;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
