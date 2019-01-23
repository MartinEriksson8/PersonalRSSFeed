package org.jeltz.vogon.personalrssfeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RssFeedsAdapter extends ArrayAdapter<RssFeed> {

    public RssFeedsAdapter(Context context, List<RssFeed> feeds) {
        super(context, 0, feeds);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        RssFeed feed = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rss_edit_feed_item_row, parent, false);
        }
        TextView feedAddress = (TextView) convertView.findViewById(R.id.rssEditFeedAddressTextView);
        TextView feedTitle = (TextView) convertView.findViewById(R.id.rssEditFeedTitleTextView);

        feedAddress.setText(feed.rssFeedAddress);
        feedTitle.setText(feed.rssFeedTitle);

        return convertView;
    }
}
