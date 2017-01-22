package caplan.innovations.trendy.fragments;

import caplan.innovations.trendy.network.NewsNetwork;
import caplan.innovations.trendy.receivers.NewsBroadcastReceiver;

/**
 * Created by Corey Caplan on 1/21/17.
 * Project: Trendy
 * <p></p>
 * Purpose of Class: A fragment that gets its news from BBC News
 */
public class BbcNewsFragment extends BaseNewsFragment {

    @Override
    int getNewsType() {
        return NewsNetwork.NEWS_BBC;
    }

    @Override
    String getNewsIntentFilter() {
        return NewsBroadcastReceiver.INTENT_FILTER_BBC_NEWS;
    }

}
