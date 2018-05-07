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
    private static final String TABLERESTAURANTS = "restaurants";
    private static final String TABLELOCATIONS = "Locations";
    private static final String ATRIBUTEID = "ID";
    private static final String ATRIBUTENAME = "Name";
    private static final String ATRIBUTELOCATIONID = "Location_id";
    private static final String ATRIBUTEDESC = "Description";
    private static final String ATRIBUTESHORTDESC = "Short_desc";
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
            + ATRIBUTESHORTDESC + " TEXT NOT NULL,"
            + ATRIBUTELOCATIONID + " TEXT,"
            + ATRIBUTETYPE + " TEXT NOT NULL,"
            + ATRIBUTEIMG + " INT NOT NULL,"
            + ATRIBUTEGEO + " TEXT);");



        //RESTAURANT CREATE TABLE
        db.execSQL("CREATE TABLE " + TABLERESTAURANTS + "("
                + ATRIBUTEID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTENAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTEDESC + " TEXT NOT NULL,"
                + ATRIBUTELOCATIONID + " TEXT,"
                + ATRIBUTETYPE + " TEXT NOT NULL,"
                + ATRIBUTEIMG + " INT NOT NULL,"
                + ATRIBUTEGEO + " TEXT);");





        Log.d(TAG, "onCreate:Tables created");


        //populate table locations
        insertNewLocation(db,"Old Town", "Aread of Dubrovnik", "The old town of Dubrovnik", R.drawable.oldtown_icon);
        insertNewLocation(db,"Lapad", "Aread of Dubrovnik","Urban Part of Dubrovnik", R.drawable.lapad_icon);
        insertNewLocation(db,"Gruz", "Aread of Dubrovnik","Urban part of dubrovnik/port", R.drawable.gruz_icon);
        //insertNewLocation(db,"Kolocep", "Island","First Elafiti island", R.drawable.kolocep);
        insertNewLocation(db,"Cavatat", "Town","Small Town close to Dubrovnik", R.drawable.cavtat_icon);
        insertNewLocation(db,"Lokrum", "Island","Small island close to Dubrovnik", R.drawable.lokrum_icon);


        cursor = getLocation_id(db, "Old Town");
        cursor.moveToNext();
        id = cursor.getInt(0);
        insertNewObject(db, "Minceta", id, "Minčeta Fortress dominates the highest north-western part of the City.", "It is a large circular tower with a massive battlement suspended by stone sup-porters.The first, smaller, quadrangular tower was constructed by Nikifor Ranjina in 1319. The Florentine architect Michelozzo Michelozzi gave the monumental present time form to the Fort, which was completed in 1464 according to the design of the renowned Renaissance builder Juraj Dalmatinac.", "Fort", R.drawable.miceta_icon, "42.642834,18.108588");
        insertNewObject(db, "Revelin", id, "Fortres of Dubrivnik Old town. These day Revelin is an exclusive night club.", "Revelin Fort was built outside the city walls and is partially included into the defence complex of the Ploče Gate. The lower part of the fort was built in 1463, in the shape the City model held by St. Blaise on the triptych painted by Nikola Božidarević around 1500. The fort protected both the eastern part of the City from mainland and the entrance to the City Harbour.\n" +
                "\n" +
                "In 1538 the fort was strengthened and enlarged in the form of an irregular square according to the instructions of Italian engineer Antonio Ferramolino of Bergamo. Revelin has three entrances, and was encompassed by the moat and sea on three sides. \n" +
                "\n" +
                "The well-known Renaissance craftsman Ivan Rabljanin kept the foundries for casting cannons and bells in the large Fort interior. Today, the spacious fort terraces serve as venues for various performances of the Dubrovnik Summer Festival.", "Fort/Night club", R.drawable.revelin_icon, "42.642094,18.112236");
        insertNewObject(db, "Sv Ivan", id, "One of the 5 forts in Old town of Dubrovnik. Also Sv Ivan has a museum and aquarium inside of it.", "The first quadrangular pier tower was constructed in 1346 in order to protect the City harbour in the south-east, and its outlines are still visible on the western wall of the present time fort. The harbour chain pulled across from the tower. The present time fort was completed in the 16th century, when the entire complex was enlarged and the outer wall extended up to the oldest tower level. The ground floor of St. Johns Fort houses the Aquarium, and the Maritime Museum is situated on the 1st and 2nd floor. One of the entrances to the walls is also situated here.", "Fort/Museum", R.drawable.svivan_icon, "Tvrđava Sv. Ivana, 20000, Dubrovnik, Croatia");
        insertNewObject(db, "Bokar", id, "One of the 5 forts in Old town of Dubrovnik.", "Walking along the seaward city wall to the west one arrives to Bokar Fort which defended the City Gate, the bridge and the moat at Pile. \n" +
                "\n" +
                "This semicircular tower with beautiful cornices was also designed by the Florentine architect Michelozzi in the 15th century.", "Fort", R.drawable.bokar_icon, "Tvrđava Bokar, Od Puća 20, 20000, Dubrovnik, Croatia");
        insertNewObject(db, "Stradun", id, "Stradun is the main street of Dubrovnik, Croatia. The limestone-paved pedestrian street runs some 300 metres through the Old Town", "Stradun is the main street of Dubrovnik, Croatia. The limestone-paved pedestrian street runs some 300 metres through the Old Town, the historic part of the city surrounded by the Walls of Dubrovnik.\n" +
                "\n" +
                "The site of the present-day street used to be a marshy channel which separated Ragusa from the forest settlement of Dubrava before it was reclaimed in the 13th century.Stradun stretches through the walled town in the east-west direction, connecting the western entrance called the \"Pile Gate\" (Vrata od Pila) to the \"Ploče Gate\" (Vrata od Ploča) on the eastern end. Both ends are also marked with 15th-century fountains (the so-called Large Onofrio's Fountain in the western section and the Small Onofrio's Fountain on the east end) and bell towers (the Dubrovnik Bell Tower to the east end and the bell tower attached to the Franciscan monastery to the west).", "Street", R.drawable.stradun_ico, "42.641389,18.108056");
        insertNewObject(db, "Sv Vlaho", id, "This is one of the biggest and most famous churches in Dubrovnik. It is named after protector of Dubrovnik.", "One of the most beautiful sacral buildings in Dubrovnik, the present-day Church of St Blaise was constructed in 1715 in the flamboyant Venetian Baroque style. It was constructed by the Venetian master Marino Gropelli in 1706, on the commission of the Dubrovnik Senate which requested a new church on the site of the old 14th century Romanesque church.\n" +
                "\n" +
                "Damaged during the earthquake for the first time, the church was destroyed completely by the devastating fire in 1706. Everything disappeared in flames, apart from the silver statue of St Blaise, which was saved by some miracle. After the years spent in exile at the Church of St Nicholas at Prijeko, the statue was returned to its old place in 1715. The people of Dubrovnik added the following inscription on the statue all other statues made of gold, silver and bronze melted in the fire, while the saints statue was miraculously undamaged. The statue is one of the most important statues in Dubrovnik, and the model of the city which the saint holds in his hand reveals the city architecture at the time. \n" +
                "\n" +
                "St Blaise has been honoured as the patron saint of Dubrovnik from the 10th century. According to the chroniclers of Dubrovnik, St Blaise saved the people of Dubrovnik in the 10th century when the Venetians anchored their ships in Gruž and in front of the Island of Lokrum. The people of Dubrovnik believed the Venetians assurances that they would leave for Levant after they supplied themselves with food and drink. The visitors used the opportunity to see the sights and observed the weaknesses in the City defence. However, St Blaise revealed their intentions to the parish priest Stojko and thus saved the City from the night attack. The priest described him as an old grey-haired man with a long beard, a bishops cap and a stick in his hand. Precisely the way his statues on the city walls and towers look like.", "Church", R.drawable.sv_vlaho_icon, "42.640683,18.11034");

        insertNewRestaurant(db, "Restoran Proljev", id, "Best restorant in dzbrovnik", "restaurant", R.drawable.stradun_ico, "google.navigation:q=Crkva svetog Vlaha,Luža ul. 2, 20000, dask, Croatia&mode=w");



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
    public void insertNewObject (SQLiteDatabase db, String name, int lication_id, String shortDesc, String description, String typeOfObject, int image, String geoData){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTENAME, name);
        objectValues.put(ATRIBUTELOCATIONID, lication_id);
        objectValues.put(ATRIBUTESHORTDESC, shortDesc);
        objectValues.put(ATRIBUTEDESC, description);
        objectValues.put(ATRIBUTETYPE, typeOfObject);
        objectValues.put(ATRIBUTEIMG, image);
        objectValues.put(ATRIBUTEGEO, geoData);
        db.insert(TABLEOBJECTS, null, objectValues);
    }

    public void insertNewRestaurant (SQLiteDatabase db, String name, int lication_id, String description, String typeOfObject, int image, String geoData){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTENAME, name);
        objectValues.put(ATRIBUTELOCATIONID, lication_id);
        objectValues.put(ATRIBUTEDESC, description);
        objectValues.put(ATRIBUTETYPE, typeOfObject);
        objectValues.put(ATRIBUTEIMG, image);
        objectValues.put(ATRIBUTEGEO, geoData);
        db.insert(TABLERESTAURANTS, null, objectValues);
    }

    //gets all location id-s where names is 'name'
    public Cursor getLocation_id(SQLiteDatabase db, String name){
        Cursor cur = db.rawQuery("SELECT " + ATRIBUTEID + " FROM " + TABLELOCATIONS + " WHERE " + ATRIBUTENAME + " = '" + name + "' ;", null);
        return cur;
    }


    public Cursor getObjects (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLEOBJECTS + " ;", null);
        return cursor;
    }


    public Cursor getLocations (){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLELOCATIONS + " ;";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }


    public Cursor getObjectsByName (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT o.Name, o.Short_desc, o.Description, o.TypeOfObject, o.Image_id, o.geoData FROM Objects o JOIN Locations l ON l.ID = o.Location_id WHERE l.Name = '" + name +"';", null);
        return cursor;
    }

    public Cursor getObjectsByType (String type){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT Name, Description, TypeOfObject, Image_id, geoData FROM Objects  WHERE TypeOfObject = '" + type +"';", null);
        return cursor;
    }
    public Cursor getObjectsByTable (String table){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT Name, Description, TypeOfObject, Image_id, geoData FROM '" + table +"';", null);
        return cursor;
    }
}

