package com.example.schoolapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

        private ImageSlider imageSlider;
        private ImageView mapimage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);
        mapimage = view.findViewById(R.id.mapimage);
        mapimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmap();
            }
        });

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/school-admin-app-a94c2.appspot.com/o/slide%2Fcrayons.jpg?alt=media&token=3e561493-e9d8-4db6-9ba3-607345826b45",null));
        images.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/school-admin-app-a94c2.appspot.com/o/slide%2Ferika-fletcher-MZxqc6n9qCw-unsplash.jpg?alt=media&token=c22b4f72-4d43-4f90-9d41-75849329a9ed",null));
        images.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/school-admin-app-a94c2.appspot.com/o/slide%2Fopenbook.jpg?alt=media&token=8e0f6cd1-acfc-4864-8029-be2c5cdd3995",null));
        images.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/school-admin-app-a94c2.appspot.com/o/slide%2Fschoolplay.jpg?alt=media&token=1098150d-1e33-4a78-8561-bceb10f33435",null));

        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);

        return view;
    }

    private void openmap() {
        Uri uri = Uri.parse("geo:0, 0?q= Nyaykhand-2 Indirapuram");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}