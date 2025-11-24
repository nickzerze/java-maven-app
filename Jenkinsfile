pipeline {
    agent any
    environment {
        NEW_VERSION = '1.4.0'
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage("Build") {
            steps {
				echo 'Building the application...'
            }
        }
        stage("Test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
				echo 'Testing the application...'
                echo "Version testing is ${NEW_VERSION}"
            }
        }
        stage("Deploy") {
            steps {
				echo 'Deploying the application...' 
				echo "Deploying version ${params.VERSION}"
            }
        }
    }
}
