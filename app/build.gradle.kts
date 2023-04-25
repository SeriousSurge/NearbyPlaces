plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.com.google.ksp)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.org.jetbrains.kotlin.serialization)
    alias(libs.plugins.com.gradle.secrets)
}

android {
    namespace = "com.hiremarknolan.nearbyplaces"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.hiremarknolan.nearbyplaces"
        minSdk = 24
        targetSdk = 33
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kotlin {
    jvmToolchain(8)
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material)

    implementation(libs.ktor.android)
    implementation(libs.ktor.core)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.serialization)

    implementation(libs.kotlinx.serialization)

//    ksp(libs.compose.destinations.ksp)
//    implementation(libs.compose.destinations)
//    implementation(libs.compose.destinations.animations)

    implementation(libs.voyager.navigator)
    implementation(libs.voyager.navigator.tab)
    implementation(libs.voyager.navigator.bottomsheet)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.androidx)

    implementation(libs.coil)

    implementation(libs.google.maps)
    implementation(libs.google.maps.play)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}