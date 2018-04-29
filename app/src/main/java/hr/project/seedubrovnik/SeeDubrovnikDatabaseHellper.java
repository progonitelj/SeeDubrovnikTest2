package hr.project.seedubrovnik;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SeeDubrovnikDatabaseHellper  extends SQLiteOpenHelper {

    private static final String DBNAME = "SeeDubrovnik.db";
    private static final String TABLEOBJECTS = "objects";
    private static final String ATRIBUTEID = "ID";
    private static final String ATRIBUTENAME = "Name";
    private static final String ATRIBUTEPOT = "PartOfTown";
    private static final String ATRIBUTEDESC = "Description";
    private static final String ATRIBUTETYPE = "TypeOfObject";
    private static final String ATRIBUTEIMG = "Image_id";
    private static final String ATRIBUTEGEO = "GeoData";
    private static final int DBVERSION = 1;


    public SeeDubrovnikDatabaseHellper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLEOBJECTS + "("
        + ATRIBUTEID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
        + ATRIBUTENAME + "TEXT NOT NULL UNIQUE,"
        + ATRIBUTEDESC + "TEXT NOT NULL,"
        + ATRIBUTEPOT + "TEXT NOT NULL,"
        + ATRIBUTETYPE + "TEXT NOT NULL,"
        + ATRIBUTEIMG + "INT NOT NULL,"
        + ATRIBUTEGEO + "TEXT UNIQUE);");

        insertObject(db, "Minceta", "Old Town", "One of the 5 forts in Old town of Dubrovnik. From 5 forts Minceta is the biggest.", "Fort", R.drawable.miceta_icon, "geo:0,0?q=Tvrđava Minčeta,Ul. Ispod Minčete 9, 20000, Dubrovnik,g Croatia");
        insertObject(db, "Revelin", "Old Town", "One of the 5 forts in Old town of Dubrovnik located on the easr entrance to the Old town Ploce gate. Also it is Night club.", "Fort/Night club", R.drawable.revelin_icon, "geo:0,0?q=Culture club Revelin, Ul. Svetog Dominika 3, 20000, Dubrovnik, Croatia");
        insertObject(db, "Sv Ivan", "Old Town", "One of the 5 forts in Old town of Dubrovnik. Also Sv Ivan has a museum and aquarium inside of it.", "Fort/Museum", R.drawable.svivan_icon, "geo:0,0?q=Tvrđava Sv. Ivana, 20000, Dubrovnik, Croatia");
        insertObject(db, "Bokar", "Old Town", "One of the 5 forts in Old town of Dubrovnik.", "Fort", R.drawable.bokar_icon, "geo:0,0?q=Tvrđava Bokar, Od Puća 20, 20000, Dubrovnik, Croatia");
        insertObject(db, "Stradun", "Old Town", "Stradun is the main street in dubrovnik. It 350 meter long and 15 meter wide.", "Street", R.drawable.stradun_ico, "geo:0,0?q=Stradun, Croatia");
        insertObject(db, "Sv Vlaho", "Old Town", "This is one of the biggest and most famous churches in Dubrovnik. It is named after protector of Dubrovnik.", "Church", R.drawable.sv_vlaho_icon, "geo:0,0?q=Crkva svetog Vlaha,Luža ul. 2, 20000, Dubrovnik, Croatia");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertObject (SQLiteDatabase db, String name, String partOfTown, String description, String typeOfObject, int image, String geoData){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTENAME, name);
        objectValues.put(ATRIBUTEPOT, name);
        objectValues.put(ATRIBUTEDESC, name);
        objectValues.put(ATRIBUTETYPE, name);
        objectValues.put(ATRIBUTEIMG, name);
        objectValues.put(ATRIBUTEGEO, name);
        db.insert(TABLEOBJECTS, null, objectValues);
    }
}
