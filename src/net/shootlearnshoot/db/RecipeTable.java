package net.shootlearnshoot.db;

import android.database.sqlite.SQLiteDatabase;

public final class RecipeTable {
	
	public static final String TABLE_NAME= "recipe";
	
	public static class RecipeColumns {
		
		public static final String id = "_id";
		public static final String name = "name";
		public static final String bullet = "bullet";
		public static final String powderName = "powderName";
		public static final String powderAmt = "powderAmt";
		public static final String primer = "primer";
		public static final String notes = "notes";
		
	}
	
	public static void onCreate(SQLiteDatabase db){
		StringBuilder sb = new StringBuilder();
		
		sb.append("CREATE TABLE " + RecipeTable.TABLE_NAME + " (");
		sb.append(RecipeColumns.id + " INTEGER PRIMARY KEY, ");
		sb.append(RecipeColumns.name + " TEXT UNIQUE NOT NULL, ");
		sb.append(RecipeColumns.bullet + " TEXT, ");
		sb.append(RecipeColumns.powderName + " TEXT, ");
		sb.append(RecipeColumns.powderAmt + " TEXT, ");
		sb.append(RecipeColumns.primer + " TEXT, ");
		sb.append(RecipeColumns.notes + " TEXT); ");
		db.execSQL(sb.toString());
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		// Not implemented yet.
		
	}
	

}
