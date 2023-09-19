pipeline {
    agent any

    tools {
        maven 'Maven 3.9.4'
    }

    environment {
      BRANCH_NAME=env.GIT_BRANCH.replace("origin/", "")
    }

    stages {
        stage('checkout') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/'+ BRANCH_NAME]],
                    userRemoteConfigs: [[url: 'https://github.com/Karthikkumarjain/mobile.testautomation.appium.git']])
            }
        }
        stage('Install pcloudy Jar') {
                    steps {
                        dir('src/main/resources/pcloudyconnector') {
                        sh 'mvn install:install-file -Dfile=src/main/resources/pcloudyconnector/pCloudy-java-connector-11.0.7-jar-with-dependencies.jar -DgroupId=pCloudy-java-connector -DartifactId=pCloudy-java-connector -Dversion=11.0.7 -Dpackaging=jar'
                        }
                    }
        }
        stage('Run Mobile Tests') {
            steps {
                  sh 'mvn clean test'
            }
        }

    }

}