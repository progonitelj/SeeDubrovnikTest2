package hr.project.seedubrovnik;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


class SeeDubrovnikDatabaseHellper  extends SQLiteOpenHelper {

    private static final String TAG = "SeeDubrovnikDatabaseHel";

    private static final String DB_NAME = "SeeDubrovnik.db";
    private static final String TABLE_EMERGENCIES= "Emergencies";
    private static final String TABLE_FOOD = "Food";
    private static final String TABLE_DRINKS = "Drinks";
    private static final String TABLE_BEACHES = "Beaches";
    private static final String TABLE_TRANSPORT = "Transport";
    private static final String TABLE_ATRACTIONS = "Atractions";
    private static final String ATRIBUTE_ID = "ID";
    private static final String ATRIBUTE_NAME = "Name";
    private static final String ATRIBUTE_TYPE = "Type";
    private static final String ATRIBUTE_SHORT_DESC = "Short_desc";
    private static final String ATRIBUTE_DESC = "Description";
    private static final String ATRIBUTE_POT = "POT";
    private static final String ATRIBUTE_IMG = "Image_id";
    private static final String ATRIBUTE_GEO = "GeoData";
    private static final String ATRIBUTE_LINK_1 = "Link_1";
    private static final String ATRIBUTE_LINK_2 = "Link_2";
    private static final String ATRIBUTE_PHONE = "Phone";
    private static final String ATRIBUTE_MAIL = "Mail";
    private static final int DBVERSION = 1;


