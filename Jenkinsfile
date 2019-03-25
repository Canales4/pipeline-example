pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Test') { 
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') { 
            steps {
                echo 'Deploying...'
            }
        }
    }
}
