package com.example.petfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private List<PostModel> postList;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Pet Finder");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        postList = new ArrayList<PostModel>();

        for (int i=0; i<5; i++) {
            PostModel postModel = new PostModel();
            postModel.username = "dhruwill";
            postModel.caption = "dhruwill Will I be defined by things that could've been? #AlterBridge #MylesKennedy #HardRock #Kashmir";
            postList.add(postModel);
        }

        PostAdapter postAdapter = new PostAdapter(postList);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

        private List<PostModel> postList;

        public PostAdapter(List<PostModel> postModelList) {
            postList = postModelList;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView imageView;
            public TextView txtUserName;
            public TextView txtCaption;
            public TextView txtComments;

            public ViewHolder(View itemView) {
                super(itemView);
                txtUserName = (TextView) itemView.findViewById(R.id.txtUserName);
                txtCaption = (TextView) itemView.findViewById(R.id.txtCaption);
                txtComments = (TextView) itemView.findViewById(R.id.txtComments);
                imageView = (ImageView) itemView.findViewById(R.id.imageViewPost);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            LayoutInflater inflater  = LayoutInflater.from(context);
            View postView = inflater.inflate(R.layout.item_home, viewGroup, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(postView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull PostAdapter.ViewHolder viewHolder, int i) {
            PostModel postModel = postList.get(i);

            TextView txtName = viewHolder.txtUserName;
            txtName.setText(postModel.username);
            TextView txtCaption = viewHolder.txtCaption;
            txtCaption.setText(postModel.caption);
            TextView txtComment = viewHolder.txtComments;
            txtComment.setText("View all comments");
            ImageView imageView = viewHolder.imageView;
            imageView.setImageResource(R.drawable.wallpaper);
        }

        @Override
        public int getItemCount() {
            return postList.size();
        }
    }
}
