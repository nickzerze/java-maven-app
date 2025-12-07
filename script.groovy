def buildJar() {
    echo "Building the application..."
    sh 'mvn package'
}

def buildimage() {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t malware4/java-maven-app:jma-3.1 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push malware4/java-maven-app:jma-3.1'
    }
}

def testApp() {
    echo 'Testing the application...'
}

def deployApp() {
    echo "Deploying the application..."
}

return this