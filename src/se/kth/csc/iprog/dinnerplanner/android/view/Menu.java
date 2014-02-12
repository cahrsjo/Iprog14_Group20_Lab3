package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class Menu {
    DinnerModel model;
    View view;
    String imageFileName;
    String imageName;
    Set<Dish> starters = new HashSet<Dish>();
    Set<Dish> maincourses = new HashSet<Dish>();
    Set<Dish> desserts = new HashSet<Dish>();
    public ImageView image;
    public TextView imageTextView;
    public LinearLayout verticalLayout;
    public LinearLayout starterLayout;
    public LinearLayout maincourseLayout;
    public LinearLayout dessertLayout;

    public Menu(View view, DinnerModel model){
        this.view = view;
        this.model = model;

        //Get all dishes
        starters = model.getDishesOfType(1);
        maincourses = model.getDishesOfType(2);
        desserts = model.getDishesOfType(3);

        //Get the empty linearlayout from the view
        starterLayout = (LinearLayout) view.findViewById(R.id.starterLayout);
        maincourseLayout = (LinearLayout) view.findViewById(R.id.maincourseLayout);
        dessertLayout = (LinearLayout) view.findViewById(R.id.dessertLayout);

        //print all dishes
        printDishes(starters, starterLayout);
        printDishes(maincourses, maincourseLayout);
        printDishes(desserts, dessertLayout);
    }

    public void printDishes(Set<Dish> dishes, LinearLayout layout){
        for(Dish s: dishes){
            imageName = s.getName(); //name for the text under the image
            imageFileName = s.getImage();   //filename for the id of each image
            imageFileName = imageFileName.replace(".jpg", "");

            //Create new verticalLayout as container to the image and text
            verticalLayout = new LinearLayout(view.getContext());
            verticalLayout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)layout.getLayoutParams();
            params.setMargins(5, 0, 0, 0);
            verticalLayout.setLayoutParams(params);

            //Create new ImageView and fill it with the picture from getImage above
            image = new ImageView(view.getContext());
            int resID = view.getResources().getIdentifier(imageFileName, "drawable", view.getContext().getPackageName());
            image.setImageResource(resID);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(140,140);
            image.setLayoutParams(params1);
            verticalLayout.addView(image);

            //Create new TextView and fill it with the picture's text
            imageTextView = new TextView(view.getContext());
            imageTextView.setText(imageName);
            verticalLayout.addView(imageTextView);

            //Add the view to the correct layout
            layout.addView(verticalLayout);
        }
    }
}
