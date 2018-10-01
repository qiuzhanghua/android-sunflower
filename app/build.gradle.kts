import org.jetbrains.dokka.gradle.SourceRoot

/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("org.jetbrains.dokka-android")
}

android {
    compileSdkVersion(Deps.compileSdkVersion)
    dataBinding {
        isEnabled = true
    }
    defaultConfig {
        applicationId = "com.google.samples.apps.sunflower"
        minSdkVersion(Deps.minSdkVersion)
        targetSdkVersion(Deps.targetSdkVersion)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        versionCode = 1
        versionName = "0.1.5"
        vectorDrawables.useSupportLibrary = true
    }
    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

dependencies {
    kapt("androidx.room:room-compiler:${Deps.roomVersion}")
    kapt("com.github.bumptech.glide:compiler:${Deps.glideVersion}")
    implementation("android.arch.navigation:navigation-fragment-ktx:${Deps.navigationVersion}")
    implementation("android.arch.navigation:navigation-ui-ktx:${Deps.navigationVersion}")
    implementation("android.arch.work:work-runtime-ktx:${Deps.workVersion}")
    implementation("androidx.appcompat:appcompat:${Deps.supportLibraryVersion}")
    implementation("androidx.constraintlayout:constraintlayout:${Deps.constraintLayoutVersion}")
    implementation("androidx.core:core-ktx:${Deps.ktxVersion}")
    implementation("androidx.legacy:legacy-support-v4:${Deps.supportLibraryVersion}")
    implementation("androidx.lifecycle:lifecycle-extensions:${Deps.lifecycleVersion}")
    implementation("androidx.recyclerview:recyclerview:${Deps.supportLibraryVersion}")
    implementation("androidx.room:room-runtime:${Deps.roomVersion}")
    implementation("com.github.bumptech.glide:glide:${Deps.glideVersion}")
    implementation("com.google.android.material:material:${Deps.supportLibraryVersion}")
    implementation("com.google.code.gson:gson:${Deps.gsonVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Deps.kotlinVersion}")

    // Testing dependencies
    androidTestImplementation("androidx.arch.core:core-testing:${Deps.coreTestingVersion}")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:${Deps.espressoVersion}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Deps.espressoVersion}")
    androidTestImplementation("androidx.test.espresso:espresso-intents:${Deps.espressoVersion}")
    androidTestImplementation("androidx.test.uiautomator:uiautomator:${Deps.uiAutomatorVersion}")
    testImplementation("junit:junit:${Deps.junitVersion}")
}

kapt {
    useBuildCache = true
}

tasks.dokka {
    outputFormat = "html"
    outputDirectory = "$buildDir/docs/dokka"
    sourceRoot(delegateClosureOf<SourceRoot> {
        path = "src/main"
    })
}
