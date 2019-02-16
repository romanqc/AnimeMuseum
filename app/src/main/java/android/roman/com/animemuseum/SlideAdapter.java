package android.roman.com.animemuseum;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SlideAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater inflater;

    public int[] images = {
            R.drawable.bg0,
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3

    };



    public String[] names = {
            "Anime",
            "Artwork",
            "Movies",
            "Anime Music"
    };

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slideshow_layout,container,false);

        ImageView img = (ImageView) view.findViewById(R.id.imageView_id);
        img.setImageResource(images[position]);

        Button button = view.findViewById(R.id.button_id);
        button.setText(names[position]);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position == 0){
                    Intent i = new Intent (context, AnimeActivity.class);
                    context.startActivity(i);
                }else if(position == 1){
                    Intent i = new Intent (context, ArtworkActivity.class);
                    context.startActivity(i);
                }else if(position == 2){
                    Intent i = new Intent (context, MovieActivity.class);
                    context.startActivity(i);
                }else if(position == 3){
                    Intent i = new Intent (context, AnimeMusic.class);
                    context.startActivity(i);
                }


            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);


    }
}

