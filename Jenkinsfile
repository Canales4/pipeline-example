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
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                parallel 'Sonar Test': {
                    script {
                        withSonarQubeEnv('sonar-6'){
                            sh 'mvn verify sonar:sonar'
                        }
                        timeout(time: 30 , unit: 'MINUTES'){
                          def qg = waitForQualityGate()
                          if (qg.status != 'OK') {
                            error "Pipeline abortado por no pasar quality gates: ${qg.status}"
                          }
                        }
                    }
                }, 'Test': {
                      sh 'mvn verify'
                }, 'Mutant Test': {
                      sh 'mvn org.pitest:pitest-maven:mutationCoverage'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn cargo:deploy'
            }
        }
    }
}
