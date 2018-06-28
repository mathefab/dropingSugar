package fabrice.sugar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class AnimationActivity extends AppCompatActivity implements
        View.OnClickListener, Animation.AnimationListener {
    Animation rotationRight;

    TextView textStatus;
    ImageView imageView;

    Button btnRotationRight;

    float saisiea = 150;
    float saisieb = 150;
    float saisiec = 150;


    public float getSaisiea() {
        EditText textesaisiea = (EditText) findViewById (R.id.Saisiea);
        saisiea = Float.parseFloat (textesaisiea.getText ().toString ());
        return saisiea;
    }
    public float getSaisieb() {
        EditText textesaisieb = (EditText) findViewById (R.id.Saisieb);
        saisieb = Float.parseFloat (textesaisieb.getText ().toString ());
        return saisieb;
    }
    public float getSaisiec() {
        EditText textesaisiec = (EditText) findViewById (R.id.Saisiec);
        saisiec = Float.parseFloat (textesaisiec.getText ().toString ());
        return saisiec;
    }

    public void theMove(float x, float y) {

        rotationRight.setDuration( seekSpeedProgress );
        rotationRight.setAnimationListener(this);
        imageView.startAnimation( rotationRight );
        imageView.setTranslationY (x);
        imageView.setTranslationX (y);
        //  imageView.setRotatonX (15);
        // imageView.setRotationY (15);
    }

    public void computeTranslations (float inputAngle, float inputSpeed){
        float posY = 1;
        float posX = 0;
        while (posY != 1500) {
            posX = posX + 1;

            posY = posX + 1;
            theMove (1, 1);

        }

    }


    SeekBar seekBarSpeed;
    TextView textSeekerSpeed;

    int seekSpeedProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        loadAnimations();
        loadUI();
    }

    private void loadAnimations() {
        rotationRight = AnimationUtils.loadAnimation( this , R.anim.rotation_right);
        rotationRight.setAnimationListener(this);
    }

    private void loadUI() {
        imageView = (ImageView)findViewById(R.id.imageview);
        textStatus = (TextView)findViewById(R.id.textStatus);



        btnRotationRight = (Button)findViewById(R.id.btnRotateRight);
        btnRotationRight.setOnClickListener(this);

        seekBarSpeed = (SeekBar)findViewById(R.id.seekBar);
        textSeekerSpeed = (TextView)findViewById(R.id.seekerSpeed);

        seekBarSpeed.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged (SeekBar seekbar , int value , boolean fromUser )
                    {
                        seekSpeedProgress = value;
                        textSeekerSpeed.setText(""+seekSpeedProgress
                                + " of " + seekBarSpeed.getMax());

                    }


                    @Override
                    public void onStartTrackingTouch( SeekBar seekBar )
                    {
                    }

                    @Override
                    public void onStopTrackingTouch( SeekBar seekBar )
                    {
                    }
                }
        );

    }

    @Override
    public void onClick(View v) {

        computeTranslations(getSaisiea (), getSaisieb ());

        }


    @Override
    public void onAnimationStart(Animation animation) {
        textStatus.setText("RUNNING");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        textStatus.setText("STOPPED");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
