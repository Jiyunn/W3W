package me.happy.win3win.fragment.tab.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import me.happy.win3win.R;
import me.happy.win3win.databinding.ItemJobBinding;
import me.happy.win3win.fragment.CompanyInfoFragment;
import me.happy.win3win.fragment.tab.model.Gonggo;

import static me.happy.win3win.R.drawable.group_4;
import static me.happy.win3win.R.drawable.group_5;

/**
 * Created by JY on 2017-04-15.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.JobViewHolder> implements View.OnClickListener{

    private Context context;
    private List<Gonggo> gongos;
    private int itemLayout;
    private RecyclerView mRecyclerview;
    private FragmentManager fgManager;

    public GroupAdapter(Context context, List<Gonggo> gongos, int itemLayout, RecyclerView mRecyclerview, FragmentManager fgManager) {
        this.context = context;
        this.gongos=gongos;
        this.itemLayout = itemLayout;
        this.mRecyclerview=mRecyclerview;
        this.fgManager=fgManager;
    }


    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        itemView.setOnClickListener(this);

        return new JobViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, final int position) {
        Gonggo gonggo = gongos.get(position);
        holder.binding.setItem(gonggo);

        /*
        로고 이미지와, 근무지부분 , 연봉부분
         */
        Glide.with(context)
                .load(gongos.get(position).getThumbnail())
                .thumbnail(0.05f)
                .into(holder.binding.itemJobLogo);

        holder.binding.itemJobContent3.setText(gongos.get(position).convertGeunmujySido() + " | " +
                gongos.get(position).getGyjogeonCdNm());
        holder.binding.itemJobContent4.setText(
                (gongos.get(position).convertMagamDt()) + " | "+
                        (gongos.get(position).getGyeongryeokGbcdNm()) + " | " +
                        (gongos.get(position).getCjhakryeok()));

    }

    @Override
    public int getItemCount() {
        return (gongos != null) ? gongos.size() : 0;
    }


    /*show company's info specific*/
    @Override
    public void onClick(View v) {
        int curPos= mRecyclerview.getChildAdapterPosition(v); //클릭된 차일드의 현재 포지션
        Gonggo clickGongo=gongos.get(curPos); //클릭한 공고

        CompanyInfoFragment companyInfoFragment=new CompanyInfoFragment();

        Bundle args=new Bundle();
        args.putInt("CUR_ID", clickGongo.getId());

        fgManager
                .beginTransaction()
                .replace(R.id.frag, companyInfoFragment.newInstance(clickGongo.getId(), clickGongo.getThumbnail()))
                .addToBackStack(null) //saved state
                .commit();
    }



    /*JobViewHolder class*/
    public class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemJobBinding binding;


        public JobViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            binding= DataBindingUtil.bind(itemView);

            binding.itemJobFavorite.setOnClickListener(this);
        }



        public void onClick(View v) {
            if (v.getId() == R.id.item_jobFavorite) {
                if (v.getTag().equals("group_5")) {
                    v.setBackgroundResource(group_4);
                    v.setTag("group_4");
                    Toast.makeText(context, "관심기업에 추가되었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    v.setBackgroundResource(group_5);
                    v.setTag("group_5");
                    Toast.makeText(context, "관심기업이 해제되었습니다", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}


