package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class BtnNext implements Observer{

    View view;
    DinnerModel model;
    public Button nextButton;

    public BtnNext(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);
        nextButton = (Button) view.findViewById(R.id.next_Button);
        nextButton.setText("Create");

    }


    @Override
    public void update(Observable observable, Object o) {

    }
}
