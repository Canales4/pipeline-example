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
                parallel 'Sonar Test': {
                      withSonarQubeEnv('sonar-6'){
                          sh 'mvn sonar:sonar'
                          timeout(time: 1, unit: 'HOURS') {
                            waitForQualityGate abortPipeline: true
                          }
                      }
                }, 'Test': {
                      echo 'Ejecutando test'
                      sh 'mvn verify'
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
