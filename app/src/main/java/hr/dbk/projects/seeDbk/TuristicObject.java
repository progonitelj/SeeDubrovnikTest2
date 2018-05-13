package hr.dbk.projects.seeDbk;


public class TuristicObject {

    String name;
    String shortDesc;
    String pot;
    String geo;
    int img;

    public TuristicObject(String name, String shortDesc, String pot, int img, String geo) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.pot = pot;
        this.geo = geo;
        this.img = img;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getPot() {
        return pot;
    }

    public void setPot(String pot) {
        this.pot = pot;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
