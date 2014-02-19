package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.BtnNext;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseButton;
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
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopupActivity extends Activity {
    private static final String TAG = "POPUPACTIVITYTEST";
    public View showPopupHere;
    public LayoutInflater inflater;
    public View popupView;
    public PopupWindow popupWindow;
    public View popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);


        // Set the view for the main activity screen
        // it must come before any call to findViewById method

        /*setContentView(R.layout.activity_choose);

        // INSTANTIATE THE MODEL HERE !!!!!!!!!
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
        // Creating the view class instance

        Participants participantView = new Participants(findViewById(R.id.participantsLayout), model);

        // PASS THE MODEL AS A VARIABLE
        TotalCost costView = new TotalCost(findViewById(R.id.total_cost), model);

        //Next button
        BtnNext next = new BtnNext(findViewById(R.id.next_button), model);//, model


        Participants participantsView = new Participants(findViewById(R.id.participantsLayout), model);
        ParticipantsController participantsCtrl = new ParticipantsController(model, participantsView);

        Menu menuView = new Menu(findViewById(R.id.menuview), model);
        MenuController menuCtrl = new MenuController(model, menuView);
        //ChooseMenu.java färdigladdat som bakgrund*/




        //TANKE: DÖLJ POPUP OCH VISA NÄR MAN KLICKAR?
        //ALSO: Måste includera popup.xml i activity_choose.xml för att kunna nå choose_button
        /*popup = findViewById(R.id.popup);
        popup.setVisibility(View.GONE);

        ChooseButton choose = new ChooseButton(findViewById(R.id.choose_button), model);

        //Log.v(TAG, "ChooseButton choose:  " + choose);

        //POPUP
        inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        popupView = inflater.inflate(R.layout.activity_popup, null);
        Log.v(TAG, "Inflated popupView:  " + popupView);

        popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setContentView(popupView);

        Log.v(TAG, "popupWindow setContentview:  " + popupWindow);

        showPopupHere = findViewById(R.id.menuview); //Byter till popupView så borde ta id't därifrån
        Log.v(TAG, "showPopupHere:  " + showPopupHere);

        //popupWindow.showAtLocation(showPopupHere, Gravity.CENTER, 0, 0);  //DENNA SOM FUCKAR



        new Handler().postDelayed(new Runnable(){

            public void run() {
                //popup.setVisibility(View.VISIBLE);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
            }

        }, 100L);*/

        //Log.v(TAG, "popupWindow showAtLocation:  " + popupWindow);

        //DET GAMLA SOM FUNKAR
        //TODO: Mycket krångel med implementeringen ovan. Förslag: ha det som innan men
        // TODO flytta ner viewen så den blir centrerad, eventuellt lägga till headern med Participants/total cost
        //

        setContentView(R.layout.activity_popup);

        // INSTANTIATE THE MODEL HERE !!!!!!!!!
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        //Menu menuView = new Menu(findViewById(R.id.menuview), model);
        //MenuController menuCtrl = new MenuController(model, menuView);

        PopupView popup = new PopupView(findViewById(R.id.showPopupWindow), model);
        PopupController popupCtrl = new PopupController(model, popup);

        ChooseButton choose = new ChooseButton(findViewById(R.id.choose_button), model);

    }
}
