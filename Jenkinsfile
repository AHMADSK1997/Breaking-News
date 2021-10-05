pipeline {
    
    agent any
    
    stages{
        //
        stage('Clone from Github') {
            steps {
                git branch: 'master', url:'https://github.com/AHMADSK1997/Breaking-News.git'
            }
        }
        stage('Build the Code') {
            steps{
                sh "./gradlew build"
            }
        }
        stage('run'){
            steps{
                sh 'JENKINS_NODE_COOKIE=dontkill java -jar ./build/libs/BreakingNews-0.0.1-SNAPSHOT.jar &'
            }
        }
    }
    post{
        success {
            slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'pipeline-breaking-news', tokenCredentialId: 'Slack-jenkins'        }
    }
}
