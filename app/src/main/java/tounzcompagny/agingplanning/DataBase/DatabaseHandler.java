package tounzcompagny.agingplanning.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tounzcompagny.agingplanning.Objects.Study;


public class DatabaseHandler extends SQLiteOpenHelper {
    public static final int DATABASEVERSION = 1;
    public static final String DATABASENAME = "studyDataBase";
    public static final String TABLESTUDY = "study";
    public static final String DROP_TABLESTUDY = "DROP TABLE IF EXISTS " + TABLESTUDY + ";";

    // Study columns name
    public static final String KEY_ID = "id";
    public static final String KEY_NSTUDY = "nStudy";
    public static final String KEY_CUSTOMER = "customer";
    public static final String KEY_NBSAMPLE = "nbSample";
    public static final String KEY_DATESTART = "dateStart";
    public static final String KEY_NBDAYSTART = "nbDayStart";
    public static final String KEY_NBDAYEND = "nbDayEnd";
    public static final String KEY_DATEEND = "dateEnd";
    public static final String KEY_CHAMBER = "chamber";
    public static final String KEY_TEST = "test";
    public static final String KEY_STATE = "state";

    // for Create table

    public static final String CREATE_STUDY_TABLE =
            "CREATE TABLE " + TABLESTUDY + " ("
                    + KEY_ID + " INTEGER, "
                    + KEY_NSTUDY + " TEXT, "
                    + KEY_CUSTOMER + " TEXT, "
                    + KEY_NBSAMPLE + " INTEGER, "
                    + KEY_DATESTART + " TEXT, "
                    + KEY_NBDAYSTART + " INTEGER, "
                    + KEY_NBDAYEND + " INTEGER, "
                    + KEY_DATEEND + " TEXT, "
                    + KEY_CHAMBER + " INTEGER, "
                    + KEY_TEST + " TEXT, "
                    + KEY_STATE + " TEXT"
                    + ");";


    public DatabaseHandler(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_STUDY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        // drop old version if existed
        database.execSQL(DROP_TABLESTUDY);
        // Load new version
        onCreate(database);
    }

    // Add new study in database

    public void addStudy(Study study) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NSTUDY, study.getnStudy());
        values.put(KEY_CUSTOMER, study.getCustomer());
        values.put(KEY_NBSAMPLE, study.getNbSample());
        values.put(KEY_DATESTART, study.getDateStart().toString());
        values.put(KEY_NBDAYSTART, study.getNbDayStart());
        values.put(KEY_NBDAYEND, study.getNbDayEnd());
        values.put(KEY_DATEEND, study.getDateEnd().toString());
        values.put(KEY_CHAMBER, study.getChamber());
        values.put(KEY_TEST, study.getTest());
        values.put(KEY_STATE, study.getState().toString());

        database.insert(TABLESTUDY, null, values);
        database.close();

    }

    // read all data in database

    public Cursor readAll() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursorOnAll = database.rawQuery("SELECT * from " + TABLESTUDY, null);
        return cursorOnAll;
    }

    public void deleteStudy(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLESTUDY, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        database.close();
    }

    public int getCountData() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = readAll();
        return cursor.getCount();
    }

    public void deleteAllData() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursorOnAll = database.rawQuery("SELECT * from " + TABLESTUDY, null);
        cursorOnAll.moveToFirst();
        int start = cursorOnAll.getInt(0);
        cursorOnAll.moveToLast();
        int end = cursorOnAll.getInt(0);
        cursorOnAll.close();
        for (int i = start; i <= end; i++) {
            database.delete(TABLESTUDY, KEY_ID + " = ?", new String[]{String.valueOf(i)});
        }
    }
}
