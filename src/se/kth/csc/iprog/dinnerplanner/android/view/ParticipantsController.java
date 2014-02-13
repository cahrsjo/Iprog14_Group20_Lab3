package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;

public class ParticipantsController implements View.OnClickListener {
    DinnerModel model;
    Participants view;

    public ParticipantsController(DinnerModel model, Participants view ) {
        this.model = model;
        this.view = view;

        // Here we setup the listeners
        view.plusButton.setOnClickListener(this);
        view.minusButton.setOnClickListener(this);
    }

    // This is the method of that we need to implement when implementing
    // the OnClickListener. Notice that the View here is an Android View
    // class (parent class of all the components), not the view we talk
    // about in the lab instructions.
    @Override
    public void onClick(View v) {

        if(v == view.plusButton) {
            // We update the model
            model.setNumberOfGuests(model.getNumberOfGuests() + 1);
        }
        if(v == view.minusButton) {
            // We update the model
            model.setNumberOfGuests(model.getNumberOfGuests() - 1);
        }
    }

}