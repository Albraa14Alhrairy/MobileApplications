package DatabaseHandler;

import static Utils.TaskUtils.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;



public class Handler extends SQLiteOpenHelper {
    public Handler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TASKS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                ID_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME_KEY + " TEXT NOT NULL, " +
                "Description" + " TEXT NOT NULL, " +
                START_TIME_KEY + " TEXT NOT NULL, " +
                End_TIME_KEY + " TEXT NOT NULL );";
        db.execSQL(CREATE_TASKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertTask(String name, String desc, String start, String end) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_KEY, name);
        values.put(DESCRIPTION_KEY, desc);
        values.put(START_TIME_KEY, start);
        values.put(End_TIME_KEY, end);

        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public long updateTask(int id, String desc, String start, String end) {
        SQLiteDatabase db = this.getWritableDatabase();

        String whe = ID_KEY + " =? ";
        String [] wheArgs = {String.valueOf(id)};

        ContentValues values = new ContentValues();
        values.put(DESCRIPTION_KEY, desc);
        values.put(START_TIME_KEY, start);
        values.put(End_TIME_KEY, end);

        long done = db.update(TABLE_NAME,  values, whe, wheArgs);
        db.close();
        return done;
    }

    public long deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String whe = ID_KEY + " =? ";
        String [] wheArgs = {String.valueOf(id)};

        long done = db.delete(TABLE_NAME, whe, wheArgs);
        db.close();
        return done;
    }

    public List<Tasks> showAllTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Tasks> tasks = new ArrayList<>();

        String [] sel = {ID_KEY, NAME_KEY, DESCRIPTION_KEY, START_TIME_KEY, End_TIME_KEY};
        Cursor cursor = db.query(TABLE_NAME, sel, null, null, null, null, null);

        while(cursor.moveToNext()) {
            int i = cursor.getInt(cursor.getColumnIndexOrThrow(ID_KEY));
            String n = cursor.getString(cursor.getColumnIndexOrThrow(NAME_KEY));
            String d = cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION_KEY));
            String s = cursor.getString(cursor.getColumnIndexOrThrow(START_TIME_KEY));
            String e = cursor.getString(cursor.getColumnIndexOrThrow(End_TIME_KEY));
            tasks.add(new Tasks(n, d, s, e, i));
        }

        db.close();
        return tasks;
    }

    public String [] showTask(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String [] info = new String[5];

        String proj = ID_KEY + " =? ";
        String [] projArgs = {String.valueOf(id)};
        String [] sel = {ID_KEY, NAME_KEY, DESCRIPTION_KEY, START_TIME_KEY, End_TIME_KEY};
        Cursor cursor = db.query(TABLE_NAME, sel, proj, projArgs, null, null, null);

        if(cursor.moveToNext()) {
            info[0] = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(ID_KEY)));
            info[1]  = cursor.getString(cursor.getColumnIndexOrThrow(NAME_KEY));
            info[2]  = cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION_KEY));
            info[3]  = cursor.getString(cursor.getColumnIndexOrThrow(START_TIME_KEY));
            info[4]  = cursor.getString(cursor.getColumnIndexOrThrow(End_TIME_KEY));
        }

        db.close();
        return info;
    }

    public long deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();

        long done = db.delete(TABLE_NAME, null, null);
        db.close();
        return done;
    }
}
