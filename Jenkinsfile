node {
    agent any
    stages {
        stage('Checkout de git') {
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        pipeline {
            agent any
            tools {
                maven 'maven360'
            }
            stages {
                stage('Build') {
                    steps {
                        sh 'mvn clean compile'
                    }
                }
                stage('Test') {
                    steps {
                        sh 'mvn --version'
                    }
                }
            }
        }
    }
}
