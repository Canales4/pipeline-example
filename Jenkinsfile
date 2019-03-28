pipeline {
    agent any
    stages {
        stage('Checkout de git') {
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Building maven') {
            tools {
              maven 'M3'
            }
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
            }
        }
    }
}
