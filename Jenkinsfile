#!/usr/bin/env groovy
//---θέλουμε το groovy Line για να γίνει detect το groovy script---


//====== ΑΝ ΕΧΩ ΔΗΛΩΣΕΙ ΤΟ JENKINS-SHARED-LIBRARY ΣΤΟ SYSTEM (οπότε είναι προσβάσιμο από όλα τα Pipelines του Jenkins)έχω τις εξής επιλογές: =====

// == 1 ==
//Αν δεν βάλω το definition (def gv)
//@Library('jenkins-shared-library') _   -> αν δεν έχω το _ τότε πρέπει να έχω αμέσως μετά το def gv

// == 2 ==
//@Library('jenkins-shared-library')
//def gv

// == 3 == 
//Αν θέλω ένα συγκεκριμένο tag
//@Library('jenkins-shared-library@v3.2') _
//def gv

// ======= ΑΝ ΚΑΝΩ IMPORT ΤΟ JENKINS-SHARED-LIBRARY MONO ΣΕ ΑΥΤΟ ΤΟ PROJECT
library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/nickzerze/jenkins-shared-library.git'
    credentialsId: 'github-credentials'     
    ]
)



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
                    buildImage 'malware4/java-maven-app:jma-3.2.2'
                    dockerLogin()
                    dockerPush 'malware4/java-maven-app:jma-3.2.2'
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
