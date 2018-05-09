package hr.project.seedubrovnik;

public class Atraction extends Emergency {
    String link1;
    String link2;

    public Atraction(String name, String type, String shortDesc, String pot, int img, String geo, String link1, String link2) {
        super(name, type, shortDesc, pot, img, geo);
        this.link1 = link1;
        this.link2 = link2;
    }
}
