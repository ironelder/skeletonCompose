plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
//    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.ironelder.skeletoncompose"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "API_KEY", "\"e17c2715face752d9ed1a2a0054aa7d6\"")
        buildConfigField("String", "LANGUAGE", "\"en-US\"")
        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1" // compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation ("androidx.core:core-ktx:1.7.0")

    //compose
    implementation ("androidx.compose.ui:ui:1.1.1") // compose_version
    implementation ("androidx.compose.material:material:1.1.1") // compose_version
    implementation ("androidx.compose.ui:ui-tooling-preview:1.1.1") // compose_version
    implementation ("androidx.compose.runtime:runtime:1.1.1")
    implementation ("androidx.compose.runtime:runtime-livedata:1.1.1")
    implementation ("androidx.compose.ui:ui:1.1.1")
    implementation ("androidx.compose.ui:ui-tooling:1.1.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.1.1")
    implementation ("androidx.compose.foundation:foundation:1.1.1")
    implementation ("androidx.compose.foundation:foundation-layout:1.1.1")
    implementation ("androidx.compose.animation:animation:1.1.1")
    implementation ("androidx.compose.material:material:1.1.1")
    implementation ("androidx.compose.ui:ui-viewbinding:1.1.1")

    //androidx
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    implementation ("androidx.activity:activity-compose:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation ("androidx.paging:paging-compose:1.0.0-alpha14")
    implementation ("androidx.navigation:navigation-compose:2.4.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.0")

    //coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")

    //dagger-hilt
    kapt ("com.google.dagger:hilt-compiler:2.42")
    implementation ("com.google.dagger:hilt-android:2.42")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")

    //Log
    implementation ("com.jakewharton.timber:timber:5.0.1")

    //image
    implementation ("io.coil-kt:coil-compose:2.1.0")
    implementation ("com.airbnb.android:lottie-compose:4.2.2")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.1.1")  // compose_version
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.1.1")// compose_version
}