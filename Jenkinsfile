pipeline {
  agent any
  stages {
    stage('clone repo') {
      steps {
        git(url: 'https://github.com/Gogetter/java-blog-posts', branch: 'master', changelog: true, poll: true)
      }
    }

    stage('build application') {
      parallel {
        stage('gradle build (clean, test, check)') {
          steps {
            dir(path: 'java-for-docker-blog-post') {
              sh './gradlew clean build'
            }

          }
        }

        stage('security checks') {
          steps {
            dir(path: 'java-for-docker-blog-post') {
              sh './gradlew dependencyCheckAnalyze'
            }

          }
        }

      }
    }

  }
  tools {
    gradle 'gradle6.5'
  }
}