package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class Desert {

    View view;
    DinnerModel model;
    String imgFileName;
    Set<Dish> getDishes = new HashSet<Dish>();

    Set<Dish> deserts = new HashSet<Dish>();
    public TextView imgName;
    public ImageView image;

    public Desert(View view, DinnerModel model){

        this.view = view;
        this.model = model;
        getDishes = model.getDishes();


        //get all deserts
        getDishes = model.getDishes();
        for (Dish d : getDishes){
            if (d.getType()==3){
                deserts.add(d);
            }
        }

        imgName = (TextView) view.findViewById(R.id.desertImgName);
        if (deserts.isEmpty()){
            imgFileName = "icecream.jpg";
            imgName.setText("Ice cream");
        }

        else {  /** TODO: choose the correct image according to the image ID! **/
            for(Dish s: deserts){
                //get the name
                imgName.setText(s.getName());
                //get the image
                imgFileName = s.getImage();

                if (imgFileName.equals("")){
                    imgFileName = "toast.jpg";
                }
            }

        }

        if (imgFileName.indexOf(".") > 0){
            //delete .jpg
            imgFileName = imgFileName.substring(0, imgFileName.lastIndexOf("."));
        }



        /** IMAGE AS DRAWABLE! **/
        image = (ImageView) view.findViewById(R.id.desertImg);
        int resID = view.getResources().getIdentifier(imgFileName , "drawable", ((Activity)view.getContext()).getPackageName());

        image.setImageResource(resID);



    }
}
