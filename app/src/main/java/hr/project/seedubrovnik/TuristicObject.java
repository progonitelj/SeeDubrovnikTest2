package hr.project.seedubrovnik;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class TuristicObject {

    TuristicObject(String name, String PartOfTown, String description, String typeOfObject, int image, Uri geoURI){
        this.setName(name);
        this.setPartOfTown(PartOfTown);
        this.setDescription(description);
        this.setImageURL(image);
        this.setGeoURI(geoURI);
        this.setTypeOfObject(typeOfObject);
    }

    public int getImage() {
        return image;
    }

    public void setImageURL(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartOfTown() {
        return partOfTown;
    }

    public void setPartOfTown(String partOfTown) {
        this.partOfTown = partOfTown;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String shortDescription) {
        this.description = shortDescription;
    }


    public Uri getGeoURI() {
        return geoURI;
    }

    public void setGeoURI(Uri geoURI) {
        this.geoURI = geoURI;
    }


    public String getTypeOfObject() {
        return typeOfObject;
    }

    public void setTypeOfObject(String typeOfObject) {
        this.typeOfObject = typeOfObject;
    }

    @Override
    public String toString() {
        return "TuristicObject{" +
                "name='" + name + '\'' +
                ", partOfTown='" + partOfTown + '\'' +
                ", shortDescription='" + description + '\'' +
                '}';
    }

    private String name;
    private String partOfTown;
    private String description;
    private String typeOfObject;
    private int image;
    private Uri geoURI;

}
