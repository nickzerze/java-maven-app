def buildJar() {
    echo "Building the application..."
    sh 'mvn package'
}

def buildimage() {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t malware4/java-maven-app:jma-3.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push malware4/java-maven-app:jma-3.0'
    }
}

def testApp() {
    echo 'Testing the application...'
    echo "Version testing is ${TEST_VERSION}"
}

def deployApp() {
    echo "Deploying the application..."
    echo "Version testing is ${params.VERSION}"
}

return this