package com.royzed.simple_bg_location.domain.location

import android.annotation.SuppressLint
import android.location.LocationRequest
import io.flutter.Log

enum class LocationAccuracy {
    Lowest {
        @SuppressLint("InlinedApi")
        override fun toLocationRequestQuality(): Int = LocationRequest.QUALITY_LOW_POWER
        override fun toGoogleLocationRequestQuality(): Int =
            com.google.android.gms.location.LocationRequest.PRIORITY_NO_POWER
    },
    Low {
        @SuppressLint("InlinedApi")
        override fun toLocationRequestQuality(): Int = LocationRequest.QUALITY_LOW_POWER
        override fun toGoogleLocationRequestQuality(): Int =
            com.google.android.gms.location.LocationRequest.PRIORITY_LOW_POWER
        },
    Medium {
        @SuppressLint("InlinedApi")
        override fun toLocationRequestQuality(): Int = LocationRequest.QUALITY_BALANCED_POWER_ACCURACY
        override fun toGoogleLocationRequestQuality(): Int =
            com.google.android.gms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
           },
    High {
        @SuppressLint("InlinedApi")
        override fun toLocationRequestQuality(): Int = LocationRequest.QUALITY_HIGH_ACCURACY
        override fun toGoogleLocationRequestQuality(): Int  =
            com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
         },
    Best {
        @SuppressLint("InlinedApi")
        override fun toLocationRequestQuality(): Int = LocationRequest.QUALITY_HIGH_ACCURACY
        override fun toGoogleLocationRequestQuality(): Int =
            com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
         },
    BestForNavigation {
        @SuppressLint("InlinedApi")
        override fun toLocationRequestQuality(): Int = LocationRequest.QUALITY_HIGH_ACCURACY
        override fun toGoogleLocationRequestQuality(): Int =
            com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
    };

    abstract fun toLocationRequestQuality(): Int
    abstract fun toGoogleLocationRequestQuality(): Int

    companion object {
        private const val TAG = "LocationAccuracy"

        fun fromInt(v: Int): LocationAccuracy {
            return try {
                LocationAccuracy.values()[v]
            } catch(e: ArrayIndexOutOfBoundsException) {
                Log.w(TAG,"$v out of bounds LocationAccuracy.")
                LocationAccuracy.Lowest
            }
        }
    }
}