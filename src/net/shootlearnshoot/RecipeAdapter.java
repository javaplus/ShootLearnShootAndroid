package net.shootlearnshoot;

import java.util.List;

import com.example.shootlearnshoot.R;

import net.shootlearnshoot.domain.Recipe;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecipeAdapter extends BaseAdapter {

	// theLayout is a linear layout that defines each item in the list.
	// So we ultimately end up with a long list of these layouts.
	// using the layout allows us to create a complex list with multiple items
	// in each row.
	private static LayoutInflater layoutInflator = null;
	
	private List<Recipe> recipes;
	
	// I believe context is what tells you what UI to apply thing to.
	private final Context context;
	
	public RecipeAdapter(Context context, List<Recipe> recipeList){
		this.recipes = recipeList;
		this.context = context;
		
		// I guess you can't use the setContentView to inflate the layout in the XML.
		// So you must inflate the layout manually to get our LinearLayout that's defined in XML.
		if(layoutInflator==null){
			layoutInflator = LayoutInflater.from(context);
			
		}
		
	}

	
	@Override
	public int getCount() {
		// our count is just how many Recipes there are.
		return this.recipes.size();
	}

	@Override
	public Object getItem(int position) {
		// get the item for this postion
		return recipes.get(position);
	}

	@Override
	public long getItemId(int position) {
		// our unique item id is just the position for now.
		// assumes they pass in valid position???
		return position;	
	}

	/*
	 * The getView(int,View, ViewGroup) method allows us to control the actual
	 * view we return for each item in the list.
	 * This way we can display multiple things in a single row of the list.
	 * In our case we will display the Avatar(image), the text of the twam, 
	 * the user name, and the time is was posted.
	 * 
	 * This will return a LinearLayout containing each of these items.
	 *  
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// if we have no Twams then return empty view.
			if(recipes==null || recipes.size()<1){
				return errorLayout();
			}
			Log.d(Constants.LOG_TAG, "recipes size =" + recipes.size());
			
			LinearLayout theLayout = (LinearLayout)layoutInflator.inflate(R.layout.activity_recipe_list, null);
			
			// once we have our layout from XML we can get the individual pieces to update them.
			TextView name = (TextView)theLayout.findViewById(R.id.tv_recipeName);
			TextView bullet = (TextView)theLayout.findViewById(R.id.tv_recipeBullet);
			TextView powderAmt = (TextView)theLayout.findViewById(R.id.tv_recipePowderAmt);
			TextView powderName = (TextView)theLayout.findViewById(R.id.tv_recipePowderName);
			

			Recipe recipe = recipes.get(position);
		
			// if somehow we have a null recipe show error message
			// for this row
			if(recipe==null){
				return errorLayout();
			}
			
			name.setText(recipe.getName());
			bullet.setText(recipe.getBullet());
			powderAmt.setText(recipe.getPowderAmt());
			powderName.setText(recipe.getPowderName());
			
			return theLayout;
			
		}
	

/**
 * 
 * Return a single row with an error message because we don't have a twam for
 * this postion.
 * 
 * @return
 */
private View errorLayout(){
	LinearLayout theLayout = (LinearLayout)layoutInflator.inflate(R.layout.activity_recipe_list, null);
	
//	// once we have our layout from XML we can get the individual pieces to update them.
//	TextView user = (TextView)theLayout.findViewById(R.id.user);
//	TextView text = (TextView)theLayout.findViewById(R.id.text);
//	TextView time = (TextView)theLayout.findViewById(R.id.time);
//	ImageView pic = (ImageView)theLayout.findViewById(R.id.avatar);
//	
//	pic.setImageResource(R.drawable.missing);
//			
//	user.setText("Unknown");
//	text.setText("Error displaying this twam");
//	time.setText("before its time");
	
	return theLayout;

}

}
