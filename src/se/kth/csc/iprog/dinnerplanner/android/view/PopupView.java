package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public class PopupView implements Observer {

    View view;
    public TextView foodName;
    public ImageView popupImage;

    public double ingredientPrice = 0;
    public double totalIngredientPrice = 0;
    DinnerModel model;
    Button chooseButton;

    public TextView popupCostPerPerson;
    public TextView popupCost;
    String imageFileName;
    String imageName;

    public PopupView(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);
        foodName = (TextView) view.findViewById(R.id.foodName);
        //chooseButton = (Button) view.findViewById(R.id.chooseButton);


        popupCost = (TextView) view.findViewById(R.id.popupCost);
        popupCostPerPerson = (TextView) view.findViewById(R.id.popupCostPerPerson);
        chooseButton = (Button) view.findViewById(R.id.choose_Button);



        updatePopupContent();
    }

    /** THIS IS HOW WE DO WHEN WE DO THE IMAGE DONE!
    ImageView image = (ImageView) view.findViewById(R.id.smallImg);
    int resID = view.getResources().getIdentifier(imageString , "drawable", ((Activity)view.getContext()).getPackageName());
    image.setImageResource(resID);**/

    @Override
    public void update(Observable observable, Object o) {
        updatePopupContent();
    }

    private void updatePopupContent() {

        foodName.setText(" " + model.getMarkedDish().getName() + " ");

        imageName = model.getMarkedDish().getName(); //name for the text under the image
        imageFileName = model.getMarkedDish().getImage();   //filename for the id of each image
        imageFileName = imageFileName.replace(".jpg", "");
        popupImage = (ImageView) view.findViewById(R.id.popupImg);
        int resID = view.getResources().getIdentifier(imageFileName , "drawable", view.getContext().getPackageName());
        popupImage.setImageResource(resID);


        popupCost.setText(" " + model.getTotalMenuPrice() + " kr");

        for (Ingredient i : model.getMarkedDish().getIngredients()){
            ingredientPrice = ingredientPrice + i.getPrice();
        }
        popupCostPerPerson.setText(" " + ingredientPrice + " kr/pers");

    }
}
