package com.example.smarteduvid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models; //ini array list membuat list dari array yang dimana parameter di define di model class

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null); //this line inflate our row
        return new MyHolder(view); //this will return our view to holder class

    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {

        myHolder.mTitle.setText(models.get(i).getTitle()); //here is the position
        myHolder.mDescription.setText(models.get(i).getDescription());
        myHolder.mImageView.setImageResource(models.get(i).getImage()); //here we used image resource because we will
        //resource folder which is drawable

        //friends this method is than you can use when you want to use one activity
        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
            }
        });


        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                if (models.get(position).getTitle().equals("Edukasi Seputar Covid-19")){

                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); // this object get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable(); //this will get our image from drawable

                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); //image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // it will compres our image

                    byte[] bytes =stream.toByteArray();
                    //get our data with intent

                    Intent intent = new Intent(c,EdukasiActivity.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc);  //get data and put in intent
                    intent.putExtra("iImage",bytes);
                    c.startActivity(intent);

                }
                if (models.get(position).getTitle().equals("Data Covid-19 Di Indonesia")){
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); // this object get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable(); //this will get our image from drawable

                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); //image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // it will compres our image

                    byte[] bytes =stream.toByteArray();
                    //get our data with intent

                    Intent intent = new Intent(c,Main2Activity.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc);  //get data and put in intent
                    intent.putExtra("iImage",bytes);
                    c.startActivity(intent);

                }
                if (models.get(position).getTitle().equals("Nomor Darurat Covid-19")){
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); // this object get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable(); //this will get our image from drawable

                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); //image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // it will compres our image

                    byte[] bytes =stream.toByteArray();
                    //get our data with intent

                    Intent intent = new Intent(c,HotlineActivity.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc);  //get data and put in intent
                    intent.putExtra("iImage",bytes);
                    c.startActivity(intent);


                }
                if (models.get(position).getTitle().equals("Daftar Rumah Sakit Rujukan Covid-19")){
                    //then you can move another activity from if body
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); // this object get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable(); //this will get our image from drawable

                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); //image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // it will compres our image

                    byte[] bytes =stream.toByteArray();
                    //get our data with intent

                    Intent intent = new Intent(c,Hospital.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc);  //get data and put in intent
                    intent.putExtra("iImage",bytes);
                    c.startActivity(intent);

                }

            }
        });
 }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
