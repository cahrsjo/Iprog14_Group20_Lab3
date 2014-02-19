package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.BackButtonView;
import se.kth.csc.iprog.dinnerplanner.android.view.CheckoutController;
import se.kth.csc.iprog.dinnerplanner.android.view.CheckoutImages;
import se.kth.csc.iprog.dinnerplanner.android.view.IngredientView;
import se.kth.csc.iprog.dinnerplanner.android.view.TotalCost;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Checkout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_checkout);
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        // Creating the view class instance
        TotalCost mainView = new TotalCost(findViewById(R.id.total_cost), model);
        IngredientView ingview = new IngredientView(findViewById(R.id.ingredient_view), model);
        BackButtonView backview = new BackButtonView(findViewById(R.id.back_button), model);

        CheckoutImages images = new CheckoutImages(findViewById(R.id.image_view), model);
        CheckoutController checkoutCtrl = new CheckoutController(model, images);

        backview.backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, ChooseMenu.class);
                startActivity(intent);
            }

        });

    }
}
