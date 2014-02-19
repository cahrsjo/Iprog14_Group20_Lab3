package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.PopupActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import android.view.View;
import android.widget.TextView;

public class PopupController implements View.OnClickListener {
    DinnerModel model;
    PopupView view;
    private static final String TAG = "MyPopupController";

    public PopupController (DinnerModel model, PopupView view ) {
        this.model = model;
        this.view = view;

        // Here we setup the listeners
        view.chooseButton.setOnClickListener(this);
        view.cancelButton.setOnClickListener(this);
        //view.minusButton.setOnClickListener(this);
    }

    // This is the method of that we need to implement when implementing
    // the OnClickListener. Notice that the View here is an Android View
    // class (parent class of all the components), not the view we talk
    // about in the lab instructions.
    @Override
    public void onClick(View v) {

        Log.v(TAG, "Är inne i onClick i POPUPCONTROLLER.");
        if (v==view.chooseButton) {
            Log.v(TAG, "Är inne i v==view.chooseButton");
            Dish d = model.getMarkedDish();
            model.setSelectedDishes(d);
            Intent intent = new Intent(v.getContext(), ChooseMenu.class);
            v.getContext().startActivity(intent);
        }

        if (v==view.cancelButton){
            Intent intent = new Intent(v.getContext(), ChooseMenu.class);
            v.getContext().startActivity(intent);
        }
    }

}