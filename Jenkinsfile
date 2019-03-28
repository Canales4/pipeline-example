pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
        stage('Test') {
          steps {
              echo 'Testing...'
          }
        }
        stage('Deploy a tomcat') {
            steps {
                echo 'mvn tomcat7:deploy'
            }
        }
    }
}
