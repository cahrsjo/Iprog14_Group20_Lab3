package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;


public class Participants implements Observer {

        View view;
        public TextView participantsView;
        public TextView participantsView2;
        DinnerModel model;
        Button plusButton;
        Button minusButton;

        public Participants(View view, DinnerModel model) {

            // store in the class the reference to the Android View
            this.view = view;
            this.model = model;
            model.addObserver(this);
            participantsView = (TextView) view.findViewById(R.id.participantsText);
            participantsView2 = (TextView) view.findViewById(R.id.staticParticipant);

            plusButton = (Button) view.findViewById(R.id.plusButton);
            minusButton = (Button) view.findViewById(R.id.minusButton);

            updateNumberOfGuests();
        }

    @Override
    public void update(Observable observable, Object o) {
        updateNumberOfGuests();
    }

    private void updateNumberOfGuests() {
        participantsView2.setText("Participants");
        participantsView.setText(" " + model.getNumberOfGuests() + " ");
    }
}
