package kr.happy.myarmy.Recyclerview;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.happy.myarmy.R;

/**
 * Created by JY on 2017-04-12.
 */

public class RegionViewHolder extends RecyclerView.ViewHolder {

    @Nullable @BindView(R.id.img_comLogo) ImageView logo;
    @Nullable @BindView(R.id.tv_comTitle) TextView title;
    @Nullable @BindView(R.id.tv_comContent1) TextView content;

    public RegionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
