package net.shootlearnshoot.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {
	
	private Context context;

	OpenHelper(final Context context){
		super(context, DataBaseConstants.DATABASE_NAME, null, DataBaseConstants.VERSION);
		this.context = context;
	}
	
	@Override
	public void onOpen(final SQLiteDatabase db){
		// not doing anything here yet other than delegating to super
		super.onOpen(db);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		RecipeTable.onCreate(db);
		
		//ShootingStringTable.onCreate(db);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		RecipeTable.onUpgrade(db, oldVersion, newVersion);
		// ShootingStringTable.onUpgrade(db, oldVersion, newVersion);

	}

}
