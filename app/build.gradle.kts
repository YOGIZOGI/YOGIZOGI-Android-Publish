plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlinx-serialization")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "org.shop.yogizogi_android_publish"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.shop.yogizogi_android_publish"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
        viewBinding = true
    }
}

dependencies {
    val splashVersion: String by project
    val navigationVersion: String by project
    val hiltVersion: String by project
    val gsonVersion: String by project
    val retrofitVersion: String by project
    val okHttpVersion: String by project
    val dataStoreVersion: String by project
    val lottieVersion: String by project
    val readMoreVersion: String by project
    val picassoVersion: String by project
    val naverMapVersion: String by project
    val fusedLocationSourceVersion: String by project
    val tedpermissionVersion: String by project
    val rxandroidVersion: String by project
    val rxjavaVersion: String by project
    val rxkotlinVersion: String by project

    // Dagger-Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")

    // Splash Screen
    implementation("androidx.core:core-splashscreen:$splashVersion")

    // JetPack Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")

    // Gson
    implementation("com.squareup.retrofit2:converter-gson:$gsonVersion")

    // Retrofit2
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    // okHttp3
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:$dataStoreVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    // Lottie Animation
    implementation("com.airbnb.android:lottie:$lottieVersion")

    // ReadMoreTextView
    implementation("kr.co.prnd:readmore-textview:$readMoreVersion")

    // Picasso
    implementation("com.squareup.picasso:picasso:$picassoVersion")

    // 네이버 지도 SDK
    implementation("com.naver.maps:map-sdk:$naverMapVersion")

    // FusedLocationSource
    implementation("com.google.android.gms:play-services-location:$fusedLocationSourceVersion")

    // Ted Permission - RxJava3
    implementation("io.github.ParkSangGwon:tedpermission-rx3:$tedpermissionVersion")

    // RxAndroid와 RxJava, RxKotlin
    implementation("io.reactivex.rxjava3:rxandroid:$rxandroidVersion")
    implementation("io.reactivex.rxjava3:rxjava:$rxjavaVersion")
    implementation("io.reactivex.rxjava3:rxkotlin:$rxkotlinVersion")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}