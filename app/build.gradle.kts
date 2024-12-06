import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlinx.serialization)
    id("org.jetbrains.kotlin.kapt")
    id("kotlin-kapt")

    // google-services plugin 추가
    id("com.google.gms.google-services")
}

android {
    namespace = "com.aurora.carevision"
    compileSdk = 34

    // local.properties에서 값을 가져오기 위해 properties 객체 생성
    val properties = Properties().apply {
        load(rootProject.file("local.properties").inputStream())
    }

    defaultConfig {
        applicationId = "com.aurora.carevision"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        // BuildConfig에 CV_BASE_URL_DEV 필드에 properties에서 가져온 값 추가
        // properties에서 가져온 값은 local.properties CV_BASE_URL_DEV에 저장되어 있음
        buildConfigField("String", "CV_BASE_URL_DEV", "${properties.getProperty("cv.base.url.dev")}")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
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
        compose = true
        // buildConfig를 사용하기 위해 추가
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.services.mlkit.barcode.scanning)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.core)
    implementation(libs.hilt.navigation.compose)

    // navigation
    implementation(libs.compose.navigation)
    implementation(libs.kotlinx.serialization.json)

    // splash
    implementation(libs.splash.screen)

    // retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.kotlin.serialization)

    // okhttp : Retrofit으로 받는 데이터를 로그로 확인하기 위해
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.logging.interceptor)

    // Timber
    implementation (libs.timber)

    // streaming & videoView
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)
    implementation(libs.rstp)
    implementation(libs.accompanist.permissions)

    // firebase
    // Import the Firebase BoM
    implementation(libs.firebase.bom)


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation(libs.firebase.analytics)

}