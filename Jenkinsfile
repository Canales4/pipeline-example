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
                    script {
                        withSonarQubeEnv('sonar-6'){
                            sh 'mvn sonar:sonar'
                        }
                        timeout(time: 10, unit: 'MINUTES') {
                          def qg = waitForQualityGate()
                          if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                          }
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
