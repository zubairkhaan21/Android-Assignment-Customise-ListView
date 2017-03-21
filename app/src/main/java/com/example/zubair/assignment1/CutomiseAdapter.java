package com.example.zubair.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Zubair on 3/21/2017.
 */

public class CutomiseAdapter extends BaseAdapter {

    ArrayList<CostomiseList> list;
    Context context;
    CutomiseAdapter(Context c){
        context = c;
        list = new ArrayList<CostomiseList>();
        String [] nameArray = c.getResources().getStringArray(R.array.names);
        String [] numberArray = c.getResources().getStringArray(R.array.numbers);

        int [] circles =  {R.drawable.circle1,R.drawable.circle2,R.drawable.circle3,R.drawable.circle5,R.drawable.circle5};

        for (int i=1;i<5;i++){
           list.add(new CostomiseList (nameArray[i],numberArray[i],circles[i]));
        }
    }
    
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customList = inflater.inflate(R.layout.customise_list_view,parent,false);

        TextView name = (TextView)customList.findViewById(R.id.tvName);
        TextView number = (TextView)customList.findViewById(R.id.tvNumber);
        ImageView circle = (ImageView)customList.findViewById(R.id.imageview);
        CostomiseList obj=list.get(position);

        name.setText(obj.personNames);
        number.setText(obj.mobileNumbers);
        circle.setImageResource(obj.circles);

        return customList;
    }
}
