package com.a110.helloworld.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_grid)
    RecyclerView rvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        ButterKnife.bind(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(GridRecyclerViewActivity.this,3);
        rvGrid.setLayoutManager(gridLayoutManager);
        rvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this,"click..."+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
