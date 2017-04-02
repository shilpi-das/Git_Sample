package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gl.listviewsample.R;

import java.util.List;

import model.RowListViewModel;

/**
 * Created by shilpi.das on 24-08-2016.
 */
public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<RowListViewModel> mListRowItem;

    public ListViewAdapter(Context context, List<RowListViewModel> mListRowItem) {
        this.context = context;
        this.mListRowItem = mListRowItem;
    }

    @Override
    public int getCount() {
        return mListRowItem.size();
    }

    @Override
    public RowListViewModel getItem(int i) {
        return mListRowItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mListRowItem.get(i).hashCode();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //if convertview==null then inflate convertview for the 1st time and set tag
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.tvCountryName = (TextView) convertView.findViewById(R.id.tvCountryName);
            viewHolder.tvCountrySpot = (TextView) convertView.findViewById(R.id.tvCountrySpot);
            viewHolder.ivCountryName = (ImageView) convertView.findViewById(R.id.ivCountry);
            viewHolder.ivCountrySpot = (ImageView) convertView.findViewById(R.id.ivSpot);
            convertView.setTag(viewHolder);
        } else {
            //else get the convert view tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //get object of RowListViewModel
        RowListViewModel rowListViewModel = (RowListViewModel) getItem(i);
        //populating view holder objects
        viewHolder.tvCountryName.setText(rowListViewModel.getmCountry());
        viewHolder.tvCountrySpot.setText(rowListViewModel.getmPlace());
        viewHolder.ivCountryName.setImageResource(rowListViewModel.getmCountryFlagImage());
        viewHolder.ivCountrySpot.setImageResource(rowListViewModel.getmCountrySpot());

        return convertView;
    }


    //Private class viewHolder
    private class ViewHolder {
        TextView tvCountryName;
        TextView tvCountrySpot;
        ImageView ivCountryName;
        ImageView ivCountrySpot;
    }
}




