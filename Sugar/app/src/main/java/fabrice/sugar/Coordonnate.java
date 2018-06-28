package fabrice.sugar;

import android.os.AsyncTask;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Coordonnate extends AsyncTask<Float, Float, TranslateAnimation> {
    float posX, posY;


    public Coordonnate(float posX, float posY) {
        super();
        this.posX = posX;
        this.posY = posY;

    }

    @Override
    protected TranslateAnimation doInBackground(Float... floats) {

        TranslateAnimation fly = null;
        for (int l = 1; l <= 5; l++) {
            posX = posX + l;
            posY = posX * posX + posX;
            publishProgress(Float.valueOf(posX), Float.valueOf(posY));


        }
        return fly;
    }
}

