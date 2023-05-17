pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                //Git репозиторій з кодом та Dockerfile
                git 'https://github.com/khrys-tina/lab1_devops.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Збірка Docker імеджа з Dockerfile
                script {
                    docker.withRegistry('', 'dockerhub') {
                        def customImage = docker.build('my-docker-image', '.')
                        customImage.push()
                    }
                }
            }
        }
    }
}
