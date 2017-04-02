package model;

/**
 * Created by shilpi.das on 24-08-2016.
 */
public class RowListViewModel {
    private String mCountry;
    private String mPlace;
    private int mCountryFlagImage;
    private int mCountrySpot;

    public RowListViewModel(String mCountry, String mPlace, int mCountryFlagImage, int mCountrySpot) {
        this.mCountry = mCountry;
        this.mPlace = mPlace;
        this.mCountryFlagImage = mCountryFlagImage;
        this.mCountrySpot = mCountrySpot;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmPlace() {
        return mPlace;
    }

    public void setmPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    public int getmCountryFlagImage() {
        return mCountryFlagImage;
    }

    public void setmCountryFlagImage(int mCountryFlagImage) {
        this.mCountryFlagImage = mCountryFlagImage;
    }

    public int getmCountrySpot() {
        return mCountrySpot;
    }

    public void setmCountrySpot(int mCountrySpot) {
        this.mCountrySpot = mCountrySpot;
    }
}
