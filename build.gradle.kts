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

buildscript {

    repositories {
        google()
        jcenter()
        maven { url = uri("http://dl.bintray.com/kotlin/kotlin-eap") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Deps.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Deps.kotlinVersion}")
        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:${Deps.navigationVersion}")
        classpath("org.jetbrains.dokka:dokka-android-gradle-plugin:${Deps.dokkaVersion}")
    }
}

plugins {
    id("com.diffplug.gradle.spotless") version "3.13.0"
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("http://dl.bintray.com/kotlin/kotlin-eap") }
    }
}

spotless {
    kotlin {
        target("**/*.kt")
        ktlint(Deps.ktlintVersion)
    }
}
