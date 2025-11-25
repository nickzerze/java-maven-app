#!/usr/bin/env groovy
//---θέλουμε το groovy Line για να γίνει detect το groovy script---

//@Library('jenkins-shared-library')_   -> αν δεν έχω το _ τότε πρέπει να έχω αμέσως μετά το def gv
@Library('jenkins-shared-library')
def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build and push image") {
            steps {
                script {
                    buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
