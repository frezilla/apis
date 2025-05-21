package eu.frezilla.apis.datas.release;

import java.util.List;

public class ReleaseNotes {

    private String id;
    private List<Release> releases;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
        
}
