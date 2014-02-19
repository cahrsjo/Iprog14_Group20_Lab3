package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.BackButtonView;
import se.kth.csc.iprog.dinnerplanner.android.view.CheckoutImages;
import se.kth.csc.iprog.dinnerplanner.android.view.CourseDescriptionView;
import se.kth.csc.iprog.dinnerplanner.android.view.IngredientView;
import se.kth.csc.iprog.dinnerplanner.android.view.TotalCost;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import android.os.Bundle;
import android.app.Activity;

public class Checkout2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_checkout2);
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        // Creating the view class instance
<<<<<<< HEAD
<<<<<<< HEAD
        TotalCost mainView = new TotalCost(findViewById(R.id.total_cost), model);
        //IngredientView ingview = new IngredientView(findViewById(R.id.ingredient_view), model);
=======
        CourseDescriptionView courseview = new CourseDescriptionView(findViewById(R.id.course_description_view), model);
>>>>>>> fa6337f37a6e727d327eb601032d84f780231bf8
        BackButtonView backview = new BackButtonView(findViewById(R.id.back_button), model);
        CheckoutImages images = new CheckoutImages(findViewById(R.id.image_view), model);
<<<<<<< HEAD
        CourseDescriptionView courseview = new CourseDescriptionView(findViewById(R.id.course_description_view), model);
        CheckoutController checkoutCtrl = new CheckoutController(model, images);
=======
        TotalCost mainView = new TotalCost(findViewById(R.id.total_cost), model);


>>>>>>> fa6337f37a6e727d327eb601032d84f780231bf8
=======
        CourseDescriptionView courseview = new CourseDescriptionView(findViewById(R.id.course_description_view), model);
        BackButtonView backview = new BackButtonView(findViewById(R.id.back_button), model);
        CheckoutImages images = new CheckoutImages(findViewById(R.id.image_view), model);
        TotalCost mainView = new TotalCost(findViewById(R.id.total_cost), model);


>>>>>>> fa6337f37a6e727d327eb601032d84f780231bf8


        /**nextButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        }

        });**/

    }
}
