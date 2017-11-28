package signs.cursoandroid.com.signs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by diogo on 28/11/17.
 */

public class CustomAdapter extends ArrayAdapter<String>{

    String[] texts;
    int [] imgs;
    Context mContext;

    public CustomAdapter(Context context, int[] imgs, String [] texts){
        super(context, R.layout.listview_item, texts);
        this.imgs = imgs;
        this.texts = texts;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder mViewHolder = null;
        if(r == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            r = inflater.inflate(R.layout.listview_item,null,true);
            mViewHolder = new ViewHolder(r);
            r.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) r.getTag();
        }

        mViewHolder.mImgs.setImageResource(imgs[position]);
        mViewHolder.mTexts.setText(texts[position]);

        return r;
    }

    class ViewHolder{
        ImageView mImgs;
        TextView mTexts;

        ViewHolder(View v){
            mImgs = v.findViewById(R.id.imageViewID);
            mTexts = v.findViewById(R.id.textViewID);
        }


    }
}
