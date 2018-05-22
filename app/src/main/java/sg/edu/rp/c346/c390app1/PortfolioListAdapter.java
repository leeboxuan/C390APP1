package sg.edu.rp.c346.c390app1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 16046473 on 8/1/2018.
 */

public class PortfolioListAdapter extends BaseAdapter {

    private ArrayList<GetPortfoliosFromFb> pdList;
    private LayoutInflater layoutInflater;

    static class ViewHolder{
        private TextView tvPdUrls;
    }

    public PortfolioListAdapter(Context context, ArrayList<GetPortfoliosFromFb> dataSet){
        this.pdList = dataSet;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pdList.size();
    }

    @Override
    public Object getItem(int position) {
        return pdList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GetPortfoliosFromFb device = pdList.get(position);
        ViewHolder holder;
        View view;
        if(convertView == null){
            holder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.list_of_urls, null);

            holder.tvPdUrls = (TextView) view.findViewById(R.id.tv_urls);
            view.setTag(holder);
        }
        else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        holder.tvPdUrls.setText(String.valueOf(device.getPdUrls()));
        return view;
    }
}
