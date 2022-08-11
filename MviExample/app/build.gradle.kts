import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())
android {
    compileSdk = DefaultConfig.COMPILE_SDK

    defaultConfig {
        applicationId = DefaultConfig.APPLICATION_ID
        minSdk = DefaultConfig.MIN_SDK
        targetSdk = DefaultConfig.TARGET_SDK
        versionCode = DefaultConfig.VERSION_CODE
        versionName = DefaultConfig.VERSION_NAME
        testInstrumentationRunner = DefaultConfig.TEST_INSTRUMENTATION_RUNNER
        buildConfigField("String", "BASE_URL", properties.getProperty("BASE_URL"))
        buildConfigField("String", "GITHUB_TOKEN", properties.getProperty("GITHUB_TOKEN"))
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    addAndroidXDependencies()
    addTestDependencies()
    addNetworkDependencies()
    addNavigationDependencies()
    addDaggerHiltDependencies()
    addLifecycleDependencies()
    implementation(Dependencies.ThirdPartyDep.COIL)
    implementation(Dependencies.ThirdPartyDep.GSON)
    implementation(Dependencies.ThirdPartyDep.COROUTINES)

    // Import Module
    implementation(project(Modules.CORE_MODULE))
    implementation(project(Modules.COMMON_MODULE))
    implementation(project(Modules.HOME_MODULE))
    implementation(project(Modules.FRIENDS_MODULE))
    implementation(project(Modules.MY_PAGE_MODULE))
    implementation(project(Modules.LOGIN_MODULE))

}