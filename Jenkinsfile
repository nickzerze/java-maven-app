def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    environment {
        TEST_VERSION = '1.4.0'
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage("Init") {
            steps {
				script {
                    gv = load "script.groovy"
                }
            }
        }        
        stage("Build Jar") {
            steps {
				script {
                    gv.buildJar()
                }
            }
        }
        stage("Test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("Build Image and Push to DockerHub") {
            steps {
				script {
                    gv.buildimage()
                }
            }
        }        
        stage("Deploy") {
            input {
                message "Select the environment to deploy to"
                ok "Done"
                parameters {
                    choice(name: 'ENV',choices: ['development', 'staging', 'production'],description: '')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "Deploying to ${ENV}"
                }
            }
        }
    }
}
