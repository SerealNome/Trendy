package caplan.innovations.trendy.recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caplan.innovations.trendy.R;
import caplan.innovations.trendy.model.NewsItem;

/**
 * Created by Corey Caplan on 1/20/17.
 * Project: Trendy
 * <p></p>
 * Purpose of Class: To represent a single item of the news, in our news feed
 */
class NewsViewHolder extends RecyclerView.ViewHolder {

    /**
     * A listener used to pass click events from this holder to the adapter
     * <p></p>
     * This interface is useful for passing actions to many different adapters.
     */
    interface OnNewsActionListenerInternal {

        /**
         * Called when the base view holder is clicked
         *
         * @param position The position at which the click occurred.
         */
        void onNewsClickInternal(int position);

        /**
         * Called when the favorite button is clicked
         *
         * @param position The position at which the click occurred
         */
        void onFavoriteClick(int position);
    }

    @BindView(R.id.news_feed_image)
    ImageView mImageView;

    @BindView(R.id.news_feed_title_text_view)
    TextView mTitleTextView;

    @BindView(R.id.news_feed_author_text_view)
    TextView mAuthorTextView;

    @BindView(R.id.news_feed_favorite_button)
    ImageButton mImageButton;

    private OnNewsActionListenerInternal mListenerInternal;

    NewsViewHolder(View itemView, OnNewsActionListenerInternal listenerInternal) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mListenerInternal = listenerInternal;
    }

    void bind(NewsItem newsItem) {
        mTitleTextView.setText(newsItem.getTitle());
        mAuthorTextView.setText(newsItem.getAuthor());
//        TODO image

        if (newsItem.isFavorite()) {
            mImageButton.setImageResource(R.drawable.ic_favorite_black_24dp);
        } else {
            mImageButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }
    }

    @OnClick(R.id.news_feed_container)
    void onNewsItemClick() {
        // Use the adapter position to get the position of the click
        int position = getAdapterPosition();
        mListenerInternal.onNewsClickInternal(position);
    }

    @OnClick(R.id.news_feed_favorite_button)
    void onFavoriteButtonClick() {
        // Use the adapter position to get the position of the click
        int position = getAdapterPosition();
        mListenerInternal.onFavoriteClick(position);
    }

}
