package hr.project.seedubrovnik;


public class TuristicObject extends PartsOfTown{

    private String partOfTown;
    private String typeOfObject;
    private String geoURI;

    TuristicObject(String name, String PartOfTown, String description, String typeOfObject, int image, String geoURI){
        super(name, image, description);
        this.setPartOfTown(PartOfTown);
        this.setGeoURI(geoURI);
        this.setTypeOfObject(typeOfObject);
    }



    public String getPartOfTown() {
        return partOfTown;
    }

    public void setPartOfTown(String partOfTown) {
        this.partOfTown = partOfTown;
    }

    public String getGeoURI() {
        return geoURI;
    }

    public void setGeoURI(String geoURI) {
        this.geoURI = geoURI;
    }


    public String getTypeOfObject() {
        return typeOfObject;
    }

    public void setTypeOfObject(String typeOfObject) {
        this.typeOfObject = typeOfObject;
    }


}
