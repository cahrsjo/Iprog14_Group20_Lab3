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

public class CourseDescriptionView implements Observer{

    //DinnerModel dynamicDescription = new DinnerModel();
    View view;
    DinnerModel model;
    int type = 0;
    String dishType = "ASDADASDASD";
    String name = "sdfs";
    String description = "asdasdas";
    Set<Dish> result2 = new HashSet<Dish>();

    public CourseDescriptionView(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);
<<<<<<< HEAD
        // TODO: This loads meatballs all the time... how to fix it??????
        resultsBack = model.getSelectedDishes();
        for (Dish d : resultsBack) {
            Log.v(TAG, "Går in i for loopen");
            if (d.getType()==1){
                Log.v(TAG, "dish type är 1");
                dishType = "Starter";
            }
            if (d.getType()==2){
                Log.v(TAG, "dish type är 2");
                dishType = "Main Course";
            }
            if (d.getType()==3){
                Log.v(TAG, "dish type är 3");
                dishType = "Dessert";
=======

        result2 = model.getFullMenu();
        for (Dish d : result2) {
            type = d.getType();
            if (type==1){
                dishType = "Menu";
            }
            else if (type==2){
                dishType = "Main Course";
            }
            else {
                dishType = "Desert";
>>>>>>> fa6337f37a6e727d327eb601032d84f780231bf8
            }
            name = d.getName();
            description = d.getDescription();
<<<<<<< HEAD
            Log.v(TAG, "beskrivningen är satt");

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
        }


=======
        }

        TextView courseTitle = (TextView) view.findViewById(R.id.show_course_type);
        courseTitle.setText(dishType);

        TextView courseName = (TextView) view.findViewById(R.id.show_course_name);
        courseName.setText(name);

        TextView courseDescription = (TextView) view.findViewById(R.id.show_course_description);
        courseDescription.setText(description);
>>>>>>> fa6337f37a6e727d327eb601032d84f780231bf8



        // Setup the rest of the view layout
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
