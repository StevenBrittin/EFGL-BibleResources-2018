package sti.bibleresources;

import android.os.Parcel;
import android.os.Parcelable;

public class BibleStudy implements Parcelable {

    // Empty Constructor
    public BibleStudy() {
    }

    // Reference to the resource id where the logo is stored
    private int mLogoId;

    public int getLogoId() {
        return mLogoId;
    }
    public void setLogoId(int logo) {
        this.mLogoId = logo;
    }

    private Language mLanguage = Language.Romanian;
    public Language getLanguage() {
        return mLanguage;
    }
    public void setLanguage(Language mLanguage) {
        this.mLanguage = mLanguage;
    }

    public String mTitleRu;
    public String getTitleRu() {
        return mTitleRu;
    }
    public void setTitleRu(String mTitleRu) {
        this.mTitleRu = mTitleRu;
    }

    public String mTitleRo;
    public String getTitleRo() {
        return mTitleRo;
    }
    public void setTitleRo(String mTitleRo) {
        this.mTitleRo = mTitleRo;
    }

    public String mTitleEn;
    public String getTitleEn() {
        return mTitleEn;
    }
    public void setTitleEn(String mTitleEn) {
        this.mTitleEn = mTitleEn;
    }

    public String getTitle() {
        switch (mLanguage) {
            case Russian:
                return mTitleRu;
            case Romanian:
                return mTitleRo;
            default:
                return mTitleEn;
        }
    }
    private String mDescriptionRu;
    public String getDescriptionRu() {
        return mDescriptionRu;
    }
    public void setDescriptionRu(String description) {
        this.mDescriptionRu = description;
    }

    private String mDescriptionRo;
    public String getDescriptionRo() {
        return mDescriptionRo;
    }
    public void setDescriptionRo(String description) {
        this.mDescriptionRo = description;
    }

    private String mDescriptionEn;
    public String getDescriptionEn() {
        return mDescriptionEn;
    }
    public void setDescriptionEn(String description) {
        this.mDescriptionEn = description;
    }

    public String getDescription() {
        switch (mLanguage) {
            case Russian:
                return mDescriptionRu;
            case Romanian:
                return mDescriptionRo;
            default:
                return mDescriptionEn;
        }
    }

    private String mPhone;
    public String getPhone() {
        return mPhone;
    }
    public void setPhone(String phone) {
        this.mPhone = phone;
    }

    private String mLocation;
    public String getLocation() {
        return mLocation;
    }
    public void setLocation(String location) {
        this.mLocation = location;
    }

    private String mWebAddress;
    public String getWebAddress() {
        return mWebAddress;
    }
    public void setWebAddress(String webAddress) {
        this.mWebAddress = webAddress;
    }

    private String mEmail;
    public String getEmail() {
        return mEmail;
    }
    public void setEmail(String email) {
        this.mEmail = email;
    }

    // Parcel Implementation

    @Override
    public int describeContents() {
        return 0;
    }

    // Writes out to the parcel and the constructor reads the data back in
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mLogoId);
        parcel.writeString(mTitleEn);
        parcel.writeString(mTitleRo);
        parcel.writeString(mTitleRu);
        parcel.writeString(mDescriptionEn);
        parcel.writeString(mDescriptionRo);
        parcel.writeString(mDescriptionRu);
        parcel.writeString(mLocation);
        parcel.writeString(mPhone);
        parcel.writeString(mWebAddress);
        parcel.writeString(mEmail);
    }

    // Parcel Support outside of the interface

    // Constructor needs to read the data in the same order as it was placed in the write
    public BibleStudy(Parcel in) {
        this.mLogoId = in.readInt();
        this.mTitleEn = in.readString();
        this.mTitleRo = in.readString();
        this.mTitleRu = in.readString();
        this.mDescriptionEn = in.readString();
        this.mDescriptionRo = in.readString();
        this.mDescriptionRu = in.readString();
        this.mLocation = in.readString();
        this.mPhone = in.readString();
        this.mWebAddress = in.readString();
        this.mEmail = in.readString();
    }

    //
    public static final Parcelable.Creator<BibleStudy> CREATOR
            = new Parcelable.Creator<BibleStudy>() {

        public BibleStudy createFromParcel(Parcel in) {
            return new BibleStudy(in);
        }

        public BibleStudy[] newArray(int size) {
            return new BibleStudy[size];
        }
    };
}
