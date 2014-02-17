package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;


public class PopupView implements Observer {

    View view;
    public TextView foodName;
    public TextView participantsView2;
    DinnerModel model;
    Button chooseButton;

    ImageView popupImage;
    TextView popupCost;
    TextView popupCostPerPerson;

    public PopupView(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        model.addObserver(this);
        foodName = (TextView) view.findViewById(R.id.foodName);
        participantsView2 = (TextView) view.findViewById(R.id.staticParticipant);
        chooseButton = (Button) view.findViewById(R.id.chooseButton);




        popupImage = (ImageView) view.findViewById(R.id.popupImg);
        //int resID = view.getResources().getIdentifier(popupImage , "drawable", view.getContext().getPackageName());
        //popupImage.setImageResource(resID);

        popupCost = (TextView) view.findViewById(R.id.popupCost);
        popupCostPerPerson = (TextView) view.findViewById(R.id.popupCostPerPerson);

        popupCost.setText("Cost: " );
        popupCostPerPerson.setText("kr/Person");

        updateNumberOfGuests();
    }

    /** THIS IS HOW WE DO WHEN WE DO THE IMAGE DONE!
    ImageView image = (ImageView) view.findViewById(R.id.smallImg);
    int resID = view.getResources().getIdentifier(imageString , "drawable", ((Activity)view.getContext()).getPackageName());
    image.setImageResource(resID);**/

    @Override
    public void update(Observable observable, Object o) {
        updateNumberOfGuests();
    }

    private void updateNumberOfGuests() {
        participantsView2.setText("Participants");
        //participantsView.setText(" " + model.getNumberOfGuests() + " ");
    }
}
