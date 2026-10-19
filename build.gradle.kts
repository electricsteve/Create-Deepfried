import java.util.Properties

plugins {
    `java-library`
    idea
    `maven-publish`
    id("net.neoforged.gradle.userdev") version "7.1.39"
}

var mod_id = property("mod_id") as String

version = property("mod_version")!!
group = property("mod_group_id")!!

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

runs {
    configureEach {
        // Recommended logging data for a userdev environment
        // The markers can be added/remove as needed separated by commas.
        // "SCAN": For mods scan.
        // "REGISTRIES": For firing of registry events.
        // "REGISTRYDUMP": For getting the contents of all registries.
        systemProperty("forge.logging.markers", "REGISTRIES")

        // Recommended logging level for the console
        // You can set various levels here.
        // Please read: https://stackoverflow.com/questions/2031163/when-to-use-the-different-log-levels
        systemProperty("forge.logging.console.level", "debug")

        modSource(project.sourceSets.getByName("main"))
    }

    create("client") {
        systemProperty("neoforge.enabledGameTestNamespaces", mod_id)
    }

    create("server") {
        systemProperty("neoforge.enabledGameTestNamespaces", mod_id)
        argument("--nogui")
    }

    create("gameTestServer") {
        systemProperty("neoforge.enabledGameTestNamespaces", mod_id)
    }

    create("data") {
        // Specify the modid for data generation, where to output the resulting resource, and where to look for existing resources.
        arguments.addAll(listOf("--mod", mod_id, "--all", "--output", file("src/generated/resources/").absolutePath, "--existing", file("src/main/resources/").absolutePath))
    }
}

repositories {
    maven("https://maven.createmod.net") // Create, Ponder, Flywheel
    maven("https://mvn.devos.one/snapshots") // Registrate
    maven("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/") // ForgeConfigAPIPort
    maven("https://www.cursemaven.com/") // Curseforge
    maven("https://api.modrinth.com/maven") // Modrinth
}

configurations {
    runtimeClasspath.configure {
        extendsFrom(named("localRuntime"))
    }
}

dependencies {
    var minecraft_version = property("minecraft_version") as String
    var neo_version = property("neo_version") as String
    var create_version = property("create_version") as String
    var ponder_version = property("ponder_version") as String
    var flywheel_version = property("flywheel_version") as String
    var registrate_version = property("registrate_version") as String

    implementation("net.neoforged:neoforge:${neo_version}")

    implementation("com.simibubi.create:create-${minecraft_version}:${create_version}:slim") { isTransitive = false }
    implementation("net.createmod.ponder:ponder-neoforge:${ponder_version}+mc${minecraft_version}")
    compileOnly("dev.engine-room.flywheel:flywheel-neoforge-api-${minecraft_version}:${flywheel_version}")
    runtimeOnly("dev.engine-room.flywheel:flywheel-neoforge-${minecraft_version}:${flywheel_version}")
    implementation("com.tterrag.registrate:Registrate:${registrate_version}")

    implementation("curse.maven:create-bitterballen-918751:8853472") // Bitterballen
    implementation("curse.maven:jei-238222:5846880") //JEI
    implementation("curse.maven:jade-324717:6291517") //Jade
    implementation("curse.maven:appleskin-248787:5586600") //Appleskin
    implementation("curse.maven:farmers-delight-398521:6154807") //Farmer"s delight
}

tasks.withType<ProcessResources>().configureEach {
    @Suppress("UNCHECKED_CAST")
    val replaceProperties = Properties().apply {
        load(project.rootProject.file("gradle.properties").inputStream())
    }.toMutableMap() as MutableMap<String, Any>

    inputs.properties(replaceProperties)

    filesMatching("META-INF/neoforge.mods.toml") {
        expand(replaceProperties)
    }
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8" // Use the UTF-8 charset for Java compilation
    }
    withType<Jar> {
        archiveBaseName.set("create_deepfried+${project.property("minecraft_version")}")
    }
}

// IDEA no longer automatically downloads sources/javadoc jars for dependencies, so we need to explicitly enable the behavior.
idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}
