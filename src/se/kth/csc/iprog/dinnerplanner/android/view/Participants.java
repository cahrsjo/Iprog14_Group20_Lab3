package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;


public class Participants {

        View view;
        public TextView participantsView;
        DinnerModel model;
        public Participants(View view, DinnerModel model) {

            // store in the class the reference to the Android View
            this.view = view;

            participantsView = (TextView) view.findViewById(R.id.participantsText);
            participantsView.setText("Participants: ");


        }

}
