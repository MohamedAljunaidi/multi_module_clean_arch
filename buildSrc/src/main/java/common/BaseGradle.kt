package common

import buildtype.BuildTypeApp
import buildtype.BuildTypeLibrary
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import defaultconfig.DefaultConfig
import org.gradle.api.Project

/**
 * Created by Mohammad Aljunaidi on 1/01/2023.
 *
 * All configurations for the app and library module are handled by the "BaseGradle" object.
 */
object BaseGradle {

    fun appGradle(baseAppModuleExtension: BaseAppModuleExtension, project: Project) {
        baseAppModuleExtension.apply {
            DefaultConfig.initAppDefaultConfig(baseAppModuleExtension = this)

//            SignConfigApp.initSignConfig(baseAppModuleExtension = this, project = project)

            BuildTypeApp.initAppBuildType(baseAppModuleExtension = this, project = project)
        }
    }


    fun libraryGradle(libraryExtension: LibraryExtension, project: Project) {
        libraryExtension.apply {
            DefaultConfig.initLibraryDefaultConfig(libraryExtension = this)
//            SignConfigLibrary.initSignConfig(libraryExtension = this, project = project)

            BuildTypeLibrary.initLibraryBuildType(libraryExtension = this, project = project)
        }
    }


}