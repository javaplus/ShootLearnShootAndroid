package net.shootlearnshoot.db;

import net.shootlearnshoot.db.RecipeTable.RecipeColumns;
import android.database.sqlite.SQLiteDatabase;

public final class ShootingStringTable {
	
public static final String TABLE_NAME= "shooting_string";
	
	public static class ShootingStringColumns {
		
		
		public static final String id = "_id";
		public static final String name = "name";
		public static final String recipe = "recipe_id";
		public static final String string = "string";
		public static final String weather = "weather";
		public static final String date = "date";
		public static final String notes = "notes";
		
	}
	
	public static void onCreate(SQLiteDatabase db){
		StringBuilder sb = new StringBuilder();
		
		sb.append("CREATE TABLE " + RecipeTable.TABLE_NAME + " (");
		sb.append(ShootingStringColumns.id + " INTEGER PRIMARY KEY, ");
		sb.append(ShootingStringColumns.name + " TEXT UNIQUE NOT NULL, ");
		sb.append(ShootingStringColumns.recipe + " INTEGER NOT NULL, ");
		sb.append("FOREIGN KEY(" + ShootingStringColumns.recipe + ") REFERENCES " + RecipeTable.TABLE_NAME + "(" + RecipeColumns.id + "), ");
		sb.append(ShootingStringColumns.string + " TEXT, ");
		sb.append(ShootingStringColumns.weather + " TEXT, ");
		sb.append(ShootingStringColumns.date + " INTEGER, ");
		sb.append(ShootingStringColumns.notes + " TEXT); ");
		db.execSQL(sb.toString());
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		// Not implemented yet.
	}
}
