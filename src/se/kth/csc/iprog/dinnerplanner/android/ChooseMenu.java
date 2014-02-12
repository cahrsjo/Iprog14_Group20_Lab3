package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.BtnNext;
import se.kth.csc.iprog.dinnerplanner.android.view.Desert;
import se.kth.csc.iprog.dinnerplanner.android.view.MainCourse;
import se.kth.csc.iprog.dinnerplanner.android.view.Participants;
import se.kth.csc.iprog.dinnerplanner.android.view.Starter;
import se.kth.csc.iprog.dinnerplanner.android.view.TotalCost;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.app.Activity;

public class ChooseMenu extends Activity {
    // INSTANTIATE THE MODEL HERE !!!!!!!!!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);


        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_choose);

        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
        // Creating the view class instance

        Participants participantView = new Participants(findViewById(R.id.participantsLayout), model);

        // PASS THE MODEL AS A VARIABLE
        TotalCost costView = new TotalCost(findViewById(R.id.total_cost), model);

        //Starter menu KLAR
        Starter startermenu = new Starter(findViewById(R.id.starter), model);

        //Main menu TBD
        MainCourse main = new MainCourse(findViewById(R.id.MainCourse), model);

        //Dessert TBD
        Desert dess = new Desert(findViewById(R.id.desert), model);

        //Next button
        BtnNext next = new BtnNext(findViewById(R.id.next_button), model);//, model

        /**nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }

        });**/

    }
}
