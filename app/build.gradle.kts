plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.chatspace"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.chatspace"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/DEPENDENCIES"
            excludes +="META-INF/LICENSE"
            excludes +="META-INF/LICENSE.txt"
            excludes +="META-INF/NOTICE"
            excludes +="META-INF/NOTICE.txt"
            excludes +="mozilla/public-suffix-list.txt"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.5")
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    //compose
//    implementation("androidx.compose.material:material-icons-extended")
//    //ViewModel
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.5")
//    //ViewModel utilities for compose
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5")
//
//    implementation("androidx.compose.runtime:runtime-livedata:1.7.1")
//    //Coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    //dagger-hilt dependencies
    implementation("com.google.dagger:hilt-android:2.49")
    kapt("com.google.dagger:hilt-android-compiler:2.49")
    //kapt("androidx.hilt:hilt-compiler:1.2.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.7.0")
    //Navigation
    implementation("androidx.navigation:navigation-compose:2.8.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //firebase
   // implementation("com.google.firebase.crashlytics:com.google.firebase.crashlytics.gradle.plugin:3.0.2")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.firebase:firebase-analytics:22.1.0")
    implementation("com.google.firebase:firebase-storage:21.0.0")
    //noinspection BomWithoutPlatform
    implementation("com.google.firebase:firebase-bom:33.3.0")

    implementation ("com.google.firebase:firebase-messaging:24.0.1")

    implementation ("com.android.volley:volley:1.2.1")

    implementation ("com.google.auth:google-auth-library-oauth2-http:1.19.0")
//
//    implementation("com.github.ZEGOCLOUD:zego_uikit_prebuilt_call_android:+")
//    implementation("com.guolindev.permissionx:permissionx:1.8.0")
}
