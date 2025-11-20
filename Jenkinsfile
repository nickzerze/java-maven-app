pipeline {
    agent any
    stages {
        stage("Test") {
            steps{
                script {
                    echo "Testing the application..."
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        stage("Build") {
            steps{
                when {
                    expression {
                        BRANCH_NAME == "master"
                    }
                }
                script {
                    echo "Building the application..."
                }
            }
        }
        stage("Deploy") {
            steps{
                when {
                    expression {
                        BRANCH_NAME == "master"
                    }
                script {
                    echo "Deploying the application..."
                }
            }
        }                
    }
    
}