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
                      }
                }, 'Test': {
                      echo 'Ejecutando test'
                      sh 'mvn verify'
                }, 'Quality Gate': {
                      timeout(time: 1, unit: 'HOURS') {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                          error "Pipeline paralizado no cumple con los quality gates: ${qg.status}"
                        }
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
