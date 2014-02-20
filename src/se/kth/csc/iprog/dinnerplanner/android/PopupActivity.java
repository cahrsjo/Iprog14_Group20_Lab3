package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.BtnNext;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseButton;
import se.kth.csc.iprog.dinnerplanner.android.view.CancelButton;
import se.kth.csc.iprog.dinnerplanner.android.view.MenuController;
import se.kth.csc.iprog.dinnerplanner.android.view.Participants;
import se.kth.csc.iprog.dinnerplanner.android.view.ParticipantsController;
import se.kth.csc.iprog.dinnerplanner.android.view.Menu;
import se.kth.csc.iprog.dinnerplanner.android.view.PopupController;
import se.kth.csc.iprog.dinnerplanner.android.view.PopupView;
import se.kth.csc.iprog.dinnerplanner.android.view.TotalCost;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopupActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);


        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_popup);

        // INSTANTIATE THE MODEL HERE !!!!!!!!!
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();


        Participants participantsView = new Participants(findViewById(R.id.popupParticipantsLayout), model);
        //ParticipantsController participantsCtrl = new ParticipantsController(model, participantsView);


        // PASS THE MODEL AS A VARIABLE
        TotalCost costView = new TotalCost(findViewById(R.id.total_cost), model);



        //Menu menuView = new Menu(findViewById(R.id.menuview), model);
        //MenuController menuCtrl = new MenuController(model, menuView);

        PopupView popup = new PopupView(findViewById(R.id.showPopupWindow), model);
        PopupController popupCtrl = new PopupController(model, popup);

        ChooseButton choose = new ChooseButton(findViewById(R.id.choose_button), model);
        CancelButton cancel = new CancelButton(findViewById(R.id.cancel_button), model);

       /* choose.chooseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupActivity.this, ChooseMenu.class);
                startActivity(intent);
            }

        }); */



        //ChooseMenu-id från activity_choose.xml för att skicka popupen
        /*final View chooseMenuView = findViewById(R.id.chooseMenuView);

        menuView.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);


                View popupView = layoutInflater.inflate(R.layout.popup, null);




                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                popupWindow.showAtLocation(chooseMenuView, Gravity.CENTER, 0, 0);
            };
        });*/

    }
}
