package hr.dbk.projects.seeDbk;

public class Transport extends Atraction {
    String phone;
    String email;

    public Transport(String name, String type, String shortDesc, String pot, int img, String geo, String link1, String link2, String phone, String email) {
        super(name, type, shortDesc, pot, img, geo, link1, link2);
        this.phone = phone;
        this.email = email;
    }
}
