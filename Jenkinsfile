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
            steps {
                echo 'copiando war generado contra webapps de tomcat'
                def dir = "C:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps"
                sh "scp -o /target/laboratorio.war admin@localhost:${dir}"
            }
        }
    }
}
