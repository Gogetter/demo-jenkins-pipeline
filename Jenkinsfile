pipeline {
  agent any
  stages {
    stage('git checkout') {
      steps {
        git(url: 'https: //github.com/Gogetter/demo-jenkins-pipeline', branch: 'master', changelog: true, poll: true)
            }
        }

    stage('ready application') {
      parallel {
        stage('compile') {
          steps {
            sh './gradlew classes'
                    }
                }

        stage('test') {
                  steps {
                    sh './gradlew test'
                    }
                }
            }
        }

    stage('run checks') {
        parallel {
            stage('checkstyle') {
                steps {
                    sh './gradlew check'
                    }
                }

            stage('security checks') {
          steps {
            sh './gradlew dependencyCheckAnalyze'
                    }
                }
            }
        }

    stage('Staging') {
      steps {
        echo "Build Docker image"
        sh './gradlew bootBuildImage'
            }
        }
    }
  tools {
    gradle 'gradle6.5'
    }
}