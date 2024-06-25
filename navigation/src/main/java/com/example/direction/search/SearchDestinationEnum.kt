package com.example.direction.search

import android.os.Parcelable
import com.example.navigation.bases.IBaseDestination
import com.example.navigation.constants.NavigationConstants
import kotlinx.parcelize.Parcelize

/**
 * Created by Mohammad Aljunaidi on 01/01/2024.
 */

@Parcelize
enum class SearchDestinationEnum : Parcelable, IBaseDestination {

    SEARCH {

        override fun getDestination(): String {
            return NavigationConstants.SEARCH_ROUTE
        }
    },

}

