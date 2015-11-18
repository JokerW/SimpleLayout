package com.example.xiufengwang.myapplication.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.xiufengwang.myapplication.R;
import com.example.xiufengwang.myapplication.moduel.PhotoInfoModel;

import java.util.List;

/**
 * Created by xiufengwang on 2015/11/17.
 */
public class ThumbnailAdapter extends BaseAdapter {

    private Context mContext;
    private List<PhotoInfoModel> mPhotoList;

    public ThumbnailAdapter(Context context, List<PhotoInfoModel> list) {
        this.mContext = context;
        this.mPhotoList = list;
    }

    @Override
    public int getCount() {
        return mPhotoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPhotoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.thumbnail_item, null);
            viewHolder.mItem = (ImageView) convertView.findViewById(R.id.thumbnail_img);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mItem.setImageURI(Uri.parse(mPhotoList.get(position).getPath_absolute()));
        return convertView;
    }

    public class ViewHolder {
        public ImageView mItem;
    }
}
