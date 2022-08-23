package com.example.schoolapp.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.dictionary,"English","English has been regarded as the first global Lingua Franca. It has become part and parcel of almost every existing field. We use it as the international language to communicate in many fields ranging from business to entertainment. Many countries teach and encourage youngsters to acquire English as a second language."));
        list.add(new BranchModel(R.drawable.hindi,"Hindi","It is the language that most of the north Indians relate to. The majority of the north Indians speak Hindi. There are other vernacular and regional languages too, like Marathi, Kannada, Malayalam, etc. Well, Hindi is the language we use in ou daily lives, Hindi is certainly the home language of we Indians."));
        list.add(new BranchModel(R.drawable.maths,"Maths","Mathematics is the science that deals with the logic of shape, quantity and arrangement. Math is all around us, in everything we do. It is the building block for everything in our daily lives, including mobile devices, computers, software, architecture (ancient and modern), art, money, engineering and even sports."));

        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/school-admin-app-a94c2.appspot.com/o/slide%2Ferika-fletcher-MZxqc6n9qCw-unsplash.jpg?alt=media&token=c22b4f72-4d43-4f90-9d41-75849329a9ed")
                .into(imageView);

        return view;

    }
}