package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.net.Uri;
import android.app.Dialog;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.HashSet;

public class CheckoutImages implements Observer{

    View view;
    DinnerModel model;
    String imageString;
    String dishName;
    Set<Dish> resultsBack = new HashSet<Dish>();
    Set<ImageView> checkoutImages = new HashSet<ImageView>();
    //Set<Dish> getSelectedDishes = new HashSet<Dish>();
    public CheckoutImages(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);

        resultsBack = model.getSelectedDishes();

        for (Dish d : resultsBack) {
            imageString = d.getImage();
            dishName = d.getName();

            if (d.getType() == 1){
                if (imageString.indexOf(".") > 0){
                    imageString = imageString.substring(0, imageString.lastIndexOf("."));
                }

                TextView dname = (TextView) view.findViewById(R.id.dishName);
                dname.setText(dishName);


                ImageView image1 = (ImageView) view.findViewById(R.id.starterImage);
                int resID1 = view.getResources().getIdentifier(imageString , "drawable", ((Activity)view.getContext()).getPackageName());
                image1.setImageResource(resID1);
                image1.setId(resID1);
                checkoutImages.add(image1);
            }

            if (d.getType() == 2){
                if (imageString.indexOf(".") > 0){
                    imageString = imageString.substring(0, imageString.lastIndexOf("."));
                }

                TextView dname = (TextView) view.findViewById(R.id.dishName2);
                dname.setText(dishName);

                ImageView image2 = (ImageView) view.findViewById(R.id.maincourseImage);
                int resID2 = view.getResources().getIdentifier(imageString , "drawable", ((Activity)view.getContext()).getPackageName());
                image2.setImageResource(resID2);
                image2.setId(resID2);
                checkoutImages.add(image2);
            }

            if (d.getType() == 3){
                if (imageString.indexOf(".") > 0){
                    imageString = imageString.substring(0, imageString.lastIndexOf("."));
                }

                TextView dname = (TextView) view.findViewById(R.id.dishName3);
                dname.setText(dishName);

                ImageView image3 = (ImageView) view.findViewById(R.id.dessertImage);
                int resID3 = view.getResources().getIdentifier(imageString , "drawable", ((Activity)view.getContext()).getPackageName());
                image3.setImageResource(resID3);
                image3.setId(resID3);
                checkoutImages.add(image3);
            }

        }
        TextView test = (TextView) view.findViewById(R.id.instructions);
        test.setText("Instructrions");


        // Setup the rest of the view layout
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
