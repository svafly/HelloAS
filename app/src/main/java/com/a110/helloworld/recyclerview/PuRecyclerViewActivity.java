package com.a110.helloworld.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.a110.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PuRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_pu)
    RecyclerView rvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        ButterKnife.bind(this);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rvPu.setLayoutManager(staggeredGridLayoutManager);
        rvPu.addItemDecoration(new MyDecoration());
        rvPu.setAdapter(new PuAdapter(PuRecyclerViewActivity.this, new PuAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this,"click:"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeight3);
            outRect.set(gap,gap,gap,gap);
        }
    }
}
