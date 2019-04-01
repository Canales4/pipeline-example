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
        stage('SonarQube Analisis'){
            steps{
                withSonarQubeEnv('Sonar'){
                    sh 'mvn sonar:sonar'
                }
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
                sh 'mvn install'
                sh 'mvn cargo:deploy'
            }
        }
    }
}
