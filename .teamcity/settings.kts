import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    vcsRoot(Sd)

    buildType(Sdf)
}

object Sdf : BuildType({
    name = "sdf"

    params {
        password("aa", "credentialsJSON:2c3603cc-eda1-4bec-8828-0a4f39acf5b7")
        password("sdf", "credentialsJSON:da9fde61-25dd-47e7-8532-b465191e70be")
    }

    vcs {
        root(Sd)
    }
})

object Sd : GitVcsRoot({
    name = "sd"
    url = "sd"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:9ce8d9bd-f474-4d0a-99ab-943d86a74190"
    }
})
