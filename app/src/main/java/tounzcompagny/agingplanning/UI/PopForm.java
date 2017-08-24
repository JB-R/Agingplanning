package tounzcompagny.agingplanning.UI;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import tounzcompagny.agingplanning.R;

public class PopForm extends Activity {

    private ImageButton buttonClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_bounce);
        a.reset();
        RelativeLayout relativeLayout = findViewById(R.id.activity_form);
        relativeLayout.clearAnimation();
        relativeLayout.startAnimation(a);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width * .5), (int) (height * .8));

        buttonClose = findViewById(R.id.form_button_close);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
