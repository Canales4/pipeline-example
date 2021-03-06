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
                      sh 'mvn clean install -Dskip.integration.tests=true org.pitest:pitest-maven:mutationCoverage'
                      junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                  if (env.BRANCH_NAME == "master") {
                      sh 'mvn cargo:deploy'
                  }else{
                      sh 'mvn tomcat7:deploy'
                  }
                }
            }
        }
    }
}
