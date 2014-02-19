package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class ExampleView implements Observer{

	View view;
    DinnerModel model;
    Button plusButton;
    Button minusButton;
    TextView example;
	public ExampleView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
        this.model = model;
        model.addObserver(this);
		example = (TextView) view.findViewById(R.id.example_text);


        //plusButton = (Button) view.findViewById(R.id.plusButton);
        //minusButton = (Button) view.findViewById(R.id.minusButton);
		// Setup the rest of the view layout

        doStuff();
	}

    @Override
    public void update(Observable observable, Object o) {
        doStuff();
    }

    private void doStuff() {
        example.setText("Welcome to Dinner Planner!" + '\n' + '\n' + "Here you will be able to plan your dinner."+ '\n' + '\n' + model.getNumberOfGuests());
    }
}
