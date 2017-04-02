package model;

/**
 * Created by shilpi.das on 25-08-2016.
 */
public class RowGridViewModel {
    private String mSpotName;
    private int mSpotImage;

    public String getmSpotName() {
        return mSpotName;
    }

    public void setmSpotName(String mSpotName) {
        this.mSpotName = mSpotName;
    }

    public int getmSpotImage() {
        return mSpotImage;
    }

    public void setmSpotImage(int mSpotImage) {
        this.mSpotImage = mSpotImage;
    }

    public RowGridViewModel(String mSpotName, int mSpotImage) {
        this.mSpotName = mSpotName;
        this.mSpotImage = mSpotImage;
    }
}
