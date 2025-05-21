package eu.frezilla.apis.datas.release;

import java.util.Date;
import java.util.List;

public class Release {

    private List<Contain> contains;
    private Date date;
    private String version;

    public List<Contain> getContains() {
        return contains;
    }

    public void setContains(List<Contain> contains) {
        this.contains = contains;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
