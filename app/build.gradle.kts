plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.serialization)
}

android {
  namespace = "com.santidev.kotlinquiz"
  compileSdk = 36
  
  defaultConfig {
    applicationId = "com.santidev.kotlinquiz"
    minSdk = 27
    targetSdk = 36
    versionCode = 2
    versionName = "1.1"
    
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  
  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  
  packaging {
    resources {
      excludes += setOf(
        "META-INF/LICENSE.md",
        "META-INF/LICENSE-notice.md",
        "META-INF/NOTICE.md"
      )
    }
  }
}

dependencies {
  
  implementation(libs.androidx.lifecycle.viewmodel.compose)
  implementation(libs.accompanist.flowlayout)
  implementation(libs.serialization.json)
  
  //MOCKK TEST
  testImplementation(libs.mockk)
  androidTestImplementation(libs.mockk.android)
  
  //Navigation
  implementation(libs.androidx.navigation.compose)
  
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  
  testImplementation(libs.junit)
  
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
  
}