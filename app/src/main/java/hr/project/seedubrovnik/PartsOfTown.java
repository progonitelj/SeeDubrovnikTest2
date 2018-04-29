package hr.project.seedubrovnik;

public class PartsOfTown {

    String name;
    int image;
    String desc;

    public PartsOfTown(String name, int image, String desc) {
        this.name = name;
        this.image = image;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
