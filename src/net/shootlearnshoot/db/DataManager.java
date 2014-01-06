package net.shootlearnshoot.db;

import java.util.List;

import net.shootlearnshoot.Constants;
import net.shootlearnshoot.domain.Recipe;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {

	
	private Context context;
	private SQLiteDatabase db;
	
	private RecipeDAO recipeDAO;
	
	public DataManager(Context context){
		this.context = context;
		SQLiteOpenHelper openHelper = new OpenHelper(context);
		db = openHelper.getWritableDatabase();
		
		recipeDAO = new RecipeDAO(db);
		
	}


	public Recipe getRecipe(long id){
		Recipe recipe = recipeDAO.get(id);

		return recipe;
	}
	
	public long saveRecipe(Recipe recipe){
		long recipeID = 0L;
		
		try{
			recipeID = recipeDAO.save(recipe);
		}catch(Exception e){
			Log.e(Constants.LOG_TAG, "Error saving recipe with name ("+ recipe.getName() + ")");
		}
		return recipeID;
	}
	
	public List<Recipe> getAllRecipes(){
		return recipeDAO.getAll();
	}
	
	
}
