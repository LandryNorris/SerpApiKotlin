plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("7.3.0-rc01").apply(false)
    kotlin("multiplatform").version("1.7.10").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}