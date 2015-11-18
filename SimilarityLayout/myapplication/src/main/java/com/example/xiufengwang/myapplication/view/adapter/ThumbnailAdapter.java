package com.example.xiufengwang.myapplication.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.xiufengwang.myapplication.R;
import com.example.xiufengwang.myapplication.moduel.PhotoInfoModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

import java.util.List;

/**
 * Created by xiufengwang on 2015/11/17.
 */
public class ThumbnailAdapter extends BaseAdapter {

    private Context mContext;
    private List<PhotoInfoModel> mPhotoList;
    private DisplayImageOptions mOptions;

    public ThumbnailAdapter(Context context, List<PhotoInfoModel> list) {
        this.mContext = context;
        this.mPhotoList = list;
        mOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new SimpleBitmapDisplayer()).build();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.thumbnail_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.display(mPhotoList.get(position));

//        viewHolder.mItem.setScaleType(ImageView.ScaleType.CENTER);
//        viewHolder.mItem.setImageURI(Uri.parse(mPhotoList.get(position).getPath_absolute()));
        return convertView;
    }


    public class ViewHolder {
        public ImageView mItem;

        public ViewHolder(View view) {
            mItem = (ImageView) view.findViewById(R.id.thumbnail_img);
            mItem.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }


        public void display(PhotoInfoModel model) {
            if (model != null) {
                ImageLoader.getInstance().displayImage(model.getPath_file(), mItem, mOptions);
            }
        }

    }
}
