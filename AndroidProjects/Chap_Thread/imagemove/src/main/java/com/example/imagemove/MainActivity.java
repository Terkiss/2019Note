package com.example.imagemove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ImageView image1, image2;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DogThread dogThread = new DogThread(HORIZONTAL, v);
                //dogThread.start();
                MoveImage ii = new MoveImage();

                ii.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, HORIZONTAL);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // DogThread dogThread = new DogThread(VERTICAL, v);
                //dogThread.start();
                MoveImage ii2 = new MoveImage();
                ii2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,VERTICAL);
            }
        });
    }

    class DogThread extends Thread {
        int direction;
        View v;
        int Margin = 0;

        boolean running = false;
        boolean forward = true;

        RelativeLayout.LayoutParams parmas = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        public DogThread(int drict, View v) {
            this.direction = drict;
            this.v = v;
        }

        public void run() {
            running = true;
            while (running) {
                if (direction == MainActivity.HORIZONTAL) {
                    if ((int) (Margin * 0.016) > 700) {
                        forward = false;
                    }
                } else if (direction == MainActivity.VERTICAL) {
                    if ((int) (Margin * 0.016) > 1200) {
                        forward = false;
                    }
                }

                if (forward) {
                    Margin += 100;
                } else {
                    Margin -= 100;

                    if (direction == MainActivity.VERTICAL) {
                        if ((int) (Margin * 0.016) < 220) {
                            break;
                        }
                    }
                }
                if (Margin <= 0) {
                    break;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (direction == HORIZONTAL) {
                            parmas.leftMargin = (int) (Margin * 0.016);
                        } else if (direction == VERTICAL) {
                            parmas.topMargin = (int) (Margin * 0.016);
                        }
                        v.setLayoutParams(parmas);
                        v.invalidate();
                    }
                });

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    class MoveImage extends AsyncTask<Integer, Integer, Boolean> {

        int Initpos = 0;

        int Initpos2 = 0;
        @Override


        protected void onPreExecute() {

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) image1.getLayoutParams();

                Initpos = params.leftMargin;

                 params = (RelativeLayout.LayoutParams) image2.getLayoutParams();

                Initpos2 = params.topMargin;


            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            RelativeLayout.LayoutParams parmas = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            if(values[1] == MainActivity.HORIZONTAL)
            {
                parmas.leftMargin = values[0];
                image1.setLayoutParams(parmas);
                image1.invalidate();
            }
            else
            {
                parmas.topMargin = values[0];
                image2.setLayoutParams(parmas);
                image2.invalidate();
            }


            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(Integer... voids) {


            int margin = 0;
            if(voids[0]== MainActivity.HORIZONTAL)
            {
               margin = Initpos;
            }
            else
            {
                margin = Initpos2;
            }
            boolean forward = true;

            while (true) {
                Log.d("J","aaaa");
                if(voids[0] == MainActivity.HORIZONTAL)
                {
                    if(margin > 700)
                    {
                        forward = false;
                    }

                }
                else if(voids[0] == MainActivity.VERTICAL)
                {
                    if(margin > 1200)
                    {
                        forward =false;
                    }
                }


                if(forward)
                {
                    margin += 10;
                }
                else
                {
                    margin -= 10;
                }


                publishProgress(margin, voids[0]);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if( voids[0] == MainActivity.HORIZONTAL)
                {
                    if(margin < Initpos)
                    {
                        break;
                    }
                }
                else
                {
                    if(margin < Initpos2)
                    {
                        break;
                    }
                }

            }

            if(voids[0] == MainActivity.HORIZONTAL)
            {
                publishProgress(Initpos, voids[0]);
            }
            else
            {
                publishProgress(Initpos2, voids[0]);
            }
            return null;
        }
    }

    class MoveImage2 extends AsyncTask<Integer, Integer, Boolean> {

        int Initpos = 0;

        int Initpos2 = 0;
        @Override


        protected void onPreExecute() {

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) image1.getLayoutParams();

            Initpos = params.leftMargin;

            params = (RelativeLayout.LayoutParams) image2.getLayoutParams();

            Initpos2 = params.topMargin;


            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            RelativeLayout.LayoutParams parmas = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            if(values[1] == MainActivity.HORIZONTAL)
            {
                parmas.leftMargin = values[0];
                image1.setLayoutParams(parmas);
                image1.invalidate();
            }
            else
            {
                parmas.topMargin = values[0];
                image2.setLayoutParams(parmas);
                image2.invalidate();
            }


            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(Integer... voids) {


            int margin = 0;
            if(voids[0]== MainActivity.HORIZONTAL)
            {
                margin = Initpos;
            }
            else
            {
                margin = Initpos2;
            }
            boolean forward = true;

            while (true) {
                Log.d("J","aaaa");
                if(voids[0] == MainActivity.HORIZONTAL)
                {
                    if(margin > 700)
                    {
                        forward = false;
                    }

                }
                else if(voids[0] == MainActivity.VERTICAL)
                {
                    if(margin > 1200)
                    {
                        forward =false;
                    }
                }


                if(forward)
                {
                    margin += 10;
                }
                else
                {
                    margin -= 10;
                }


                publishProgress(margin, voids[0]);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if( voids[0] == MainActivity.HORIZONTAL)
                {
                    if(margin < Initpos)
                    {
                        break;
                    }
                }
                else
                {
                    if(margin < Initpos2)
                    {
                        break;
                    }
                }

            }
            return null;
        }
    }
}

