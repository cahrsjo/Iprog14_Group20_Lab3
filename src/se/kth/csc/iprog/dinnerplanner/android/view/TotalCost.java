package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class TotalCost implements Observer {


    //DinnerModel dynamicPrice = new DinnerModel();
    View view;
    DinnerModel model;
    Set<Dish> getTheMenu = new HashSet<Dish>();
    public TotalCost(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);
        getTheMenu = model.getFullMenu();

        TextView totalcost = (TextView) view.findViewById(R.id.display_total_cost);
        //totalcost.setText("Total cost " + dynamicPrice.getTotalMenuPrice() + " kr");
        totalcost.setText("Total cost " + model.getTotalMenuPrice() + " kr");



        // Setup the rest of the view layout
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
