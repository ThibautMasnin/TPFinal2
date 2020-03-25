package masnin.thibaut.tpfinal.Model;

public class Pays {
    private String flag;
    private String name;
    private String region;
    private String subregion;

    public Pays(String f, String n, String r, String s) {
        this.flag=f;
        this.name=n;
        this.region=r;
        this.subregion=s;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }
}
