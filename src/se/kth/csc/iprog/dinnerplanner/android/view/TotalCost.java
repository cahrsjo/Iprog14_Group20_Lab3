package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class TotalCost implements Observer {

    private static final String TAG = "MyTotalCost";
    //DinnerModel dynamicPrice = new DinnerModel();
    View view;
    DinnerModel model;
    public TextView totalcost;

    public TotalCost(View view, DinnerModel model) {

        Log.v(TAG, "ENTERING TOTAL COST!");

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);

        totalcost = (TextView) view.findViewById(R.id.display_total_cost);

        updateCost();
        // Setup the rest of the view layout
    }

    @Override
    public void update(Observable observable, Object o) {
        updateCost();
    }

    public void updateCost(){

        totalcost.setText("Total cost " + model.getTotalMenuPrice() + " kr");
        Log.v(TAG, "Har gått in i updateCost och hämtat från modellen.");
    }
}
