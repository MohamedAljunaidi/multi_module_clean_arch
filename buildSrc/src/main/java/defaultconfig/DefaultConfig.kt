package defaultconfig

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import common.AppConfig
import org.gradle.api.JavaVersion

/**
 * Created by Mohammad Aljunaidi on 1/01/2023.
 *
 * The DefaultConfig for the app and library module are handled by the "DefaultConfig" object.
 */
object DefaultConfig {

    fun initAppDefaultConfig(baseAppModuleExtension: BaseAppModuleExtension) {
        baseAppModuleExtension.apply {
            compileSdk = AppConfig.AppConfigConstant.compileSdk
            buildToolsVersion = AppConfig.AppConfigConstant.buildToolsVersion
            defaultConfig {
                versionCode = AppConfig.AppConfigConstant.versionCode
                minSdk = AppConfig.AppConfigConstant.minSdk
                applicationId = AppConfig.AppConfigConstant.APPLICATION_ID
                targetSdk = AppConfig.AppConfigConstant.targetSdk
                versionName = AppConfig.AppConfigConstant.versionName
                testInstrumentationRunner = AppConfig.AppConfigConstant.testInstrumentationRunner

            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            buildFeatures {
                dataBinding = true
                buildConfig = true
            }

        }
    }

    fun initLibraryDefaultConfig(libraryExtension: LibraryExtension) {
        libraryExtension.apply {
            compileSdk = AppConfig.AppConfigConstant.compileSdk
            defaultConfig {
                minSdk = AppConfig.AppConfigConstant.minSdk
                testInstrumentationRunner = AppConfig.AppConfigConstant.testInstrumentationRunner
                consumerProguardFiles("consumer-rules.pro")
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            buildFeatures {
                dataBinding = true
                buildConfig = true
            }

        }
    }


}