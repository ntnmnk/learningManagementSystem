pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Clone the repository into the local directory
                    bat 'cd C:\\deploy && git clone https://github.com/ntnmnk/learningManagementSystem.git'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Navigate to the cloned repository and run Gradle build
                    bat 'cd C:\\deploy\\learningManagementSystem && gradle clean build -x test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    // Find the JAR file matching the pattern "learningManagementSystem-*-SNAPSHOT.jar" in the build/libs directory
                    bat 'cd C:\\deploy\\learningManagementSystem\\build\\libs && dir /B learningManagementSystem-*-SNAPSHOT.jar > jarname.txt'

                    // Read the JAR name from the file
                    def jarName = readFile('C:\\deploy\\learningManagementSystem\\build\\libs\\jarname.txt').trim()

                    echo "Found JAR: ${jarName}"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Deploy the application by running the JAR file on localhost
                    def jarName = readFile('C:\\deploy\\learningManagementSystem\\build\\libs\\jarname.txt').trim()
                    
                    // Run the JAR using java -jar
                    bat "cd C:\\deploy\\learningManagementSystem\\build\\libs && java -jar ${jarName}"
                }
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
