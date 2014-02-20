package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.Checkout;
import se.kth.csc.iprog.dinnerplanner.android.Checkout2;
import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.PopupActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckoutController implements View.OnClickListener {
    DinnerModel model;
    CheckoutImages view;
    View ingredientImage;
    private static final String TAG = "MyCheckoutController";

    public CheckoutController (DinnerModel model, CheckoutImages view ) {
        this.model = model;
        this.view = view;
        ingredientImage = view.view.findViewById(R.id.image_view);

        ingredientImage = ingredientImage.findViewById(R.id.smallIngredientImg);
        ingredientImage.setOnClickListener(this);

        // Here we setup the listeners
        for (ImageView i : view.checkoutImages){
            // Log.v(TAG, "test i for-loop");
            i.setOnClickListener(this);
        }
        //view.minusButton.setOnClickListener(this);
    }

    // This is the method of that we need to implement when implementing
    // the OnClickListener. Notice that the View here is an Android View
    // class (parent class of all the components), not the view we talk
    // about in the lab instructions.
    @Override
    public void onClick(View v) {

        if (v==ingredientImage){
            Intent intent = new Intent(v.getContext(), Checkout.class);
            v.getContext().startActivity(intent);
        }

        else {
            int id;
            id = v.getId();
            String str;
            str = v.getResources().getString(id); // str is on the form "res/drawable/bakedbrie.jpg"
            model.setMarkedDish(str);             // We update the model

            Log.v(TAG, "Är inne i onClick i checkoutcontroller."+ " " + str + " " + id);

            Intent intent = new Intent(v.getContext(), Checkout2.class);// TODO: Something wrong in Checkout2 atm...
            v.getContext().startActivity(intent);
        }



    }

}