pipeline {
    agent any
    tools {
        maven 'maven360'
    }
    stages {
        stage('Checkout de git') {
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Ejecutando test'
                sh 'mvn verify'
            }
        }
        stage('Deploy') {
          sshagent(['tomcat-dev']) {
            sh 'ssh -o StrictHostKeyChecking=no target/*.war ec2-user@localhost:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps'
          }
        }
    }
}
