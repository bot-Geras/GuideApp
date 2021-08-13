package ke.xd.guideapp.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import ke.xd.guideapp.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.splash_screen_background01,
            R.drawable.splash_screen_background02,
            R.drawable.splash_screen_background03,
            R.drawable.splash_screen_background04

    };

    int headings[] = {
            R.string.first_slide_Title,
            R.string.second_slide_Title,
            R.string.third_slide_Title,
            R.string.fourth_slide_Title


    };

    int description[] = {

            R.string.first_slide_description,
            R.string.second_slide_description,
            R.string.third_slide_description,
            R.string.fourth_slide_description
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull  Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout, container, false);
//Hooks
        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView heading = view.findViewById(R.id.slider_heading);
        TextView descriptions = view.findViewById(R.id.slider_description);


        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        descriptions.setText(description[position]);

        container.addView(view);


        return view;
    }


    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
