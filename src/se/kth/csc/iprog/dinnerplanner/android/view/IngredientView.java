package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

import android.view.View;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.HashSet;

public class IngredientView implements Observer{

    View view;
    DinnerModel model;
    String string = "";
    Set<Dish> getTheMenu = new HashSet<Dish>();
    Set<Ingredient> resultsBack = new HashSet<Ingredient>();

    public IngredientView(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);
        TextView totalguests = (TextView) view.findViewById(R.id.show_number_of_guests);
        totalguests.setText(model.getNumberOfGuests() + " pers");

        TextView ingredientTitle = (TextView) view.findViewById(R.id.show_ingredient_title);
        ingredientTitle.setText("Ingredients");

        TextView ingredientlist = (TextView) view.findViewById(R.id.ingredient_list);


        //getTheMenu = model.getFullMenu();
        resultsBack = model.getAllIngredients();

        if (resultsBack.isEmpty()){
            string = "it is empty...";
        }
       for (Ingredient i : resultsBack) {
           string = string + i.getName() + " " + i.getQuantity() + " " + i.getUnit() + "\n";
        }


        ingredientlist.setText(string);

        // Setup the rest of the view layout
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
