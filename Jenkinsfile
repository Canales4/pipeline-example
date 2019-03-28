pipeline {
    agent none
    stages {
        stage('Checkout de git') {
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Build') {
            agent {
              docker 'maven:3-alpine'
              docker 'openjdk:8-jre'
            }
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
                sh 'java -version'
            }
        }
        stage('Test') {
          steps {
              echo 'Testing...'
          }
        }
    }
}
