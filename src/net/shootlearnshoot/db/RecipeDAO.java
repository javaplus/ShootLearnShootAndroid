package net.shootlearnshoot.db;

import java.util.ArrayList;
import java.util.List;

import net.shootlearnshoot.db.RecipeTable.RecipeColumns;
import net.shootlearnshoot.domain.Recipe;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class RecipeDAO {
	
	private static final String INSERT = "insert into " + RecipeTable.TABLE_NAME 
			+ "(" + RecipeColumns.name + ", " + RecipeColumns.bullet + ", " 
			+ RecipeColumns. powderName + ", " + RecipeColumns.powderAmt +", " 
			+ RecipeColumns.primer	 + ", " + RecipeColumns.notes + ")"
			+ " values(?, ?, ?, ?, ?, ?)";
	
	private SQLiteDatabase db;
	private SQLiteStatement insertStatement;
	
	public RecipeDAO(SQLiteDatabase db){
		this.db = db;
		insertStatement = db.compileStatement(INSERT);
	}
	
	public long save(Recipe recipe){
		insertStatement.clearBindings();
		insertStatement.bindString(1, recipe.getName());
		insertStatement.bindString(2, recipe.getBullet());
		insertStatement.bindString(3, recipe.getPowderName());
		insertStatement.bindString(4, recipe.getPowderAmt());
		insertStatement.bindString(5, recipe.getPrimer());
		insertStatement.bindString(6, recipe.getNotes());
		return insertStatement.executeInsert();
	}
	
	public Recipe get(long id){
		Recipe recipe = null;
		Cursor c = db.query(RecipeTable.TABLE_NAME,	new String[]{
				RecipeColumns.id, RecipeColumns.name, RecipeColumns.bullet, RecipeColumns.powderName, RecipeColumns.powderAmt, RecipeColumns.primer, RecipeColumns.notes
		}, RecipeColumns.id + " = ?", new String[]{String.valueOf(id)}, null, null, null, "1");
		if(c.moveToFirst()){
			recipe = this.buildRecipeFromCursor(c);
		}
		if(!c.isClosed()){
			c.close();
		}
		return recipe;
	}
	
	public List<Recipe> getAll(){
		List<Recipe> recipeList = new ArrayList<Recipe>();
		Cursor c = db.query(RecipeTable.TABLE_NAME,	new String[]{
				RecipeColumns.id, RecipeColumns.name, RecipeColumns.bullet, RecipeColumns.powderName, RecipeColumns.powderAmt, RecipeColumns.primer, RecipeColumns.notes
		},null, null, null, null, RecipeColumns.name, null);
		
		if(c.moveToFirst()){
			do{
				Recipe recipe = this.buildRecipeFromCursor(c);
				if(recipe!=null){
					recipeList.add(recipe);
				}
			}while(c.moveToNext());
		}
		if(!c.isClosed()){
			c.close();
		}
		return recipeList;
	}

	private Recipe buildRecipeFromCursor(Cursor c) {
		Recipe recipe = null;
		
		if(c!=null){
			recipe = new Recipe();
			recipe.setId(c.getLong(0));
			recipe.setName(c.getString(1));
			recipe.setBullet(c.getString(2));
			recipe.setPowderName(c.getString(3));
			recipe.setPowderAmt(c.getString(4));
			recipe.setPrimer(c.getString(5));
			recipe.setNotes(c.getString(6));
		}
		
		return recipe;
	}
}
