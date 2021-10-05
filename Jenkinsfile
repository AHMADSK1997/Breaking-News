def attachments = [
  [
    text: 'I find your lack of faith disturbing!',
    fallback: 'Hey, Vader seems to be mad at you.',
    color: '#ff0000'
  ]
]
slackSend(channel: "#general", attachments: attachments)

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
        stage('Run'){
            steps{
                sh 'JENKINS_NODE_COOKIE=dontkill java -jar ./build/libs/BreakingNews-0.0.1-SNAPSHOT.jar &'
            }
        }
        stage('Send Slack'){
            steps {
                slackSend color: "good", message: "Message from Jenkins Pipeline"
            }
        }
    }
}

    
