package fr.cnam.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity implements
        View.OnClickListener, Animation.AnimationListener {

    Animation animFadeIn;
    Animation rotationRight;
    Animation animBounce;
    Animation animZoomIn;
    Animation rotationLeft;


    TextView textStatus;
    ImageView imageView;

    Button btnFadeIn;
    Button btnRotationRight;
    Button btnBounce;
    Button btnZoomIn;
    Button btnRotationLeft;

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
        animFadeIn = AnimationUtils.loadAnimation( this , R.anim.fade_in);
        animFadeIn.setAnimationListener(this);
        rotationRight = AnimationUtils.loadAnimation( this , R.anim.rotation_right);
        rotationRight.setAnimationListener(this);
        rotationLeft = AnimationUtils.loadAnimation( this , R.anim.rotation_left);
        rotationLeft.setAnimationListener(this);
        animBounce = AnimationUtils.loadAnimation( this , R.anim.bounce);
        animBounce.setAnimationListener(this);
        animZoomIn = AnimationUtils.loadAnimation( this , R.anim.zoom_in);
        animZoomIn.setAnimationListener(this);


    }

    private void loadUI() {
        imageView = (ImageView)findViewById(R.id.imageview);
        textStatus = (TextView)findViewById(R.id.textStatus);
        btnFadeIn = (Button)findViewById(R.id.btnFadeIn);
        btnFadeIn.setOnClickListener(this);

        btnRotationRight = (Button)findViewById(R.id.btnRotateRight);
        btnRotationRight.setOnClickListener(this);

        btnRotationLeft = (Button)findViewById(R.id.btnRotateLeft);
        btnRotationLeft.setOnClickListener(this);

        btnBounce = (Button)findViewById(R.id.btnBounce);
        btnBounce.setOnClickListener(this);

        btnZoomIn= (Button)findViewById(R.id.btnZoomIn);
        btnZoomIn.setOnClickListener(this);


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
        switch( v.getId()) {
            case R.id.btnFadeIn :
                animFadeIn.setDuration( seekSpeedProgress );
                animFadeIn.setAnimationListener(this);
                imageView.startAnimation( animFadeIn );
                break;
            case R.id.btnRotateRight :
                rotationRight.setDuration( seekSpeedProgress );
                rotationRight.setAnimationListener(this);
                imageView.startAnimation( rotationRight );
                break;
            case R.id.btnRotateLeft :
                rotationLeft.setDuration( seekSpeedProgress );
                rotationLeft.setAnimationListener(this);
                imageView.startAnimation( rotationLeft );
                break;
            case R.id.btnBounce :
                animBounce.setDuration( seekSpeedProgress );
                animBounce.setAnimationListener(this);
                imageView.startAnimation( animBounce );
                break;
            case R.id.btnZoomIn :
                animZoomIn.setDuration( seekSpeedProgress );
                animZoomIn.setAnimationListener(this);
                imageView.startAnimation( animZoomIn );
                break;


        }
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
