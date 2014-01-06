package net.shootlearnshoot;

import net.shootlearnshoot.db.DataManager;
import net.shootlearnshoot.domain.Recipe;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.shootlearnshoot.R;

public class NewReloadActivity extends Activity {

	private DataManager dataManger = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dataManger = new DataManager(getBaseContext());
		setContentView(R.layout.activity_newreloadscreen);
		
		 Button button = (Button)findViewById(R.id.bn_newReload);
	        
	     System.out.println("trying to set onClick");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView nameField = (TextView)findViewById(R.id.et_reloadName);
				TextView bulletField = (TextView)findViewById(R.id.et_bulletName);
				TextView powderNameField = (TextView)findViewById(R.id.et_powderName);
				TextView powderAmtField = (TextView)findViewById(R.id.et_powderAmt);
				TextView primerField = (TextView)findViewById(R.id.et_primer);
				TextView notesField = (TextView)findViewById(R.id.et_notes);
				
				Recipe recipe = new Recipe();
				
				recipe.setName(nameField.getText().toString());
				recipe.setBullet(bulletField.getText().toString());
				recipe.setPowderName(powderNameField.getText().toString());
				recipe.setPowderAmt(powderAmtField.getText().toString());
				recipe.setPrimer(primerField.getText().toString());
				recipe.setNotes(notesField.getText().toString());
				
				System.err.println("Got name for reload (" +  nameField.getText() +")" + " bulletName=" + bulletField.getText());
				
				long id = dataManger.saveRecipe(recipe);
				Log.d(Constants.LOG_TAG, "Saved Recipe with ID =" + id);
				
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_reload, menu);
		return true;
	}

}
