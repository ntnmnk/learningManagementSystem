pipeline {
    agent any // Use any available agent; specify a Windows agent if needed

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from your GitHub repository
                git 'https://github.com/ntnmnk/learningManagementSystem.git'
            }
        }

        stage('Build') {
            steps {
                // Use the Gradle Wrapper to build your project
                bat './gradlew clean build' // Use 'mvn clean install' if using Maven
            }
        }

        stage('Test') {
            steps {
                // Run tests using Gradle
                bat './gradlew test' // Use 'mvn test' if using Maven
            }
        }

        stage('Package') {
            steps {
                // Package the application using Gradle
                bat './gradlew bootJar' // Use 'mvn package' if using Maven
            }
        }

        stage('Deploy') {
            steps {
                // Use WinSCP to copy the JAR file to your Windows server
                // Make sure WinSCP is installed and accessible in your PATH
                bat 'winscp.com /command "open scp://your-username@192.168.140.215" "put build/libs/*.jar C:\\" "exit"'
            }
        }
    }

    post {
        success {
            echo 'Build and Deploy succeeded!'
        }
        failure {
            echo 'Build or Deploy failed!'
        }
    }
}
