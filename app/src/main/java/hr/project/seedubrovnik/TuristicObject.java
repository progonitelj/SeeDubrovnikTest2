package hr.project.seedubrovnik;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class TuristicObject {

    TuristicObject(String name, String PartOfTown, String description, String typeOfObject, String imageURL, Uri geoURI){
        this.setName(name);
        this.setPartOfTown(PartOfTown);
        this.setDescription(description);
        this.setImageURL(imageURL);
        this.setGeoURI(geoURI);
        this.setTypeOfObject(typeOfObject);
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
    private String imageURL;
    private Uri geoURI;

}
