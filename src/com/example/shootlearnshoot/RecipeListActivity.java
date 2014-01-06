package com.example.shootlearnshoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.shootlearnshoot.Constants;
import net.shootlearnshoot.RecipeAdapter;
import net.shootlearnshoot.db.DataManager;
import net.shootlearnshoot.domain.Recipe;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecipeListActivity extends ListActivity  {

	// dataManager to get Recipes
	private DataManager dataManger = null;
		
	// The adapter that backs our list data.
	private RecipeAdapter recipeAdapter;
	
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dataManger = new DataManager(getBaseContext());
		ListView listView = getListView();

		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	    
	    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	      @Override
	      public void onItemClick(AdapterView<?> parent, final View view,
	          int position, long id) {
	    	  System.err.print("Stop touching me!");
	        // final String item = (String) parent.getItemAtPosition(position);
//	        view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
//	              @Override
//	              public void run() {
//	                list.remove(item);
//	                adapter.notifyDataSetChanged();
//	                view.setAlpha(1);
//	              }
//	            });
	      }

	    });
	  }
	
	@Override
	/**
	 * Called anytime our window is displayed including being brought 
	 *  back up(like after going to home) and then launching app again.
	 * 
	 */
	protected void onResume() {
		Log.i(Constants.LOG_TAG, "Calling onResume");
		super.onResume();
		
		//  let's load our recipes
		List<Recipe> recipeList = dataManger.getAllRecipes();

		
		this.recipeAdapter = new RecipeAdapter(this, recipeList); 
		setListAdapter(recipeAdapter);
				
	}

	   
		

}
