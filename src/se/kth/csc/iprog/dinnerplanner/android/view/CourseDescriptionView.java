package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.HashSet;

public class CourseDescriptionView implements Observer{

    //DinnerModel dynamicDescription = new DinnerModel();
    View view;
    DinnerModel model;

    String dishType =" ";
    String name = " ";
    String description = " ";
    Set<Dish> resultsBack = new HashSet<Dish>();
    private static final String TAG = "myCOURSEDESCRIPTIONVIEW";
    public CourseDescriptionView(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);

        resultsBack = model.getSelectedDishes();
        for (Dish d : resultsBack) {
            Log.v(TAG, "Går in i for loopen");
            if (d.getType()==1){
                Log.v(TAG, "dish type är 1");
                dishType = "Starter";
            }
            else if (d.getType()==2){
                Log.v(TAG, "dish type är 2");
                dishType = "Main Course";
            }
            else {
                Log.v(TAG, "dish type är 3");
                dishType = "Dessert";
            }
            name = d.getName();
            Log.v(TAG, "namnet är satt");
            description = d.getDescription();
            Log.v(TAG, "beskrivningen är satt");
        }

        TextView courseTitle = (TextView) view.findViewById(R.id.show_course_type);
        Log.v(TAG, "hämtar titeln från viewn");
        courseTitle.setText(" " + dishType + " ");
        //courseTitle.setText("course title goes here");

        TextView courseName = (TextView) view.findViewById(R.id.show_course_name);
        Log.v(TAG, "hämtar titeln från viewn");
        courseName.setText(" " + name + " ");
        //courseTitle.setText("course name goes here");

        TextView courseDescription = (TextView) view.findViewById(R.id.show_course_description);
        Log.v(TAG, "hämtar titeln från viewn");
        courseDescription.setText(" " + description + " ");
        //courseDescription.setText("course description goes here");



        // Setup the rest of the view layout
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
