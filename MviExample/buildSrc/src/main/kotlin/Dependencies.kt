object Dependencies {
    object AndroidXDep {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VERSION}"
        const val CONSTRAINT_LAYOUT ="androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX_VERSION}"
        const val CARD_VIEW = "androidx.cardview:cardview:${Versions.CARD_VIEW_VERSION}"
        const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW_VERSION}"
    }

    object LifecycleDep {
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
        const val LIVEDATA =  "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"
    }

    object NavigationDep {
        const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    }

    object ThirdPartyDep {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_DESIGN_VERSION}"
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT_VERSION}"

        const val GSON = "com.google.code.gson:gson:${Versions.GSON_VERSION}"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
        const val RETROFIT ="com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
        const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_VERSION}"

        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES_VERSION}"

        const val COIL = "io.coil-kt:coil:${Versions.COIL_VERSION}"
    }

    object TestDep {
        const val JUNIT = "junit:junit:${Versions.JUNIT_VERSION}"
    }

    object AndroidTestDep {
        const val TEST_JUNIT_EXT = "androidx.test.ext:junit:${Versions.TEST_EXT_JUNIT_VERSION}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}"
    }

    object Plugins {
        const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT_VERSION}"
        const val SAFE_ARGS_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION_VERSION}"
    }
}