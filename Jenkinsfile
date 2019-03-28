pipeline {
    agent { docker { image 'maven:3.3.3'}}
    stages {
        stage('Checkout') { 
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn --version'
            }
        }
        stage('Test') { 
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') { 
            steps {
                echo 'Deploying...'
            }
        }
    }
}