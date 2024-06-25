package common

/**
 *  The `AppConfig` object held all of the constants that we utilized in our Gradle project.
 */

object AppConfig {

    object AppConfigConstant {
        const val compileSdk = 34
        const val minSdk = 24
        const val targetSdk = 34
        const val versionName = "1.0.0"
        const val versionCode = 1
        const val buildToolsVersion = "34.0.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val JVM_TARGET = "1.8"
        const val APPLICATION_ID = "com.example.myapplication"
        const val APPLICATION_NAME = "News App"

    }
    object ManifestConstant {
        const val APPLICATION_LABEL_KEY = "applicationLabel"
        const val APPLICATION_LABEL_VALUE = "applicationlabel"
    }
    object BuildConfigField {
        const val BASE_URL_KEY = "BASE_URL"
        const val BASE_URL_VALUE = "base_url"
        const val API_KEY_KEY = "API_KEY"
        const val API_KEY_VALUE = "api_key"

    }

    object BuildTypeConstant {
        const val DEBUG = "debug"
        const val STAGING = "staging"
        const val RELEASE = "release"
    }

    object SignConfigConstant {
        const val RELEASE = "release"
        const val NEWS_KEY_STORE_PATH = "app/src/keystore/keystore.properties"
        const val KEY_ALIAS = "keyAlias"
        const val KEY_PASSWORD = "keyPassword"
        const val STORE_FILE = "storeFile"
        const val STORE_PASSWORD = "storePassword"
    }

    object ModulePathsConstant {
        const val CORE = ":core"
        const val NETWORK = ":network"
        const val CACHING = ":caching"
        const val NAVIGATION = ":navigation"
        const val THEME = ":theme"
        const val HELPER = ":helper"
        const val HOME = ":features:news"
        const val SEARCH = ":features:search"
    }


}