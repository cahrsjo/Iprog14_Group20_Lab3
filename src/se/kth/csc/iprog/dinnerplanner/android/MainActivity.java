package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.BtnNext;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.android.view.ExampleViewController;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.activity_main);
        
    	// Creating the view class instance
    	ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id), model);
        BtnNext buttonView = new BtnNext(findViewById(R.id.next_button), model);

        // Creating the view class instance and passing the model
        ExampleView exampleView = new ExampleView(findViewById(R.id.this_is_example_view_id), model);
        //ExampleViewController exampleCtrl = new ExampleViewController(model, exampleView);

        buttonView.nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseMenu.class);
                startActivity(intent);
            }

        });

}
}