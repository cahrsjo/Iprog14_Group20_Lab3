package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

import android.view.View;
import android.widget.TextView;

import java.util.Set;
import java.util.HashSet;

public class CourseDescriptionView {

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

        result2 = model.getFullMenu();
        for (Dish d : result2) {
            type = d.getType();
            if (type==1){
                dishType = "Starter";
            }
            else if (type==2){
                dishType = "Main Course";
            }
            else {
                dishType = "Desert";
            }
            name = d.getName();
            description = d.getDescription();
        }

        TextView courseTitle = (TextView) view.findViewById(R.id.show_course_type);
        courseTitle.setText(dishType);

        TextView courseName = (TextView) view.findViewById(R.id.show_course_name);
        courseName.setText(name);

        TextView courseDescription = (TextView) view.findViewById(R.id.show_course_description);
        courseDescription.setText(description);



        // Setup the rest of the view layout
    }

}
