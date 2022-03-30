pipeline {
    agent any
    environment {
        PATH = "/opt/maven/bin:${env.PATH}"
    }
    stages {
        stage ("Maven: Clean and Install") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ("Maven: Build Artifact") {
            steps {
                sh 'mvn package'
            }
        }
        stage ("Upload artifact to S3 bucket") {
            steps {
                s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'devops-artifacts-2022', excludedFile: '/target', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'us-east-1', showDirectlyInBrowser: false, sourceFile: '**/target/AWS_Rest_Service.jar', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'S3-Artifacts', userMetadata: []
            }
        }
    }
}
