package com.example.thirdassignment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentsViewHolder>{

    List <Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }
    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_student_adapter, parent, false);
        StudentsViewHolder myHolder = new StudentsViewHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder hold, final int position) {
        final Student student = studentList.get(position);
        String gender = student.getGender();

        hold.tName.setText(student.getName());
        hold.tAge.setText(student.getAge());
        hold.tAddress.setText(student.getAddress());

        hold.tGender.setText(student.getGender());

        if (gender.equals("Male")) {
            hold.imageView.setImageResource(R.drawable.user_dummy);
        } else if (gender.equals("Female")) {
            hold.imageView.setImageResource(R.drawable.female);
        } else {
            hold.imageView.setImageResource(R.drawable.a);
        }

        hold.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentList.remove(student);

                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tName, tAge, tAddress, tGender;
        Button btn;
        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
            tName = itemView.findViewById(R.id.tvName);
            tAge = itemView.findViewById(R.id.tvAge);
            tAddress = itemView.findViewById(R.id.tvAddress);
            tGender = itemView.findViewById(R.id.tvGender);
            btn = itemView.findViewById(R.id.btnDelete);
        }
    }

}
