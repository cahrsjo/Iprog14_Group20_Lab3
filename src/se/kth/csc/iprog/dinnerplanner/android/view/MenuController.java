package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenu;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MenuController implements View.OnClickListener {
    DinnerModel model;
    Menu view;
    View chooseMenuView;

    private static final String TAG = "MyActivity";

    public MenuController (DinnerModel model, Menu view ) {
        this.model = model;
        this.view = view;
        //chooseMenuView = view.findViewById(R.id.chooseMenuView);
        //Log.v(TAG, "test utanfor allt");
        chooseMenuView = view.view.findViewById(R.id.menuview);

        for (ImageView i : view.imageList){
            Log.v(TAG, "test i for-loop");
            i.setOnClickListener(this);
        }
    }

    // This is the method of that we need to implement when implementing
    // the OnClickListener. Notice that the View here is an Android View
    // class (parent class of all the components), not the view we talk
    // about in the lab instructions.
    @Override
    public void onClick(View v) {
        Log.v(TAG, "HALLÅÅÅÅÅÅÅÅÅÅÅÅÅ" + v);
        int id;
        id = v.getId();
        String str;
        str = v.getResources().getString(id); // str is on the form "res/drawable/bakedbrie.jpg"
        model.setMarkedDish(str);             // We update the model
        Log.v(TAG, " image: " + str + " id: " + id);

        createPopup(v);

        //INFLATE THE POPUP

        //LayoutInflater layoutInflater = (LayoutInflater)v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void createPopup(View v){
        LayoutInflater layoutInflater = (LayoutInflater)view.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View popupView = layoutInflater.inflate(R.layout.popup, null);


        PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        //chooseMenuView = v.findViewById(R.id.chooseMenuView);

        Log.v(TAG, "CHOOSEMENUVIEW: " +chooseMenuView);
        popupWindow.showAtLocation(chooseMenuView, Gravity.CENTER, 0, 0);
    }
}

