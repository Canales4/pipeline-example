pipeline {
    agent any
    stages {
        stage('Checkout de git') {
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Building maven') {
            agent { docker 'apache-maven-3.6.0'}
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
            }
        }
        stage('Building openjdk') {
            agent { docker 'openjdk:8-jre' }
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}
