package net.shootlearnshoot;

import com.example.shootlearnshoot.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.bn_createReload);
        
	    System.out.println("trying to set onClick");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Constants.INTENT_ACTION_NEW_RELOAD);
		    	//intent.putExtra(Constants.CUISINE_CHOICE, this.cuisine.getSelectedItem().toString());
		    	//intent.putExtra(Constants.LOCATION, this.location.getText().toString());
		    	startActivity(intent);				
			}
		});
		
		Button viewButton = (Button)findViewById(R.id.bn_viewReload);
		viewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TextView recipeIDField = (TextView)findViewById(R.id.et_recipeID);
								
				Intent intent = new Intent(Constants.INTENT_ACTION_VIEW_RELOAD);
				intent.putExtra(Constants.RECIPE_ID, Long.valueOf(recipeIDField.getText().toString()));
		    	startActivity(intent);				
			}
		});

		
		Button viewListButton = (Button)findViewById(R.id.bn_recipe_list);
		viewListButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TextView recipeIDField = (TextView)findViewById(R.id.et_recipeID);
								
				Intent intent = new Intent(Constants.INTENT_ACTION_VIEW_RECIPE_LIST);
				// intent.putExtra(Constants.RECIPE_ID, Long.valueOf(recipeIDField.getText().toString()));
		    	startActivity(intent);				
			}
		});
                
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

    
}
