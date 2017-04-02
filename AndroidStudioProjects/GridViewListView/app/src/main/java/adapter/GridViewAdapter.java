package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import model.RowGridViewModel;

/**
 * Created by shilpi.das on 25-08-2016.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<RowGridViewModel> mListRowItem;
    private LayoutInflater layoutInflater;
    public GridViewAdapter(Context context, List<RowGridViewModel> mListRowItem) {
        this.context = context;
        this.mListRowItem = mListRowItem;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mListRowItem.size();
    }

    @Override
    public RowGridViewModel getItem(int i) {
        return mListRowItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mListRowItem.get(i).hashCode();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        //if convertview==null then inflate convertview for the 1st time and set tag
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item_layout, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.tvSpotName = (TextView) convertView.findViewById(R.id.tvGridViewSpotName);
            viewHolder.ivSpotImage = (ImageView) convertView.findViewById(R.id.ivGridViewSpotImage);
            convertView.setTag(viewHolder);
        } else {
            //else get the convert view tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //get object of RowListViewModel
        RowGridViewModel rowGridViewModel = (RowGridViewModel) getItem(i);
        //populating view holder objects
        viewHolder.tvSpotName.setText(rowGridViewModel.getmSpotName());
        viewHolder.ivSpotImage.setImageResource(rowGridViewModel.getmSpotImage());
        return convertView;
    }


    //Private class viewHolder
    private class ViewHolder {
        TextView tvSpotName;
        ImageView ivSpotImage;
    }
}
