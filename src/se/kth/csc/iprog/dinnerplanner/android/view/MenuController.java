package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;

public class MenuController implements View.OnClickListener {
    DinnerModel model;
    Menu view;

    public MenuController (DinnerModel model, Menu view ) {
        this.model = model;
        this.view = view;

        // Here we setup the listeners
        //view.image.findViewById(R.id.menuHeader).setOnClickListener(this);
        view.image.setOnClickListener(this);
        //view.minusButton.setOnClickListener(this);
    }

    // This is the method of that we need to implement when implementing
    // the OnClickListener. Notice that the View here is an Android View
    // class (parent class of all the components), not the view we talk
    // about in the lab instructions.
    @Override
    public void onClick(View v) {

        if(v == view.image) {
            // We update the model
            int id = view.image.getId();

        }
        /**if(v == view.minusButton) {
            // We update the model
            model.setNumberOfGuests(model.getNumberOfGuests() - 1);
        }**/
    }

}