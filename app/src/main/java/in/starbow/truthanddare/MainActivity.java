package in.starbow.truthanddare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //variable decelerations
 private Button button;
 private ConstraintLayout layout;
 private ImageView imageView;
 private Random random =new Random();
    private int lastdirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);


    }
    public void spin(View view)
    {   int newDirection = random.nextInt(3600)+lastdirection+3600;

       float pivotX = imageView.getWidth()/2;
       float pivotY =imageView.getHeight()/2;

        Animation rotate = new RotateAnimation(lastdirection,newDirection,pivotX,pivotY);
        rotate.setDuration(4500);
        rotate.setFillAfter(true);//keeps the animation there after it is completed(image dosent comeback to its original position after animation  completion)
        rotate.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
               // button.setBackgroundColor(Color.parseColor("#DAE0E2"));

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        lastdirection=newDirection;//make the animation start from the position (list time it has stopped)

        imageView.startAnimation(rotate);
    }

}