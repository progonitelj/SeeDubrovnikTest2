package hr.dbk.projects.seeDbk;

public class Emergency extends TuristicObject {
    String type;

    public Emergency(String name, String type, String shortDesc, String pot, int img, String geo) {
        super(name, shortDesc, pot, img, geo);
        this.type = type;
    }
}
