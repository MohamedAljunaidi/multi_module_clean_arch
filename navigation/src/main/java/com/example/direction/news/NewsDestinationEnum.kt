package com.example.direction.news

import android.os.Parcelable
import com.example.navigation.bases.IBaseDestination
import com.example.navigation.constants.NavigationConstants
import kotlinx.parcelize.Parcelize

/**
 * Created by Mohammad Aljunaidi on 01/01/2024.
 */

@Parcelize
enum class NewsDestinationEnum : Parcelable, IBaseDestination {

    News {

        override fun getDestination(): String {
            return NavigationConstants.NEWS_PATH
        }
    },
    NEWS_DETAILS {

        override fun getDestination(): String {
            return NavigationConstants.NEWS_DETAILS_PATH
        }
    },


}

