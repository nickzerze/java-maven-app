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
        stage("Deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
