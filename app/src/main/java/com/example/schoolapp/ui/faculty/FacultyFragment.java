package com.example.schoolapp.ui.faculty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView englishDepartment,hindiDepartment,mathsDepartment;
    private LinearLayout englishNoData,hindiNoData,mathsNoData;
    private List<TeacherData> list1,list2,list3;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);


        englishDepartment = view.findViewById(R.id.englishDepartment);
        hindiDepartment = view.findViewById(R.id.hindiDepartment);
        mathsDepartment = view.findViewById(R.id.mathsDepartment);

        englishNoData = view.findViewById(R.id.englishNoData);
        hindiNoData = view.findViewById(R.id.hindiNoData);
        mathsNoData = view.findViewById(R.id.mathsNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        englishDepartment();
        hindiDepartment();
        mathsDepartment();

      return view;
    }

    private void englishDepartment() {
        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    englishNoData.setVisibility(View.VISIBLE);
                    englishDepartment.setVisibility(View.GONE);
                }else {
                    englishNoData.setVisibility(View.GONE);
                    englishDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    englishDepartment.setHasFixedSize(true);
                    englishDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter =new TeacherAdapter(list1,getContext());
                    englishDepartment.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hindiDepartment() {
        dbRef = reference.child("Hindi");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    hindiNoData.setVisibility(View.VISIBLE);
                    hindiDepartment.setVisibility(View.GONE);
                }else {
                    hindiNoData.setVisibility(View.GONE);
                    hindiDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    hindiDepartment.setHasFixedSize(true);
                    hindiDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter =new TeacherAdapter(list2,getContext());
                    hindiDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mathsDepartment() {
        dbRef = reference.child("Maths");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mathsNoData.setVisibility(View.VISIBLE);
                    mathsDepartment.setVisibility(View.GONE);
                }else {
                    mathsNoData.setVisibility(View.GONE);
                    mathsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    mathsDepartment.setHasFixedSize(true);
                    mathsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter =new TeacherAdapter(list3,getContext());
                    mathsDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}