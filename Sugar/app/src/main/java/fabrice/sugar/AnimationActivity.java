package fabrice.sugar;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class AnimationActivity extends AppCompatActivity implements
        View.OnClickListener, Animation.AnimationListener {

    Coordonnate calcul;

//    TranslateAnimation fly;

    TextView textStatus;
    Button haveago;

    //
//    public void position(Integer x) {
//        Toast.makeText(this.getBaseContext(),"I got some news -> "+x.toString(),Toast.LENGTH_SHORT).show();
//    }
//
//
//    public abstract class Coordonate extends AsyncTask<Integer, Integer, Integer>{
//
//
//        protected Integer doInBackground(Void... voids) {
//
//            for (int l = 1; l <= 5; l++) {
//                publishProgress(l, l, l);
//            theMove(l, l*l);}
//
//           return null;
//
//        }
//
//        void onProgressUpdate(Integer posX, Integer posY) {
//            for (int l = 1; l <= 5; l++) theMove(posX * l, posY + l);
//
//        }
//    }
    public void theMove(float x, float y) {
        ImageView sucre = (ImageView) findViewById(R.id.imageview);
        ImageView tasseeclab = (ImageView) findViewById(R.id.imageview4);
        ImageView spoon = (ImageView) findViewById(R.id.imageview3);


        TranslateAnimation flysugar = new TranslateAnimation(x, x *30 , y, 30*y);
            flysugar.setInterpolator(new LinearInterpolator());
            flysugar.setDuration(700);
            sucre.startAnimation(flysugar);

        RotateAnimation spinspoon = new RotateAnimation(0f, (x*y),
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        spinspoon.setInterpolator(new LinearInterpolator());
        spinspoon.setDuration(700);
        spoon.startAnimation(spinspoon);

       // TODO si les coordonnées du sugar sont celles de la tasse alors afficher l'image view tasseeclab à la place de tasse)

        tasseeclab.setVisibility(View.VISIBLE);







//        TranslateAnimation flytasse = new TranslateAnimation(x , x *4 , y , y*2);
//        flytasse.setInterpolator(new LinearInterpolator());
//        flytasse.setDuration(700);
//        tasse.startAnimation(flytasse);

//        TranslateAnimation flyspoon = new TranslateAnimation(x , x *2 , y , y*5);
//        flyspoon.setInterpolator(new LinearInterpolator());
//        flyspoon.setDuration(700);
//        spoon.startAnimation(flyspoon);
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation = ObjectAnimator.ofFloat(sucre, "translationX", x);
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation2 = ObjectAnimator.ofFloat(sucre, "translationY", y);
//        animation.setDuration(500);
//        animation.start();
//        animation2.setDuration(500);
//        animation2.start();




//
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation3 = ObjectAnimator.ofFloat(tasse, "translationX", x * x);
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation4 = ObjectAnimator.ofFloat(tasse, "translationY", y * y);
//
//        animation3.setDuration(500);
//        animation3.setFloatValues(x, y);
//        animation3.start();
//        animation4.setDuration(500);
//        animation4.setFloatValues(x, y);
//        animation4.start();

//
//
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation5 = ObjectAnimator.ofFloat(spoon, "translationX", x + 20);
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation6 = ObjectAnimator.ofFloat(spoon, "translationY", y + 20);
//
//        animation5.setDuration(500);
//        animation5.setFloatValues(x, y);
//        animation5.start();
//        animation6.setDuration(500);
//        animation6.setFloatValues(x, y);
//        animation6.start();

//        Coordonnate calcul = new Coordonnate(x, y);
//        for (int l = 1; l <= x; l++) {
//            TranslateAnimation fly = new TranslateAnimation(x, x* l , y, y * l);
//            x=x+l;
//            y = y+l;
//            fly.setInterpolator(new LinearInterpolator());
//            fly.setDuration(700);
//            sucre.startAnimation(fly);
//            flySugarfly(x, y);
//
//        }
//        calcul.execute(x, y);
    }

//    public void flySugarfly(float x, float y) {
//
//        ImageView tasse = (ImageView) findViewById(R.id.imageview2);
//
//
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation = ObjectAnimator.ofFloat(tasse, "translationX", x);
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation2 = ObjectAnimator.ofFloat(tasse, "translationY", y);
//
//        animation.setDuration(500);
//        animation.setFloatValues(x, y);
//        animation.start();
//        animation2.setDuration(500);
//        animation.setFloatValues(x, y);
//        animation2.start();
//
//        ImageView spoon = (ImageView) findViewById(R.id.imageview3);
//
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation3 = ObjectAnimator.ofFloat(spoon, "translationX", x + 20);
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animation4 = ObjectAnimator.ofFloat(spoon, "translationY", y+20);
//
//        animation3.setDuration(500);
//        animation3.setFloatValues(x, y);
//        animation3.start();
//        animation4.setDuration(500);
//        animation4.setFloatValues(x, y);
//        animation4.start();
//
//            fly = new TranslateAnimation(0,2*x,0,2*y);/*-
//            fly.setInterpolator(new LinearInterpolator());
//            fly.setDuration(700);
//            sugar.startAnimation(fly);
//
//        fly = new TranslateAnimation(0,-x,0,-y);
//        fly.setInterpolator(new LinearInterpolator());
//        fly.setDuration(700);
//        sugar.startAnimation(fly);
        //LE PROBLEME : il ne fait que la dernière animation !!!!
//        You really need to understand event driven threaded operating systems.
// The for loop will create the animations, and send events to the main thread (the UI thread).
// As soon as the event is dispatched, the loop continues with the next iteration. Since the thread is completely busy,
// it cannot update the UI until the loop is finished, and the last animation is displayed. Instead, use another thread,
// perhaps using a Runnable with a timer.



    SeekBar seekBarSpeedx;
    SeekBar seekBarSpeedy;
    TextView textSeekerSpeedx;
    TextView textSeekerSpeedy;

    int seekSpeedProgressx;
    int seekSpeedProgressy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        loadUI();
    }

    protected void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        loadUI();
        theMove(seekSpeedProgressx, seekSpeedProgressy);
    }

    private void loadUI() {
        textStatus = (TextView) findViewById(R.id.textStatus);

        haveago = (Button) findViewById(R.id.haveago);
        haveago.setOnClickListener(this);

        seekBarSpeedx = (SeekBar) findViewById(R.id.seekBarx);
        seekBarSpeedy = (SeekBar) findViewById(R.id.seekBary);
        textSeekerSpeedx = (TextView) findViewById(R.id.seekerSpeedx);
        textSeekerSpeedy = (TextView) findViewById(R.id.seekerSpeedy);


        seekBarSpeedx.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekbar, int valuex, boolean fromUser) {
                        seekSpeedProgressx = valuex;
                        textSeekerSpeedx.setText("" + seekSpeedProgressx
                                + " of " + seekBarSpeedx.getMax());
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
        seekBarSpeedy.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekbar, int valuey, boolean fromUser) {
                        seekSpeedProgressy = valuey;
                        textSeekerSpeedy.setText("" + seekSpeedProgressy
                                + " of " + seekBarSpeedy.getMax());
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {

        theMove((float) seekSpeedProgressx, (float) seekSpeedProgressy);

    }

    @Override
    public void onAnimationStart(Animation animation) {
//        textStatus.setText("RUNNING");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
//        textStatus.setText("STOPPED");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
