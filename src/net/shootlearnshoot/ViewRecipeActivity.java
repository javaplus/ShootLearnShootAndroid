package net.shootlearnshoot;

import net.shootlearnshoot.db.DataManager;
import net.shootlearnshoot.domain.Recipe;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shootlearnshoot.R;

public class ViewRecipeActivity extends Activity {
	
	private DataManager dataManger = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dataManger = new DataManager(getBaseContext());
		setContentView(R.layout.activity_view_recipe);
		
		TextView nameField = (TextView)findViewById(R.id.tv_reloadName);
		TextView bulletField = (TextView)findViewById(R.id.tv_bulletName);
		TextView powderNameField = (TextView)findViewById(R.id.tv_powderName);
		TextView powderAmtField = (TextView)findViewById(R.id.tv_powderAmt);
		TextView primerField = (TextView)findViewById(R.id.tv_primer);
		TextView notesField = (TextView)findViewById(R.id.tv_notes);
		
		Intent intent = getIntent();
		
		long id = intent.getLongExtra(Constants.RECIPE_ID, 1);
		
		Recipe recipe = dataManger.getRecipe(id);
		
		nameField.setText(recipe.getName());
		bulletField.setText(recipe.getBullet());
		powderNameField.setText(recipe.getPowderName());
		powderAmtField.setText(recipe.getPowderAmt());
		primerField.setText(recipe.getPrimer());
		notesField.setText(recipe.getNotes());
	}

}
