plugins {
    alias(core.plugins.androidApplication)
    alias(core.plugins.jetbrainsKotlinAndroid)
    alias(core.plugins.kotlin.serialization)
}

android {
    namespace = "com.oneotrix.nti"
    compileSdk = core.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.oneotrix.nti"
        minSdk = core.versions.minSdk.get().toInt()
        targetSdk = core.versions.targetSdk.get().toInt()
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
        }
    }
}

dependencies {

    implementation(core.androidx.core.ktx)
    implementation(core.androidx.lifecycle.runtime.ktx)
    implementation(core.androidx.activity.compose)
    implementation(platform(core.androidx.compose.bom))
    implementation(core.androidx.ui)
    implementation(core.androidx.ui.graphics)
    implementation(core.androidx.ui.tooling.preview)
    implementation(core.androidx.material3)
    implementation(core.androidx.view.model.compose)

    // Network
    implementation(network.okhttp)
    implementation(network.okhttp.loggingInterceptor)
    implementation(network.retrofit)
    implementation(network.retrofit.kotlinx.serialization)

    // Serialization
    implementation(json.kotlinx.serializarion)

    // Asynchronously
    implementation(core.coroutines)


    testImplementation(core.junit)
    androidTestImplementation(core.androidx.junit)
    androidTestImplementation(core.androidx.espresso.core)
    androidTestImplementation(platform(core.androidx.compose.bom))
    androidTestImplementation(core.androidx.ui.test.junit4)
    debugImplementation(core.androidx.ui.tooling)
    debugImplementation(core.androidx.ui.test.manifest)
}