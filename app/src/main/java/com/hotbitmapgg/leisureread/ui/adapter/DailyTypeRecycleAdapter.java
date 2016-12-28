package com.hotbitmapgg.leisureread.ui.adapter;

import com.bumptech.glide.Glide;
import com.hotbitmapgg.leisureread.mvp.model.entity.ThemeDailyInfo;
import com.hotbitmapgg.leisureread.widget.recycler.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.rxzhihu.R;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hcc on 2016/12/28 13:35
 * 100332338@qq.com
 * LeisureRead
 *
 * @HotBitmapGG 主题日报列表Adapter
 */
public class DailyTypeRecycleAdapter extends AbsRecyclerViewAdapter {

  private List<ThemeDailyInfo.OthersBean> others = new ArrayList<>();


  public DailyTypeRecycleAdapter(RecyclerView recyclerView, List<ThemeDailyInfo.OthersBean> others) {

    super(recyclerView);
    this.others = others;
  }


  @Override
  public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    bindContext(parent.getContext());
    return new ItemViewHolder(
        LayoutInflater.from(getContext()).inflate(R.layout.item_themes_daily, parent, false));
  }


  @Override
  public void onBindViewHolder(ClickableViewHolder holder, int position) {

    super.onBindViewHolder(holder, position);

    if (holder instanceof ItemViewHolder) {
      ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
      itemViewHolder.mName.setText(others.get(position).getName());
      Glide.with(getContext())
          .load(others.get(position).getThumbnail())
          .placeholder(R.drawable.account_avatar)
          .into(itemViewHolder.mImage);
      itemViewHolder.mDes.setText(others.get(position).getDescription());
    }
  }


  @Override
  public int getItemCount() {

    return others.size();
  }


  public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

    public TextView mName;

    public ImageView mImage;

    public TextView mDes;


    public ItemViewHolder(View itemView) {

      super(itemView);
      mName = $(R.id.item_type_name);
      mImage = $(R.id.item_type_img);
      mDes = $(R.id.item_type_des);
    }
  }
}
