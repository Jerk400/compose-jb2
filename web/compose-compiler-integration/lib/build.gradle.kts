plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        nodejs {}
        browser() {}
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(compose.runtime)
                implementation(project(":web-core"))
            }
        }
    }
}
