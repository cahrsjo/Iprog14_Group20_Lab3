package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.Checkout;
import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class Menu implements Observer{
    DinnerModel model;
    View view;
    String imageFileName;
    String imageName;
    Set<Dish> starters = new HashSet<Dish>();
<<<<<<< HEAD
    //Set<ImageView> imageList = new HashSet<ImageView>();
    ArrayList<ImageView> imageList = new ArrayList<ImageView>();
=======
    Set<ImageView> imageList = new HashSet<ImageView>();
    //ArrayList<ImageView> imageList = new ArrayList<ImageView>();
>>>>>>> ba98f65da46bbf8eaa7e4c06180997d88cd57351
    Set<Dish> maincourses = new HashSet<Dish>();
    Set<Dish> desserts = new HashSet<Dish>();
    public ImageView image;
    public TextView imageTextView;
    public LinearLayout verticalLayout;
    public LinearLayout starterLayout;
    public LinearLayout maincourseLayout;
    public LinearLayout dessertLayout;
    //final View chooseMenuView;
    int resID;

    private static final String TAG = "MyActivity";

    public Menu(View view, DinnerModel model){
        this.view = view;
        this.model = model;
        model.addObserver(this);


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


        //get popupviewplace
        //chooseMenuView = view.findViewById(R.id.chooseMenuView);



    }

    public Context getContext(){
        return view.getContext();
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
            resID = view.getResources().getIdentifier(imageFileName, "drawable", view.getContext().getPackageName());
            image.setImageResource(resID);
            image.setId(resID);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(140,140);
            image.setLayoutParams(params1);
            verticalLayout.addView(image);
            imageList.add(image);



            //Create new TextView and fill it with the picture's text
            imageTextView = new TextView(view.getContext());
            imageTextView.setText(imageName);
            verticalLayout.addView(imageTextView);


            //Add onclicklistener to each dish
            /*image.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.v(TAG, "Går in i onClick i setOnClickListener...");
                    createPopup(v);
                }
            });
            //Add the view to the correct layout*/
            layout.addView(verticalLayout);
        }
    }

   /* public void createPopup(View v){
            LayoutInflater layoutInflater = (LayoutInflater)view.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View popupView = layoutInflater.inflate(R.layout.popup, null);

            PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

            popupWindow.showAtLocation(chooseMenuView, Gravity.CENTER, 0, 0);
    }*/

    @Override
    public void update(Observable observable, Object o){

    }
}
