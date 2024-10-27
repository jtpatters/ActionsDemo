import groovy.yaml.YamlSlurper

def yamlFile = new File("deployment.yaml")
def yaml = new YamlSlurper().parse(yamlFile)

def artifacts = yaml.artifacts
def environment = yaml.environment

artifacts.each { artifact ->
    println "Artifact Name: ${artifact.name}"
    println "Artifact Version: ${artifact.version}"
}

println "Environment: ${environment}"

// Set properties to be used in the deployment
component.setProperty("artifactName", artifacts[0].name)
component.setProperty("artifactVersion", artifacts[0].version)
component.setProperty("environment", environment)
