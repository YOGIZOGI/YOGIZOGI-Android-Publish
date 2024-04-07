// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    // Define extra properties
    extra["splashVersion"] = "1.1.0-alpha02"
    extra["navigationVersion"] = "2.7.7"
    extra["hiltVersion"] = "2.48"
    extra["gsonVersion"] = "2.9.0"
    extra["retrofitVersion"] = "2.9.0"
    extra["okHttpVersion"] = "5.0.0-alpha.11"
    extra["dataStoreVersion"] = "1.0.0"
    extra["lottieVersion"] = "6.2.0"
    extra["readMoreVersion"] = "1.0.0"
    extra["picassoVersion"] = "2.8"
    extra["naverMapVersion"] = "3.17.0"
    extra["fusedLocationSourceVersion"] = "21.2.0"
    extra["tedpermissionVersion"] = "3.3.0"
    extra["rxjavaVersion"] = "3.1.0"
    extra["rxkotlinVersion"] = "3.0.0"
    extra["rxandroidVersion"] = "3.0.0"

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.22")
        // Use the navigationVersion defined in the extra properties
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
    }
}
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}