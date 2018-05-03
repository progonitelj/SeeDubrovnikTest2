package hr.project.seedubrovnik;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


class SeeDubrovnikDatabaseHellper  extends SQLiteOpenHelper {

    private static final String TAG = "SeeDubrovnikDatabaseHel";

    private static final String DBNAME = "SeeDubrovnik.db";
    private static final String TABLEOBJECTS = "objects";
    private static final String TABLELOCATIONS = "Locations";
    private static final String ATRIBUTEID = "ID";
    private static final String ATRIBUTENAME = "Name";
    private static final String ATRIBUTELOCATIONID = "Location_id";
    private static final String ATRIBUTEDESC = "Description";
    private static final String ATRIBUTETYPE = "TypeOfObject";
    private static final String ATRIBUTEIMG = "Image_id";
    private static final String ATRIBUTEGEO = "GeoData";
    private static final int DBVERSION = 1;


    SeeDubrovnikDatabaseHellper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        int id;
        Cursor cursor;

        //enable SQLite foreign keys
        db.execSQL("PRAGMA foreign_keys = ON;");


        //create table locations
        db.execSQL("CREATE TABLE " + TABLELOCATIONS + "("
                + ATRIBUTEID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTENAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTEDESC + " TEXT NOT NULL,"
                + ATRIBUTETYPE + " TEXT NOT NULL,"
                + ATRIBUTEIMG + " INT NOT NULL,"
                + " FOREIGN KEY (" + ATRIBUTEID +") REFERENCES " + TABLEOBJECTS + "(" + ATRIBUTEID + "));" );


        // create table objects
        db.execSQL("CREATE TABLE " + TABLEOBJECTS + "("
            + ATRIBUTEID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ATRIBUTENAME + " TEXT NOT NULL UNIQUE,"
            + ATRIBUTEDESC + " TEXT NOT NULL,"
            + ATRIBUTELOCATIONID + " TEXT,"
            + ATRIBUTETYPE + " TEXT NOT NULL,"
            + ATRIBUTEIMG + " INT NOT NULL,"
            + ATRIBUTEGEO + " TEXT UNIQUE);");


        Log.d(TAG, "onCreate:Tables created");


        //populate table locations
        insertNewLocation(db,"Old Town", "Aread of Dubrovnik", "The old town of Dubrovnik", R.drawable.oldtown_icon);
        insertNewLocation(db,"Lapad", "Aread of Dubrovnik","Urban Part of Dubrovnik", R.drawable.lapad_icon);
        insertNewLocation(db,"Gruz", "Aread of Dubrovnik","Urban part of dubrovnik/port", R.drawable.gruz_icon);
        insertNewLocation(db,"Kolocep", "Island","First Elafiti island", R.drawable.kolocep);
        insertNewLocation(db,"Cavatat", "Town","Small Town close to Dubrovnik", R.drawable.cavtat_icon);
        insertNewLocation(db,"Lokrum", "Island","Small island close to Dubrovnik", R.drawable.lokrum_icon);


        cursor = getLocation_id(db, "Old Town");
        cursor.moveToNext();
        id = cursor.getInt(0);
        insertNewObject(db, "Minceta", id, "One of the 5 forts in Old town of Dubrovnik. From 5 forts Minceta is the biggest.", "Fort", R.drawable.miceta_icon, "geo:0,0?q=Tvrđava Minčeta,Ul. Ispod Minčete 9, 20000, Dubrovnik,g Croatia");
        insertNewObject(db, "Revelin", id, "One of the 5 forts in Old town of Dubrovnik located on the easr entrance to the Old town Ploce gate. Also it is Night club.", "Fort/Night club", R.drawable.revelin_icon, "geo:0,0?q=Culture club Revelin, Ul. Svetog Dominika 3, 20000, Dubrovnik, Croatia");
        insertNewObject(db, "Sv Ivan", id, "One of the 5 forts in Old town of Dubrovnik. Also Sv Ivan has a museum and aquarium inside of it.", "Fort/Museum", R.drawable.svivan_icon, "geo:0,0?q=Tvrđava Sv. Ivana, 20000, Dubrovnik, Croatia");
        insertNewObject(db, "Bokar", id, "One of the 5 forts in Old town of Dubrovnik.", "Fort", R.drawable.bokar_icon, "geo:0,0?q=Tvrđava Bokar, Od Puća 20, 20000, Dubrovnik, Croatia");
        insertNewObject(db, "Stradun", id, "Stradun is the main street in dubrovnik. It 350 meter long and 15 meter wide.", "Street", R.drawable.stradun_ico, "geo:0,0?q=Stradun, Croatia");
        insertNewObject(db, "Sv Vlaho", id, "This is one of the biggest and most famous churches in Dubrovnik. It is named after protector of Dubrovnik.", "Church", R.drawable.sv_vlaho_icon, "geo:0,0?q=Crkva svetog Vlaha,Luža ul. 2, 20000, Dubrovnik, Croatia");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLEOBJECTS + ";");
        onCreate(db);


    }

    //insert new location into table locations
    public void insertNewLocation(SQLiteDatabase db, String name, String type, String description, int img){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTENAME, name);
        objectValues.put(ATRIBUTEDESC, description);
        objectValues.put(ATRIBUTETYPE, type);
        objectValues.put(ATRIBUTEIMG, img);
        long res = db.insert(TABLELOCATIONS, null, objectValues);

    }


    //insert new object into table objects
    public void insertNewObject (SQLiteDatabase db, String name, int lication_id, String description, String typeOfObject, int image, String geoData){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTENAME, name);
        objectValues.put(ATRIBUTELOCATIONID, lication_id);
        objectValues.put(ATRIBUTEDESC, description);
        objectValues.put(ATRIBUTETYPE, typeOfObject);
        objectValues.put(ATRIBUTEIMG, image);
        objectValues.put(ATRIBUTEGEO, geoData);
        db.insert(TABLEOBJECTS, null, objectValues);
    }

    //gets all location id-s where names is 'name'
    public Cursor getLocation_id(SQLiteDatabase db, String name){
        Cursor cur = db.rawQuery("SELECT " + ATRIBUTEID + " FROM " + TABLELOCATIONS + " WHERE " + ATRIBUTENAME + " = '" + name + "' ;", null);
        return cur;
    }

    //Returns a cursor object with all turistic objects
    public Cursor getObjects (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLEOBJECTS + " ;", null);
        return cursor;
    }

    //Returns a cursor object with all turistic areas
    public Cursor getLocations (){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLELOCATIONS + " ;";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    //Returns a cursor object with all turistic objects with name 'name'
    public Cursor getObjectsOf (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT o.Name, o.Description, o.TypeOfObject, o.Image_id, o.geoData FROM Objects o JOIN Locations l ON l.ID = o.Location_id WHERE l.Name = '" + name +"';", null);
        return cursor;
    }
}