    SeeDubrovnikDatabaseHellper(Context context) {
        super(context, DB_NAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        int id;
        Cursor cursor;

        //enable SQLite foreign keys
        db.execSQL("PRAGMA foreign_keys = ON;");


        //CREATE TABLE EMERGENCIES
        db.execSQL("CREATE TABLE " + TABLE_EMERGENCIES + "("
                + ATRIBUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTE_NAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTE_TYPE + " TEXT NOT NULL,"
                + ATRIBUTE_SHORT_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_POT + " TEXT NOT NULL,"
                + ATRIBUTE_IMG + " INT NOT NULL,"
                + ATRIBUTE_GEO + " TEXT NOT NULL );");


        //CREATE TABLE FOOD
        db.execSQL("CREATE TABLE " + TABLE_FOOD + "("
                + ATRIBUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTE_NAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTE_TYPE + " TEXT NOT NULL,"
                + ATRIBUTE_SHORT_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_POT + " TEXT NOT NULL,"
                + ATRIBUTE_IMG + " INT NOT NULL,"
                + ATRIBUTE_GEO + " TEXT NOT NULL,"
                + ATRIBUTE_LINK_1 + " TEXT,"
                + ATRIBUTE_LINK_2 + " TEXT,"
                + ATRIBUTE_PHONE + " TEXT,"
                + ATRIBUTE_MAIL + " TEXT);");



        //CREATE TABLE DRINKS
        db.execSQL("CREATE TABLE " + TABLE_DRINKS + "("
                + ATRIBUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTE_NAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTE_TYPE + " TEXT NOT NULL,"
                + ATRIBUTE_SHORT_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_POT + " TEXT NOT NULL,"
                + ATRIBUTE_IMG + " INT NOT NULL,"
                + ATRIBUTE_GEO + " TEXT NOT NULL,"
                + ATRIBUTE_LINK_1 + " TEXT,"
                + ATRIBUTE_LINK_2 + " TEXT,"
                + ATRIBUTE_PHONE + " TEXT,"
                + ATRIBUTE_MAIL + " TEXT);");


        //CREATE TABLE BEACHES
        db.execSQL("CREATE TABLE " + TABLE_BEACHES + "("
                + ATRIBUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTE_NAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTE_SHORT_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_POT + " TEXT NOT NULL,"
                + ATRIBUTE_IMG + " INT NOT NULL,"
                + ATRIBUTE_GEO + " TEXT NOT NULL );");


        //CREATE TABLE TRANSPORT
        db.execSQL("CREATE TABLE " + TABLE_TRANSPORT + "("
                + ATRIBUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTE_NAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTE_TYPE + " TEXT NOT NULL,"
                + ATRIBUTE_SHORT_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_POT + " TEXT NOT NULL,"
                + ATRIBUTE_IMG + " INT NOT NULL,"
                + ATRIBUTE_GEO + " TEXT NOT NULL,"
                + ATRIBUTE_LINK_1 + " TEXT,"
                + ATRIBUTE_LINK_2 + " TEXT,"
                + ATRIBUTE_PHONE + " TEXT,"
                + ATRIBUTE_MAIL + " TEXT);");



        //CREATE TABLE ATRACTIONS
        db.execSQL("CREATE TABLE " + TABLE_ATRACTIONS + "("
                + ATRIBUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ATRIBUTE_NAME + " TEXT NOT NULL UNIQUE,"
                + ATRIBUTE_TYPE + " TEXT NOT NULL,"
                + ATRIBUTE_SHORT_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_DESC + " TEXT NOT NULL,"
                + ATRIBUTE_POT + " TEXT NOT NULL,"
                + ATRIBUTE_IMG + " INT NOT NULL,"
                + ATRIBUTE_GEO + " TEXT NOT NULL,"
                + ATRIBUTE_LINK_1 + " TEXT,"
                + ATRIBUTE_LINK_2 + " TEXT );");





        Log.d(TAG, "onCreate:Tables created");



        insertNewAtraction(db, "Minceta", "Monument", "Minčeta Fortress dominates the highest north-western part of the City.", "It is a large circular tower with a massive battlement suspended by stone sup-porters.The first, smaller, quadrangular tower was constructed by Nikifor Ranjina in 1319. The Florentine architect Michelozzo Michelozzi gave the monumental present time form to the Fort, which was completed in 1464 according to the design of the renowned Renaissance builder Juraj Dalmatinac.", "Old Town", R.drawable.miceta_icon, "42.642834,18.108588","https://hr.wikipedia.org/wiki/Min%C4%8Deta", "http://www.tzdubrovnik.hr/get/spomenici/5315/tvrdava_minceta.html");
        insertNewAtraction(db, "Revelin", "Monument", "Fortres of Dubrivnik Old town. These day Revelin is an exclusive night club.", "Revelin Fort was built outside the city walls and is partially included into the defence complex of the Ploče Gate. The lower part of the fort was built in 1463, in the shape the City model held by St. Blaise on the triptych painted by Nikola Božidarević around 1500. The fort protected both the eastern part of the City from mainland and the entrance to the City Harbour.\n" +
                "\n" +
                "In 1538 the fort was strengthened and enlarged in the form of an irregular square according to the instructions of Italian engineer Antonio Ferramolino of Bergamo. Revelin has three entrances, and was encompassed by the moat and sea on three sides. \n" +
                "\n" +
                "The well-known Renaissance craftsman Ivan Rabljanin kept the foundries for casting cannons and bells in the large Fort interior. Today, the spacious fort terraces serve as venues for various performances of the Dubrovnik Summer Festival.", "Old Town", R.drawable.revelin_icon, "42.642094,18.112236", "https://hr.wikipedia.org/wiki/Tvr%C4%91ava_Revelin", "http://www.tzdubrovnik.hr/get/spomenici/5351/tvrdava_revelin.html");
        insertNewAtraction(db, "Sv Ivan", "Monument", "One of the 5 forts in Old town of Dubrovnik. Also Sv Ivan has a museum and aquarium inside of it.", "The first quadrangular pier tower was constructed in 1346 in order to protect the City harbour in the south-east, and its outlines are still visible on the western wall of the present time fort. The harbour chain pulled across from the tower. The present time fort was completed in the 16th century, when the entire complex was enlarged and the outer wall extended up to the oldest tower level. The ground floor of St. Johns Fort houses the Aquarium, and the Maritime Museum is situated on the 1st and 2nd floor. One of the entrances to the walls is also situated here.", "OldTown", R.drawable.svivan_icon, "Tvrđava Sv. Ivana, 20000, Dubrovnik, Croatia", "https://hr.wikipedia.org/wiki/Tvr%C4%91ava_Sv._Ivan_u_Dubrovniku", "http://www.tzdubrovnik.hr/get/spomenici/5324/tvrdava_sv_ivana.html");
        insertNewAtraction(db, "Bokar", "Monument", "One of the 5 forts in Old town of Dubrovnik.", "Walking along the seaward city wall to the west one arrives to Bokar Fort which defended the City Gate, the bridge and the moat at Pile. \n" +
                "\n" +
                "This semicircular tower with beautiful cornices was also designed by the Florentine architect Michelozzi in the 15th century.", "Old Town", R.drawable.bokar_icon, "Tvrđava Bokar, Od Puća 20, 20000, Dubrovnik, Croatia", "https://hr.wikipedia.org/wiki/Bokar", null);
        insertNewAtraction(db, "Stradun", "Monument", "Stradun is the main street of Dubrovnik, Croatia. The limestone-paved pedestrian street runs some 300 metres through the Old Town", "Stradun is the main street of Dubrovnik, Croatia. The limestone-paved pedestrian street runs some 300 metres through the Old Town, the historic part of the city surrounded by the Walls of Dubrovnik.\n" +
                "\n" +
                "The site of the present-day street used to be a marshy channel which separated Ragusa from the forest settlement of Dubrava before it was reclaimed in the 13th century.Stradun stretches through the walled town in the east-west direction, connecting the western entrance called the \"Pile Gate\" (Vrata od Pila) to the \"Ploče Gate\" (Vrata od Ploča) on the eastern end. Both ends are also marked with 15th-century fountains (the so-called Large Onofrio's Fountain in the western section and the Small Onofrio's Fountain on the east end) and bell towers (the Dubrovnik Bell Tower to the east end and the bell tower attached to the Franciscan monastery to the west).", "Old Town", R.drawable.stradun_ico, "42.641389,18.108056", "https://hr.wikipedia.org/wiki/Stradun", "http://www.tzdubrovnik.hr/lang/en/get/spomenici/5333/bokar_fort.html");
        /*insertNewObject(db, "Sv Vlaho", id, "This is one of the biggest and most famous churches in Dubrovnik. It is named after protector of Dubrovnik.", "One of the most beautiful sacral buildings in Dubrovnik, the present-day Church of St Blaise was constructed in 1715 in the flamboyant Venetian Baroque style. It was constructed by the Venetian master Marino Gropelli in 1706, on the commission of the Dubrovnik Senate which requested a new church on the site of the old 14th century Romanesque church.\n" +
                "\n" +
                "Damaged during the earthquake for the first time, the church was destroyed completely by the devastating fire in 1706. Everything disappeared in flames, apart from the silver statue of St Blaise, which was saved by some miracle. After the years spent in exile at the Church of St Nicholas at Prijeko, the statue was returned to its old place in 1715. The people of Dubrovnik added the following inscription on the statue all other statues made of gold, silver and bronze melted in the fire, while the saints statue was miraculously undamaged. The statue is one of the most important statues in Dubrovnik, and the model of the city which the saint holds in his hand reveals the city architecture at the time. \n" +
                "\n" +
                "St Blaise has been honoured as the patron saint of Dubrovnik from the 10th century. According to the chroniclers of Dubrovnik, St Blaise saved the people of Dubrovnik in the 10th century when the Venetians anchored their ships in Gruž and in front of the Island of Lokrum. The people of Dubrovnik believed the Venetians assurances that they would leave for Levant after they supplied themselves with food and drink. The visitors used the opportunity to see the sights and observed the weaknesses in the City defence. However, St Blaise revealed their intentions to the parish priest Stojko and thus saved the City from the night attack. The priest described him as an old grey-haired man with a long beard, a bishops cap and a stick in his hand. Precisely the way his statues on the city walls and towers look like.", "Church", R.drawable.sv_vlaho_icon, "42.640683,18.11034");*/

        //insertNewFood(db, "Restoran Letva", id,"dasdasdasd" ,"Best restorant in dzbrovnik", "restaurant", R.drawable.stradun_ico, "google.navigation:q=Crkva svetog Vlaha,Luža ul. 2, 20000, dask, Croatia&mode=w");
        //insertNewRestaurant(db, "Restoran bronson", id,"dasdasdasd" ,"Best restorant in dzbrovnik", "restaurant", R.drawable.bokar_icon, "google.navigation:q=Crkva svetog Vlaha,Luža ul. 2, 20000, dask, Croatia&mode=w");
        //insertNewRestaurant(db, "Restoran halson", id,"dasdasdasd" ,"Best restorant in dzbrovnik", "restaurant", R.drawable.buza_icon, "google.navigation:q=Crkva svetog Vlaha,Luža ul. 2, 20000, dask, Croatia&mode=w");
        //insertNewRestaurant(db, "Restoran Mali Rus", id,"dasdasdasd" ,"Best restorant in dzbrovnik", "restaurant", R.drawable.buza_icon, "google.navigation:q=Crkva svetog Vlaha,Luža ul. 2, 20000, dask, Croatia&mode=w");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMERGENCIES + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRINKS + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BEACHES + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSPORT + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATRACTIONS + ";");
        onCreate(db);


    }

    //INSERT NEW ITEM IN TABLE EMERGENCIES
    public void insertNewEmergencies (SQLiteDatabase db, String name, String type, String shortDesc, String description, String pot, int image, String geoData){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTE_NAME, name);
        objectValues.put(ATRIBUTE_TYPE, type);
        objectValues.put(ATRIBUTE_SHORT_DESC, shortDesc);
        objectValues.put(ATRIBUTE_DESC, description);
        objectValues.put(ATRIBUTE_POT, pot);
        objectValues.put(ATRIBUTE_IMG, image);
        objectValues.put(ATRIBUTE_GEO, geoData);
        db.insert(TABLE_EMERGENCIES, null, objectValues);
    }


