package mrs.riverjach.blocnote.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Note(
    var titre: String? = "",
    var contenu: String? = "",
    var cat: Int = 0,
    var filename: String? = ""
) : Parcelable, Serializable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titre)
        parcel.writeString(contenu)
        parcel.writeInt(cat)
        parcel.writeString(filename)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {

        private val serialVersionUid: Long = 444444444
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

}