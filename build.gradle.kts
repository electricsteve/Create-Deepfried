import java.util.Properties

plugins {
    `java-library`
    idea
    `maven-publish`
    id("net.neoforged.gradle.userdev") version "7.1.39"
    id("me.modmuss50.mod-publish-plugin") version "2.2.1"
}

var modId = property("mod_id") as String

version = property("mod_version")!!
group = property("mod_group_id")!!

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

runs {
    configureEach {
        systemProperty("forge.logging.markers", "REGISTRIES")
        systemProperty("forge.logging.console.level", "debug")

        modSource(project.sourceSets.getByName("main"))
    }

    create("client") {
        systemProperty("neoforge.enabledGameTestNamespaces", modId)
    }

    create("server") {
        systemProperty("neoforge.enabledGameTestNamespaces", modId)
        argument("--nogui")
    }

    create("gameTestServer") {
        systemProperty("neoforge.enabledGameTestNamespaces", modId)
    }

    create("data") {
        // Specify the modid for data generation, where to output the resulting resource, and where to look for existing resources.
        arguments.addAll(listOf("--mod", modId, "--all", "--output", file("src/generated/resources/").absolutePath, "--existing", file("src/main/resources/").absolutePath))
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
        @Suppress("UnstableApiUsage")
        extendsFrom(named("localRuntime"))
    }
}

dependencies {
    var minecraftVersion = property("minecraft_version") as String
    var neoVersion = property("neo_version") as String
    var createVersion = property("create_version") as String
    var ponderVersion = property("ponder_version") as String
    var flywheelVersion = property("flywheel_version") as String
    var registrateVersion = property("registrate_version") as String

    implementation("net.neoforged:neoforge:${neoVersion}")

    implementation("com.simibubi.create:create-${minecraftVersion}:${createVersion}:slim") { isTransitive = false }
    implementation("net.createmod.ponder:ponder-neoforge:${ponderVersion}+mc${minecraftVersion}")
    compileOnly("dev.engine-room.flywheel:flywheel-neoforge-api-${minecraftVersion}:${flywheelVersion}")
    runtimeOnly("dev.engine-room.flywheel:flywheel-neoforge-${minecraftVersion}:${flywheelVersion}")
    implementation("com.tterrag.registrate:Registrate:${registrateVersion}")

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

publishMods {
    file.set(tasks.named<Jar>("jar").flatMap { it.archiveFile })
    changelog.set("Hello!")
    type.set(STABLE)
    modLoaders.add("neoforge")

    curseforge {
        projectId.set("990016")
        projectSlug.set("create-deepfried") // Required for discord webhook
        accessToken.set(providers.environmentVariable("CURSEFORGE_TOKEN"))
        minecraftVersions.add("1.21.1")
        client.set(true)
        server.set(true)
        requires("create-bitterballen")
    }
    modrinth {
        projectId.set("76TqKW7O")
        accessToken.set(providers.environmentVariable("MODRINTH_TOKEN"))
        minecraftVersions.add("1.21.1")
    }
    github {
        repository.set("electricsteve/create-deepfried")
        accessToken.set(providers.environmentVariable("GITHUB_TOKEN"))
        commitish.set("1.21.1")
    }
    discord {
        webhookUrl.set(providers.environmentVariable("DISCORD_WEBHOOK"))
    }
}