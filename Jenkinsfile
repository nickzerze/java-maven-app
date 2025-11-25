#!/usr/bin/env groovy
//---θέλουμε το groovy Line για να γίνει detect το groovy script---

//Αν δεν βάλω το definition (def gv)
//@Library('jenkins-shared-library') _   -> αν δεν έχω το _ τότε πρέπει να έχω αμέσως μετά το def gv

@Library('jenkins-shared-library')
def gv

//Αν θέλω ένα συγκεκριμένο tag
//@Library('jenkins-shared-library@v3.2') _
//def gv


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
                    buildImage 'malware4/java-maven-app:jma-3.2.1'
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
