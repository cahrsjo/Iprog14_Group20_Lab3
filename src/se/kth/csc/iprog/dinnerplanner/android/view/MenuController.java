package se.kth.csc.iprog.dinnerplanner.android.view;

import android.util.Log;
import android.view.View;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuController implements View.OnClickListener {
    DinnerModel model;
    Menu view;
    private static final String TAG = "MyActivity";
    public MenuController (DinnerModel model, Menu view ) {
        this.model = model;
        this.view = view;

        //System.out.println("hejsan"); //Want to find the console.. REMOVE THIS later.
        //Log.v(TAG, "test utanfor allt");

        for (ImageView i : view.imageList){
            Log.v(TAG, "test i for-loop");
            i.setOnClickListener(this);

        }

        /**view.imageList.get(0).setOnClickListener(this);
        view.imageList.get(1).setOnClickListener(this);
        view.imageList.get(2).setOnClickListener(this);
        view.imageList.get(3).setOnClickListener(this);
        view.imageList.get(4).setOnClickListener(this);
        view.imageList.get(5).setOnClickListener(this);**/

        // Here we setup the listeners
        //view.image.setOnClickListener(this);
        //view.minusButton.setOnClickListener(this);
    }

    // This is the method of that we need to implement when implementing
    // the OnClickListener. Notice that the View here is an Android View
    // class (parent class of all the components), not the view we talk
    // about in the lab instructions.
    @Override
    public void onClick(View v) {

        if(v == view.image) {
            int id;
            id = view.image.getId();
            String str;

            str = view.image.getResources().getString(id); // str is on the form "res/drawable/bakedbrie.jpg"

            model.setMarkedDish(str);             // We update the model
            Log.v(TAG, "image: " + str);
        }
        /**if(v == view.minusButton) {
            // We update the model
            model.setNumberOfGuests(model.getNumberOfGuests() - 1);
        }**/
    }

}