package com.gl.webviewsample;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {
    private WebView mWebView;
    private View view;
    private TextView mTvWebFragment;

    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_web_view, container, false);
        String url = getArguments().getString(Strings.URL);
        mWebView = (WebView) view.findViewById(R.id.web_view);
        mTvWebFragment = (TextView) view.findViewById(R.id.tvWebView);
        mWebView.getSettings().setJavaScriptEnabled(true);


        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
                mTvWebFragment.setText("Page is loading please wait");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mTvWebFragment.setVisibility(View.INVISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                mTvWebFragment.setVisibility(View.VISIBLE);
                mTvWebFragment.setText("No connection");
                Toast.makeText(getActivity(), "Your Internet Connection May not be active Or ", Toast.LENGTH_LONG).show();
                Log.e("Error", "error");
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                mTvWebFragment.setVisibility(View.VISIBLE);
                mTvWebFragment.setText("No connection");
                Toast.makeText(getActivity(), "Your Internet Connection May not be active Or " + error, Toast.LENGTH_LONG).show();
                Log.e("Error", "error");
            }
        });
        mWebView.loadUrl(url);


        return view;
    }


}