    //INSERT NEW ITEM IN TABLE FOOD
    public void insertNewFood (SQLiteDatabase db, String name, String type, String shortDesc, String description, String pot, int image, String geoData, String link1, String link2, String phone, String email){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTE_NAME, name);
        objectValues.put(ATRIBUTE_TYPE, type);
        objectValues.put(ATRIBUTE_SHORT_DESC, shortDesc);
        objectValues.put(ATRIBUTE_DESC, description);
        objectValues.put(ATRIBUTE_POT, pot);
        objectValues.put(ATRIBUTE_IMG, image);
        objectValues.put(ATRIBUTE_GEO, geoData);
        objectValues.put(ATRIBUTE_LINK_1, link1);
        objectValues.put(ATRIBUTE_LINK_2, link2);
        objectValues.put(ATRIBUTE_PHONE, phone);
        objectValues.put(ATRIBUTE_MAIL, email);
        db.insert(TABLE_FOOD, null, objectValues);
    }

    //INSERT NEW ITEM IN TABLE DRINKS
    public void insertNewDrink (SQLiteDatabase db, String name, String type, String shortDesc, String description, String pot, int image, String geoData, String link1, String link2, String phone, String email){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTE_NAME, name);
        objectValues.put(ATRIBUTE_TYPE, type);
        objectValues.put(ATRIBUTE_SHORT_DESC, shortDesc);
        objectValues.put(ATRIBUTE_DESC, description);
        objectValues.put(ATRIBUTE_POT, pot);
        objectValues.put(ATRIBUTE_IMG, image);
        objectValues.put(ATRIBUTE_GEO, geoData);
        objectValues.put(ATRIBUTE_LINK_1, link1);
        objectValues.put(ATRIBUTE_LINK_2, link2);
        objectValues.put(ATRIBUTE_PHONE, phone);
        objectValues.put(ATRIBUTE_MAIL, email);
        db.insert(TABLE_DRINKS, null, objectValues);
    }



    //INSERT NEW ITEM IN TABLE BEACHES
    public void insertNewBeach (SQLiteDatabase db, String name, String shortDesc, String description, String pot, int image, String geoData){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTE_NAME, name);
        objectValues.put(ATRIBUTE_SHORT_DESC, shortDesc);
        objectValues.put(ATRIBUTE_DESC, description);
        objectValues.put(ATRIBUTE_POT, pot);
        objectValues.put(ATRIBUTE_IMG, image);
        objectValues.put(ATRIBUTE_GEO, geoData);
        db.insert(TABLE_BEACHES, null, objectValues);
    }

    //INSERT NEW ITEM IN TABLE TRANSPORT
    public void insertNewTransport (SQLiteDatabase db, String name, String type, String shortDesc, String description, String pot, int image, String geoData, String link1, String link2, String phone, String email){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTE_NAME, name);
        objectValues.put(ATRIBUTE_TYPE, type);
        objectValues.put(ATRIBUTE_SHORT_DESC, shortDesc);
        objectValues.put(ATRIBUTE_DESC, description);
        objectValues.put(ATRIBUTE_POT, pot);
        objectValues.put(ATRIBUTE_IMG, image);
        objectValues.put(ATRIBUTE_GEO, geoData);
        objectValues.put(ATRIBUTE_LINK_1, link1);
        objectValues.put(ATRIBUTE_LINK_2, link2);
        objectValues.put(ATRIBUTE_PHONE, phone);
        objectValues.put(ATRIBUTE_MAIL, email);
        db.insert(TABLE_TRANSPORT, null, objectValues);
    }

    //INSERT NEW ITEM IN TABLE DRINKS
    public void insertNewAtraction (SQLiteDatabase db, String name, String type, String shortDesc, String description, String pot, int image, String geoData, String link1, String link2){
        ContentValues objectValues = new ContentValues();
        objectValues.put(ATRIBUTE_NAME, name);
        objectValues.put(ATRIBUTE_TYPE, type);
        objectValues.put(ATRIBUTE_SHORT_DESC, shortDesc);
        objectValues.put(ATRIBUTE_DESC, description);
        objectValues.put(ATRIBUTE_POT, pot);
        objectValues.put(ATRIBUTE_IMG, image);
        objectValues.put(ATRIBUTE_GEO, geoData);
        objectValues.put(ATRIBUTE_LINK_1, link1);
        objectValues.put(ATRIBUTE_LINK_2, link2);
        db.insert(TABLE_ATRACTIONS, null, objectValues);
    }




    public Cursor getAllFromTable (String tableName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName  + " ;", null);
        return cursor;
    }


}

