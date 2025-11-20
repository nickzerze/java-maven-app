def buildJar() {
    echo "Building the application..."
    sh 'mvn package'
}

def buildimage() {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')])
    sh 'docker build -t malware4/java-maven-app:jma-2.0 .'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push malware4/java-maven-app:jma-2.0'
}


def deployApp() {
    echo "Deploying the application..."
}

return this