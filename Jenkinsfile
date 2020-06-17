pipeline {
  agent any
  stages {
    stage('git checkout') {
      steps {
        git(url: 'https://github.com/Gogetter/demo-jenkins-pipeline', branch: 'master', changelog: true, poll: true)
      }
    }

    stage('build application') {
      parallel {
        stage('gradle build (clean, test, check)') {
          steps {
            sh './gradlew clean build'
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
        sh './gradlew bootRun'
        sh 'pid=$(lsof -i:8095 -t); kill -TERM $pid || kill -KILL $pid'
      }
    }

  }
  tools {
    gradle 'gradle6.5'
  }
}