package eu.frezilla.apis.datas;

public class AppInfo {

    private final String description;
    private final String name;
    private final String version;

    public AppInfo(String name, String descrtiption, String version) {
        this.description = descrtiption;
        this.name = name;
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

}
