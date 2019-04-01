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
                step {
                  echo 'Ejecutando test'
                  sh 'mvn verify'
                }
                step{
                  withSonarQubeEnv('sonar-6'){
                      sh 'mvn sonar:sonar'
                  }
                }
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
