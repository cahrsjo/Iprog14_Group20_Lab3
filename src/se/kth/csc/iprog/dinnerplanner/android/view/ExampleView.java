package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;

public class ExampleView {

	View view;
    DinnerModel model;

	public ExampleView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
        this.model = model;
		TextView example = (TextView) view.findViewById(R.id.example_text);
		example.setText("Welcome to Dinner Planner!" + '\n' + '\n' + "Here you will be able to plan your dinner.");


		// Setup the rest of the view layout
	}

}
