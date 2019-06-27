package com.sonukumar.app.service.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Created by Sonu Kumar on 6/27/2019.
 */
class ArticleModel protected constructor(`in`: Parcel) : Parcelable {
    var status: String? = null
    var copyright: String? = null
    var num_results: Int = 0
    var results: List<ArticleModel>? = null
    var url: String? = null
    var adx_keywords: String? = null
    var column: String? = null
    var section: String? = null
    var byline: String? = null
    var type: String? = null
    var title: String? = null

    @SerializedName(value = "abstract")
    var abstract_data: String? = null
    var published_date: String? = null
    var source: String? = null
    var id: String? = null
    var asset_id: String? = null
    var views: Int = 0
    var media: ArrayList<ArticleModel>? = null
    var subtype: String? = null
    var caption: String? = null
    var approved_for_syndication: Int = 0
    @SerializedName(value = "media-metadata")
    var media_metadata: ArrayList<ArticleModel>? = null
    var format: String? = null

    init {
        status = `in`.readString()
        copyright = `in`.readString()
        num_results = `in`.readInt()
        results = `in`.createTypedArrayList(ArticleModel.CREATOR)
        url = `in`.readString()
        adx_keywords = `in`.readString()
        column = `in`.readString()
        section = `in`.readString()
        byline = `in`.readString()
        type = `in`.readString()
        title = `in`.readString()
        abstract_data = `in`.readString()
        published_date = `in`.readString()
        source = `in`.readString()
        id = `in`.readString()
        asset_id = `in`.readString()
        views = `in`.readInt()
        media = `in`.createTypedArrayList(ArticleModel.CREATOR)
        subtype = `in`.readString()
        caption = `in`.readString()
        approved_for_syndication = `in`.readInt()
        media_metadata = `in`.createTypedArrayList(ArticleModel.CREATOR)
        format = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(status)
        dest.writeString(copyright)
        dest.writeInt(num_results)
        dest.writeTypedList(results)
        dest.writeString(url)
        dest.writeString(adx_keywords)
        dest.writeString(column)
        dest.writeString(section)
        dest.writeString(byline)
        dest.writeString(type)
        dest.writeString(title)
        dest.writeString(abstract_data)
        dest.writeString(published_date)
        dest.writeString(source)
        dest.writeString(id)
        dest.writeString(asset_id)
        dest.writeInt(views)
        dest.writeTypedList(media)
        dest.writeString(subtype)
        dest.writeString(caption)
        dest.writeInt(approved_for_syndication)
        dest.writeTypedList(media_metadata)
        dest.writeString(format)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {

        val CREATOR: Parcelable.Creator<ArticleModel> = object : Parcelable.Creator<ArticleModel> {
            override fun createFromParcel(`in`: Parcel): ArticleModel {
                return ArticleModel(`in`)
            }

            override fun newArray(size: Int): Array<ArticleModel?> {
                return arrayOfNulls(size)
            }
        }
    }


     object CREATOR : Parcelable.Creator<ArticleModel> {
        override fun createFromParcel(parcel: Parcel): ArticleModel {
            return ArticleModel(parcel)
        }

        override fun newArray(size: Int): Array<ArticleModel?> {
            return arrayOfNulls(size)
        }
    }
}
