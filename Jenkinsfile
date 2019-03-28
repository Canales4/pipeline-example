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
              sh './gradlew check'
          }
        }
        stage('Deploy a tomcat') {
            steps {
                sshagent(['tomcat-dev']) {
                    sh 'ssh -o StrictHostKeyChecking=no target/*.war admin@192.168.1.106:C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps'
                }
            }
        }
    }
    post {
    always {
        junit 'build/reports/**/*.xml'
    }
}
}
